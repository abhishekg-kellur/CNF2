Same as Fourth program

only difference is-->

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
