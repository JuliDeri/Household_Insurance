package household.insurance;

import java.util.*;

public class Calculation implements Product {

    String insuranceName;
    double livingSpace;
    double insuredSum;
    public double insuredSumPerQm;
    HashMap<String, Double> conditions = new HashMap<>();


    public Calculation(String insuranceName, double livingSpace) {
        this.insuranceName = insuranceName;
        this.livingSpace = livingSpace;
        //only insurance names that are elements of the enum should be accepted arguments
        if (getConditions().containsKey(insuranceName)) {
            this.insuranceName = insuranceName;
        } else throw new IllegalArgumentException("Insurance name spelling mistake or insurance not found.");

        //only positive numbers are accepted as living space value
        if (livingSpace <= 0) {
            throw new IllegalArgumentException("Living Space is 0 or a negative number.");
        }
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public double getLivingSpace() {
        return livingSpace;
    }

    //this method executes the main calculation with input parameters and should be executed by main method.
    @Override
    public double getInsuredSum() {
        return calculateInsuredSum(getInsuranceName(), getLivingSpace());
    }

    //iterates over an array of the InsuranceOptions, fills a Map with the insurance options and returns it.
    //here, insuranceName is key and insuredSumPerQm is value, can easily be extended with further parameters.
    @Override
    public HashMap<String, Double> getConditions() {
        for (InsuranceOptions i : InsuranceOptions.values()
        ) {
            conditions.put(i.getInsuranceName(), i.getInsuredSumPerQm());

        }
        return conditions;
    }

    //main calculation method

    public double calculateInsuredSum(String insuranceName, double livingSpace) {
        //detects correct insuredSumPerQM value in the conditions Map and multiplies with livingSpace input parameter
        insuredSumPerQm = getConditions().get(insuranceName);
        return insuredSum = insuredSumPerQm * livingSpace;
    }


}
