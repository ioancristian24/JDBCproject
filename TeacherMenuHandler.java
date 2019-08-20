import java.sql.*;

public class TeacherMenuHandler {

    public static void displayTeacherTable(Connection connection){

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM teachers");

            while (rs.next()){
                Integer id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Integer age = rs.getInt("age");
                String tip = rs.getString("tip");

                System.out.println
                        ("The teacher with id " + id + " is " + firstName + " " + lastName + ", he has " + age
                                + " years old and he is teaching " + tip );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewTeacher(Connection connection){

        try {
            Statement stmt = connection.createStatement();
            Integer result = stmt.executeUpdate("INSERT INTO school.teachers (first_name, last_name, age, tip)" +
                    "VALUES(\"Leopold\",\"Zamfirescu\",63,\"Philosophy\")");

            if (result == 1){
                System.out.println("The teacher was inserted succesufully into database");
            }else {
                System.out.println("The teacher was not inserted yet into database");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewTeacherFromKeyboard(Connection connection, String firstName, String lastName, Integer age, String tip){
        String sql = "INSERT INTO school.teachers(first_name, last_name, age, tip) VALUES (?,?,?,?)";
        Integer resultSet = 0;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setInt(3, age);
            stmt.setString(4,tip);
            resultSet = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (resultSet == 1){
            System.out.println("The teacher was inserted succesufully into database");
        }else {
            System.out.println("The teacher was not inserted yet into database");
        }

    }
}
