import java.sql.*;

public class StudentMenuHandler {

    public static void displayTableStudents(Connection connection) {
        try {

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(" SELECT * FROM students ");

            while (resultSet.next()) {

                Integer id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Integer age = resultSet.getInt("age");

                System.out.println
                        ("Studentul cu id-ul " + id + " este " + firstName + " " + lastName + " si are varsta de " + age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewStudent(Connection connection) {

        try {
            Statement stmt = connection.createStatement();
            Integer result = stmt.executeUpdate("INSERT INTO school.students(first_name, last_name, age)VALUES(\"Ion\",\"Georgescu\", 28)");

            if (result == 1) {
                System.out.println("Studentul a fost inserat cu succes ");
            } else {
                System.out.println(" Studentul nu a fost inserat cu succes ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewStudentFromKeyboard(Connection connection, String firstName, String lastName, Integer ageOfStudent) {
        String sql = "INSERT INTO school.students(first_name, last_name, age) VALUES(?, ?, ?)";
        int resultSet = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setInt(3, ageOfStudent);
            resultSet = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (resultSet == 1) {
            System.out.println("Studentul a fost inserat cu succes ");
        } else {
            System.out.println("Studentul nu a fost inserat cu succes");
        }
    }

    public static void searchForStudent (Connection connection, String firstName){
        String sql = "SELECT * FROM students WHERE first_name = ?";
        ResultSet resultSet;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,firstName);
            resultSet = stmt.executeQuery();

            while (resultSet.next()){
                String firstNameToDisplay = resultSet.getString("first_name");
                String lastNameToDisplay = resultSet.getString("last_name");
                Integer ageToDisplay = resultSet.getInt("age");

                System.out.println("Display results:");
                System.out.println("First name search result: " + firstNameToDisplay);
                System.out.println("Last name search: " + lastNameToDisplay);
                System.out.println("Age search result: " + ageToDisplay);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAStudentFromKeyboard (Connection connection, String firstName, String lastName){
        String sql = "DELETE FROM students WHERE first_name = ? AND last_name = ?";
        int resultSet = 0;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            resultSet = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (resultSet == 1){
            System.out.println("Studentul a fost eliminat cu succes din baza de date");
        }else {
            System.out.println("Studentul inca nu a fost eliminat din baza de date");
        }
    }
}