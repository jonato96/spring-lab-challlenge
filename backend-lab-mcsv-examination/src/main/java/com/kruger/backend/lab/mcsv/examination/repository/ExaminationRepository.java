package com.kruger.backend.lab.mcsv.examination.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kruger.backend.lab.mcsv.examination.entity.Examination;

public interface ExaminationRepository extends JpaRepository<Examination, Integer>{

	List<Examination> findAllByIdPatient(int patientId);
}
