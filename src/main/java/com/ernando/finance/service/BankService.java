package com.ernando.finance.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ernando.finance.entity.Bank;
import com.ernando.finance.repository.BankRepository;
import com.ernando.finance.request.BankRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BankService {

	private BankRepository bankRepository;
	private ModelMapper modelMapper;
	
	public Bank create(BankRequest bankRequest) {
		Bank bank = modelMapper.map(bankRequest, Bank.class);
		return bankRepository.save(bank);
	}

	public List<Bank> findAll() {
		return bankRepository.findAll();
	}

	public Bank findById(Integer id) {
		return bankRepository.findById(id).orElseThrow();
	}

	public Bank update(Integer bankId, BankRequest bankRequest) {
		Bank bank = findById(bankId);
		bank.setName(bankRequest.getName());
		bank.setNumber(bankRequest.getNumber());
		return bankRepository.save(bank);
		
	}

	public void delete(Integer bankId) {
		bankRepository.deleteById(bankId);
		
	}
	
}
