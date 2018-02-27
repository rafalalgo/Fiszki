import Database.SetOfDatabaseFunction;

public class CreateNewUserTest {
    public static void main(String[] args) {
        new SetOfDatabaseFunction().createTableForNewUser("Jędrzej");
        new SetOfDatabaseFunction().createTableForNewUser("Rafał");
        new SetOfDatabaseFunction().createTableForNewUser("Edyta");
    }
}
