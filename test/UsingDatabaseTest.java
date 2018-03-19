import Database.SetOfDatabaseFunction;
import Model.UserInterface;

public class UsingDatabaseTest {
    public static void main(String[] args) {
        String user = "JJ";
        new SetOfDatabaseFunction().createTableForNewUser(user);
        UserInterface userInterface = new UserInterface(user);
        while(userInterface.use());
        new SetOfDatabaseFunction().deleteTableAndUser(user);
    }
}
