package com.hibernate.Dao;

import com.hibernate.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

import com.hibernate.Entity.Users;

import java.util.List;
public class StudentDao {
	
	private static SessionFactory factory;
	
	public List<Users> getQuery() {
		try {
            factory = HibernateUtil.getSessionFactory();
        } catch (Throwable throwable) {
            System.out.println("Error");
            throw new ExceptionInInitializerError(throwable);
        }
		Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        List<Users> list = session.createQuery("from com.hibernate.Entity.Users").list();
        System.out.println(list);
        return list;
	}

}
