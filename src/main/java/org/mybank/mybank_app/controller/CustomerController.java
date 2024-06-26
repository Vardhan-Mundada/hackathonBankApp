package org.mybank.mybank_app.controller;

import org.mybank.mybank_app.model.Customer;
import org.mybank.mybank_app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    @Autowired
//    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.addCustomer(customer);
        System.out.println("Added customer with ID: " + savedCustomer.getId());
        return savedCustomer;
    }

    // PUT endpoint to update a customer by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        try {
            Customer existingCustomer = customerService.getCustomerById(id);
            if (existingCustomer == null) {
                return ResponseEntity.notFound().build();
            }

            // Update existingCustomer with updatedCustomer data
            existingCustomer.setFirstName(updatedCustomer.getFirstName());
            existingCustomer.setLastName(updatedCustomer.getLastName());
            // Set other properties accordingly

            Customer savedCustomer = customerService.updateCustomer(existingCustomer);
            return ResponseEntity.ok(savedCustomer);
        } catch (Exception e) {
            e.printStackTrace(); // Output exception details to console
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            System.out.println("Found customer: " + customer.getFirstName() + " " + customer.getLastName());
        } else {
            System.out.println("Customer with ID " + id + " not found.");
        }
        return customer;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        System.out.println("Total customers: " + customers.size());
        return customers;
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        System.out.println("Deleted customer with ID: " + id);
    }
}
