package Model;

import Database.SetOfDatabaseFunction;

import java.util.List;

/**
 * Created by Jedrzej Hodor on 15.03.2018.
 */

public class SignIn {

    public Boolean signIn(String name) {

        if(this.checkName(name)) {
            System.out.println("Podaj haslo.");
            String password = GetFromHuman.getString();
            return this.checkPassword(name, password);
        } else {
            System.out.println("Nie ma takiego uzytkownika.");
            return false;
        }
    }

    private Boolean checkName(String name) {
        List<String> users = new SetOfDatabaseFunction().getUserNames();
        return users.contains(name);
    }

    private Boolean checkPassword(String name, String password) {
        List<Model.Pair> users = new SetOfDatabaseFunction().getUsers();
        for(Model.Pair user : users) {
            if((user.getFirst()).equals(name)) {
                if((user.getSecond()).equals(password)) {
                    return true;
                } else {
                    System.out.println("Bledne haslo!");
                    return false;
                }
            }
        }
        return false;
    }
}
