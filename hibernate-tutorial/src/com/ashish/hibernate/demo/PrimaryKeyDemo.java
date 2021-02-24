package com.ashish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashish.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			 
			//create 3 student object 
			Student tempStudent = new Student("test", "rset", "testrset@test.com");
			Student tempStudent1 = new Student("test1", "rest", "testrest@test.com");
			Student tempStudent2 = new Student("test2", "reset", "testreset@test.com");
			
			//start the student object
			session.beginTransaction();
			
			//save the student object.
			session.save(tempStudent);
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			// commit transaction
			session.getTransaction().commit();
			
			
			
			
		}finally {
			factory.close();
		}

	}

}
