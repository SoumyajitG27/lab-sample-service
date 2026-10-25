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
                sample.getProductid(),
                sample.getBatchid(),
                sample.getSamplestatus().name(),
                sample.getReceivedby(),
                sample.getReceiveddt()
        );
    }
}
