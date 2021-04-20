package FrontEnd;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/*
Can be used to view any table from anywhere
 */

class JDBCView {
    // assumption : queries are always formed perfectly
    private final String query;
    private final String username;
    private final String password;
    private final String database;
    private Connection conn;

    JDBCView(String viewQuery){
        query = viewQuery;
        // your details here
        username = "";
        password = "";
        database = "";
        conn = null;
    }

    String run(){
        // can also pass string here?
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database + "?user=" + username + "&password=" + password + "&useSSL=false&allowPublicKeyRetrieval=true");
        }
        catch(SQLException e){
            System.out.println("Failed to make connection to database...\n");
            e.printStackTrace();
            return null;
        }

        String output = "";
        try(Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmt = rs.getMetaData();
            int cols = rsmt.getColumnCount();
            String outputRow = "";
            for(int i = 1; i <= cols; ++i){
                outputRow = outputRow + rsmt.getColumnName(i) + "\t\t";
            }
            output += outputRow + "\n";

            while(rs.next()) {
                outputRow = "";
                for (int i = 1; i <= cols; ++i) {
                    outputRow = outputRow + rs.getString(i) + "\t\t";
                }
                output += outputRow + "\n";
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return output;
    }
}
