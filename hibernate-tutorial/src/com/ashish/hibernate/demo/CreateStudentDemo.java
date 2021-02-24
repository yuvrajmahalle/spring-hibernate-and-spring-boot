package com.ashish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashish.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		 
		// create session factory
		// SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		try {
			 
			//create a student object 
			Student tempStudent = new Student("leonardo", "Caprio", "test@test.com");
			
			//start the student object
			session.beginTransaction();
			
			//save the student object.
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			//find out the student generated id
			
			System.out.println("Saved student primary id :: "+ tempStudent.getId());
			
			// now get a new session  and start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("getting student with id :: "+ tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("myStudent :: "+ myStudent); 
			
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}

	}

}
