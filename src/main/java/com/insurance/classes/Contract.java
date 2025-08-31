package com.insurance.classes;

import com.insurance.exceptions.ContractNotFinishedException;


public class Contract {
    private User user;
    private InsuranceCompany insuranceCompany;

    public Contract(User user, InsuranceCompany insuranceCompany) {
        if(user==null||insuranceCompany==null){
            throw new ContractNotFinishedException("some element is not valid");
        }
        this.user = user;
        this.insuranceCompany = insuranceCompany;
    }
}
