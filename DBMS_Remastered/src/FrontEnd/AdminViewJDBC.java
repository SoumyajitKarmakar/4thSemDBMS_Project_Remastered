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

class AdminViewJDBC {
    private final String displayTable;
    private final JTextArea textBox;
    private final String username;
    private final String password;
    private final String database;
    private Connection conn;

    AdminViewJDBC(String tableName, JTextArea textArea){
        displayTable = tableName;
        textBox = textArea;
        // your details here
        username = "";
        password = "";
        database = "";
        conn = null;
    }

    void run(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database + "?user=" + username + "&password=" + password + "&useSSL=false");
        }
        catch(SQLException e){
            System.out.println("Failed to make connection to database...\n");
            e.printStackTrace();
            return;
        }

        String query = "select * from " + displayTable;
        String output = "";
        try(Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmt = rs.getMetaData();
            int cols = rsmt.getColumnCount();

            String outputRow = "";
            for(int i = 1; i <= cols; ++i){
                outputRow = outputRow + rsmt.getColumnName(i) + "\t";
            }
            output += outputRow + "\n";

            while(rs.next()) {
                outputRow = "";
                for (int i = 1; i <= cols; ++i) {
                    outputRow = outputRow + rs.getString(i) + "\t";
                }
                output += outputRow + "\n";
            }
            textBox.append(output);
            textBox.setVisible(true);
            textBox.setEditable(false);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
