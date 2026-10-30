package com.example.labsample.web.dto;

import com.example.labsample.domain.Sample;

import java.time.Instant;

public record SampleResponse (
        Long id,
        String productId,
        String BatchId,
        String sampleStatus,
        String receivedBy,
        Instant receivedDt
) {
    public static SampleResponse from (Sample sample){
        return new SampleResponse(
                sample.getId(),
                sample.getProductId(),
                sample.getBatchId(),
                sample.getSampleStatus().name(),
                sample.getReceivedBy(),
                sample.getReceivedDt()
        );
    }
}
