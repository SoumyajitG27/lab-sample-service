package com.example.labsample.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name="sample")
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 64)
    private String productId;

    @Column(nullable = false, length = 64)
    private String batchId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 32)
    private SampleStatus sampleStatus;

    @Column(nullable = true, length = 64)
    private String receivedBy;

    @Column(nullable = true, updatable = false)
    private Instant receivedDt;

    protected Sample(){

    }

    public Sample(String productid, String batchid, String receivedby){
        this.productId = productid;
        this.batchId = batchid;
        if(receivedby!=null && !receivedby.isBlank()){
            this.receivedBy = receivedby;
            this.receivedDt = Instant.now();
            this.sampleStatus = SampleStatus.RECEIVED;
        }else {
            this.sampleStatus = SampleStatus.INITIAL;
        }
    }

    public Long getId() {
        return id;
    }

    public String getProductid() {
        return productId;
    }

    public String getBatchid() {
        return batchId;
    }

    public SampleStatus getSamplestatus() {
        return sampleStatus;
    }

    public String getReceivedby() {
        return receivedBy;
    }

    public Instant getReceiveddt() {
        return receivedDt;
    }

    public void setSamplestatus(SampleStatus samplestatus) {
        this.sampleStatus = samplestatus;
    }
}
