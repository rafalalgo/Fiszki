package Model.UserInterface.Menu;

import Model.UserInterface.UserInterfaceController;

/**
 * Created by Jedrzej Hodor on 31.03.18.
 */

public class MenuController {

    private UserInterfaceController userInterfaceController;

    public MenuController(UserInterfaceController userInterfaceController) {
        this.userInterfaceController = userInterfaceController;
    }


    public void importWordsF() {
        userInterfaceController.importWords(userInterfaceController.importWordsAll());
    }

    public void displayWordsAdminF() {
        userInterfaceController.displayWords(userInterfaceController.importWordsAll());
    }

    public void displayWordsF() {
        userInterfaceController.displayWords(userInterfaceController.getWords());
    }

    public void editWordsF() {
        userInterfaceController.editWords(userInterfaceController.getWords());
    }

    public void addWordsF() {
        userInterfaceController.addWords();
    }

}
