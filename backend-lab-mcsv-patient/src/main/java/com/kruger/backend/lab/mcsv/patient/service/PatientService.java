package com.kruger.backend.lab.mcsv.patient.service;

import java.util.List;
import java.util.Optional;

import com.kruger.backend.lab.mcsv.patient.dto.PatientDto;
import com.kruger.backend.lab.mcsv.patient.entity.Patient;

public interface PatientService {
	
	List<Patient> findAll();
	Optional<Patient> findById(Integer id);
	Patient save(Patient patient);
	
	PatientDto findByPatient(int id);

}
