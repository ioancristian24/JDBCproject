import java.sql.*;

public class GroupMenuHandler {

    public static void displayGroupTable(Connection connection){

        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM school.groups");

            while (resultSet.next()){

                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println("The group with id " + id + " has the name " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewGroup(Connection connection){

        try {
            Statement stmt = connection.createStatement();
            Integer result = stmt.executeUpdate("INSERT INTO school.groups(name)VALUES(\"E\")");

            if (result == 1){
                System.out.println("The group was inserted successfully into database");
            }else {
                System.out.println("The group was not inserted yet into database");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewGroupFromKeyboard(Connection connection,String name){
        String sql = "INSERT INTO school.groups (name) VALUES (?)";
        int result = 0;

         try {
             PreparedStatement stmt = connection.prepareStatement(sql);
             stmt.setString(1, name);
             result = stmt.executeUpdate();

             if (result == 1){
                 System.out.println("The group was inserted successfully into database ");
             }else {
                 System.out.println("The group was not inserted yet into database ");
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void searchForGroup(Connection connection, String name){
        String sql = "SELECT * FROM school.groups WHERE name = ?";
        ResultSet resultSet;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            resultSet = stmt.executeQuery();

            while (resultSet.next()){
                String nameToDisplay = resultSet.getString("name");

                System.out.println("Display results: ");
                System.out.println("Name search result: " + nameToDisplay);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAGroupFromKeyboard(Connection connection, String name){
        String sql = "DELETE FROM school.groups WHERE name = ?";
        int result = 0;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            result = stmt.executeUpdate();

            if (result == 1){
                System.out.println("The group was deleted successfully from our database. ");
            }else {
                System.out.println("The group was not deleted yet from our database. ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
