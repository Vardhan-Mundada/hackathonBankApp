package io.bankapp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.bankapp.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    // Custom method to check if account ID exists
    boolean existsByAcctID(int acctID);

    // Example of a query-based method (not necessary for exists check)
    @Query("SELECT c FROM Customer c WHERE c.acctID = :acctID")
    Customer findByAcctID(@Param("acctID") int acctID);

}
