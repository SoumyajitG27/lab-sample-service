package com.example.labsample.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record SpecCompositeKey (
        @Column(name = "specid", nullable = false, length = 128) String specId,
        @Column(name = "specversionid", nullable = false) long specVersionId
) implements Serializable {
}
