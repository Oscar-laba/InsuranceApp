package com.insurance.classes;

public class Ocuppation {
    private String title;
    private RiskFactor riskFactor;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RiskFactor getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(RiskFactor riskFactor) {
        this.riskFactor = riskFactor;
    }

    @Override
    public String toString() {
        return title;
    }
}
