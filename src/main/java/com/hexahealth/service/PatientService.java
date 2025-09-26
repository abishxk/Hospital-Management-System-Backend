package com.hexahealth.service;

import com.hexahealth.model.Patient;
import com.hexahealth.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientRepository patientRepo;

    public PatientService(PatientRepository patientRepo) {
        this.patientRepo = patientRepo;
    }

    public Patient save(Patient patient) {
        return patientRepo.save(patient);
    }

    public Patient findById(int pid) {
        return patientRepo.findById(pid).orElseThrow(()->new RuntimeException("patient not found"));
    }
}
