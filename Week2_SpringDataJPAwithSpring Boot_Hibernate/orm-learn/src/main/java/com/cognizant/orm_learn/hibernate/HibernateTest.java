package com.cognizant.orm_learn.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cognizant.orm_learn.model.Country;

public class HibernateTest {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // Create
            Country newCountry = new Country();
            newCountry.setCode("FR");
            newCountry.setName("France");
            session.save(newCountry);

            // Read
            List<Country> countries = session.createQuery("from Country", Country.class).list();
            countries.forEach(System.out::println);

            // Get specific
            Country c = session.get(Country.class, "IN");
            System.out.println("Fetched: " + c);

            // Delete
            Country d = session.get(Country.class, "FR");
            session.delete(d);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
