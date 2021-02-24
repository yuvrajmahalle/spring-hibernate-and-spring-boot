package com.ashish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashish.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			   
			// print data going to be deletw
			System.out.println("deleting student :: "+ myStudent); 
		    
			// session.delete is used to delete the data from table using hibernate session object
			session.delete(myStudent);
			
			// commit the getTransaction
			session.getTransaction().commit();
			
			System.out.println(" Deleted  successfully!"); 
		    
			
		}finally {
			factory.close();
		}

	}

}
