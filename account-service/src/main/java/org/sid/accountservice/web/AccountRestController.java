package org.sid.accountservice.web;

import lombok.AllArgsConstructor;
import org.sid.accountservice.clients.CustomerRestClient;
import org.sid.accountservice.entities.BankAccount;
import org.sid.accountservice.model.Customer;
import org.sid.accountservice.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountRestController {
    //@Autowired
    private BankAccountRepository bankAccountRepository;
   // @Autowired
    private CustomerRestClient customerRestClient;

   /* public AccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }*/

/*
    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
*/
    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        List<BankAccount> accountList= bankAccountRepository.findAll();
        accountList.forEach(
                acc->{
                    acc.setCustomer(customerRestClient.FindCustomerById(acc.getCustomerId()));
                }
        );
        return accountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount account(@PathVariable String id){
       // return bankAccountRepository.findById(id).get(); // avant ajout de client
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer= customerRestClient.FindCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
