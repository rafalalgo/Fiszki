package Model.MainBody;

/**
 * Created by Jedrzej Hodor on 28.02.18.
 */

public class MainBodyController {
    public static void main(String[] args) {

        //first set up:

        //new SetOfDatabaseFunction().createTableForNewUser("Admin");
        //new SetOfDatabaseFunction().createTableLanguages();
        //new SetOfDatabaseFunction().createTableUsers();

        /*
        Boolean stop = true;
        while(stop) {
            System.out.println("Witaj w naszej super aplikacji!!");
            System.out.println("Czuj sie jak u siebie w domu hihi");
            System.out.println("Wpisz '-1', aby przerwac trwajacy proces.");
            System.out.println("Czy jestes nowym uzytkownikiem?");
            Integer answer = GetFromHuman.getSpecialSecretInt(0, 1);

            if (answer == 1) {
                SignUp signup = new SignUp();
                if (signup.signUp()) {
                    if (signup.finalSignUp()) {
                        System.out.println("Rejestracja zakonczyla sie sukcesem, mozesz teraz sie zalogowac.");
                    } else {
                        TalkToHuman.fatalError();
                    }
                } else {
                    stop = TalkToHuman.exit();
                }
            } else if (answer == 0) {
                System.out.println("Podaj swoja nazwe uzytkownika.");
                String name = GetFromHuman.getString();
                SignIn signIn = new SignIn();
                if (signIn.signIn(name)) {
                    UserInterfaceController userinterface = new UserInterfaceController(name);
                    while (userinterface.use()) {
                    }
                    stop = TalkToHuman.exit();
                } else {
                    stop = TalkToHuman.exit();
                }
            } else if (answer == 69) {
                System.out.println("Jestes w trybie programisty!");
                DeveloperMode developerMode = new DeveloperMode();
                while (developerMode.action()) {
                }
                stop = TalkToHuman.exit();
            }
        }
        System.out.println("Do zoabczenia ponownie!");
        */



    }
}
