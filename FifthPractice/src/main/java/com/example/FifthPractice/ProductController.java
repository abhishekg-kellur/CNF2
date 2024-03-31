package com.example.FifthPractice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	List<Product> pr = new ArrayList<Product>();
	
	@GetMapping
	public List<Product> getProduct() {
		return pr;
	}
	
	@PostMapping
	public ResponseEntity<?> postProduct(@Valid @RequestBody Product product, BindingResult result) {
		List<String> errors = new ArrayList<String>();
		if(result.hasErrors()) {
			for(FieldError error: result.getFieldErrors()) {
				errors.add(error.getField() + " " + error.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(errors);
		}
		else {
			pr.add(product);
			return ResponseEntity.ok(pr);
		}
	}
	
	@DeleteMapping("/{id}")
	public List<Product> deleteProduct(@PathVariable int id) {
		for(Product p: pr) {
			if(id == p.getId()) {
				pr.remove(id);
			}
		}
		return pr;
	}
	
	@PutMapping
	public List<Product> putProduct(@RequestBody Product product) {
		for(Product p: pr) {
			if(p.getId() == product.getId()) {
				p.setName(product.getName());
				p.setPrice(product.getPrice());
				break;
			}
		}
		return pr;
	}
}
