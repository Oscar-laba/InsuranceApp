package com.insurance.classes;

public class CounterInsurance {

    private static int COUNTER_LIFE=0;
    private static int COUNTER_CAR=0;


    public <T> void countInsurance(T typeInsurance){

        if(typeInsurance instanceof CarInsurance){
            COUNTER_CAR++;
        }
        if(typeInsurance instanceof LifeInsurance){
           COUNTER_LIFE++;
        }
    }
}
