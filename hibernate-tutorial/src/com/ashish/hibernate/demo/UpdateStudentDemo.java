package com.ashish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashish.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			 
			//student id
			int studentId = 1;
			session.beginTransaction();
			  
			// get student data using student id
			Student myStudent = session.get(Student.class,  studentId);
			 
			myStudent.setFirstName("ASHISH UPDATED");
			
			myStudent = session.get(Student.class,  studentId);
			
			System.out.println("updating student name :: "+ myStudent); 
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
