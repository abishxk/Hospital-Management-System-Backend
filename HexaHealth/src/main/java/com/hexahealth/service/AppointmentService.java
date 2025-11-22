package com.hexahealth.service;

import com.hexahealth.model.Appointment;
import com.hexahealth.model.AppointmentType;
import com.hexahealth.model.Patient;
import com.hexahealth.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    public List<Appointment> findTodaysAppoinments() {
        return appointmentRepo.findAll()
                .parallelStream().filter(appointment -> appointment.getDateTime() != null)
                .filter(appointment -> appointment.getDateTime().toLocalDate().isEqual(LocalDate.now()))
                .toList();
    }

    public List<Patient> patientsForSurgery(AppointmentType type) {
        return appointmentRepo.patientsForSurgery(type);
    }

    public List<Appointment> findAppointmentsByPatient(int pid) {
        return appointmentRepo.findAppointmentsByPatient(pid);
    }

    public List<Appointment> findAppointmentsByAppointmentsType(AppointmentType type) {
        return appointmentRepo.findAppointmentsByAppointmentsType(type);
    }
}
