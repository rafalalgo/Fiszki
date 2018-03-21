package Database;


import Model.Pair;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SetOfDatabaseFunction implements DatabaseFunction {
    @Override
    public boolean createTableForNewUser(String userName) {
        String createTableForNewUser = "CREATE TABLE  "
                + userName
                + " (id int, lg VARCHAR(255), fg VARCHAR(255), pl VARCHAR(255), state int)";

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
        List<Word> words = this.getUserWords(userName);
        Word word = new Word(0, language, foreign, polish, state);
        for(Word w : words) {
            if(word.equals2(w)) {
                System.out.println("FAILURE");
                return false;
            }
        }

        String addWord = "INSERT INTO "
                + userName
                + " VALUES ( " + 0 + ", '" + language + "', '" + foreign + "', '" + polish + "', " + state + " );";
                // nie wiem skad wziac numerek, zeby byl kolejny

        if (executeCommand(addWord)) return false;

        System.out.println("SUCCESS");
        return true;
    }

    @Override
    public boolean deleteWord(String userName, String language, String foreign) {
        String deleteWord = "DELETE FROM "
                + userName
                + " WHERE lg = '" + language + "' AND fg = '" + foreign + "';";

        if (executeCommand(deleteWord)) return false;

        System.out.println("SUCCESS");
        return true;
    }

    @Override
    public boolean changeState(String userName, String language, String foreign, int newState) {
        String changeState = "UPDATE "
                + userName
                + " SET STATE = " + newState
                + " WHERE lg = '" + language + "' AND fg = '" + foreign + "';";

        if (executeCommand(changeState)) return false;

        System.out.println("SUCCESS");
        return true;
    }

    @Override
    public List<Word> getUserWords(String userName) {
        try (Statement stat = Database.instance.connection.createStatement()) {
            List<Word> wordList = new LinkedList<>();
            try {
                ResultSet resultSet = stat.executeQuery("SELECT * FROM " + userName + ";" );
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String language = resultSet.getString("lg");
                    String foreign = resultSet.getString("fg");
                    String polish = resultSet.getString("pl");
                    int state = resultSet.getInt("state");

                    Word word = new Word(id, language, foreign, polish, state);
                    wordList.add(word);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
            return wordList;
        } catch (SQLException e) {
            System.err.println("FAILURE");
            return null;
        }
    }

    @Override
    public List<Word> getUserWordsWithLanguage(String userName, String language) {
        List<Word> listWord = this.getUserWords(userName);
        return listWord.stream().filter(item -> (item.getLanguage()).equals(language)).collect(Collectors.toList());
    }

    @Override
    public List<Word> getUserWordWithSpecificState(String userName, int state) {
        List<Word> listWord = this.getUserWords(userName);
        return listWord.stream().filter(item -> item.getState() == state).collect(Collectors.toList());
    }

    @Override
    public List<Word> getUserWordWithSpecificStateAndLanguage(String userName, String language, int state) {
        List<Word> listWord = this.getUserWordsWithLanguage(userName, language);
        return listWord.stream().filter(item -> item.getState() == state).collect(Collectors.toList());
    }



    @Override
    public boolean createTableLanguages(){
        String createTableForNewUser = "CREATE TABLE  "
                + "Languages"
                + " (id int, lang VARCHAR(255))";

        if (executeCommand(createTableForNewUser)) return false;

        System.out.println("SUCCESS");
        return true;
    }

    @Override
    public boolean addLanguage(String language){
        List<String> langs = this.getLanguages();
        for(String l : langs) {
            if(language.equals(l)) {
                System.out.println("FAILURE");
                return false;
            }
        }
        String addWord = "INSERT INTO "
                + "Languages"
                + " VALUES ( " + 0 + ", '" + language + "')";

        if (executeCommand(addWord)) return false;

        System.out.println("SUCCESS");
        return true;
    }

    @Override
    public boolean deleteLanguage(String language){
        String addWord = "DELETE FROM "
                + "Languages"
                + " WHERE lang = '" + language + "'";

        if (executeCommand(addWord)) return false;

        System.out.println("SUCCESS");
        return true;
    }

    @Override
    public List<String> getLanguages(){
        try (Statement stat = Database.instance.connection.createStatement()) {
            List<String> languages = new LinkedList<>();
            try {
                ResultSet resultSet = stat.executeQuery("SELECT * FROM " + "Languages" + ";" );
                while (resultSet.next()) {
                    String language = resultSet.getString("lang");

                    languages.add(language);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
            return languages;
        } catch (SQLException e) {
            System.err.println("FAILURE");
            return null;
        }
    }


    @Override
    public boolean createTableUsers(){
        String createTableForNewUser = "CREATE TABLE  "
                + "Users"
                + " (id int, name VARCHAR(255), password VARCHAR(255))";

        if (executeCommand(createTableForNewUser)) return false;

        System.out.println("SUCCESS");
        return true;
    }

    @Override
    public boolean addUser(String name, String password){
        String addWord = "INSERT INTO "
                + "Users"
                + " VALUES ( " + 0 + ", '" + name + ", '" + password + "')";

        if (executeCommand(addWord)) return false;

        System.out.println("SUCCESS");
        return true;
    }

    @Override
    public boolean deleteUser(String name){
        String addWord = "DELETE FROM "
                + "Languages"
                + " WHERE name = '" + name + "'";

        if (executeCommand(addWord)) return false;

        System.out.println("SUCCESS");
        return true;
    }

    @Override
    public List<Model.Pair> getUsers(){
        try (Statement stat = Database.instance.connection.createStatement()) {
            List<Pair> users = new LinkedList<>();
            try {
                ResultSet resultSet = stat.executeQuery("SELECT * FROM " + "Users" + ";" );
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String password = resultSet.getString("password");

                    Pair<String, String> user = new Pair<>(name, password);
                    users.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
            return users;
        } catch (SQLException e) {
            System.err.println("FAILURE");
            return null;
        }
    }

    @Override
    public List<String> getUserNames(){
        List<Pair> users = this.getUsers();
        List<String> names = new LinkedList<>();
        for(Pair user : users) {
            names.add((user.getFirst()).toString());
        }
        return names;
    }
}
