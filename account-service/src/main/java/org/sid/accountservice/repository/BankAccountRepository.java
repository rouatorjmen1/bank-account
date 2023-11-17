package org.sid.accountservice.repository;

import org.sid.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RestController;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
