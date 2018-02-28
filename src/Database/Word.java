package Database;

import java.util.Objects;

public class Word {
    private int id;
    private String language;
    private String foreign;
    private String polish;
    private int state;

    public Word(int id, String language, String foreign, String polish, int state) {
        this.id = id;
        this.language = language;
        this.foreign = foreign;
        this.polish = polish;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getForeign() {
        return foreign;
    }

    public void setForeign(String foreign) {
        this.foreign = foreign;
    }

    public String getPolish() {
        return polish;
    }

    public void setPolish(String polish) {
        this.polish = polish;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void display() {
        System.out.println(id + " " + polish + " - " + foreign);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return id == word.id &&
                state == word.state &&
                Objects.equals(language, word.language) &&
                Objects.equals(foreign, word.foreign) &&
                Objects.equals(polish, word.polish);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, language, foreign, polish, state);
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", foreign='" + foreign + '\'' +
                ", polish='" + polish + '\'' +
                ", state=" + state +
                '}';
    }
}
