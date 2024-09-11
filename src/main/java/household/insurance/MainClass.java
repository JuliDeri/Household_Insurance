package household.insurance;

public class MainClass {
    public static void main(String[] args) {
        Calculation newCalculation = new Calculation("Kompakt", 84.6);
        Calculation newCalculation2 = new Calculation("Optimal", 84.6);
        System.out.println(newCalculation.getInsuredSum());
        System.out.println(newCalculation2.getInsuredSum());
    }
}
