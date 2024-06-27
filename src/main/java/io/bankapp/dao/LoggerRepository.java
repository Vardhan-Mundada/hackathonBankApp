package io.bankapp.dao;

import org.springframework.data.repository.CrudRepository;
import io.bankapp.model.Logger;
import java.util.List;

public interface LoggerRepository extends CrudRepository<Logger, Integer> {
    List<Logger> findByAcctID(int acctID);
    void deleteByAcctID(int acctID); // Custom query method for deletion
}
