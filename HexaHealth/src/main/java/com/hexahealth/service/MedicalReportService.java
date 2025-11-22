package com.hexahealth.service;

import com.hexahealth.model.MedicalReport;
import com.hexahealth.repository.MedicalReportRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicalReportService {
    private final MedicalReportRepository medicalReportRepo;

    public MedicalReportService(MedicalReportRepository testReportRepo) {
        this.medicalReportRepo = testReportRepo;
    }

    public MedicalReport save(MedicalReport testReport) {
        return medicalReportRepo.save(testReport);
    }
}
