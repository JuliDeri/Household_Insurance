package household.insurance;

public enum InsuranceOptions {
    OPTIMAL("Optimal", 700),
    KOMPAKT("Kompakt", 650);

    public double insuredSumPerQm;
    public String insuranceName;

    public String getInsuranceName() {
        return insuranceName;
    }

    //there are two parameters for an insurance option
    InsuranceOptions(String insuranceName, double insuredSumPerQm) {
        this.insuredSumPerQm = insuredSumPerQm;
        this.insuranceName = insuranceName;
    }

    public double getInsuredSumPerQm() {
        return insuredSumPerQm;
    }


}
