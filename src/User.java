import java.sql.*;

public class User extends Registration {
    public User(String userName, String password, String mobileNumber, String email) {
        super(userName, password, mobileNumber, email);
    }

    public User(){

    }

    public void requestRide(String source , String destination){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Abd Elrahman\\IdeaProjects\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Requests VALUES ('"+userName+"','"+source+"','"+destination+"')");
            System.out.println("You requested a ride, we will respond soon");
            connection.close();
            statement.close();
        }
        catch (SQLException throwable) {
            System.out.println("Error!");;
        }
    }

    public void rateDriver(String driverUserName ,int rate){
        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Abd Elrahman\\IdeaProjects\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Rates VALUES ('"+driverUserName+"','"+rate+"')");
            connection.close();
            statement.close();
        }
        catch (SQLException throwable) {
            System.out.println("Error!");;
        }
    }

    public void checkRate(String driverName){
        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Abd Elrahman\\IdeaProjects\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            ResultSet R = statement.executeQuery("SELECT AvgRate from Drivers WHERE drivername = '"+driverName+"'");
            System.out.println("the driver "+driverName+" his rate is "+R.getString("AvgRate"));
            connection.close();
            statement.close();
        }
        catch (SQLException throwable) {
            System.out.println("Error!");;
        }
    }

    @Override
    public boolean login(String username, String password) {
        Boolean flag = false;
        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Abd Elrahman\\IdeaProjects\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            ResultSet R = statement.executeQuery("select * from Users");
            while(R.next()){
                if (R.getString("UserName").equals(username) && R.getString("Password").equals(password)){
                    System.out.println("Login successfully");
                    flag = true;
                    this.userName = R.getString("UserName");
                    this.password = R.getString("Password");
                    this.mobileNumber = R.getString("PhoneNumber");
                    this.email = R.getString("Email");
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
            System.out.println("Error!");
        }
        return false;
    }

    @Override
    public void Register() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Abd Elrahman\\IdeaProjects\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert INTO Users VALUES ('"+userName+"','"+password+"','"+email+"','"+mobileNumber+"')");
            System.out.println("Account is registered successfully");
            connection.close();
            statement.close();
        }
        catch (SQLException throwable) {
            System.out.println("Error!");;
        }
    }
}
