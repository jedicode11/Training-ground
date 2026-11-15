package com.luv2code.springdemo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Customer> getCustomers() {
		return entityManager.createQuery("select c from Customer c order by c.lastName", Customer.class)
				.getResultList();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		if (theCustomer.getId() == 0) {
			entityManager.persist(theCustomer);
		} else {
			entityManager.merge(theCustomer);
		}
	}

	@Override
	public Customer getCustomer(int theId) {
		return entityManager.find(Customer.class, theId);
	}

	@Override
	public void deleteCustomer(int theId) {
		entityManager.createQuery("delete from Customer c where c.id = :customerId")
				.setParameter("customerId", theId)
				.executeUpdate();
	}
}
