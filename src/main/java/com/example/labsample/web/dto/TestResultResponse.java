package com.example.labsample.web.dto;

import com.example.labsample.domain.TestResult;

import java.math.BigDecimal;
import java.time.Instant;

public record TestResultResponse (
        long id,
        long sampleId,
        String specId,
        long specVersionId,
        String testName,
        BigDecimal measuredValue,
        boolean passed,
        Instant recordedAt
){
    public static TestResultResponse from(TestResult testResult){
        return new TestResultResponse(
                testResult.getId(),
                testResult.getSample().getId(),
                testResult.getSpecification().getSpecId(),
                testResult.getSpecification().getSpecVersionId(),
                testResult.getTestName(),
                testResult.getMeasuredValue(),
                testResult.isPassed(),
                testResult.getRecordedAt()
        );
    }
}
