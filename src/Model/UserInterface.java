package Model;

import Database.SetOfDatabaseFunction;
import Database.Word;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * Created by Jedrzej Hodor on 10.03.18.
 */

public class UserInterface {
    private String userName;
    private List<Word> words;
    private SetOfDatabaseFunction f;

    public UserInterface(String userName) {
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

    private List<Word> getWordsLang(String language) {
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

    private List<Word> importWordsAll() {
        return f.getUserWords("Admin");
    }

    private List<Word> importWordsLang(String language) {
        return f.getUserWordsWithLanguage("Admin", language);
    }



    public Boolean use() {
        this.setWords();
        System.out.println("Co mozemy dla ciebie zrobic?");
        System.out.println("1 - uczenie sie");
        System.out.println("2 - importuj slowa");
        System.out.println("3 - wyswietl slowa Admina");
        System.out.println("4 - wyswietl slowa");
        System.out.println("5 - edytuj slowa");
        System.out.println("6 - dodaj slowa");
        System.out.println("7 - wyjdz");

        Integer dec = GetFromHuman.getInt(1,7);

        if(dec == 1) {
            this.learning();
        } else if(dec >= 2 && dec <= 6) {
            System.out.println("Wpisz jezyk, jesli interesuje cie konkretny, w przeciwnym przypadku wpisz 'all'");
            Boolean ok = true;
            while(ok) {
                String language = GetFromHuman.getString();
                if(language.equals("all")) {
                    this.twoSixAll(dec);
                    ok = false;
                } else if(this.checkLanguage(language)) {
                    this.twoSixLang(dec, language);
                    ok = false;
                } else if(language.equals("-1")){
                    ok = false;
                } else {
                    System.out.println("Nie ma takiego jezyka, sprobuj ponownie.");
                }
            }
        } else {
            return false;
        }

        System.out.println("Cos jeszcze?");
        return GetFromHuman.getBoolean();

    }

    private void learning() {
        System.out.println("Jakiego jezyka chcesz sie uczyc?");
        Boolean ok = true;
        while(ok) {
            String lang = GetFromHuman.getString();
            if(this.checkLanguage(lang)) {
                Learning learning = new Learning(this.userName, lang);
                learning.learning();
                ok = false;
            } else if(lang.equals("-1")){
                ok = false;
            } else {
                System.out.println("Nie ma takiego jezyka, sprobuj ponownie.");
            }
        }
    }

    private void twoSixAll(Integer dec) {
        switch (dec) {
            case 2:
                this.importWords(importWordsAll());
                break;
            case 3:
                this.displayWords(importWordsAll());
                break;
            case 4:
                this.displayWords(this.words);
                break;
            case 5:
                this.editWords(this.words);
                break;
            case 6:
                this.addWords();
                break;
        }
    }

    private void twoSixLang(Integer dec, String language) {
        switch (dec) {
            case 2:
                this.importWords(this.importWordsLang(language));
                break;
            case 3:
                this.displayWords(this.importWordsLang(language));
                break;
            case 4:
                this.displayWords(this.getWordsLang(language));
                break;
            case 5:
                this.editWords(this.getWordsLang(language));
                break;
            case 6:
                this.addWordsL(language);
                break;
        }
    }


    private void importWords(List<Word> imported) {
        for(Word word : imported) {
            if(!checkIfHave(word)) {
                f.addWord(this.userName, word.getLanguage(), word.getForeign(), word.getPolish(), 0);
            }
        }
    }

    private void displayWords(List<Word> imported) {
        for(Word word : imported) {
            word.display();
        }
    }

    private void editWords(List<Word> words) {
        System.out.println("Na razie nie dostepne, prosze czekaj na update'y! ;)");
    }

    private void addWords() {
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

    private void addWordsL(String language) {
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

}
