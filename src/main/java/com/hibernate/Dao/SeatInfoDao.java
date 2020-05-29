package com.hibernate.Dao;

import com.hibernate.Entity.Bus;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Date;

public class SeatInfoDao {

    private static SessionFactory factory;
    private static Session session;
    private static Transaction tx;


    public Bus getSeatInformation(int busId, LocalDate date) {

        System.out.println(date);
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        if(date != null)
            session.enableFilter("seatFilter").setParameter("t_date" , date);
        Bus bus = session.get(Bus.class , busId);
        return bus;
    }
}
