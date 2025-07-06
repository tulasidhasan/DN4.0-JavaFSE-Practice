package com.cognizant.orm_learn.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cognizant.orm_learn.model.Employee;

public class EmployeeAnnotationTest {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Create and Save Employee
            Employee emp = new Employee();
            emp.setName("John Doe");
            emp.setSalary(50000);
            session.save(emp);

            // Fetch
            Employee e = session.get(Employee.class, emp.getId());
            System.out.println("Fetched: " + e);

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