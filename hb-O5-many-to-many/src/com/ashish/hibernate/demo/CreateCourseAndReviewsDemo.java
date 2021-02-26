package com.ashish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashish.hibernate.demo.entity.Course;
import com.ashish.hibernate.demo.entity.Instructor;
import com.ashish.hibernate.demo.entity.InstructorDetail;
import com.ashish.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		 
		// create session factory
		// SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Course tempCourse = new Course("SPRING");
			
			tempCourse.add(new Review("Great course !! and i jokes a lot"));
			tempCourse.add(new Review("bad course !! and i jokes a lot"));
			tempCourse.add(new Review("fine course !!"));
			
			System.out.println("Saving the course");
			
			session.save(tempCourse);
			
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
