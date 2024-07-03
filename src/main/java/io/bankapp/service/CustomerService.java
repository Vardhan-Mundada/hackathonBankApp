package io.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.bankapp.dao.CustomerRepository;
import io.bankapp.model.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public void createCustomer(Customer customer) {
		// Check if customer already exists
		if (customerRepository.existsById(customer.getAcctID())) {
			throw new IllegalArgumentException("Account ID already exists.");
		}

		customerRepository.save(customer);
	}

	public Customer getCustomerInfo(int acctID) {
		return customerRepository.findById(acctID).orElse(null);
	}

	public void deleteCustomer(int acctID) {
		customerRepository.deleteById(acctID);
	}
}
