//package io.bankapp;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import io.bankapp.model.Customer;
//import io.bankapp.service.CustomerService;
//import io.bankapp.model.Accounts;
//import io.bankapp.service.AccountService;
//import io.bankapp.model.Logger;
//import io.bankapp.service.LoggerService;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Autowired
//    private AccountService accountService;
//
//    @Autowired
//    private LoggerService loggerService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        Customer customer1 = new Customer(1, "Ravi Kumar", "Mumbai", "Maharashtra", "India", 9876543, "password1");
//        Customer customer2 = new Customer(2, "Anita Sharma", "Delhi", "Delhi", "India", 9876543, "password2");
//        Customer customer3 = new Customer(3, "Rahul Singh", "Bengaluru", "Karnataka", "India", 987654, "password3");
//
//        customerService.createCustomer(customer1);
//        customerService.createCustomer(customer2);
//        customerService.createCustomer(customer3);
//
//        // Ensure each customer gets an account
//        Accounts account1 = new Accounts(1, 0, "Active");
//        Accounts account2 = new Accounts(2, 0, "Active");
//        Accounts account3 = new Accounts(3, 0, "Active");
//
//        accountService.createAccount(account1);
//        accountService.createAccount(account2);
//        accountService.createAccount(account3);
//
//        // Example logger creation
//        Logger logger1 = new Logger(1, "Deposit", "Success", 0, 1000);
//        Logger logger2 = new Logger(2, "Withdrawal", "Success", 0, 500);
//        Logger logger3 = new Logger(3, "Transfer", "Success", 0, 200);
//
//        loggerService.addLog(logger1);
//        loggerService.addLog(logger2);
//        loggerService.addLog(logger3);
//    }
//}
