public class Driver extends Registration{
    private long nationalID;
    private String license;
    private Rating myRate;
    private double totalRate;

    public double getTotalRate() {
        return totalRate;
    }

    public Rating getMyRate() {
        return myRate;
    }

    public Driver(long nationalID, String license) {
        this.nationalID = nationalID;
        this.license = license;
    }

    public void setNationalID(long nationalID) {
        this.nationalID = nationalID;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public long getNationalID() {
        return nationalID;
    }

    public String getLicense() {
        return license;
    }

    public void calculateRate() {
        this.totalRate = myRate.getRate();
    }

    public void seeMyRates(){
        myRate.display();
    }

}
