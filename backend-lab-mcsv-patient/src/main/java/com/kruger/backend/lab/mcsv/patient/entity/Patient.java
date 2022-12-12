package com.kruger.backend.lab.mcsv.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name="patients")
@Data
public class Patient {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer id;
    
    @Column(name = "first_name")
    @NotBlank
    private String firstName;
   
    @Column(name = "last_name")
    @NotBlank
    private String lastName;
    
    @Column(name = "address")
    @NotBlank
    private String address;
    
    @Column(name = "telephone")
    @NotBlank    
    private String telephone;
	
}
