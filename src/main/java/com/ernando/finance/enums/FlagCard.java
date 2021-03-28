package com.ernando.finance.enums;

public enum FlagCard {
	VISA("Visa"),
	ELO("Elo"),
	AMERICAN_EXPRESS("American Express"),
	MASTERCARD("Mastercard");
	
	private String description;
	
	private FlagCard(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
