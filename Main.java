import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Connection connection = null;

        //create connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "parola");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(" ======== Main Menu ======== ");
        System.out.println(" Please select one option: ");
        System.out.println("1.  Student Menu ");
        System.out.println("2.  Teacher Menu ");
        System.out.println("3.  Group Menu ");


        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.println(" Your choice " + choice);

        switch (choice) {
            case 1:
                StudentMenu.displayMenuStudent(connection);
                break;
            case 2:
                TeacherMenu.displayMenuTeacher(connection);
                break;
            case 3:
                GroupMenu.displayGroupMenu(connection);
                break;
        }
    }
}
