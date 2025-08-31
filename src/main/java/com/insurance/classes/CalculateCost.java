package com.insurance.classes;


import com.insurance.interfaces.Acceptable;

public class CalculateCost implements Acceptable {



    public double calculateCost(User user){
        double cost = 100;
        double risk = user.getOcuppation().getRiskFactor().getValue();

        if(user.getAge()>60){
            cost+=100;
        }
        if(user.isAccidentPrevious()){
            cost= cost+((cost*50)/100);
        }

        cost*=risk;

        return cost;

    }


    @Override
    public boolean isAceceptable(User user) {
        if(user.getAge()>75){
            return false;
        }
        return true;
    }
}
