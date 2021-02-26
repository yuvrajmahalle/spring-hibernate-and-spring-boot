package com.ashish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashish.hibernate.demo.entity.Instructor;
import com.ashish.hibernate.demo.entity.InstructorDetail;
import com.ashish.hibernate.demo.entity.Student;

public class DeleteDemo {

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
			 
			session.beginTransaction();
			
			int theId = 2;
			Instructor tempInstructor = session.get(Instructor.class,theId);
			
			if(tempInstructor != null) {
				System.out.println("Deleting :: " + tempInstructor);
				// note this will aslo delete the instructor_details entry because of the cascadeType.ALL
				session.delete(tempInstructor);
			}
			
			session.getTransaction().commit();
			 
			System.out.println("Done!!");
			
		}finally {
			factory.close();
		}

	}

}
