package com.example.annotationDemo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();// can be defined hibernate.cfg.xml file manually

        SessionFactory factory = configuration.buildSessionFactory();
        System.out.println(factory);
        System.out.println(factory.isOpen());

        // Create a new book instance
        Book book = new Book(
                "Effective Java",
                "Manish",
                new Date(),
                "A comprehensive guide to best practices in Java programming.");

                 //opening connection 
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();

        Session session2 = factory.openSession();

       Book book2 =  session2.get(Book.class, 2);
       System.out.println("book info is- "+book2.getAuthor());

        session2.close();

    }
}
