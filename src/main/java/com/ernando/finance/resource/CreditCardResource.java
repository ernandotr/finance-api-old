package com.ernando.finance.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ernando.finance.entity.CreditCard;
import com.ernando.finance.repository.CreditCardRepository;


@RestController
@RequestMapping("/creditcard")
public class CreditCardResource {
	
	private CreditCardRepository creditCardRepository;
	
	public CreditCardResource(CreditCardRepository creditCardRepository) {
		this.creditCardRepository = creditCardRepository;
	}

	@GetMapping
	public ResponseEntity<List<CreditCard>> getAll() {
		return ResponseEntity.ok(creditCardRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		CreditCard creditCard = creditCardRepository.findById(id).orElse(null);
		if(creditCard == null) {
			return ResponseEntity.badRequest().body("Recurso não encontrado");
		}
		return ResponseEntity.ok(creditCard);
	}
	
	@GetMapping("/number/{number}")
	public ResponseEntity<?> getByNumber(@PathVariable String number){
		CreditCard creditCard = creditCardRepository.findByNumber(number).orElse(null);
		if(creditCard == null) {
			return ResponseEntity.badRequest().body("Recurso não encontrado");
		}
		return ResponseEntity.ok(creditCard);
	}
	
	@PostMapping
	public ResponseEntity<CreditCard> create(@RequestBody CreditCard entity){
		
		return new ResponseEntity<>(creditCardRepository.save(entity), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> change(@RequestBody CreditCard entity, @PathVariable(value = "id") Long id){
	 	CreditCard creditCard = creditCardRepository.findById(id).orElse(null);
		if(creditCard != null) {
			creditCard.setExpiration(entity.getExpiration());
			creditCard.setInvoiceDueDay(entity.getInvoiceDueDay());
			creditCard.setNumber(entity.getNumber());
			creditCardRepository.save(creditCard);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.badRequest().body("Recurso não encontrado");
	}
	
	

}
