import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class  Registration {
    String userName;
    String password;
    String mobileNumber;
    String email;
    public Registration(String userName, String password, String mobileNumber, String email) {
        this.userName = userName;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public  Registration(){

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }
    public abstract boolean login(String username, String password);


    public abstract void Register();

}
