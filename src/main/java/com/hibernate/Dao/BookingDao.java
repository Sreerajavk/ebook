package com.hibernate.Dao;

import com.hibernate.Entity.Booking;
import com.hibernate.Entity.Bus;
import com.hibernate.Entity.SeatInfo;
import com.hibernate.Entity.Users;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingDao {

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

    public int addBookingDetails(Date travel_date, int uid, int busid)  {

        try{
            // getting configuration
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();


            //getting user and bus objects
            Users user = session.get(Users.class , uid);
            session.enableFilter("seatFilter").setParameter("t_date" , travel_date);
            Bus bus = session.get(Bus.class , busid);

            //checking for seat availability
            SeatInfo seatInfo = bus.getSeatInfo().iterator().next();
            int seatLeft = seatInfo.getSeatLeft();
            if(seatLeft == 0){
                return -1;
            }

            // Available -  updating the seat left and creating booking object
            seatInfo.setSeatLeft(seatLeft-1);
            session.update(seatInfo);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = format.format(new Date());
            Date today = format.parse(strDate);
            Booking booking = new Booking(today , travel_date , seatLeft , user , bus );
            session.save(booking);
            tx.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return 0;

    }
    public Booking getBookingWithId(int id){
        return session.get(Booking.class , id);
    }
}
