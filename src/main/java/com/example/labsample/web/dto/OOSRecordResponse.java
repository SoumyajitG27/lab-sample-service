package com.example.labsample.web.dto;

import com.example.labsample.domain.OOSCondition;
import com.example.labsample.domain.OOSRecord;
import com.example.labsample.domain.Specification;
import com.example.labsample.domain.TestResult;

import java.time.Instant;

public record OOSRecordResponse (
        long id,
        long testResultId,
        String testName,
        long sampleId,
        String specId,
        long specVersionId,
        String reason,
        OOSCondition status,
        Instant createdAt
){
    public static OOSRecordResponse from(OOSRecord oosRecord){
        TestResult testResult = oosRecord.getTestResult();
        Specification specification = testResult.getSpecification();
        return new OOSRecordResponse(
                oosRecord.getId(),
                testResult.getId(),
                testResult.getTestName(),
                oosRecord.getSample().getId(),
                specification.getSpecId(),
                specification.getSpecVersionId(),
                oosRecord.getReason(),
                oosRecord.getStatus(),
                oosRecord.getCreatedAt()
        );
    }
}
