package com.ernando.finance.resource;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ernando.finance.entity.BankAccount;
import com.ernando.finance.service.BankAccountService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("bank-account")
@AllArgsConstructor
public class BankAccountResource {
	
	private BankAccountService bankAcountService;

	@GetMapping
	public ResponseEntity<List<BankAccount>> getAll() {
		return ResponseEntity.ok(bankAcountService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		BankAccount bankAccount = bankAcountService.findById(id);
		if(bankAccount == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(bankAccount);
	}
	
	@GetMapping("/number/{number}")
	public ResponseEntity<?> getByNumber(@PathVariable Long number){
		BankAccount bankAccount = bankAcountService.findByNumber(number);
		if(bankAccount == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(bankAccount);
	}
	
	@PostMapping
	public ResponseEntity<BankAccount> create(@RequestBody BankAccount entity){
		BankAccount bankAccount = bankAcountService.create(entity);
				ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
		URI uri = builder.pathSegment(bankAccount.getId().toString()).build().toUri();
		return ResponseEntity.created(uri).body(bankAccount);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> change(@RequestBody BankAccount entity, @PathVariable(value = "id") Long id){
	 	BankAccount bankAccount = bankAcountService.update(entity, id);
	 	if(bankAccount == null) {
	 		return ResponseEntity.notFound().build();
	 	}
	 	return ResponseEntity.noContent().build();
	}
}
