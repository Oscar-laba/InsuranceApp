package com.insurance.classes;

import java.util.Objects;

public class Address {

    private String country;
    private String city;
    private String Street;

    public Address() {
    }

    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        Street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) && Objects.equals(city, address.city) && Objects.equals(Street, address.Street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, Street);
    }
}
