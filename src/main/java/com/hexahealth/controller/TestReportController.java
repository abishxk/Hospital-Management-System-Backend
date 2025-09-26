package com.hexahealth.controller;

import com.hexahealth.model.Appointment;
import com.hexahealth.model.TestReport;
import com.hexahealth.service.AppointmentService;
import com.hexahealth.service.TestReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test_report")
public class TestReportController {
    @Autowired
    private TestReportService testReportService;

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/add/{aid}")
    public ResponseEntity<?> addTestReport(@PathVariable int aid, @RequestBody TestReport testReport){
        try{
            Appointment appointment = appointmentService.findById(aid);
            testReport.setAppointment(appointment);
            return ResponseEntity.ok(testReportService.save(testReport));
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
