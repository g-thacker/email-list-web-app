import java.sql.*;

public class UserDb {
    public static int addEmail(User user) {
        PreparedStatement preparedStatement = null;
        String addEmailString = "INSERT INTO email_user (email_user_email, email_user_firstname, email_user_lastname) VALUES (?, ?, ?);";
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");
             preparedStatement = connection.prepareStatement(addEmailString);
             preparedStatement.setString(1, user.getEmail());
             preparedStatement.setString(2, user.getFirstName());
             preparedStatement.setString(3, user.getLastName());
             return preparedStatement.executeUpdate();
         } catch (Exception e) {
             e.printStackTrace();
             return 0;
         } finally {
             DbUtil.closeStatement(preparedStatement);
         }
    }
    public static int removeEmail(String email) {
        PreparedStatement preparedStatement = null;
        String removeEmailString = "DELETE FROM email_user WHERE email_user_email = ?;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");
            preparedStatement = connection.prepareStatement(removeEmailString);
            preparedStatement.setString(1, email);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            DbUtil.closeStatement(preparedStatement);
        }
    }
    public static int updateInformation(User user) {
        PreparedStatement preparedStatement = null;
        String updateInfoString = "UPDATE email_user SET email_user_firstname = ?, email_user_lastname = ? WHERE email_user_email = ?;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");
            preparedStatement = connection.prepareStatement(updateInfoString);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            DbUtil.closeStatement(preparedStatement);
        }
    }
    static String displayList() {
       PreparedStatement preparedStatement = null;
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT * FROM email_user;");
           String queryResult = SqlUtil.getHtmlTable(resultSet);
           resultSet.close();
           return queryResult;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       } finally {
           DbUtil.closeStatement(preparedStatement);
       }
    }
}
