package com.ashish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashish.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Ashish", "Mahalle", "test@test.com");
			
			//start the student object
			session.beginTransaction();
			
			//save the student object.
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			
			
			
		}finally {
			factory.close();
		}

	}

}
