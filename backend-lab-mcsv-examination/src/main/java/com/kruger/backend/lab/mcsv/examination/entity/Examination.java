package com.kruger.backend.lab.mcsv.examination.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="examinations")
@Data
public class Examination {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer id;
	
	@Column(name = "id_patient")
	@NotNull(message = "Patient ID is needed")
    private Integer idPatient;
   
    @Column(name = "glucose")
    @DecimalMin(message = "Min percentaje is 0", value= "0.0", inclusive = true)
    @DecimalMax(message = "Max percentaje is 100",value = "100.0", inclusive = true)
    private double glucose;
    
    @Column(name = "fat")  
    @DecimalMin(message = "Min percentaje is 0", value= "0.0", inclusive = true)
    @DecimalMax(message = "Max percentaje is 100",value = "100.0", inclusive = true)
    private double fat;
    
    @Column(name = "oxygen")
    @DecimalMin(message = "Min percentaje is 0", value= "0.0", inclusive = true)
    @DecimalMax(message = "Max percentaje is 100",value = "100.0", inclusive = true)
    private double oxygen;
    
    @Column(name = "resul")    
    private String result;
	
}
