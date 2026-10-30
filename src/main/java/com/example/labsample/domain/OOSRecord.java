package com.example.labsample.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "oos_records")
public class OOSRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "test_result_id", nullable = false, unique = true)
    private TestResult testResult;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sample_id", nullable = false)
    private Sample sample;

    @Column(nullable = false, length = 512)
    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 32)
    private OOSCondition status;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    protected OOSRecord() {}

    public OOSRecord(TestResult testResult, Sample sample, String reason, OOSCondition status) {
        this.testResult = testResult;
        this.sample = sample;
        this.reason = reason;
        this.status = status;
        this.createdAt = Instant.now();
    }

    public long getId() { return id; }
    public TestResult getTestResult() { return testResult; }
    public Sample getSample() { return sample; }
    public String getReason() { return reason; }
    public OOSCondition getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }
}