package com.ernando.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ernando.finance.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer>{

}
