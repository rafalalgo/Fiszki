package Database;

import jdk.internal.util.xml.impl.Pair;

import java.util.List;

public interface DatabaseFunction {
    boolean createTableForNewUser(String userName);

    boolean deleteTableAndUser(String userName);

    boolean addWord(String userName, String language, String foreign, String polish, int state);

    boolean deleteWord(String userName, String language, String foreign);

    boolean changeState(String userName, String language, String foreign, int newState);

    List<Word> getUserWords(String userName);

    List<Word> getUserWordsWithLanguage(String userName, String language);

    List<Word> getUserWordWithSpecificState(String userName, int state);


    boolean createTableLanguages();

    boolean addLanguage(String language);

    boolean deleteLanguage(String language);

    List<String> getLanguages();


    boolean createTableUsers();

    boolean addUser(String name, String password);

    boolean deleteUser(String name);

    List<Model.Pair> getUsers();

    List<String> getUserNames();
}
