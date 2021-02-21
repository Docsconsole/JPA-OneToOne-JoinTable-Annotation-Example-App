package com.docsconsole.tutorials.client;

import com.docsconsole.tutorials.entity.Employee;
import com.docsconsole.tutorials.entity.Organization;
import com.docsconsole.tutorials.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MainClient {


    public static void main(String[] args) {
        System.out.println("the main method");

        EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try {

            transaction = entityManager.getTransaction();
            transaction.begin();

            System.out.println("the main method");

            Employee emp = new Employee();
            emp.setEmpName("Jan");
            emp.setEmpSal(new Long(100000));

            //Add new Employee object
            Organization org = new Organization();
            org.setOrgName("Google Inc");

            emp.setOrganization(org);

            // Save employee
            entityManager.persist(emp);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
