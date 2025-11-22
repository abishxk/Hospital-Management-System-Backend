package com.hexahealth.controller;

import com.hexahealth.model.Appointment;
import com.hexahealth.model.MedicalReport;
import com.hexahealth.service.AppointmentService;
import com.hexahealth.service.MedicalReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medical_report")
public class MedicalReportController {
    @Autowired
    private MedicalReportService testReportService;

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/add/{aid}")
    public ResponseEntity<?> addTestReport(@PathVariable int aid, @RequestBody MedicalReport medicalReport){
                /*
                    {
                        "description" : ""
                    }
                 */
        try{
            Appointment appointment = appointmentService.findById(aid);
            medicalReport.setAppointment(appointment);
            return ResponseEntity.ok(testReportService.save(medicalReport));
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
