package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    static String resource = "META-INF/hibernate.cfg.xml";
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration();
        configuration = configuration.configure(resource);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Employee employee1 = new Employee();
        employee1.setName("Pushkar");
        employee1.setSalary(3000000);

        Employee employee2 = new Employee();
        employee2.setName("Narender");
        employee2.setSalary(4000000);

        //Start
        Transaction transaction = session.beginTransaction();

        session.save(employee1);
        session.save(employee2);

        transaction.commit();

        session.close();

        sessionFactory.close();

    }
}
