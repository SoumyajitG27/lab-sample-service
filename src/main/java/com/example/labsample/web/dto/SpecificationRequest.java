package com.example.labsample.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record SpecificationRequest (
        @NotBlank String specId,
        @NotNull long specVersionId,
        @NotBlank String productCode,
        @NotBlank String testName,
        @NotNull BigDecimal lowerLimit,
        @NotNull BigDecimal upperLimit,
        @NotBlank String unit
) {
}
