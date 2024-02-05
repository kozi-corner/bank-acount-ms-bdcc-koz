package net.kozi.accountservice.web;

import lombok.AllArgsConstructor;
import net.kozi.accountservice.clients.CustomerRestClient;
import net.kozi.accountservice.entities.BankAccount;
import net.kozi.accountservice.model.Customer;
import net.kozi.accountservice.repos.BankAccountRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class BankAccountController {
    private final BankAccountRepo bankAccountRepo;
    private final CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<BankAccount> bankAccountList(){
        List<BankAccount> accountList = bankAccountRepo.findAll();
        accountList.forEach(acc->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
        return accountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount accountById(@PathVariable String id){
         BankAccount bankAccount = bankAccountRepo.findById(id).get();
         Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
         bankAccount.setCustomer(customer);
         return bankAccount;
    }
}
