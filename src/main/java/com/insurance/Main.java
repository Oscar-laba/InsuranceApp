package com.insurance;

import com.insurance.classes.*;
import com.insurance.interfaces.Acceptable;
import com.insurance.interfaces.IMakeContract;
import com.insurance.exceptions.NotValidOptionException;
import com.insurance.exceptions.PersonNotAccepetedException;
import com.insurance.interfaces.ISign;
import com.insurance.interfaces.Printable;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);


    public static void main(String[] args) {

        File file = new File("src\\main\\resources\\example.txt");

        String toRead = null;

        try {
            toRead = FileUtils.readFileToString(file,"UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int numberOfJavaTimes = StringUtils.countMatches(toRead,"Java");

        String toWrite = "Number of times Java is " + numberOfJavaTimes;

        File fileToWrite = new File("src\\main\\resources\\taskResult.txt");

        try {
            FileUtils.write(fileToWrite,toWrite,"UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Set<InsuranceCompany> insuranceCompanySet = new HashSet<>();
        insuranceCompanySet.add(new InsuranceCompany("Sura"));
        insuranceCompanySet.add(new InsuranceCompany("Bolivar"));
        insuranceCompanySet.add(new InsuranceCompany("Mpafree"));

        List<Ocuppation> bannedOcuppation = new LinkedList<>();
        Ocuppation ocuppation1 = new Ocuppation();
        ocuppation1.setTitle("Police Man");
        Ocuppation ocuppation2 = new Ocuppation();
        ocuppation2.setTitle("Soldier");
        bannedOcuppation.add(ocuppation1);
        bannedOcuppation.add(ocuppation2);

        List<Vehicule> tooExpensiveToInsure= new ArrayList<>();
        Vehicule vehicule1 = new Vehicule(Motor.GASOLINE,"Ferrary",100000,"red");
        Vehicule vehicule2 = new Vehicule(Motor.GASOLINE,"Lambo",150000,"black");
        Vehicule vehicule3 = new Vehicule(Motor.GASOLINE,"Pagany",200000,"any color");
        tooExpensiveToInsure.add(vehicule1);
        tooExpensiveToInsure.add(vehicule2);
        tooExpensiveToInsure.add(vehicule3);

        List<String> carBanned = tooExpensiveToInsure.stream().map(car->car.getMark()).collect(Collectors.toList());




        Scanner sc = new Scanner(System.in);
        String name, lastName;
        int option;
        int optionCompany;
        LOGGER.info("Welcome what is your name");
        name = sc.nextLine();
        LOGGER.info("Welcome " + name);
        LOGGER.info("what is your Lastname");
        lastName = sc.nextLine();
        LOGGER.info("Choose your desired insurance");
        LOGGER.info("1- Life main.java.classes.Insurance");
        LOGGER.info("2- main.java.classes.Car main.java.classes.Insurance");

        option = sc.nextInt();
        CounterInsurance counterInsurance = new CounterInsurance();




        switch (option){
            case 1 : Insurance life = new LifeInsurance();
                counterInsurance.countInsurance(life);
                break;
            case 2:  Insurance car  = new CarInsurance();
                counterInsurance.countInsurance(car);
                break;
            default:
                throw  new NotValidOptionException("option not valid");
        }




        LOGGER.info("We are check our database pls wait");



        LOGGER.info("Welcome "+ name+" "+lastName+" you are already in our registers");
        FullName nameUser = new FullName(name,lastName);
        Address addressUser = new Address("Col","Bog","street false 123");
        Ocuppation ocuppationUser = new Ocuppation();
        ocuppationUser.setTitle("FireFighter");
        ocuppationUser.setRiskFactor(RiskFactor.HIGH);
        Vehicule vehiculeuser =null;
        User user = new User(nameUser,addressUser,ocuppationUser,vehiculeuser,45,false);


        InsuranceCompany insuranceCompany1 = new InsuranceCompany("Sura");
        InsuranceCompany insuranceCompany2 = new InsuranceCompany("Bolivar");
        InsuranceCompany insuranceCompany3 = new InsuranceCompany("Mpafree");

        LOGGER.info("Select main.java.classes.InsuranceCompany");
        for (InsuranceCompany insuranceCompany:insuranceCompanySet){
            LOGGER.info(insuranceCompany);
        }
        optionCompany= sc.nextInt();
        LOGGER.info("We are calculating risk and cost of insurance pls wait");


        CalculateCost calculateCost = new CalculateCost();
         Acceptable acceptableLabmda = userLambda -> userLambda.getAge()<65;
         boolean isAccepted = acceptableLabmda.isAceceptable(user);
        if(isAccepted){
            LOGGER.info("you are accepted");
        }else {
            throw new PersonNotAccepetedException("person in not accepted");
        }

        ;
        double cost =calculateCost.calculateCost(user);

        InsuranceCompany insuranceCompanySelected = null;
        switch (optionCompany){
            case 1: insuranceCompanySelected=insuranceCompany1;
                break;
            case 2: insuranceCompanySelected=insuranceCompany2;
                break;
            case 3: insuranceCompanySelected=insuranceCompany3;
                break;
        }
        LOGGER.info("The insure cost is " + cost);
        LOGGER.info("we create a bill, we will send you by mail");
        Bill bill = new Bill();
        bill.setUser(user);
        bill.setInsuranceCompany(insuranceCompanySelected);
        bill.setCost(cost);
        LOGGER.info("Save the bill in our database");
        ISign iSign = userToSign -> userToSign!=null;
        iSign.signContract(user);
        Printable billToPrint = bill1 -> System.out.println(bill1.getCost() + " and your company is "+ bill1.getInsuranceCompany());
        billToPrint.print(bill);
        bill.sendMail(bill);
        IMakeContract contract = new MakeContractImpFactory();
        contract.makeContract(user,insuranceCompanySelected);




    }
}