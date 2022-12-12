package com.kruger.backend.lab.mcsv.examination.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.backend.lab.mcsv.examination.entity.Examination;
import com.kruger.backend.lab.mcsv.examination.service.ExaminationService;

@RestController
@RequestMapping("/api/examinations")
public class ExaminationController {
	
	@Autowired
	private ExaminationService examinationService;
	
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(examinationService.findAll());
	}
	
	
	@GetMapping("/{examinationId}")
	public ResponseEntity<?> findById(@PathVariable("examinationId") int examinationId){
		Optional<Examination> examination = examinationService.findById(examinationId);
		if(examination.isPresent()) {
			return ResponseEntity.ok(examination);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("/patient/{patientId}")
	public ResponseEntity<?> findAllByPatientId(@PathVariable("patientId") int patientId){
		return ResponseEntity.ok(examinationService.findByPatientId(patientId));
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Examination examination, BindingResult result) {
		if(result.hasErrors()) {
			return validate(result);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(examinationService.save(examination));
	}
	
	
	@DeleteMapping("/{examinationId}")
	public ResponseEntity<?> delete(@PathVariable("examinationId") int examinationId){
		examinationService.delete(examinationId);
		return ResponseEntity.noContent().build();
	}
	
	
	private ResponseEntity<?> validate(BindingResult result) {
		Map<String, String> errores = new HashMap<>();
		result.getFieldErrors().forEach(error->{
			errores.put(error.getField(), "The field: "+error.getField() +" "+error.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
	

}
