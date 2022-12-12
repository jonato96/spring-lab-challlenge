package com.kruger.backend.lab.mcsv.examination.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.backend.lab.mcsv.examination.entity.Examination;
import com.kruger.backend.lab.mcsv.examination.repository.ExaminationRepository;

@Service
public class ExaminationServiceImp implements ExaminationService {
	
	@Autowired
	private ExaminationRepository examinationRepository;

	@Override
	public Examination save(Examination examination) {
		
		examination.setResult(ExaminationResult(examination.getGlucose(), examination.getFat(), examination.getOxygen()));
		return examinationRepository.save(examination);
	}

	@Override
	public List<Examination> findAll() {
		return examinationRepository.findAll();
	}

	@Override
	public Optional<Examination> findById(int id) {		
		return examinationRepository.findById(id);
	}
	
	@Override
	public List<Examination> findByPatientId(int patientId) {		
		return examinationRepository.findAllByIdPatient(patientId);
	}

	@Override
	public void delete(int id) {
		examinationRepository.deleteById(id);
		
	}
	
	private String ExaminationResult(double glucouse, double fat, double oxygen) {		
		if(glucouse > 70 & fat > 88.5 & oxygen < 60) {
			return "HIGH RISK";
		}
		if(glucouse >= 50 & glucouse <= 70
				& fat >= 62.2 & fat <= 88.5
				& oxygen >= 60 & oxygen <= 70) {
			return  "MEDIUM RISK";
		}
		if(glucouse < 50 & fat < 62.5 & oxygen > 70) {
			return  "LOW RISK";
		}
		return "NOT MEASURABLE";
	}	

}
