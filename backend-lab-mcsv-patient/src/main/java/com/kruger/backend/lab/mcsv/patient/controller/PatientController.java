package com.kruger.backend.lab.mcsv.patient.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.backend.lab.mcsv.patient.entity.Patient;
import com.kruger.backend.lab.mcsv.patient.service.PatientService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	@Autowired
	private PatientService service;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<Patient> patients = service.findAll();
		if(patients.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not patients yet");
		}
		return ResponseEntity.status(HttpStatus.OK).body(patients);
	}
	
	@GetMapping("/{patientId}")
	public ResponseEntity<?> findPatient(@PathVariable("patientId") @Min(1) int patientId){
		Optional<Patient> patientFinded = service.findById(patientId);
		if(patientFinded.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(patientId));
	}
	
	
	@GetMapping("/{patientId}/examinations")
	@CircuitBreaker(name="CircuitBreakerService", fallbackMethod="findPatientWithExamFallback")
	public ResponseEntity<?> findPatientWithExam(@PathVariable("patientId") @Min(1) int patientId){
		return ResponseEntity.status(HttpStatus.OK).body(service.findByPatient(patientId));
	}
	
	@PostMapping	
	public ResponseEntity<?> createPatient(@Valid @RequestBody Patient patient, BindingResult result) {
		if(result.hasErrors()) {
			return validate(result);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(patient));
	}
	
	@PutMapping("/{patientId}")
	public ResponseEntity<?> edit(@Valid @RequestBody Patient patient, BindingResult result, @PathVariable int patientId){
		if(result.hasErrors()) {
			return validate(result);
		}
		Optional<Patient> patientFinded = service.findById(patientId);
		if(patientFinded.isPresent()) {
			Patient patientEdit = patientFinded.get();
			patientEdit.setFirstName(patient.getFirstName());
			patientEdit.setLastName(patient.getLastName());
			patientEdit.setAddress(patient.getAddress());
			patientEdit.setTelephone(patient.getTelephone());
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(patientEdit));
		}
		return ResponseEntity.notFound().build();
	}
	
	private ResponseEntity<?> validate(BindingResult result) {
		Map<String, String> errores = new HashMap<>();
		result.getFieldErrors().forEach(error->{
			errores.put(error.getField(), "The field: "+error.getField() +" "+error.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
	
	private ResponseEntity<?> findPatientWithExamFallback(Exception ex) {
		return ResponseEntity.status(HttpStatus.OK).body("Ups, examination service down, come back later");		
	}

}
