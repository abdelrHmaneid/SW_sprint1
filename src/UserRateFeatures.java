import java.sql.*;

public interface UserRateFeatures{

    public void rateDriver(String driverUserName ,int rate);

    public void checkRate(String driverName);
}


