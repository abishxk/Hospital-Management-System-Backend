package com.hexahealth.controller;

import com.hexahealth.dto.PatientProfileDTO;
import com.hexahealth.model.AppointmentType;
import com.hexahealth.model.Patient;
import com.hexahealth.model.User;
import com.hexahealth.service.AppointmentService;
import com.hexahealth.service.PatientService;
import com.hexahealth.service.UserService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity<?> addPatient(@RequestBody Patient patient){
                    /*
                        {
                        "name" : "",
                        "city" : "",
                        "user" : {
                            "username" : "",
                            "password" : ""
                            }
                        }
                     */
        try{
            User user = patient.getUser();
            user = userService.save(user);

            patient.setUser(user);
            return ResponseEntity.ok(patientService.save(patient));
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<?> addPatient(@RequestBody Patient patient, @PathVariable int id){
                    /*
                        {
                        "name" : "",
                        "city" : ""
                        }
                     */
        try{
            User user = userService.findById(id);
            patient.setUser(user);
            return ResponseEntity.ok(patientService.save(patient));
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public List<Patient> getAllPatients(){
        return patientService.getAll();
    }

    @GetMapping("/profile/{pid}")
    public PatientProfileDTO patientProfile(@PathVariable int pid){
        Patient patient = patientService.findById(pid);
        PatientProfileDTO patientProfileDTO = new PatientProfileDTO();
        patientProfileDTO.setPid(patient.getPid());
        patientProfileDTO.setAppointments(appointmentService.findAppointmentsByPatient(pid));
        patientProfileDTO.setCity(patient.getCity());
        patientProfileDTO.setName(patient.getName());

        return patientProfileDTO;
    }
}
