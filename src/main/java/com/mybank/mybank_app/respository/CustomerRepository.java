package org.mybank.mybank_app.repository;

import org.mybank.mybank_app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
