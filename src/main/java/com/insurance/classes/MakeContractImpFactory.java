package com.insurance.classes;


import com.insurance.interfaces.IMakeContract;

public class MakeContractImpFactory implements IMakeContract {


    @Override
    public Contract makeContract(User user, InsuranceCompany company) {
        return new Contract(user,company);
    }
}
