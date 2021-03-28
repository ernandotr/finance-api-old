package com.ernando.finance.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bank_account")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Bank bank;
	
	private Integer agencyNumber;
	private Integer accountNumber;
	private Byte digit;
	private BigDecimal balance;
	private BigDecimal accountLimit;
	private BigDecimal maintenanceFee;
	
}
