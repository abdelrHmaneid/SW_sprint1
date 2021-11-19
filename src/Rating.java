import java.util.ArrayList;

public class Rating {
    private ArrayList<Double> rates = new ArrayList<Double>();
    private double rate;

    public Rating() {

    }

    public double getRate() {
        for(int i = 0 ; i < rates.size() ; i++){
            rate+=rates.get(i);
        }
        rate = rate/rates.size();
        return rate;
    }

    public void setRate(double rate) {
        rates.add(rate);
    }

    public void display(){
        for(int i = 0 ; i < rates.size() ; i++){
            System.out.println(rates.get(i));;
        }
    }

}
