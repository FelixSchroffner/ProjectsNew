import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class DBCreate {
    private Connection conn;

    public DBCreate(Connection conn) {
        this.conn = conn;
    }

    public void createDatabase() throws SQLException {
        String createSql = "CREATE DATABASE IF NOT EXISTS mydatabase";

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createSql);
            DBLogger.log("Database created successfully");
        } catch (SQLException e) {
            DBLogger.log("Error creating database - " + e.getMessage());
            throw e;
        }
    }

    public void createTable() throws SQLException {
        String createSql = "CREATE TABLE IF NOT EXISTS table_name (id INT PRIMARY KEY, name VARCHAR(50), address VARCHAR(50))";

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createSql);
            DBLogger.log("Table created successfully");
        } catch (SQLException e) {
            DBLogger.log("Error creating table - " + e.getMessage());
            throw e;
        }
    }

    public void dropDatabase() throws SQLException {
        String dropSql = "DROP DATABASE IF EXISTS mydatabase";

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(dropSql);
            DBLogger.log("Database dropped successfully");
        } catch (SQLException e) {
            DBLogger.log("Error dropping database - " + e.getMessage());
            throw e;
        }
    }

    public void dropTable() throws SQLException {
        String dropSql = "DROP TABLE IF EXISTS table_name";

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(dropSql);
            DBLogger.log("Table dropped successfully");
        } catch (SQLException e) {
            DBLogger.log("Error dropping table - " + e.getMessage());
            throw e;
        }
    }
}
