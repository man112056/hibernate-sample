package com.example.hqlDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.annotationDemo.Book;

public class HQLDemoMain {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();// can be defined hibernate.cfg.xml file manually

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.openSession();
        String hql = "FROM Book";
        Query query = session.createQuery(hql);
        List<Book> bookList = query.list();
        bookList.forEach(System.out::println);

        /*
         * Retrieve Books by Author
         */

         String retrieveBookHql = "FROM Book b WHERE b.author = :authorName";
         Query query2 = session.createQuery(retrieveBookHql);
         query2.setParameter("authorName", "Manish");
         List<Book> bookListWithAuthor = query2.list();
         bookListWithAuthor.forEach(book -> System.out.println(book));

         /*
          * 
          */


        session.close();
    }

}
