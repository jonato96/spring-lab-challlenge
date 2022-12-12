package com.kruger.backend.lab.mcsv.patient.dto;

import java.util.List;

import lombok.Data;

@Data
public class PatientDto {
	   
    private Integer id;    
    
    private String firstName;   
    
    private String lastName;    
    
    private String address;    
     
    private String telephone;
	
    private List<ExaminationDto> examinations;
}
