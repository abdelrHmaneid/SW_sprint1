import java.sql.*;

public class Driver extends Registration{
    private long nationalID;
    private String license;
    private double totalRate;

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
                if (R.getString("driverName").equals(username) && R.getString("password").equals(password)){
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
                System.out.println("Invalid username/password");
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
            statement.executeUpdate("INSERT into Drivers VALUES('"+userName+"','"+password+"','"+email+"','"+mobileNumber+"','"+license+"',"+nationalID+",null)");
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
        }
        catch (SQLException throwable) {
            System.out.println("Error!");;
        }
    }

    public void seeMyRates(){

    } //req

}
