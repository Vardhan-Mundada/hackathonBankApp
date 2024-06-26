package org.mybank.mybank_app.service;

import org.mybank.mybank_app.dao.CustomerDAO;
import org.mybank.mybank_app.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDAO.update(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerDAO.findById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    @Override
    public void deleteCustomer(Long id) {
        customerDAO.deleteById(id);
    }
}
