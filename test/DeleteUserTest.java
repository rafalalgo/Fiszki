import Database.SetOfDatabaseFunction;

public class DeleteUserTest {
    public static void main(String[] args) {
        new SetOfDatabaseFunction().deleteTableAndUser("Jędrzej");
        new SetOfDatabaseFunction().deleteTableAndUser("Rafał");
        new SetOfDatabaseFunction().deleteTableAndUser("Edyta");
    }
}
