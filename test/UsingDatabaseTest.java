import Database.SetOfDatabaseFunction;
import Model.UserInterface;

public class UsingDatabaseTest {
    public static void main(String[] args) {
        String userName = "JJ";
        //new SetOfDatabaseFunction().createTableForNewUser(userName);
        UserInterface userInterface = new UserInterface(userName);

        //SetOfDatabaseFunction setOfDatabaseFunction = new SetOfDatabaseFunction();

        while(userInterface.use());
        new SetOfDatabaseFunction().deleteTableAndUser(userName);
    }
}
