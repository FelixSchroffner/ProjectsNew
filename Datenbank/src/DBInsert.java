import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class DBInsert {
    private Connection conn;
    public DBInsert(Connection conn) {
        this.conn = conn;
    }
    public void insertDataWithTransaction() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter address: ");
        String address = sc.next();

        String insertSql = "INSERT INTO table_name (id, name, address) VALUES (?, ?, ?)";

        try {
            conn.setAutoCommit(false);

            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setString(3, address);
                pstmt.executeUpdate();
            }

            conn.commit();

            DBLogger.log("Data inserted successfully with id: " + id);
        } catch (SQLException e) {
            conn.rollback();
            DBLogger.log("Error inserting data with id: " + id + " - " + e.getMessage());
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }
}
