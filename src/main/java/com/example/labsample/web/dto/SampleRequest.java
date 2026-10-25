package com.example.labsample.web.dto;

import jakarta.validation.constraints.NotBlank;

public record SampleRequest(
    @NotBlank(message = "Product ID is required") String productId,
    @NotBlank(message = "Batch ID is required") String batchId,
    String receivedBy
) {}
