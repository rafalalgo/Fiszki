package Model;

import Database.SetOfDatabaseFunction;

/**
 * Created by Jedrzej Hodor on 15.03.2018.
 */


public class DeveloperMode {

    public Boolean action() {
        System.out.println("1 - dodaj jezyk");
        System.out.println("2 - usun jezyk");
        System.out.println("3 - usun uzytkownika");

        Integer answer = GetFromHuman.getInt(1,3);
        this.doo(answer);
        System.out.println("Cos jeszcze?");
        return GetFromHuman.getBoolean();
    }

    private void doo(int what) {
        switch (what) {
            case 1:
                this.addLanguage();
                break;
            case 2:
                this.deleteLanguage();
                break;
            case 3:
                this.deleteUser();
                break;
        }
    }

    private void addLanguage() {
        System.out.println("Jaki jezyk chcesz dodac?");
        String language = GetFromHuman.getString();
        System.out.println("Czy na pewno chcesz dodac" + language + "?");
        Boolean iff = GetFromHuman.getBoolean();
        if(iff) {
            new SetOfDatabaseFunction().addLanguage(language);
        }
    }

    private void deleteLanguage() {
        System.out.println("Jaki jezyk chcesz usunac?");
        String language = GetFromHuman.getString();
        System.out.println("Czy na pewno chcesz usunac" + language + "?");
        Boolean iff = GetFromHuman.getBoolean();
        if(iff) {
            new SetOfDatabaseFunction().deleteLanguage(language);
        }
    }

    private void deleteUser() {
        System.out.println("Kogo chcesz usunac?");
        String user = GetFromHuman.getString();
        System.out.println("Czy na pewno chcesz usunac" + user + "?");
        Boolean iff = GetFromHuman.getBoolean();
        if(iff) {
            new SetOfDatabaseFunction().deleteUser(user);
            new SetOfDatabaseFunction().deleteTableAndUser(user);
        }
    }

}
