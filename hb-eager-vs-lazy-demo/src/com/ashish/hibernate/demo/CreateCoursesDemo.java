package com.ashish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashish.hibernate.demo.entity.Course;
import com.ashish.hibernate.demo.entity.Instructor;
import com.ashish.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		 
		// create session factory
		// SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class,theId);
			
			System.out.println("tempInstructor :: "+ tempInstructor);
			
			Course tempCourses = new Course("GGG");
			Course tempCourses1 = new Course("PS");
			 
			
			tempInstructor.add(tempCourses);
			tempInstructor.add(tempCourses1);
			 
			session.save(tempCourses);
			session.save(tempCourses1);
			 
			
			 
			session.getTransaction().commit();
			System.out.println("done!!");
			
			
		}catch(Exception exe){
			exe.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}

	}

}
