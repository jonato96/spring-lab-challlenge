package com.kruger.backend.lab.mcsv.patient.dto;

import lombok.Data;

@Data
public class ExaminationDto {

	private Integer id;	
	
    private Integer idPatient;       
    
    private double glucose;
    
    private double fat;   
   
    private double oxygen;    
      
    private String result;
	
}
