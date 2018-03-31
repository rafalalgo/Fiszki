package Model.UserInterface;

import Database.SetOfDatabaseFunction;
import Database.Word;
import Model.GetFromHuman;
import Model.Learning;
import Model.UserInterface.Menu.MenuController;
import Model.UserInterface.SpecificLanguageMenu.SpecificLanguageMenuController;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.fxml.FXML;

import java.awt.*;
import java.util.List;

/**
 * Created by Jedrzej Hodor on 10.03.18.
 */

public class UserInterfaceController {
    private String userName;
    private List<Word> words;
    private SetOfDatabaseFunction f;

    @FXML
    private TextField choosenLanguage;

    public UserInterfaceController(String userName) {
        this.userName = userName;
        this.f = new SetOfDatabaseFunction();
        this.setWords();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private void setWords() {
        this.words = f.getUserWords(userName);
    }

    public List<Word> getWords() {
        return this.words;
    }

    public List<Word> getWordsLang(String language) {
        return f.getUserWordsWithLanguage(userName, language);
    }

    private Boolean checkLanguage(String check) {
        /*
        List<String> languages = new SetOfDatabaseFunction().getLanguages();
        languages.add("all");
        return !languages.contains(check);
        */
        return true;
    }

    private Boolean checkIfHave(Word word) {
        for (Word w: this.words) {
            if(word.equals(w)) {
                return true;
            }
        }
        return false;
    }

    public List<Word> importWordsAll() {
        return f.getUserWords("Admin");
    }

    public List<Word> importWordsLang(String language) {
        return f.getUserWordsWithLanguage("Admin", language);
    }


    public void importWords(List<Word> imported) {
        for(Word word : imported) {
            if(!checkIfHave(word)) {
                f.addWord(this.userName, word.getLanguage(), word.getForeign(), word.getPolish(), 0);
            }
        }
    }

    public void displayWords(List<Word> imported) {
        for(Word word : imported) {
            word.display();
        }
    }

    public void editWords(List<Word> words) {
        System.out.println("Na razie nie dostepne, prosze czekaj na update'y! ;)");
    }

    public void addWords() {
        Boolean stop = true;
        String language;
        String foreign;
        String polish;
        while (stop) {
            System.out.println("Language:");
            language = GetFromHuman.getString();
            if (!this.checkLanguage(language)) {
                stop = false;
            } else {
                System.out.println("Foreign:");
                foreign = GetFromHuman.getString();
                if (foreign.equals("-1")) {
                    stop = false;
                    break;
                }
                System.out.println("Polish:");
                polish = GetFromHuman.getString();
                if (polish.equals("-1")) {
                    stop = false;
                    break;
                }
                System.out.println("Czy na pewno chcesz dodac slowo?");
                System.out.println(language + ", " + foreign + ", " + polish);
                if (GetFromHuman.getBoolean()) {
                    f.addWord("Admin", language, foreign, polish, 0);
                    f.addWord(this.userName, language, foreign, polish, 0);
                }
            }
        }
    }

    public void addWordsL(String language) {
        Boolean stop = true;
        String foreign;
        String polish;
        while (stop) {
            System.out.println("Foreign:");
            foreign = GetFromHuman.getString();
            if (foreign.equals("-1")) {
                stop = false;
                break;
            }
            System.out.println("Polish:");
            polish = GetFromHuman.getString();
            if (polish.equals("-1")) {
                stop = false;
                break;
            }
            System.out.println("Czy na pewno chcesz dodac slowo?");
            System.out.println(language + ", " + foreign + ", " + polish);
            if (GetFromHuman.getBoolean()) {
                f.addWord("Admin", language, foreign, polish, 0);
                f.addWord(this.userName, language, foreign, polish, 0);
            }
        }
    }


    public void learning() {
        String l = this.choosenLanguage.getText();
        if(this.checkLanguage(l)) {
            Learning learning = new Learning(this.userName, l);
            learning.learning();
            //okienko
        }
    }

    public void menu() {
        MenuController menuController = new MenuController(this);
        //cos zeby wywolac okienko
    }

    public void specificLanguageMenu() {
        String l = this.choosenLanguage.getText();
        if(this.checkLanguage(l)) {
            SpecificLanguageMenuController specificLanguageMenuController = new SpecificLanguageMenuController(this, l);
            //cos zeby wywolac okienko
        }
    }

}