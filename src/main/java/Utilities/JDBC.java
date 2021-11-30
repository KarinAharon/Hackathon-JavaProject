package Utilities;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JDBC extends Base{

    public static void initSQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, usernameDB, passwordDB);
            stmt = con.createStatement();
        }
        catch (Exception e) {
            System.out.println("Error Occurred while Connecting to DB, See Details: " + e);
        }
    }

    public static void getCredentials() {
        credentialsUser = new ArrayList<>();
        credentialsPass = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT username,password FROM LoginDetails");

            while (rs.next()) {
                credentialsUser.add(rs.getString(1));
                credentialsPass.add(rs.getString(2));

            }
        }
        catch(SQLException e) {
            System.out.println("Error Occured While Printing Table Data, See Details: " + e);
        }
    }

    public static void closeDBCon() {
        try {
            con.close();
        }
        catch(SQLException e) {
            System.out.println("Error Occured While Closing JDBC, See Details: " + e);
        }
    }

}
