package Model;

import Database.SetOfDatabaseFunction;
import Database.Word;
import jdk.internal.util.xml.impl.Pair;

import java.util.List;

/**
 * Created by Jedrzej Hodor on 10.03.18.
 */


public class SignUp {
    private String userName;
    private String password;

    public SignUp() {
        this.userName = null;
        this.password = null;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    private Boolean checkUserName(String check) {
        List<String> users = new SetOfDatabaseFunction().getUserNames();
        users.add("Admin");
        users.add("Languages");
        users.add("Users");

        return users.contains(check);
    }

    private Boolean setUser() {
        Boolean stop = true;
        while(stop){
            System.out.println("Wpisz nazwe uzytkownika.");
            String name = GetFromHuman.getString();
            if(name.equals("-1")) {
                stop = false;
            } else if(this.checkUserName(name)) {
                System.out.println("Nazwa zajeta! Sprobuj ponownie");
            } else {
                this.setUserName(name);
                return true;
            }
        }
        return false;
    }

    private Boolean setPassword() {
        Boolean stop = true;
        while(stop){
            System.out.println("Wpisz haslo.");
            String password = GetFromHuman.getString();
            if(password.equals("-1")) {
                stop = false;
            } else {
                System.out.println("Potwierdz haslo.");
                String password2 = GetFromHuman.getString();
                if(password2.equals("-1")) {
                    stop = false;
                } else if (!password2.equals(password)) {
                    System.out.println("Hasla sie nie zgadzaja, sprobuj ponownie.");
                } else {
                    this.setPassword(password);
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean signUp() {
        if(this.setUser()) {
            if(this.setPassword()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean finalSignUp() {
        //dodanie usera do jakiejs listy userow, tylko nie wiem, gdzie ma byc ta lista,
        // czy to ma byc oddzielna tabelka w sql? chyba ma sens

        Boolean succ =  new SetOfDatabaseFunction().createTableForNewUser(this.getUserName());
        return succ;
    }

}
