package org.sid.custumorservice;

import org.sid.custumorservice.config.GlobalConfig;
import org.sid.custumorservice.entities.Customer;
import org.sid.custumorservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
@EnableConfigurationProperties(GlobalConfig.class) //il faut l'activer pour la 2eme solution
@SpringBootApplication
public class CustumorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustumorServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Customer customer1 =Customer.builder().firstName("Torjmen").lastName("Roua").email("tr@gmail.com").build();
            customerRepository.save(customer1);
            Customer customer2 =Customer.builder().firstName("Torjmen").lastName("Salah").email("ts@gmail.com").build();
            customerRepository.save(customer2);


        };
    }
}


