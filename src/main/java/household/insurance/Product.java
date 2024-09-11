package household.insurance;

import java.util.HashMap;

//This interface inherits three methods to a product category. It was firstly derived from Household insurance product category.
public interface Product {

    //This method executes the main calculation with input parameters and should be executed by main method.
    double getInsuredSum();

    //Fills a Map with the available insurance options of the product category.
    HashMap<String, Double> getConditions();

    //The method for the specific calculation of the product category household.
    double calculateInsuredSum(String insuranceName, double livingSpace);


}
