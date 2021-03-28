package com.ernando.finance.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ernando.finance.enums.FlagCard;

import lombok.Data;

@Data
@Entity
@Table(name = "credit_card")
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(name = "total_limit", precision = 19, scale = 2)
	private BigDecimal totalLimit;
	
	@Column(name = "invoice_due_day")
	private Byte invoiceDueDay;
	
	@Enumerated(EnumType.STRING)
	private FlagCard flag;
	
	private String expiration;
	
	private String number;
	
	private Short cvv;
	
	private Byte annuityInstallments;
	
	@Column(precision = 19, scale = 2)
	private BigDecimal annuity;
	
	@Column(precision = 19, scale = 2)
	private BigDecimal pontuation;
	

}
