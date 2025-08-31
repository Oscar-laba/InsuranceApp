package com.insurance.classes;

public abstract class Citizen {
    private IDPerson IdPerson;

    public IDPerson getIdPerson() {
        return IdPerson;
    }

    public void setIdPerson(IDPerson idPerson) {
        IdPerson = idPerson;
    }
}
