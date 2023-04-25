import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBQuery {
    private Connection conn;

    public DBQuery(Connection conn) {
        this.conn = conn;
    }

    public void searchByName() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name to search: ");
        String name = sc.next();

        String searchSql = "SELECT name, address FROM table_name WHERE name LIKE ?";

        try (PreparedStatement pstmt = conn.prepareStatement(searchSql)) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String resultName = rs.getString("name");
                String address = rs.getString("address");

                System.out.println("Name: " + resultName + ", Address: " + address);
            }

            DBLogger.log("Data search completed successfully");
        } catch (SQLException e) {
            DBLogger.log("Error searching data by name - " + e.getMessage());
            throw e;
        }
    }
}
