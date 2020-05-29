package com.hibernate.util;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.Entity.*;

public class HibernateUtil {
	
	public static final SessionFactory sessionFactory;
	
	static{
		 try{
	            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
	            		.addAnnotatedClass(Bus.class)
	            		.addAnnotatedClass(Booking.class)
	            		.addAnnotatedClass(Users.class)
	            		.addAnnotatedClass(SeatInfo.class)
						.addAnnotatedClass(Student.class)
	            		.buildSessionFactory();
	        }

	        catch (Throwable e){
	            e.printStackTrace();
	            throw new ExceptionInInitializerError(e);
	        }
	    }
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	}


