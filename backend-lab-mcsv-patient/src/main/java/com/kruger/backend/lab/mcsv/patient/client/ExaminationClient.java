package com.kruger.backend.lab.mcsv.patient.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kruger.backend.lab.mcsv.patient.dto.ExaminationDto;

@FeignClient("mcsv-examination")
public interface ExaminationClient {

	@RequestMapping("/api/examinations/patient/{id}")
	List<ExaminationDto> findAll(@PathVariable int id);
	
}
