package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        Configuration configuration = new Configuration();
        configuration.configure();// can be defined hibernate.cfg.xml file manually

        SessionFactory factory = configuration.buildSessionFactory();
        System.out.println(factory);
        System.out.println(factory.isOpen());

        // adding data in student bj
        Student student = new Student();
        student.setId(3);
        student.setName("ManishKumar");
        student.setCity("Godda city");

        //opening connection 
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }
}
