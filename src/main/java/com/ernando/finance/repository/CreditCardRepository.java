package com.ernando.finance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ernando.finance.entity.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long>{

	Optional<CreditCard> findByNumber(String number);

}
