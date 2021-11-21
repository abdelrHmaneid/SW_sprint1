import java.util.Scanner;

public class Administrator {
    public static void main(String[] args) {
        Scanner press = new Scanner(System.in);

        while(true) {
            System.out.println("press 1 to register new account");
            System.out.println("press 2 to login");
            System.out.println("press 3 to exit");
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
                    while (user.login(username,password)) {
                        System.out.println("press 1 to request a ride");
                        System.out.println("press 2 to rate a driver");
                        System.out.println("press 3 see driver rate");
                        System.out.println("press 4 back to main menu");
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
                            System.out.println("Thank you for rating");
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
                    while (driver.login(username,password)){
                        driver.calculateRate();
                        System.out.println("press 1 add favorite area");
                        System.out.println("press 2 to offers");
                        System.out.println("press 3 see users rate");
                        System.out.println("press 4 back to main menu");
                        int p3 = press.nextInt();
                        if (p3 == 1) {
                            //add fav area
                        }
                        else if (p3 == 2) {
                            //offers
                        }
                        else if (p3 == 3){
                            //see users rate
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
