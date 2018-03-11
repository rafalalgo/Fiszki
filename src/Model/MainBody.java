package Model;

import Database.SetOfDatabaseFunction;

/**
 * Created by Jedrzej Hodor on 28.02.18.
 */

public class MainBody {
    public static void main(String[] args) {

        Users.constructor();
        Language.constructor();

        Boolean stop = true;
        while(stop) {
            System.out.println("Witaj w naszej super aplikacji!!");
            System.out.println("Czuj sie jak u siebie w domu hihi");
            System.out.println("Wpisz '-1', aby przerwac trwajacy proces.");
            System.out.println("Czy jestes nowym uzytkownikiem?");
            Boolean answer = GetFromHuman.getBoolean();

            if(answer) {
                SignUp signup = new SignUp();
                if(signup.signUp()) {
                    if(signup.finalSignUp()) {
                        System.out.println("Rejestracja zakonczyla sie sukcesem, mozesz teraz sie zalogowac.");
                    } else {
                        TalkToHuman.fatalError();
                    }
                } else {
                    stop = TalkToHuman.exit();
                }
            } else {
                System.out.println("Podaj swoja nazwe uzytkownika.");
                String name = GetFromHuman.getString();
                if(Users.check(name)) {
                    System.out.println("Podaj haslo.");
                    String password = GetFromHuman.getString();
                    if(Users.checkPassword(name, password)) {
                        UserInterface ui = new UserInterface(name);
                        while(ui.use());
                    } else {
                        System.out.println("Bledne haslo!");
                        stop = TalkToHuman.exit();
                    }
                } else {
                    System.out.println("Nie ma takiego uzytkownika.");
                    stop = TalkToHuman.exit();
                }

            }
        }
        System.out.println("Do zoabczenia ponownie!");
    }
}
