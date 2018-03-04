package Database;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SetOfDatabaseFunction implements DatabaseFunction {
    @Override
    public boolean createTableForNewUser(String userName) {
        String createTableForNewUser = "CREATE TABLE  "
                + userName
                + " (id int PRIMARY KEY, lg VARCHAR(255), fg VARCHAR(255), pl VARCHAR(255), state int)";

        if (executeCommand(createTableForNewUser)) return false;

        System.out.println("SUCCESS");
        return true;
    }

    @Override
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

    @Override
    public boolean addWord(String userName, String language, String foreign, String polish, int state) {
        String createTableForNewUser = "INSERT INTO"
                + userName
                + "VALUES (" + 0 + ", " + language + ", " + foreign + ", " + polish + ", " + state + ")";
                // nie wiem skad wziac numerek, zeby byl kolejny

        if (executeCommand(createTableForNewUser)) return false;

        System.out.println("SUCCESS");
        return true;
    }

    @Override
    public boolean deleteWord(String userName, String language, String foreign) {
        return false;
    }

    @Override
    public boolean changeState(String userName, String language, String foreign) {
        return false;
    }

    @Override
    public List<Word> getUserWords(String userName) {
        return null;
    }

    @Override
    public List<Word> getUserWordsWithLanguage(String userName, String language) {
        return null;
    }

    @Override
    public List<Word> getUserWordWithSpecificState(String userName, int state) {
        return null;
    }
}
