public class User extends Rating {
    User(){
        //constructor
    }
    public void requestRide(String source ,String Destination){
        //request
    }

    public void rateDriver(Driver driver ,double rate){
        driver.getMyRate().setRate(rate);
    }

    public void checkRate(Driver driver){
        System.out.println("Driver rate is: "+driver.getTotalRate());
    }



}
