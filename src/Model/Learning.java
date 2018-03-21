package Model;

import Database.Word;
import Database.SetOfDatabaseFunction;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

/**
 * Created by Jedrzej Hodor on 28.02.18.
 */

public class Learning {
    private String language;
    private String user;
    private List<Word> list;
    private List<List<Word>> superList;
    private SetOfDatabaseFunction setOfDatabaseFunction;

    public Learning(String user, String language) {
        this.language = language;
        this.user = user;
        this.setOfDatabaseFunction = new SetOfDatabaseFunction();
        this.list = setList(user, language);
        this.superList = setSuperList(user, language);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    private List<Word> setList(String user, String language) {
        return this.setOfDatabaseFunction.getUserWordsWithLanguage(user, language);
    }

    private List<List<Word>> setSuperList(String user, String language) {
        List<List<Word>> superList = new LinkedList<>();
        for(int i = 0; i <= 13; i++) {
            List<Word> list = this.setOfDatabaseFunction.getUserWordWithSpecificStateAndLanguage(user, language, i);
            superList.add(list);
        }
        return superList;
    }


    private Integer checkFirstBox() {
        Integer counter = 0;
        for(Word word : list) {
            if(word.getState() == 1){
                counter ++;
            }
        }
        if(counter > 30) {
            TalkToHuman.fatalError();
            return -1;
        } else if (counter == 30) {
            return 0;
        } else {
            return 30 - counter;
        }
    }

    private void addToFirstBox() {
        Integer missing = this.checkFirstBox();
        Boolean stop = true;
        List<Word> boxZ = this.superList.get(0);

        while(stop) {
            if(missing > 0) {
                System.out.println("Words, which you can add to your first box: ");

                for (Word word : boxZ) {
                    word.display();
                }

                System.out.println("Press 1 to choose a word, 0 to decline. Be aware, that your fist box may have less than 30 words. ");

                for (Word word : boxZ) {
                    if(TalkToHuman.askIfWord(word)) {
                        setOfDatabaseFunction.changeState(this.user, this.language, word.getForeign(), 1);
                    }
                }
            }
            if(missing > 0) {
                System.out.println("Are you sure, that you don't want to add anymore?");
                if(GetFromHuman.getBoolean())
                    stop = false;
            } else {
                stop = false;
            }
        }
    }

    private void doABox(Integer nr) {
        if((nr >= 1 && nr <= 6) || nr == 9 || nr == 12) {
            for(Word word : this.superList.get(nr)) {
                if(TalkToHuman.askQuestion(this.language, nr % 2, word)) {
                    setOfDatabaseFunction.changeState(this.user, this.language, word.getForeign(), nr + 1);;
                }
            }
        } else if (nr == 7 || nr == 8 || nr == 10 || nr == 11) {
            for(Word word : this.superList.get(nr)) {
                setOfDatabaseFunction.changeState(this.user, this.language, word.getForeign(), nr + 1);
            }
        } else {
            TalkToHuman.fatalError();
        }
    }

    private void extraRound() {
        List<Word> boxThirteen = this.superList.get(13);
        Collections.shuffle(boxThirteen);

        Integer how_many = Math.min(10, boxThirteen.size());
        for(int i = 0; i < how_many; i++) {
            if(!TalkToHuman.askQuestion(this.language, i % 2, boxThirteen.get(i))) {
                Word word = boxThirteen.get(i);
                setOfDatabaseFunction.changeState(this.user, this.language, word.getForeign(), 2);
            }
        }
    }


    public void learning() {
        this.addToFirstBox();
        this.superList = setSuperList(user, language);
        for(int i = 1; i <= 12; i++) {
            System.out.println("Box number: " + i);
            this.doABox(i);
            System.out.println("DONE");
        }
        System.out.println("Extra round:");
        this.extraRound();
        System.out.println("ALL DONE!");
        System.out.println("Keep it this way!!!");
    }
}
