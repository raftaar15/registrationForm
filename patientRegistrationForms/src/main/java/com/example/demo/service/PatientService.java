package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PatientRepository;
import com.example.demo.entity.Patient;

@Service
public class PatientService {

@Autowired
private PatientRepository patientRepository;

public Patient createPatient(Patient patient) {
	return patientRepository.save(patient);
}

public List<Patient> createPatient(List<Patient> patients){
	return patientRepository.saveAll(patients);
}

public Patient getPatientById(int id) {
	return patientRepository.findById(id).orElse(null);
}

public List<Patient> getPatients(){
	return patientRepository.findAll();
}

public Patient updatePatient(Patient patient) {
	Patient oldPatient = null;
	Optional<Patient> optionalPatient = patientRepository.findById(patient.getId());
	if(optionalPatient.isPresent()) {
		oldPatient = optionalPatient.get();
		oldPatient.setName(patient.getName());
		oldPatient.setDetails(patient.getDetails());
		patientRepository.save(oldPatient);
	}else {
		return new Patient();
	}
	return oldPatient;
}

public String deleteUserById(int id) {
	patientRepository.deleteById(id);
	return "Patient got deleted";
}

}
