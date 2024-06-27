package io.bankapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import io.bankapp.model.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Integer>, JpaRepository<Accounts, Integer> {

    @Query("select balance from Accounts where acctID = ?1")
    public int findBalanceByAcctID(int acctID);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Accounts set balance = balance + ?2, lastUpdatedDate = current_timestamp where acctID = ?1")
    public void saveBalanceByAcctID(int acctID, int balance);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Accounts set balance = balance - ?2, lastUpdatedDate = current_timestamp where acctID = ?1")
    public void withdrawAmountByAcctID(int acctID, int balance);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Accounts set acctStatus = 'active', lastUpdatedDate = current_timestamp where acctID = ?1")
    public void activateAccount(int acctID);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Accounts set acctStatus = 'inactive', lastUpdatedDate = current_timestamp where acctID = ?1")
    public void deactivateAccount(int acctID);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Accounts set accountHolderName = ?2, accountType = ?3, branch = ?4, interestRate = ?5, lastUpdatedDate = current_timestamp where acctID = ?1")
    public void updateAccountInfo(int acctID, String accountHolderName, String accountType, String branch, double interestRate);
}
