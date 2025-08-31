package com.insurance.classes;


import com.insurance.exceptions.InvalidAgeException;

import java.util.Objects;

public class User extends Citizen {

    private FullName name;
    private Address address;
    private Ocuppation ocuppation;

    private Vehicule vehicule;
    private int age;
    private boolean accidentPrevious;

    public User(FullName name, Address address, Ocuppation ocuppation, Vehicule vehicule, int age, boolean accidentPrevious) {
        this.name = name;
        this.address = address;
        this.ocuppation = ocuppation;
        this.vehicule = vehicule;
        this.age = age;
        this.accidentPrevious = accidentPrevious;
    }

    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Ocuppation getOcuppation() {
        return ocuppation;
    }

    public void setOcuppation(Ocuppation ocuppation) {
        this.ocuppation = ocuppation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0){
            throw new InvalidAgeException("this age is Imposible");
        }
        this.age = age;
    }

    public boolean isAccidentPrevious() {
        return accidentPrevious;
    }

    public void setAccidentPrevious(boolean accidentPrevious) {
        this.accidentPrevious = accidentPrevious;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
