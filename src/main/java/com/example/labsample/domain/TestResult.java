package com.example.labsample.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "test_results")
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sample_id", nullable = false)
    private Sample sample;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "specid", referencedColumnName = "specid", nullable = false),
            @JoinColumn(name = "specversionid", referencedColumnName = "specversionid", nullable = false)
    })
    private Specification specification;

    @Column(nullable = false, length = 128)
    private String testName;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal measuredValue;

    @Column(nullable = false)
    private boolean passed;

    @Column(nullable = false, updatable = false)
    private Instant recordedAt;

    protected TestResult() {}

    public TestResult(Sample sample, Specification specification, String testName, BigDecimal measuredValue, boolean passed) {
        this.sample = sample;
        this.specification = specification;
        this.testName = testName;
        this.measuredValue = measuredValue;
        this.passed = passed;
        this.recordedAt = Instant.now();
    }

    public long getId() { return id; }
    public Sample getSample() { return sample; }
    public Specification getSpecification() { return specification; }
    public String getTestName() { return testName; }
    public BigDecimal getMeasuredValue() { return measuredValue; }
    public boolean isPassed() { return passed; }
    public Instant getRecordedAt() { return recordedAt; }
}