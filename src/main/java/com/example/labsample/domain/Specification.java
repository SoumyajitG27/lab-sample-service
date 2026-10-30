package com.example.labsample.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(
        name = "specifications"
)
public class Specification {

    @EmbeddedId
    private SpecCompositeKey id;

    @Column(nullable = false, length = 64)
    private String productCode;

    @Column(nullable = false, length = 128)
    private String testName;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal lowerLimit;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal upperLimit;

    @Column(nullable = false, length = 32)
    private String unit;

    protected Specification() {
    }

    public Specification(String specId, long specVersionId,
            String productCode,
            String testName,
            BigDecimal lowerLimit,
            BigDecimal upperLimit,
            String unit) {
        this.id = new SpecCompositeKey(specId, specVersionId);
        this.productCode = productCode;
        this.testName = testName;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.unit = unit;
    }

    public SpecCompositeKey getId() { return id; }
    public String getSpecId() { return id.specId(); }
    public long getSpecVersionId() { return id.specVersionId(); }
    public String getProductCode() { return productCode; }
    public String getTestName() { return testName; }
    public BigDecimal getLowerLimit() { return lowerLimit; }
    public BigDecimal getUpperLimit() { return upperLimit; }
    public String getUnit() { return unit; }

    public boolean isWithinLimits(BigDecimal value) {
        return value.compareTo(lowerLimit) >= 0 && value.compareTo(upperLimit) <= 0;
    }
}