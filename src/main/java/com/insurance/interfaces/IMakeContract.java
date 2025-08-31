package com.insurance.interfaces;

import com.insurance.classes.Contract;
import com.insurance.classes.InsuranceCompany;
import com.insurance.classes.User;


public interface IMakeContract {

    public Contract makeContract(User user, InsuranceCompany company);
}
