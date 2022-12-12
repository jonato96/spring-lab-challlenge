package com.kruger.backend.lab.mcsv.patient.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kruger.backend.lab.mcsv.patient.entity.Patient;
import com.kruger.backend.lab.mcsv.patient.repository.PatientRepository;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

	@Mock
	private PatientRepository patientRepository;
	
	@InjectMocks
	private PatientServiceImp patientService;
	
	private Patient patient;
	private Optional<Patient> simulatedPatient;
	private List<Patient> patients;
	
	@BeforeEach
	void setUp() {
		patient = new Patient();
		patients = new ArrayList<>();		
		patient.setFirstName("Jonathan");
		patient.setLastName("Sanchez");
		patient.setAddress("Quininde");
		patient.setTelephone("0999999999");
		
		simulatedPatient = Optional.of(patient);	
				
		patients.add(patient);
	}
	
	@Test
	void shouldFindAllPatients() {
		Mockito.when(patientRepository.findAll()).thenReturn(patients);
		assertNotNull(patientService.findAll());
	}
	
	@Test
	void shouldFindOnePatientById() {
		patient.setId(1);
		Mockito.when(patientRepository.findById(1)).thenReturn(simulatedPatient);
		Optional<Patient> result = patientService.findById(1);
		assertEquals(simulatedPatient, result);
		Mockito.verify(patientRepository).findById(1);
	}
	
	@Test
	void shouldCreateOnePatient() {
		patient.setId(1);
		Mockito.when(patientRepository.save(patient)).thenReturn(patient);
		Patient createdPatient = patientService.save(patient);
		assertNotNull(createdPatient);
		assertNotNull(createdPatient.getId());
	}
	
	@Test
	void shouldEditOnePatient() {
		patient.setId(1);
		Mockito.when(patientRepository.save(patient)).thenReturn(patient);
		patient.setFirstName("JOna");
		Patient editedPatient = patientService.save(patient);
		assertNotNull(editedPatient);
		assertEquals(patient.getFirstName(), "JOna");
	}
	
}
