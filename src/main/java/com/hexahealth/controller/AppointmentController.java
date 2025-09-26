package com.hexahealth.controller;

import com.hexahealth.model.Appointment;
import com.hexahealth.model.Doctor;
import com.hexahealth.model.Patient;
import com.hexahealth.service.AppointmentService;
import com.hexahealth.service.DoctorService;
import com.hexahealth.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add/{pid}/{did}")
    public ResponseEntity<?> createAppointment(@PathVariable int pid, @PathVariable int did,
                                               @RequestBody Appointment appointment){

        try{
            Patient patient = patientService.findById(pid);
            Doctor doctor = doctorService.findById(did);
            appointment.setPatient(patient);
            appointment.setDoctor(doctor);
            return ResponseEntity.ok(appointmentService.save(appointment));

        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
