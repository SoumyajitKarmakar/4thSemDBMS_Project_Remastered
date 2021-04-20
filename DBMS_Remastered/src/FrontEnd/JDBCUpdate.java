package FrontEnd;

import java.sql.*;

class JDBCUpdate {
    private final String query;
    private final String username;
    private final String password;
    private final String database;
    private Connection conn;

    JDBCUpdate(String updateQuery){
        query = updateQuery;
        // your details here
        username = "";
        password = "";
        database = "";
        conn = null;
    }

    void run() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database + "?user=" + username + "&password=" + password + "&useSSL=false&allowPublicKeyRetrieval=true");
        } catch (SQLException e) {
            System.out.println("Failed to make connection to database...\n");
            e.printStackTrace();
            return;
        }

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
