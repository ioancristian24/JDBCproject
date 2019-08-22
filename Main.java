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

        System.out.println(" ======== Student Meniu ======== ");
        System.out.println(" Please select one option: ");
        System.out.println("1.  Display students table ");
        System.out.println("2.  Add student from keyboard ");
        System.out.println("3.  Display info about selected student ");
        System.out.println("4.  Add student ");
        System.out.println("5.  Delete student from keyboard ");

        System.out.println("========= Teachers Menu =========");
        System.out.println(" Please select one option: ");
        System.out.println("6.  Display teachers table ");
        System.out.println("7.  Add teacher from keyboard ");
        System.out.println("8.  Display info about selected teacher ");
        System.out.println("9.  Add teacher ");
        System.out.println("10. Delete teacher from keyboard ");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        System.out.println(" Your choice " + choice);

        if(choice.equals("1")){
            StudentMenuHandler.displayTableStudents(connection);
        }

        if (choice.equals("4")){
            StudentMenuHandler.insertNewStudent(connection);
        }

        if (choice.equals("2")){
            System.out.println("Please type the first name of student: ");
            String firstName = scanner.nextLine();

            System.out.println("Please type the last name of student: ");
            String lastName = scanner.nextLine();

            System.out.println("Please type the age of the student: ");
            Integer ageOfStudent = scanner.nextInt();

            StudentMenuHandler.insertNewStudentFromKeyboard(connection,firstName,lastName,ageOfStudent);

        }

        if (choice.equals("3")){
            System.out.println("Please type the name of a student: ");
            System.out.println("first_name= ");
            String firstName = scanner.nextLine();
            StudentMenuHandler.searchForStudent(connection,firstName);
        }

        if (choice.equals("5")){
            System.out.println("Please type the first name of the student that you want to delete: ");
            String firstName = scanner.nextLine();

            System.out.println("Please type the last name of the student that you want to delete: ");
            String lastName = scanner.nextLine();

            StudentMenuHandler.deleteAStudentFromKeyboard(connection, firstName, lastName);
        }

        if (choice.equals("6")){
            TeacherMenuHandler.displayTeacherTable(connection);
        }

        if(choice.equals("9")){
            TeacherMenuHandler.insertNewTeacher(connection);
        }

        if(choice.equals("7")){
            System.out.println("Please insert the first name of the teacher: ");
            String firstName = scanner.nextLine();

            System.out.println("Please insert the last name of the teacher: ");
            String lastName = scanner.nextLine();

            System.out.println("Please insert the age of the teacher: ");
            Integer age = scanner.nextInt();

            System.out.println("Please insert the tip of the teacher: ");
            String tip = scanner.nextLine();

            TeacherMenuHandler.insertNewTeacherFromKeyboard(connection,firstName,lastName,age,tip);
        }

        if (choice.equals("8")){
            System.out.println("Please type the first name of the teacher: ");
            System.out.println("First Name: ");
            String firstName = scanner.nextLine();
            TeacherMenuHandler.searchForTeacher(connection, firstName);
        }

        if (choice.equals("10")){
            System.out.println("Please type the first name of the teacher that you want to delete:");
            String firstName = scanner.nextLine();

            System.out.println("Please type the last name of the teacher that you want to delete: ");
            String lastName = scanner.nextLine();

            TeacherMenuHandler.deleteATeacherFromKeyboard(connection, firstName, lastName);
        }
    }
}
