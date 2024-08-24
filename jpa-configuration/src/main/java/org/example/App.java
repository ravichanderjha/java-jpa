package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("META-INF/MyPersistenceUnitName");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Employee employee1 = new Employee();
        employee1.setName("Sumit");
        employee1.setSalary(3000000);

        Employee employee2 = new Employee();
        employee2.setName("Prakash");
        employee2.setSalary(4000000);

        entityManager.persist(employee1);
        entityManager.persist(employee2);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        System.out.println( "Hello World!" );
    }
}
