# SW_sprint1

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin {
    private static Admin admin;
    private String adminName = "admin";
    private String adminPassword = "1223334444";
    private void Admin(){

    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public static Admin getAdmin(){
        if (admin == null){
            admin = new Admin();
        }
        return admin;
    }



    public static void verify(String driverName){
        try {
            Connection connection = DriverManager.getConnection("D:\\level3 IS\\Advanced Software engineering\\assignments\\assignment1\\Sprint1_AhmedSamir_20190211_20190668_20190242_20190297\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Drivers SET state = 1 where driverName = '"+driverName+"'");
            connection.close();
            statement.close();
        }
        catch (SQLException throwable) {
            System.out.println("error!");;
        }
    }

    public static void suspendUser(String userName){
        try {
            Connection connection = DriverManager.getConnection("D:\\level3 IS\\Advanced Software engineering\\assignments\\assignment1\\Sprint1_AhmedSamir_20190211_20190668_20190242_20190297\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Users SET state = 0 where userName = '"+userName+"'");
            connection.close();
            statement.close();
        }
        catch (SQLException throwable) {
            System.out.println("error!");;
        }
    }

    public static void suspendDriver(Driver driver){
        try {
            Connection connection = DriverManager.getConnection("D:\\level3 IS\\Advanced Software engineering\\assignments\\assignment1\\Sprint1_AhmedSamir_20190211_20190668_20190242_20190297\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Drivers SET state = 0 where driverName = '"+driver.getUserName()+"'");
            connection.close();
            statement.close();
        }
        catch (SQLException throwable) {
            System.out.println("error!");;
        }
    }
}
