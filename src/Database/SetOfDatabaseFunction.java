package Database;

import java.sql.SQLException;
import java.sql.Statement;

public class SetOfDatabaseFunction {
    public boolean createTableForNewUser(String userName) {
        String createTableForNewUser = "CREATE TABLE  "
                + userName
                + " (id int PRIMARY KEY, lg VARCHAR(255), fg VARCHAR(255), pl VARCHAR(255), state int)";

        if (executeCommand(createTableForNewUser)) return false;

        System.out.println("SUCCESS");
        return true;
    }

    public boolean deleteTableAndUser(String userName) {
        String deleteTable = "DROP TABLE IF EXISTS " + userName + ";";

        if (executeCommand(deleteTable)) return false;

        System.out.println("SUCCESS");
        return true;
    }

    private boolean executeCommand(String command) {
        try (Statement stat = Database.instance.connection.createStatement()) {
            stat.execute(command);
        } catch (SQLException e) {
            System.err.println("FAILURE");
            return true;
        }
        return false;
    }
}
