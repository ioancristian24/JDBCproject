import java.sql.Connection;
import java.util.Scanner;

public class GroupMenu {

    public static void displayGroupMenu(Connection connection){
        System.out.println("========= Group Menu =========");
        System.out.println(" Please select one option: ");
        System.out.println("1.  Display group table ");
        System.out.println("2.  Add group ");
        System.out.println("3.  Add group from keyboard ");
        System.out.println("4.  Display info about selected group ");
        System.out.println("5.  Delete group from keyboard ");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        System.out.println("Your choice: " + choice);

        switch (choice){
            case "1":
                GroupMenuHandler.displayGroupTable(connection);
                break;
            case "2":
                GroupMenuHandler.insertNewGroup(connection);
                break;
            case "3":
                System.out.println("Please type the name of the group: ");
                String name = scanner.nextLine();
                GroupMenuHandler.insertNewGroupFromKeyboard(connection, name);
                break;
            case "4":
                System.out.println("Please type the name of the group: ");
                System.out.println("Name of group: ");
                name = scanner.nextLine();
                GroupMenuHandler.searchForGroup(connection,name);
                break;
            case "5":
                System.out.println("Please type the name of group that you want to delete: ");
                name = scanner.nextLine();
                GroupMenuHandler.deleteAGroupFromKeyboard(connection,name);
                break;
            default:
                System.out.println("You do not have a valid choice ");
        }
    }
}
