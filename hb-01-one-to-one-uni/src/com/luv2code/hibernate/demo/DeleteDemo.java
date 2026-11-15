package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Instructor;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = DemoDatabase.configuration().buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			session.beginTransaction();
			
			int theId = 1;
			Instructor tempInstructor = session.find(Instructor.class, theId);
			
			System.out.println("Found instructor: " + tempInstructor);
			
			if (tempInstructor != null) {
				 
				System.out.println("Deleting: " + tempInstructor);
				
				session.remove(tempInstructor);
			}
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





