package org.suda.customerMgr.dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.suda.customerMgr.dao.api.CustomerDAO;
import org.suda.customerMgr.domain.Customer;
import scala.util.Random;

import java.util.List;


@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private static Logger LOGGER = LoggerFactory.getLogger(CustomerDAOImpl.class);
    @Autowired
    public SessionFactory sessionFactory;
    public boolean addCustomer(Customer customer) {
        LOGGER.info("Adding customer: " + customer);
        try {
            sessionFactory.getCurrentSession().save(customer);
            return true;
        }
        catch (RuntimeException e ){
            LOGGER.error("Error in adding dich", e);
        }
        catch (Exception e) {
            LOGGER.error("Error in adding Customer", e);
        }

        return false;
    }

    public List<Customer> listCustomer() {
        LOGGER.info("Listing all users ");
        return sessionFactory.getCurrentSession().createQuery("from Customer").list();
    }

    public void removeCustomer(Integer id) {
        Customer customer = (Customer) sessionFactory.getCurrentSession().load(
                Customer.class, id);
        if (null != customer) {
            sessionFactory.getCurrentSession().delete(customer);
        }

    }


//    public void editCustomer(Integer id) {
//        Session session = sessionFactory.getCurrentSession();
//        Customer existingPerson = (Customer) session.get(Customer.class, id);
//        java.util.Random random = new java.util.Random(10);
//        existingPerson.setFirstname("test" + random);
//        existingPerson.setLastname("2222");
//        existingPerson.setEmail("2222@22222");
//        existingPerson.setTelephone("33333333333");
//        sessionFactory.getCurrentSession().update(existingPerson);
//    }


    public List<Customer> editCustomerforObject(Integer id) {
        return sessionFactory.getCurrentSession().createQuery("from Customer where id = :customerid").setParameter("customerid",id).list();
    }


    public void editCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        // Retrieve existing person via id
        Customer existingPerson = (Customer) session.get(Customer.class, customer.getId());
        // Assign updated values to this person
        existingPerson.setFirstname(customer.getFirstname());
        existingPerson.setLastname(customer.getLastname());
        existingPerson.setEmail(customer.getEmail());
        existingPerson.setTelephone(customer.getTelephone());
        sessionFactory.getCurrentSession().update(existingPerson);
    }
}
