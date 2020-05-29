package com.hibernate.Dao;

import com.hibernate.Entity.Bus;
import com.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.*;

public class BusDao {

    private static SessionFactory factory;
    private static Session session;
    private static Transaction tx;

    static {
        try {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
        } catch (Throwable throwable) {
            System.out.println("Error");
            throw new ExceptionInInitializerError(throwable);
        }
    }

    public List<Bus> allBus(){
        List<Bus> busList = session.createQuery("from com.hibernate.Entity.Bus").list();
        return busList;
    }

    public Bus getBusWithId(int id) {
        Bus bus = session.get(Bus.class , id);
        return bus;
    }
    public List<Bus> getBusWithOrigin(String origin , String destination){
        String query = "from com.hibernate.Entity.Bus where origin = :origin and destination=:destination";
        List<Bus> busList = session.createQuery(query).
                            setParameter("origin" , origin).
                            setParameter("destination" , destination).list();
        return busList;
    }

    public void createBus(Bus bus) {
        try{
            tx = session.beginTransaction();
            session.save(bus);
            tx.commit();
        }
        catch (HibernateException e){
            if (tx !=null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void editTravelAmount(int busId, int amount) {

        try{
            // Getting bus object and updating the amount
            tx = session.beginTransaction();
            Bus bus = session.get(Bus.class , busId);
            bus.setAmount(amount);
            session.update(bus);
            tx.commit();
        }
        catch (HibernateException e){
            if (tx !=null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Bus> getBusWithType(String type) {

        String query = "from com.hibernate.Entity.Bus where bus_type=:type";
        List<Bus>  busList = session.createQuery(query).setParameter("type" , type).list();
        return busList;
    }


}
