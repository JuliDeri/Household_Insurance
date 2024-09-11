package household.insurance;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.aMapWithSize;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Test;


import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {

    @Test
    void getConditions() {
        HashMap<String, Double> conditions = new HashMap<>();
        conditions.put(InsuranceOptions.KOMPAKT.getInsuranceName(), InsuranceOptions.KOMPAKT.getInsuredSumPerQm());
        conditions.put(InsuranceOptions.OPTIMAL.getInsuranceName(), InsuranceOptions.OPTIMAL.getInsuredSumPerQm());

        // Test map entries
        assertThat(conditions, IsMapContaining.hasEntry("Kompakt", (double) 650));
        assertThat(conditions, IsMapContaining.hasEntry("Optimal", (double) 700));

        // Test map value
        assertThat(conditions, IsMapContaining.hasKey("Kompakt"));

        //Test correct map size
        assertThat(conditions, aMapWithSize(2));

    }


    @Test
    void calculateInsuredSum() {
        //Testing three different and valid test cases
        Calculation underTest = new Calculation("Kompakt", 60);
        double result = underTest.getInsuredSum();
        assertEquals(39000, result);
        Calculation underTest2 = new Calculation("Optimal", 60);
        double result2 = underTest2.getInsuredSum();
        assertEquals(42000, result2);
        Calculation underTest3 = new Calculation("Kompakt", 1600);
        double result3 = underTest3.getInsuredSum();
        assertEquals(1040000, result3);


    }

    @Test
    public void itShouldThrowIllegalArgumentException() {

        //Test cases that should throw illegal argument exceptions because of invalid parameters
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Calculation calculation = new Calculation("Kompakt", -600);
                    calculation.getInsuredSum();
                    Calculation calculation1 = new Calculation("Kompakt", 0);
                    calculation1.getInsuredSum();
                    Calculation calculation2 = new Calculation("kompakt", 5);
                    calculation2.getInsuredSum();
                    Calculation calculation3 = new Calculation("KOMPAKT", 5);
                    calculation3.getInsuredSum();
                    Calculation calculation4 = new Calculation("Optimal", -500);
                    calculation4.getInsuredSum();
                    Calculation calculation5 = new Calculation("Optimal", 0);
                    calculation5.getInsuredSum();
                    Calculation calculation6 = new Calculation("optimal", 5);
                    calculation6.getInsuredSum();
                    Calculation calculation7 = new Calculation("", 60);
                    calculation7.getInsuredSum();
                    Calculation calculation8 = new Calculation("abcdefg", 0);
                    calculation8.getInsuredSum();
                });
    }
}