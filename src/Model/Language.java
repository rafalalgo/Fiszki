package Model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jedrzej Hodor on 10.03.18.
 */

public class Language {

    private static List<String> possible;

    public static void constructor() {
        possible = new LinkedList<>();
        possible.add("eng");
        possible.add("deu");
        possible.add("esp");
    }

    public static void addPossibleLanguages(String poss) {
        possible.add(poss);
    }

    public static Boolean check(String notSure) {
        for(String language : possible) {
            if(notSure.equals(language)) {
                return true;
            }
        }
        return false;
    }

}
