package org.mybank.mybank_app.dao;

import org.mybank.mybank_app.model.Customer;
import java.util.List;

public interface CustomerDAO {
    Customer save(Customer customer);
    Customer update(Customer customer);
    Customer findById(Long id);
    List<Customer> findAll();
    void deleteById(Long id);
}
