package com.kruger.backend.lab.mcsv.examination.service;

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

import com.kruger.backend.lab.mcsv.examination.entity.Examination;
import com.kruger.backend.lab.mcsv.examination.repository.ExaminationRepository;

@ExtendWith(MockitoExtension.class)
public class ExaminationServiceTest {

	@Mock
	private ExaminationRepository examinationRepository;
	
	@InjectMocks
	private ExaminationServiceImp examinationService;
	
	private Examination examination;
	private Optional<Examination> simulatedExamination;
	private List<Examination> examinations;
	
	
	@BeforeEach
	void setUp() {
		examination = new Examination();		
		examinations = new ArrayList<>();
		
		examination.setIdPatient(1);
		examination.setGlucose(75.67);
		examination.setFat(88.6);
		examination.setOxygen(60.34);		
	}
	
	@Test
	void shouldFindAllExaminations() {
		examination.setId(1);
		examinations.add(examination);
		Mockito.when(examinationRepository.findAll()).thenReturn(examinations);
		assertNotNull(examinationService.findAll());
		assertEquals(1, examinations.size());
	}
	
	@Test
	void shouldFindOneExaminationById(){		
		examination.setId(1);
		simulatedExamination = Optional.of(examination);
		Mockito.when(examinationRepository.findById(1)).thenReturn(simulatedExamination);
		Optional<Examination> testExamination = examinationService.findById(1);
		assertNotNull(testExamination);
		assertEquals(1, testExamination.get().getIdPatient());		
	}
	
	@Test
	void shouldCreateOneExamination() {
		examination.setId(2);
		Mockito.when(examinationRepository.save(examination)).thenReturn(examination);
		Examination testExamination = examinationService.save(examination);
		assertNotNull(testExamination);
		assertEquals(2, testExamination.getId());
		assertEquals(1, testExamination.getIdPatient());
	}
}
