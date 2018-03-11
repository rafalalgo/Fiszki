package Model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jedrzej Hodor on 10.03.18.
 */

public class Users {

    private static List<Pair> users;

    public static void addUsers(String user, String password) {
        Pair pair = new Pair(user, password);
        users.add(pair);
    }

    public static void constructor() {
        users = new LinkedList<>();
        addUsers("J", "a");
        addUsers("Rafal", "a");
        addUsers("Edyta", "a");
    }

    public static Boolean check(String notSure) {
        for(Pair user : users) {
            if(notSure.equals(user.getFirst())) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkPassword(String user, String notSure) {
        for(Pair u : users) {
            if(user.equals(u.getFirst())) {
                return notSure.equals(u.getSecond());
            }
        }
        return false;
    }


}
