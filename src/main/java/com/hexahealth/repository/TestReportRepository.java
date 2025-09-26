package com.hexahealth.repository;

import com.hexahealth.model.TestReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestReportRepository extends JpaRepository<TestReport, Integer> {
}
