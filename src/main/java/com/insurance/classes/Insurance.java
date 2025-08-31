package com.insurance.classes;

public abstract class Insurance {
    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void showType();

}
