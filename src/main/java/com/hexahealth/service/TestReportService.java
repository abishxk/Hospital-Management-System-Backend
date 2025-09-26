package com.hexahealth.service;

import com.hexahealth.model.TestReport;
import com.hexahealth.repository.TestReportRepository;
import org.springframework.stereotype.Service;

@Service
public class TestReportService {
    private final TestReportRepository testReportRepo;

    public TestReportService(TestReportRepository testReportRepo) {
        this.testReportRepo = testReportRepo;
    }

    public TestReport save(TestReport testReport) {
        return testReportRepo.save(testReport);
    }
}
