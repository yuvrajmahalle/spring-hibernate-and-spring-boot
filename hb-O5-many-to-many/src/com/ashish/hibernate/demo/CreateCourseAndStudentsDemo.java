package com.ashish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashish.hibernate.demo.entity.Course;
import com.ashish.hibernate.demo.entity.Instructor;
import com.ashish.hibernate.demo.entity.InstructorDetail;
import com.ashish.hibernate.demo.entity.Review;
import com.ashish.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			System.out.println("Saving the course...");
			Course tempCourse = new Course("SPRING");
			 
			session.save(tempCourse);
			System.out.println("Saved the course...");
			
			Student tempStudent = new Student("test","mahalle","test@test.com");
			Student tempStudent1 = new Student("ashish","temp","test1@test.com");
			
			tempCourse.addStudent(tempStudent);
			tempCourse.addStudent(tempStudent1);
			
			System.out.println("Saving student...");
			
			session.save(tempStudent);
			session.save(tempStudent1);
			
			System.out.println("Saved student..." + tempCourse.getStudents());
			
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
