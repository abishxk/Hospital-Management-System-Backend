package com.hexahealth.service;

import com.hexahealth.model.Doctor;
import com.hexahealth.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepo;

    public DoctorService(DoctorRepository doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public Doctor save(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    public Doctor findById(int did) {
        return doctorRepo.findById(did).orElseThrow(()->new RuntimeException("doctor not found"));
    }
}
