package com.ernando.finance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ernando.finance.entity.BankAccount;
import com.ernando.finance.repository.BankAccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BankAccountService {

	private BankAccountRepository bankAccountRepository;
	
	public BankAccount create(BankAccount bankAccount) {
		return bankAccountRepository.save(bankAccount);
	}
	
	public List<BankAccount> findAll(){
		return bankAccountRepository.findAll();
	}
	
	public BankAccount findById(Long id) {
		return bankAccountRepository.findById(id).orElse(null);
	}
	
	public BankAccount findByNumber(Long number) {
		return bankAccountRepository.findByAccountNumber(number).orElse(null);
	}
	
	public BankAccount update(BankAccount bankAccountRequest, Long id) {
		BankAccount bankAccount = findById(id);
		if(bankAccount == null) {
			return null;
		}
		bankAccount.setAccountLimit(bankAccountRequest.getAccountLimit());
		bankAccount.setAccountNumber(bankAccountRequest.getAccountNumber());
		bankAccount.setAgencyNumber(bankAccountRequest.getAgencyNumber());
		bankAccount.setBalance(bankAccountRequest.getBalance());
//		bankAccount.setBank(null);
		bankAccount.setDigit(bankAccountRequest.getDigit());
		bankAccount.setMaintenanceFee(bankAccountRequest.getMaintenanceFee());
		
		return bankAccountRepository.save(bankAccount);
	}
	
	public void delete(Long id) {
		bankAccountRepository.deleteById(id);
	}
}
