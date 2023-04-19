package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Patient;
import com.example.demo.service.PatientService;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/addPatient")
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.createPatient(patient);
	}
	
	@PostMapping("/add")
	public List<Patient> addPatients(@RequestBody List<Patient> patients){
		return patientService.createPatient(patients);
	}
	
	@GetMapping("/patient/{id}")
	public Patient getPatentById(@PathVariable int id) {
		return patientService.getPatientById(id);
	}
	
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		return patientService.getPatients();
	}
	
	@PutMapping("/updatePatient")
	public Patient updatePatient(@RequestBody Patient patient) {
		return patientService.updatePatient(patient);
	}
	
	@DeleteMapping("/patient/{id}")
	public String deletePatient(@PathVariable int id) {
		return patientService.deleteUserById(id);
	}
	
}
