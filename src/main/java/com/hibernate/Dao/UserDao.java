package com.hibernate.Dao;

import java.time.LocalDate;
import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.Entity.Users;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Transaction;

public class UserDao {
	
	private static SessionFactory factory;
	private static Session session;
	private  static Transaction tx;
	
	static {
		try {
            factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
        } catch (Throwable throwable) {
            System.out.println("Error");
            throw new ExceptionInInitializerError(throwable);
        }
	}
	
	public List<Users> allUsers() {
        List<Users> userList = session.createQuery("from com.hibernate.Entity.Users").list();
        return userList;
	}
	public Users userWithId(int id) {
		Users user = (Users) session.get(Users.class, id);
		return user;
	}

	public Users getUserPastBooking(int id , LocalDate date){

        System.out.println(date);
		factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
		session.enableFilter("dateFilter").setParameter("today" , date);
//		String query = "from com.hibernate.Entity. where id = :id and travel_date < :date";
		Users user= session.get(Users.class, id);
		return user;
	}

	public void creteUser(Users user) {

		try{
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		}
		catch (HibernateException e){
			if (tx !=null) tx.rollback();
		}
		finally {
			session.close();
		}
	}
}
