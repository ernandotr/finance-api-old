package com.ernando.finance.resource;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ernando.finance.response.HomeResponse;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
public class HomeResource {

	@GetMapping("/")
	@Hidden
	public ResponseEntity<HomeResponse> index(){
		ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
		URI newUri = builder.path("swagger-ui.html").build().toUri();
		HomeResponse response = HomeResponse.builder().apiDocs(newUri).apiName("Finance API").apiVersion("1.0.0").build();
		return ResponseEntity.ok(response);
	}
}
