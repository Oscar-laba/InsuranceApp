package com.insurance.classes;

public enum RiskFactor {
    LOW(1.0),
    MEDIUM(1.5),
    HIGH(2.0);

    private final double value;

    RiskFactor(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
