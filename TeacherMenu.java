import java.sql.Connection;
import java.util.Scanner;

public class TeacherMenu {

    public static void displayMenuTeacher(Connection connection){
        System.out.println("========= Teacher Menu =========");
        System.out.println(" Please select one option: ");
        System.out.println("1.  Display teacher table ");
        System.out.println("2.  Add teacher ");
        System.out.println("3.  Add teacher from keyboard ");
        System.out.println("4.  Display info about selected teacher ");
        System.out.println("5.  Delete teacher from keyboard ");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        System.out.println("your choice: " + choice);

        switch (choice){
            case "1":
                TeacherMenuHandler.displayTeacherTable(connection);
                break;
            case "2":
                TeacherMenuHandler.insertNewTeacher(connection);
                break;
            case "3":
                System.out.println("Please insert the first name of the teacher: ");
                String firstName = scanner.nextLine();

                System.out.println("Please insert the last name of the teacher: ");
                String lastName = scanner.nextLine();

                System.out.println("Please insert the age of the teacher: ");
                Integer age = scanner.nextInt();

                System.out.println("Please insert the tip of the teacher: ");
                String tip = scanner.nextLine();

                TeacherMenuHandler.insertNewTeacherFromKeyboard(connection,firstName,lastName,age,tip);
                break;
            case "4":
                System.out.println("Please type the first name of the teacher: ");
                System.out.println("First Name: ");
                firstName = scanner.nextLine();

                TeacherMenuHandler.searchForTeacher(connection, firstName);
                break;
            case "5":
                System.out.println("Please type the first name of the teacher that you want to delete:");
                firstName = scanner.nextLine();

                System.out.println("Please type the last name of the teacher that you want to delete: ");
                lastName = scanner.nextLine();

                TeacherMenuHandler.deleteATeacherFromKeyboard(connection, firstName, lastName);
                break;
            default:
                System.out.println("You do not have a valid choice ");
        }
    }
}
