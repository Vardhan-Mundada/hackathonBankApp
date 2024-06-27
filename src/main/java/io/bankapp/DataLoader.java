package io.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.bankapp.model.Customer;
import io.bankapp.service.CustomerService;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        Customer customer1 = new Customer(1, "Ravi Kumar", "Mumbai", "Maharashtra", "India", 9876543, "password1");
        Customer customer2 = new Customer(2, "Anita Sharma", "Delhi", "Delhi", "India", 9876543, "password2");
        Customer customer3 = new Customer(3, "Rahul Singh", "Bengaluru", "Karnataka", "India", 987654, "password3");

        customerService.createCustomer(customer1);
        customerService.createCustomer(customer2);
        customerService.createCustomer(customer3);
    }
}
