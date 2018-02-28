package Model;

import Database.Word;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Learning {
    private String language;
    private String user;
    private List<Word> list;

    public Learning(String language, String user, List<Word> list) {
        this.language = language;
        this.user = user;
        this.list = list;
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


    private void setList() {
        //pobiera tabelke usera ze wszystkimi slowami
    }

    private Boolean ifLanguage(Word word) {
        if(word.getLanguage() == language) {
            return true;
        } else {
            return false;
        }
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
        while(stop) {
            if(missing > 0) {
                System.out.println("Words, which you can add to your first box: ");

                for (Word word : this.list) {
                    if ((word.getState() == 0) && (ifLanguage(word)))
                        word.display();
                }

                System.out.println("Press 1 to choose a word, 0 to decline. Be aware, that your fist box may have less than 30 words. ");

                for (Word word : this.list) {
                    if ((word.getState() == 0) && (ifLanguage(word)))
                    {
                        if(TalkToHuman.askIfWord(word)) {
                            word.setState(1);
                        }
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
            for(Word word : this.list) {
                if(this.ifLanguage(word) && word.getState() == nr) {
                    if(TalkToHuman.askQuestion(this.language, nr % 2, word)) {
                        word.setState(nr + 1);
                    }
                }
            }
        } else if (nr == 7 || nr == 8 || nr == 10 || nr == 11) {
            for(Word word : this.list) {
                if(this.ifLanguage(word) && word.getState() == nr) {
                    word.setState(nr + 1);
                }
            }
        } else {
            TalkToHuman.fatalError();
        }
    }

    private void extraRound() {
        LinkedList<Word> boxThirteen = new LinkedList<>();
        for(Word word : list) {
            if(this.ifLanguage(word) && word.getState() == 13) {
                boxThirteen.add(word);
            }
        }
        Collections.shuffle(boxThirteen);

        Integer how_many = Math.max(10, boxThirteen.size());
        for(int i = 0; i < how_many; i++) {
            if(!TalkToHuman.askQuestion(this.language, i % 2, boxThirteen.get(i))) {
                (boxThirteen.get(i)).setState(2);
            }
        }
    }


    public void learning() {
        this.addToFirstBox();
        for(int i = 1; i <= 12; i++) {
            this.doABox(i);
        }
        this.extraRound();
    }
}
