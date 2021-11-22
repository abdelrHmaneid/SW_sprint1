import java.sql.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner press = new Scanner(System.in);

        while(true) {
            System.out.println("press 1 to register new account");
            System.out.println("press 2 to login");
            System.out.println("press 3 to login as admin");
            System.out.println("press 4 to exit");
            int p1 = press.nextInt();
            if (p1 == 1) {
                System.out.println("press 1 to register new User");
                System.out.println("press 2 to register new Driver");
                int p2 = press.nextInt();
                if (p2 == 1){
                    System.out.println("Enter your username");
                    String username = press.next();
                    System.out.println("Enter your password");
                    String password = press.next();
                    System.out.println("Enter your email (optional)");
                    String email = press.next();
                    System.out.println("Enter your phone number");
                    String phone = press.next();
                    User user = new User(username,password,email,phone);
                    user.Register();
                }
                else {
                    System.out.println("Enter your username");
                    String username = press.next();
                    System.out.println("Enter your password");
                    String password = press.next();
                    System.out.println("Enter your email (optional)");
                    String email = press.next();
                    System.out.println("Enter your phone number");
                    String phone = press.next();
                    System.out.println("Enter your national ID");
                    long NID = press.nextLong();
                    System.out.println("Enter your licence");
                    String licence = press.next();
                    Driver driver = new Driver(username,password,email,phone,NID,licence);
                    driver.Register();
                }
            }
            else if(p1 == 2){
                System.out.println("press 1 to login as User");
                System.out.println("press 2 to login as Driver");
                int p2 = press.nextInt();
                if (p2 == 1){
                    System.out.println("Enter your username");
                    String username = press.next();
                    System.out.println("Enter your password");
                    String password = press.next();
                    User user = new User();
                    boolean flag = user.login(username,password);
                    while (flag) {
                        System.out.println("press 1 to request a ride");
                        System.out.println("press 2 to rate a driver");
                        System.out.println("press 3 see driver rate");
                        System.out.println("press 4 back to main menu (logout)");
                        int p3 = press.nextInt();
                        if (p3 == 1) {
                            System.out.println("Enter your source");
                            String s = press.next();
                            System.out.println("Enter your destination");
                            String d = press.next();
                            user.requestRide(s,d);
                        } else if (p3 == 2) {
                            System.out.println("Enter driver name that you want to rate");
                            String driverName = press.next();
                            System.out.println("Enter rate from (1 worst) to (5 best)");
                            int rate = press.nextInt();
                            user.rateDriver(driverName,rate);
                        }
                        else if (p3 == 3){
                            System.out.println("Enter driver name that you want to see his rate");
                            String driverName = press.next();
                            user.checkRate(driverName);
                        }
                        else {
                            break;
                        }
                    }
                }
                else {
                    System.out.println("Enter your username");
                    String username = press.next();
                    System.out.println("Enter your password");
                    String password = press.next();
                    Driver driver = new Driver();
                    boolean flag = driver.login(username,password);
                    while (flag){
                        driver.calculateRate();
                        System.out.println("press 1 add favorite area");
                        System.out.println("press 2 to offers");
                        System.out.println("press 3 see users rate");
                        System.out.println("press 4 back to main menu (logout)");
                        int p3 = press.nextInt();
                        if (p3 == 1) {
                            System.out.println("Enter your favorite area");
                            String fav = press.next();
                            driver.addFavArea(fav);
                            System.out.println("you add "+fav+" as favorite area");
                        }
                        else if (p3 == 2) {
                            System.out.println("press 1 see near by requests");
                            System.out.println("press 2 set prices for all offers");
                            int p4 = press.nextInt();
                            if (p4 == 1){
                                driver.notifyRide();
                            }
                            else {
                                driver.offer();
                            }
                        }
                        else if (p3 == 3){
                            driver.seeMyRates();
                        }
                        else {
                            break;
                        }
                    }

                }
            }
            else if (p1 == 3){
                System.out.println("Enter Admin name");
                String adminName =press.next();
                System.out.println("Enter Admin password");
                String password = press.next();
                Admin.getAdmin();
                if(Admin.getAdmin().getAdminName().equals(adminName) && Admin.getAdmin().getAdminPassword().equals(password)){
                    System.out.println("Welcome Admin");
                    while (true){
                        System.out.println("Press 1 verify driver");
                        System.out.println("Press 2 suspend account");
                        System.out.println("Press 3 logout");
                        int p2 = press.nextInt();
                        if(p2 == 1){
                            System.out.println("Enter driver name you want to verify");
                            String driverName = press.next();
                            Admin.verify(driverName);
                        }
                        else if (p2 == 2){
                            System.out.println("press 1 suspend user");
                            System.out.println("press 2 suspend driver");
                            int p3 = press.nextInt();
                            if (p3 == 1){
                                System.out.println("Enter user name you want to suspend");
                                String userName = press.next();
                                Admin.suspendUser(userName);
                            }
                            else {
                                System.out.println("Enter driver name you want to suspend");
                                String driverName = press.next();
                                Admin.suspendUser(driverName);
                            }
                        }
                        else {
                            break;
                        }
                    }
                }
            }
            else {
                System.out.println("program closed");
                break;
            }
        }
    }
}
