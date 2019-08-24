import java.sql.Connection;
import java.util.Scanner;

public class StudentMenu {

    public static void displayMenuStudent(Connection connection){
        System.out.println("========= Student Menu =========");
        System.out.println(" Please select one option: ");
        System.out.println("1.  Display student table ");
        System.out.println("2.  Add student ");
        System.out.println("3.  Add student from keyboard ");
        System.out.println("4.  Display info about selected student ");
        System.out.println("5.  Delete student from keyboard ");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        System.out.println("Your choice: " + choice);

        switch (choice){
            case "1":
                StudentMenuHandler.displayTableStudents(connection);
                break;
            case "2":
                StudentMenuHandler.insertNewStudent(connection);
                break;
            case "3":
                System.out.println("Please type the first name of student: ");
                String firstName = scanner.nextLine();

                System.out.println("Please type the last name of student: ");
                String lastName = scanner.nextLine();

                System.out.println("Please type the age of the student: ");
                Integer ageOfStudent = scanner.nextInt();

                StudentMenuHandler.insertNewStudentFromKeyboard(connection,firstName,lastName,ageOfStudent);
                break;
            case "4":
                System.out.println("Please type the name of a student: ");
                System.out.println("first_name= ");
                firstName = scanner.nextLine();

                StudentMenuHandler.searchForStudent(connection,firstName);
                break;
            case "5":
                System.out.println("Please type the first name of the student that you want to delete: ");
                firstName = scanner.nextLine();

                System.out.println("Please type the last name of the student that you want to delete: ");
                lastName = scanner.nextLine();

                StudentMenuHandler.deleteAStudentFromKeyboard(connection, firstName, lastName);
                break;
            default:
                System.out.println("You do not have a valid choice ");
        }
    }
}
