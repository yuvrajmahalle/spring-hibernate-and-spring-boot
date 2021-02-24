package com.ashish.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashish.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			 
			 
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display the students
			displayMethods(theStudents);
			
			theStudents = session.createQuery("from Student s WHERE s.lastName='Mahalle'").getResultList();
			
			displayMethods(theStudents);
			
			System.out.println("\\n\\nStudents with last name Mahalle :: " + theStudents);
			
			theStudents = session.createQuery("from Student s where s.email LIKE '%test.com' ").getResultList();
			
			displayMethods(theStudents);
			
			System.out.println("\n\nStudents with email end with test.com :: " + theStudents);
		 
		 
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
			
		}finally {
			factory.close();
		}

	}

	private static void displayMethods(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
