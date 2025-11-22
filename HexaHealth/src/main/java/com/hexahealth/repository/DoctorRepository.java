package com.hexahealth.repository;

import com.hexahealth.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
