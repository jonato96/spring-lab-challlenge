package com.kruger.backend.lab.mcsv.examination.service;

import java.util.List;
import java.util.Optional;

import com.kruger.backend.lab.mcsv.examination.entity.Examination;

public interface ExaminationService {
	
	Examination save(Examination examination);
	List<Examination> findAll();
	Optional<Examination> findById(int id);
	void delete(int id);
	
	List<Examination> findByPatientId(int patientId);

}
