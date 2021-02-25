package com.ashish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashish.hibernate.demo.entity.Instructor;
import com.ashish.hibernate.demo.entity.InstructorDetail;
import com.ashish.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		 
		// create session factory
		// SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			 // start a transaction
			session.beginTransaction();
			
			int theId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			System.out.println("tempInstructorDetail :: "+ tempInstructorDetail);
			
			
			//getting the associated instructor
			System.out.println("associated Instructor ::"+tempInstructorDetail.getInstructor());
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}
		catch(Exception exe){
			exe.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
