import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class  Registration {

    public Registration() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Abd Elrahman\\IdeaProjects\\Gobr\\data.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into User Values()");
        }
        catch (SQLException throwable) {
            System.out.println("Error!");;
        }
    }

}
