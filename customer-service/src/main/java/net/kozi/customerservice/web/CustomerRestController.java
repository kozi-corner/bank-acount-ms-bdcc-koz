package net.kozi.customerservice.web;

import lombok.AllArgsConstructor;

import net.kozi.customerservice.entities.Customer;
import net.kozi.customerservice.repos.CustomerRepo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RefreshScope
public class CustomerRestController {
    private final CustomerRepo customerRepo;

    @GetMapping("/customers")
    public List<Customer> customerList(){
        return customerRepo.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id){
        return customerRepo.findById(id).get();
    }
}
