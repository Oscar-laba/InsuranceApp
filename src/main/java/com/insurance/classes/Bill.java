package com.insurance.classes;

import com.insurance.exceptions.BillIsNullException;
import com.insurance.interfaces.IMail;
import com.insurance.interfaces.ISign;
import com.insurance.interfaces.Printable;


import java.util.Objects;

public class Bill implements Printable, ISign, IMail {
    private User user;
    private InsuranceCompany insuranceCompany;
    private double cost;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "main.java.classes.Bill{" +
                "user=" + user +
                ", insuranceCompany=" + insuranceCompany +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Double.compare(bill.cost, cost) == 0 && Objects.equals(user, bill.user) && Objects.equals(insuranceCompany, bill.insuranceCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, insuranceCompany, cost);
    }

    @Override
    public void print(Bill bill) {
        System.out.println(bill.cost + " and your company is "+ bill.insuranceCompany);
    }

    @Override
    public boolean signContract(User user) {
        if(user!=null){
            System.out.println("Congratulation");
            return true;
        }
        return false;
    }

    @Override
    public void sendMail(Bill bill) {
        if(bill==null){
            throw new BillIsNullException("the bill was not created");
        }
        if(bill.signContract(user)) System.out.println( "your info will be sent");
        else System.out.println("sign the contract");

    }
}
