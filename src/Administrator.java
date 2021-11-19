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

                }
                else {

                }
            }
            else if(p1 == 2){
                System.out.println("press 1 to login as User");
                System.out.println("press 2 to login as Driver");
                int p2 = press.nextInt();
                if (p2 == 1){

                }
                else {

                }
            }
            else {
                break;
            }
        }
    }
}
