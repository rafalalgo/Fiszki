package Model.UserInterface.SpecificLanguageMenu;

import Model.UserInterface.UserInterfaceController;

/**
 * Created by Jedrzej Hodor on 31.03.18.
 */

public class SpecificLanguageMenuController {

    private UserInterfaceController userInterfaceController;
    private String language;

    public SpecificLanguageMenuController(UserInterfaceController userInterfaceController, String language) {
        this.userInterfaceController = userInterfaceController;
        this.language = language;
    }


    public void importWordsF() {
        userInterfaceController.importWords(userInterfaceController.importWordsLang(this.language));
    }

    public void displayWordsAdminF() {
        userInterfaceController.displayWords(userInterfaceController.importWordsLang(this.language));
    }

    public void displayWordsF() {
        userInterfaceController.displayWords(userInterfaceController.getWordsLang(this.language));
    }

    public void editWordsF() {
        userInterfaceController.editWords(userInterfaceController.getWordsLang(this.language));
    }

    public void addWordsF() {
        userInterfaceController.addWordsL(this.language);
    }

}
