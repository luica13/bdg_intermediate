package airport_management_system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnector {
    private final String dbUrl;
    private final String dbUsername;
    private final String dbPassword;

    private DBConnector() {
        this.dbUrl = DBInfoLoader.getDBProps().getProperty("db.url");
        this.dbUsername = DBInfoLoader.getDBProps().getProperty("db.username");
        this.dbPassword = DBInfoLoader.getDBProps().getProperty("db.password");
        String dbClass = DBInfoLoader.getDBProps().getProperty("db.class");
        try {
            Class.forName(dbClass);
        } catch (ClassNotFoundException e) {
            System.err.println("db driver not found: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        DBConnector db = DBConnectorCreator.DB_CONNECTOR;
        return DriverManager.getConnection(db.dbUrl, db.dbUsername, db.dbPassword);
    }

    private static class DBConnectorCreator {
        private static final DBConnector DB_CONNECTOR = new DBConnector();
    }
}
