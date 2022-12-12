package com.kruger.backend.lab.mcsv.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kruger.backend.lab.mcsv.patient.entity.Patient;


public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
