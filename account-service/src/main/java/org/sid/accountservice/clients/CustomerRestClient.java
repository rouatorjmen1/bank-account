package org.sid.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.sid.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")

public interface CustomerRestClient {

    @CircuitBreaker(name = "CustomerService", fallbackMethod = "getDefaultCustomer")
    @GetMapping("/customers/{id}")
    Customer FindCustomerById(@PathVariable Long id);


    @CircuitBreaker(name = "CustomerService", fallbackMethod = "getDefaultAllCustomer")
    @GetMapping("/customers")
    List<Customer> allCustomers();

    default List<Customer> getDefaultAllCustomer(){
        return List.of();
    }
    default Customer getDefaultCustomer(Long id, Exception exception){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("defaultname");
        customer.setLastName("defaultlname");
        customer.setEmail("defaultmail");
        return customer;
    }
}
