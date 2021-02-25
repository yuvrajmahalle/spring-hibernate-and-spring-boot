package com.ashish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashish.hibernate.demo.entity.Instructor;
import com.ashish.hibernate.demo.entity.InstructorDetail;
import com.ashish.hibernate.demo.entity.Student;

public class CreateDemo {

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
			 Instructor tempInstructor = new Instructor("Test","Mahalle","test1@test.com");
			 
			 InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/tester","testing");
			 
			 tempInstructor.setInstructorDetail(tempInstructorDetail);
		 
			session.beginTransaction();
			
			
			// this will also save tempInstructor because of cascadeType.ALL
			session.save(tempInstructor);
		 
			session.getTransaction().commit();
			 
			
		}finally {
			factory.close();
		}

	}

}
