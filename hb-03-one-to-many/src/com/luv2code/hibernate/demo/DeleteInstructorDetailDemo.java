package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = DemoDatabase.configuration().buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			session.beginTransaction();
			
			int theId = 4;
			InstructorDetail tempInstructorDetail = 
								session.find(InstructorDetail.class, theId);
			
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			System.out.println("the associated instructor: " + 
								tempInstructorDetail.getInstructor());
			
			System.out.println("deleting tempInstructorDetail: " 
								+ tempInstructorDetail);
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			
			session.remove(tempInstructorDetail);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
			
		}
		finally {
			
			session.close();
			factory.close();
		}
	}

}





