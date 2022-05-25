package Class_Project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Rao_Ramkishore_Task7b {

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
    public ResultSet getAllTeams(String Date_Formed) throws SQLException {
           	    	
    	getDBConnection();
               
        final PreparedStatement stmt = conn.prepareStatement("select Team_Name from Team where Date_Formed >=?;");
        
        String Date1 = Date_Formed;
        
        stmt.setString(1, Date1);
      
        
        ResultSet rs = stmt.executeQuery();
		return rs;
       
    }

        
}

