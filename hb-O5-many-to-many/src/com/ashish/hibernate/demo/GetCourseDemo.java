package com.ashish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashish.hibernate.demo.entity.Course;
import com.ashish.hibernate.demo.entity.Instructor;
import com.ashish.hibernate.demo.entity.InstructorDetail;
import com.ashish.hibernate.demo.entity.Review;
import com.ashish.hibernate.demo.entity.Student;

public class GetCourseDemo {

	public static void main(String[] args) {
		 
		// create session factory
		// SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int theId =5 ;
			
			Student tempStudent =  session.get(Student.class,theId);
			
			System.out.println("student data :: " + tempStudent);
			System.out.println("Courses data :: " + tempStudent.getCourses());
			 
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
