package com.kruger.backend.lab.mcsv.patient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.backend.lab.mcsv.patient.client.ExaminationClient;
import com.kruger.backend.lab.mcsv.patient.dto.ExaminationDto;
import com.kruger.backend.lab.mcsv.patient.dto.PatientDto;
import com.kruger.backend.lab.mcsv.patient.entity.Patient;
import com.kruger.backend.lab.mcsv.patient.repository.PatientRepository;

@Service
public class PatientServiceImp implements PatientService{

	@Autowired
	private PatientRepository repository;
	
	@Autowired
	private ExaminationClient examinationClient;
	
	@Override
	public List<Patient> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Patient> findById(Integer id) {		
		return repository.findById(id);
	}

	@Override
	public Patient save(Patient patient) {
		return repository.save(patient);
	}

	@Override
	public PatientDto findByPatient(int id) {
		PatientDto patientDto = new PatientDto();
		Optional<Patient> patient = repository.findById(id);
		List<ExaminationDto> examinations = examinationClient.findAll(id);
		if(patient.isPresent()) {
			
			Patient p = patient.get();
			patientDto.setId(p.getId());
			patientDto.setFirstName(p.getAddress());
			patientDto.setLastName(p.getLastName());
			patientDto.setAddress(p.getAddress());
			patientDto.setTelephone(p.getTelephone());
			if(examinations != null) {
				patientDto.setExaminations(examinations);
			}
		}
		return patientDto;
	}

}
