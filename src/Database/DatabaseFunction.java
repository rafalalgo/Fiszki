package Database;

import java.util.List;

public interface DatabaseFunction {
    boolean createTableForNewUser(String userName);

    boolean deleteTableAndUser(String userName);

    boolean addWord(String userName, String language, String foreign, String polish, int state);

    boolean deleteWord(String userName, String language, String foreign);

    boolean changeState(String userName, String language, String foreign);

    List<Word> getUserWords(String userName);

    List<Word> getUserWordsWithLanguage(String userName, String language);

    List<Word> getUserWordWithSpecificState(String userName, int state);
}
