package com.ernando.finance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ernando.finance.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{

	Optional<BankAccount> findByAccountNumber(Long number);

}
