import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends Registration implements DriverRateFeatures {
    private long nationalID;
    private String license;
    private double totalRate;
    private ArrayList<String> favAreas = new ArrayList<String>();

    public Driver(String userName, String password, String mobileNumber, String email, long nationalID, String license) {
        super(userName, password, mobileNumber, email);
        this.nationalID = nationalID;
        this.license = license;
    }

    public Driver(){

    }

    @Override
    public boolean login(String username,String password) {
        Boolean flag = false;
        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Abd Elrahman\\IdeaProjects\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            ResultSet R = statement.executeQuery("select * from Drivers");
            while(R.next()){
                if (R.getString("driverName").equals(username) && R.getString("password").equals(password) && R.getInt("state")==1){
                    System.out.println("Login successfully");
                    flag = true;
                    this.userName = R.getString("driverName");
                    this.password = R.getString("password");
                    this.mobileNumber = R.getString("phoneNumber");
                    this.license = R.getString("licence");
                    this.email = R.getString("Email");
                    this.nationalID = R.getLong("NationalId");
                    break;
                }
            }
            if (flag == false){
                System.out.println("Invalid username/password or suspended or does not verified");
            };
            connection.close();
            statement.close();
        }
        catch (SQLException throwable) {
            System.out.println("Error!");;
        }
        return flag;
    }

    @Override
    public void Register() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Abd Elrahman\\IdeaProjects\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT into Drivers VALUES('"+userName+"','"+password+"','"+email+"','"+mobileNumber+"','"+license+"',"+nationalID+", "+0+" ,"+0+")");
            System.out.println("Account is registered successfully");
            connection.close();
            statement.close();
        }
        catch (SQLException throwable) {
            System.out.println("Error!");;
        }
    }

    public double getTotalRate() {
        return totalRate;
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

    @Override
    public void calculateRate() {
        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Abd Elrahman\\IdeaProjects\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            ResultSet R = statement.executeQuery("SELECT * FROM Rates WHERE drivername = '"+userName+"'");
            int count = 0;
            while (R.next()){
                totalRate += R.getDouble("rate");
                count++;
            }
            totalRate=totalRate/count;
            statement.executeUpdate("UPDATE Drivers SET AvgRate = '"+totalRate+"' WHERE drivername = '"+userName+"' ");
            connection.close();
            statement.close();
            totalRate = 0;
        }
        catch (SQLException throwable) {
            System.out.println("Error!");;
        }
    }

    @Override
    public void seeMyRates(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Abd Elrahman\\IdeaProjects\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            ResultSet R = statement.executeQuery("select * from Rates where drivername ='"+userName+"'");
            while(R.next()){
                System.out.println(R.getString("user")+" rates you with "+R.getString("rate")+" stars");
            }
            connection.close();
            statement.close();
        }
        catch (SQLException throwable) {
            System.out.println("Error!");;
        }
    }

    public void addFavArea(String area){
        favAreas.add(area);
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Abd Elrahman\\IdeaProjects\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into FavArea values ('"+userName+"','"+area+"')");
            connection.close();
            statement.close();
        }
        catch (SQLException throwable) {
            System.out.println("you already have  this in favorite areas");;
        }
    }

    public void notifyRide(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Abd Elrahman\\IdeaProjects\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            for (int i = 0 ; i<favAreas.size() ; i++) {
                ResultSet R = statement.executeQuery("SELECT * from Requests where source = '" + favAreas.get(i) + "'");
                while (R.next()) {
                    System.out.println(R.getString("username") + " request a ride from " + favAreas.get(i) + " to " + R.getString("dest"));
                }
            }
            connection.close();
            statement.close();
        }
        catch (SQLException throwable) {
            System.out.println("error!");;
        }
    }

    public void offer(){
        Scanner setPrice = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Abd Elrahman\\IdeaProjects\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            for (int i = 0 ; i < favAreas.size() ; i++) {
                ResultSet R = statement.executeQuery("SELECT source from Requests where source = '" + favAreas.get(i) + "'");
                while (R.next()) {
                    System.out.println("Enter price for offer");
                    double price = setPrice.nextDouble();
                    statement.executeUpdate("UPDATE Requests SET price = '" + price + "' WHERE source = '" + favAreas.get(i) + "' ");
                }
            }
            connection.close();
            statement.close();
        }
        catch (SQLException throwable) {
            System.out.println("error!");;
        }
    }

}
