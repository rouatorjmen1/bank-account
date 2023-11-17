package org.sid.accountservice;

import org.sid.accountservice.clients.CustomerRestClient;
import org.sid.accountservice.entities.BankAccount;
import org.sid.accountservice.enums.AccountType;
import org.sid.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	/*@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
		return args -> {
			BankAccount account1= BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("dt")
					.balance(822878)
					.createAt(LocalDate.now())
					.type(AccountType.SAVING_ACCOUNT)
					.customerId(Long.valueOf(1))
					.build();
			BankAccount account2= BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("dt")
					.balance(822878)
					.createAt(LocalDate.now())
					.type(AccountType.CURRENT_ACCOUNT)
					.customerId(Long.valueOf(2))
					.build();
			bankAccountRepository.save(account1);
			bankAccountRepository.save(account2);

		};
	}*/
	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient){
		return args -> {
			customerRestClient.allCustomers().forEach(c->{
				BankAccount account1= BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("dt")
						.balance(822878)
						.createAt(LocalDate.now())
						.type(AccountType.SAVING_ACCOUNT)
						.customerId(c.getId())
						.build();
				BankAccount account2= BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("dt")
						.balance(822878)
						.createAt(LocalDate.now())
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(c.getId())
						.build();
				bankAccountRepository.save(account1);
				bankAccountRepository.save(account2);
			});



		};
	}
}
