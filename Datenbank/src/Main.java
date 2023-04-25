import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            conn = DBConnection.getConnection();

            DBLogger.log("Connection to database established successfully");

            DBCreate dbCreate = new DBCreate(conn);

            System.out.println("Choose an option:");
            System.out.println("1. Create database");
            System.out.println("2. Create table");
            System.out.println("3. Drop database");
            System.out.println("4. Drop table");
            System.out.println("5. Insert data with transaction");
            System.out.println("6. Search data by name");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dbCreate.createDatabase();
                    break;
                case 2:
                    dbCreate.createTable();
                    break;
                case 3:
                    dbCreate.dropDatabase();
                    break;
                case 4:
                    dbCreate.dropTable();
                    break;
                case 5:
                    DBInsert dbInsert = new DBInsert(conn);
                    dbInsert.insertDataWithTransaction();
                    break;
                case 6:
                    DBQuery dbQuery = new DBQuery(conn);
                    dbQuery.searchByName();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } catch (SQLException e) {
            DBLogger.log("Error - " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    DBLogger.log("Connection to database closed successfully");
                }
            } catch (SQLException e) {
                DBLogger.log("Error closing connection - " + e.getMessage());
            }
        }
    }
}
