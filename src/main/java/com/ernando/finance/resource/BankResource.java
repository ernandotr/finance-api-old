package com.ernando.finance.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ernando.finance.entity.Bank;
import com.ernando.finance.request.BankRequest;
import com.ernando.finance.service.BankService;


@RestController
@RequestMapping("/banks")
public class BankResource {

	@Autowired
	private BankService bankService;
	
	@PostMapping
	public ResponseEntity<Bank> create(@Valid @RequestBody BankRequest bankRequest){
		Bank bank = bankService.create(bankRequest);
		ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
		URI uri = builder.pathSegment(bank.getId().toString()).build().toUri();
		return ResponseEntity.created(uri).body(bank);
	}
	
	@GetMapping
	public ResponseEntity<List<Bank>> getAll(){
		return ResponseEntity.ok(bankService.findAll());
	}
	
	@GetMapping("/{bankId}")
	public ResponseEntity<Bank> getById(@PathVariable Integer bankId){
		return ResponseEntity.ok(bankService.findById(bankId));
	}

	
	@PutMapping("/{bankId}")
	public ResponseEntity<Bank> update(@PathVariable Integer bankId, @RequestBody BankRequest bankRequest){
		bankService.update(bankId, bankRequest);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{bankId}")
	public ResponseEntity<Void> delete(@PathVariable Integer bankId){
		bankService.delete(bankId);
		return ResponseEntity.ok().build();
	}
	
}
