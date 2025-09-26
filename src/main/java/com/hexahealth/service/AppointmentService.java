package com.hexahealth.service;

import com.hexahealth.model.Appointment;
import com.hexahealth.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepo;

    public AppointmentService(AppointmentRepository appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    public Appointment findById(int aid) {
        return appointmentRepo.findById(aid).orElseThrow(()->new RuntimeException("Appointment not found"));
    }
}
