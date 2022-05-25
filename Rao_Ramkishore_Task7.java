package Class_Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Rao_Ramkishore_Task7 {

    private Connection conn;

    // Azure SQL connection credentials
    private String server = "rao0013-sql-server.database.windows.net";
    private String database = "cs-dsa-4513-sql-db";
    private String username = "rao0013";
    private String password = "10,Dulkar";

    // Resulting connection string
    final private String url =
            String.format("jdbc:sqlserver://rao0013-sqlserver.database.windows.net:1433;database=cs-dsa-4513-sql-db;user=rao0013@rao0013-sqlserver;password={10,Dulkar};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                    server, database, username, password);

    // Initialize and save the database connection
    private void getDBConnection() throws SQLException {
        if (conn != null) {
            return;
        }

        this.conn = DriverManager.getConnection(url);
    }

    // Return the result of selecting everything from the movie_night table 
    public ResultSet getAllTeams() throws SQLException {
        getDBConnection();
        
        final String sqlQuery = "SELECT * FROM Team;";
        final PreparedStatement stmt = conn.prepareStatement(sqlQuery);
        return stmt.executeQuery();
    }

    // Inserts a record into the Team table with the given attribute values
    public boolean addTeam(
            String Team_Name, String Team_Type, String Date_Formed) throws SQLException {

        getDBConnection(); // Prepare the database connection

        // Prepare the SQL statement
        final String sqlQuery =
                "INSERT INTO Team " + 
                    "(Team_Name, Team_Type, Date_Formed) " + 
                "VALUES " + 
                "(?, ?, ?)";
        final PreparedStatement stmt = conn.prepareStatement(sqlQuery);

        // Replace the '?' in the above statement with the given attribute values
        stmt.setString(1, Team_Name);
        stmt.setString(2, Team_Type);
        stmt.setString(3, Date_Formed);
             
       
        // Execute the query, if only one record is updated, then we indicate success by returning true
        return stmt.executeUpdate() == 1;
    }
}

