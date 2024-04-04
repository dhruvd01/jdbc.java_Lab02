import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class JdbcJava {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/customers";
        String uname = "root";
        String pass = "16082004";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, uname, pass);
            Statement st = con.createStatement();
            String query = "SELECT * FROM CUSTOMER";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Could not find JDBC driver class: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
