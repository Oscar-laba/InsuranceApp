package com.insurance.classes;

public class Vehicule extends Car{

    private Motor motor;
    private String mark;
    private double cost;
    private String color;

    public Vehicule(Motor motor, String mark, double cost, String color) {
        this.motor = motor;
        this.mark = mark;
        this.cost = cost;
        this.color = color;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "main.java.classes.Vehicule{" +
                "mark='" + mark + '\'' +
                ", cost=" + cost +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    double costVehicule() {
        return this.cost;
    }
}
