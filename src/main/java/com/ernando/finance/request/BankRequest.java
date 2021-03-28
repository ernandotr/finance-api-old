package com.ernando.finance.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BankRequest {

	@NotBlank
	private String name;
	@NotBlank
	private String number;
}
