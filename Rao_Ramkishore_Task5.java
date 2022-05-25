package Class_Project;

import java.sql.Connection;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Rao_Ramkishore_Task5 {

    // Database credentials
    final static String HOSTNAME = "rao0013-sql-server.database.windows.net";
    final static String DBNAME = "cs-dsa-4513-sql-db";
    final static String USERNAME = "rao0013";
    final static String PASSWORD = "10,Dulkar";

    // Database connection string
    final static String URL = String.format("jdbc:sqlserver://rao0013-sqlserver.database.windows.net:1433;database=cs-dsa-4513-sql-db;user=rao0013@rao0013-sqlserver;password={10,Dulkar};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
            HOSTNAME, DBNAME, USERNAME, PASSWORD);

    // Query templates
        
    //private static final String SAMPLE_CSV_FILE_PATH = "C:/Data Science and Analytics/DSA 4513/users.csv";
    
  //  private static final String SAMPLE_CSV_FILE = "C:/Data Science and Analytics/DSA 4513/users2.csv";
    
       // User input prompt//
    final static String PROMPT = 
            "\nPlease select one of the options below: \n" +
            "1) Enter a new team into database, Option 1; \n" + 
            "2) Enter a new client into database and associate him with teams, Option 2; \n" +
            "3) Enter a new volunteer into the database and associate him or her with one or more teams, Option3; \n"+
            "4) Enter the number of hours a volunteer worked this month for a particular team, Option 4;\n"+
            "5) Enter a new employee into database and associate him or her with one or more teams, Option 5;\n"+
            "6) Enter an expense charged by an employee, Option 6; \n"+
            "7) Enter a new organization and associate him or her with several donations, Option 7; \n"+
            "8) Enter a new donor and associate him with several donations, Option 8; \n"+
            "9) Enter a new organization and associate it with several donations, Option 9;\n"+
            "10) Retrieve the name and phone number of the doctor of a particular client, Option 10;\n"+
            "11) Retrieve the total amount of expenses charged by each employee for a particular period of time. The list should be sorted by the total amount of expenses, Option 11;\n"+
            "12) Retrieve the list of volunteers that are members of teams that support a particular client., Option 12; \n"+
            "13) Retrieve the names and contact information of the clients that are supported by teams sponsored by an organization whose name starts with a letter between B and K. The client list should be sorted by name, Option 13; \n"+
            "14) Retrieve the name and total amount donated by donors that are also employees. The list should be sorted by the total amount of the donations, and indicate if each donor wishes to remain anonymous, Option 14; \n"+
            "15) Retrieve the names of all teams that were founded after a particular date, Option 15; \n"+
            "16) Increase the salary by 10% of all employees to whom more than one team must report., Option 16;\n"+
            "17) Delete all clients who do not have health insurance and whose value of importance for transportation is less than 5, Option 17; \n"+
            "18) Import: enter new teams from a data file until the file is empty, Option 18;\n"+
            "19) Export: Retrieve names and mailing addresses of all people on the mailing list and output them to a data file instead of screen, Option 19; \n"+
            "20) Exit!";

    public static void main(String[] args) throws SQLException, IOException {

        System.out.println("Welcome to the Patient Assistant Network Database System");

        final Scanner sc = new Scanner(System.in); // Scanner is used to collect the user input
        String option = ""; // Initialize user option selection as nothing
        while (!option.equals("4")) { // As user for options until option 4 is selected
            System.out.println(PROMPT); // Print the available options
            option = sc.next(); // Read in the user option selection

            switch (option) { // Switch between different options
                case "1": // Enter a New Team into the Database, Option 1
                    // Collect the new Team data from the user
                    System.out.println("Please enter Team Name:");
                    sc.nextLine();
                    final String Team_Name = sc.nextLine(); // Read in the user input of Faculty ID
                   
                    System.out.println("Please enter Team Type:");
                                        
                 // No need to call nextLine extra time here, because the preceding nextLine consumed the newline character.
                    final String Team_Type = sc.nextLine(); // Read in user input of Faculty Name (white-spaces allowed).

                    System.out.println("Please enter Date Team is Formed:");
                 
                    // No need to call nextLine extra time here, because the preceding nextLine consumed the newline character.
                    final String  Date_Formed = sc.nextLine(); 
                   
                      System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDTEAM @Team_Name =?, @Team_Type =?, @Date_Formed =?;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, Team_Name);
                            statement.setString(2, Team_Type);
                            statement.setString(3, Date_Formed);
                         
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                    break;
                    
                case "2": // Enter a new client into database and associate him with teams, Option 2
                    // Collect the new Person, Additional_Contact, Emergency_Contact, Client, and Client_Care data from the user
                	System.out.println("Please enter Person Name");
                	sc.nextLine();
                	final String Name = sc.nextLine();
                	                	
                	System.out.println("Please enter Person SSN");
                     final String SSN = sc.nextLine();
                	
                	System.out.println("Please enter Birth Date");
                	final String Birth_Date = sc.nextLine();
                	
                	System.out.println("Race");
                	final String Race = sc.nextLine();
                	
                	System.out.println("Gender");
                	final String Gender = sc.nextLine();
                	
                	System.out.println("Street No.");
                	final String Street_No = sc.nextLine();
                	
                	System.out.println("Street Name");
                	final String Street_Name = sc.nextLine();
                	
                	System.out.println("City");
                	final String City = sc.nextLine();
                	
                	System.out.println("State");
                	final String State = sc.nextLine();
                	
                	System.out.println("Zip");
                	final int Zip = sc.nextInt();
                	
                	System.out.println("On Mailing List?  Yes or No");
                	sc.nextLine();
                	final String On_Mailing_List = sc.nextLine();
                	
                	System.out.println("Profession_Name");
                	final String Profession_Name = sc.nextLine();
                	
                	try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDPERSON @Name=?, @SSN=?, @Birth_Date=?, @Race=?, @Gender=?, @Street_No=?, @Street_Name=?, @City=?, @State=?, @Zip=?, @On_Mailing_List=?, @Profession_Name=?;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, Name);
                            statement.setString(2, SSN);
                            statement.setString(3, Birth_Date);
                            statement.setString(4, Race);
                            statement.setString(5, Gender);
                            statement.setString(6, Street_No);
                            statement.setString(7, Street_Name);
                            statement.setString(8, City);
                            statement.setString(9, State);
                            statement.setInt(10, Zip);
                            statement.setString(11, On_Mailing_List);
                            statement.setString(12, Profession_Name);
                                                    
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                           
                	System.out.println("Please enter Client_SSN:");
                    
                    final String Client_SSN = sc.nextLine(); // Read in the Client_SSN

                    System.out.println("Please enter Date Assigned:");
                  
                    final String Date_Assigned = sc.nextLine(); // Read in the date assigned.

                                      
                      System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDCLIENT @Client_SSN =?, @Date_Assigned =?;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, Client_SSN);
                            statement.setString(2, Date_Assigned);
                            
                         
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                	                                        
                    System.out.println("Please enter Person SSN");
                     final String SSN1 =  sc.nextLine();
                	
                	System.out.println("Please enter EmailAddress");
                	 final String Email_Address = sc.nextLine();
                	
                	System.out.println("Please enter Work Phone");
                	final String Work_Phone = sc.nextLine();
                	
                	System.out.println("Cell Phone");
                	final String Cell_Phone = sc.nextLine();
                	
                	System.out.println("Home Phone");
                	final String Home_Phone = sc.nextLine();
                    
                	System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDCONTACT @SSN =?, @Email_Address =?, @Work_Phone = ?, @Cell_Phone = ?, @Home_Phone =? ;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, SSN1);
                            statement.setString(2, Email_Address);
                            statement.setString(3, Work_Phone);
                            statement.setString(4, Cell_Phone);
                            statement.setString(5, Home_Phone);
                                                     
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                                                   
                    System.out.println("Please enter Person SSN");
                	final String SSN11 =  sc.nextLine();
                	
                	System.out.println("Please enter Contact Name");
                	final String Emergency_Contact_Name= sc.nextLine();
                	
                	System.out.println("Please enter Email Address");
                	final String Emergency_Contact_Email_Address = sc.nextLine();
                	
                	System.out.println("Work Phone");
                	final String Emergency_Contact_Work_Phone = sc.nextLine();
                	
                	System.out.println("Cell Phone");
                	final String Emergency_Contact_Cell_Phone = sc.nextLine();
                	
                	System.out.println("Home Phone");
                	final String Emergency_Contact_Home_Phone = sc.nextLine();
                	
                	System.out.println("Relationship Type");
                	final String Relationship_Type = sc.nextLine();
                	              	
                    
                	System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDEMERGENCYCONTACT @SSN =?, @Emergency_Contact_Name =?, @Emergency_Contact_Email_Address = ?,  @Emergency_Contact_Work_Phone =?,  @Emergency_Contact_Cell_Phone =?, @Emergency_Contact_Home_Phone =?, @Relationship_Type = ?;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, SSN11);
                            statement.setString(2, Emergency_Contact_Name);
                            statement.setString(3, Emergency_Contact_Email_Address);
                            statement.setString(4, Emergency_Contact_Work_Phone);
                            statement.setString(5, Emergency_Contact_Cell_Phone);
                            statement.setString(6, Emergency_Contact_Home_Phone);
                            statement.setString(7, Relationship_Type);
                                                  
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                                   	               	
                    System.out.println("Please enter Client_SSN:");
                    final String ClientSSN = sc.nextLine(); // Read in the Client_SSN

                    System.out.println("Please enter Attorney Name:");
                    final String Attorney_Name = sc.nextLine(); 
                    
                    System.out.println("Please enter Street No");
                    final String Street_No2 = sc.nextLine();
                    
                    System.out.println("Please enter Street Name");
                    final String Street_Name2 = sc.nextLine();
                                                           
                    System.out.println("City");
                    final String City2 = sc.nextLine();
                    
                    System.out.println("State");
                    final String State2 = sc.nextLine();
                    
                    System.out.println("Zip");
                    final String Zip2 = sc.nextLine();
                    
                    System.out.println("Attorney Phone");
                    final String AttorneyPhone = sc.nextLine();
                                                                              
                      System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDCLIENT_ATTORNEY @Client_SSN =?, @Attorney_Name =?, @Street_No=?,  @Street_Name = ?, @City = ?, @State =?, @Zip = ?, @AttorneyPhone =? ;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, ClientSSN);
                            statement.setString(2, Attorney_Name);
                            statement.setString(3, Street_No2);
                            statement.setString(4, Street_Name2);
                            statement.setString(5, City2);
                            statement.setString(6, State2 );
                            statement.setString(7, Zip2);
                            statement.setString(8, AttorneyPhone );
                         
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                    
                    
                    System.out.println("Please enter Client_SSN:");
                    final String ClientSSN3 = sc.nextLine(); // Read in the Client_SSN

                    System.out.println("Please enter Doctor Name:");
                    
                    final String Doctor_Name = sc.nextLine(); 
                    
                    System.out.println("Please enter Street No");
                    final String Street_No3 = sc.nextLine();
                    
                    System.out.println("Please enter Street Name");
                    final String Street_Name3 = sc.nextLine();
                   
                                     
                    System.out.println("City");
                    final String City3 = sc.nextLine();
                    
                    System.out.println("State");
                    final String State3 = sc.nextLine();
                    
                    System.out.println("Zip");
                    final String Zip3 = sc.nextLine();
                    
                    System.out.println("Doctor Phone");
                    final String DoctorPhone = sc.nextLine();
                                                                              
                      System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDCLIENT_DOCTOR @Client_SSN =?, @Doctor_Name =?, @Street_No=?,  @Street_Name = ?, @City = ?, @State =?, @Zip = ?, @DoctorPhone =? ;")) {
                            // Populate the query template with the data collected from the user
                        	 statement.setString(1, ClientSSN3);
                             statement.setString(2, Doctor_Name);
                             statement.setString(3, Street_No3);
                             statement.setString(4, Street_Name3);
                             statement.setString(5, City3);
                             statement.setString(6, State3 );
                             statement.setString(7, Zip3);
                             statement.setString(8, DoctorPhone );
                         
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                    
                    System.out.println("Please enter Client_SSN:");
                    final String ClientSSN4 = sc.nextLine(); // Read in the Client_SSN

                    System.out.println("Please enter Policy ID:");
                     final int Policy_ID = sc.nextInt(); 
                    
                    System.out.println("Please enter ProviderID");
                    sc.nextLine();
                    final String ProviderID = sc.nextLine();
                    
                    System.out.println("Please enter Street No");
                    final String Street_No4 = sc.nextLine();
                    
                    System.out.println("Please enter Street Name");
                    final String Street_Name4 = sc.nextLine();
                   
                    System.out.println("Please enter SuiteNo");
                    final String SuiteNo4 = sc.nextLine();
                    
                                     
                    System.out.println("City");
                    final String City4 = sc.nextLine();
                    
                    System.out.println("State");
                    final String State4 = sc.nextLine();
                    
                    System.out.println("Zip");
                    final String Zip4 = sc.nextLine();
                   
                    System.out.println("PolicyType");
                    final String PolicyType = sc.nextLine();
                                     
                                    
                      System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDINSURANCE_POLICY @Client_SSN =?, @Policy_ID =?, @Provider_ID = ?,  @Street_No=?,  @Street_Name = ?, @Suite_No = ?,  @City = ?, @State =?, @Zip = ?, @Policy_Type =? ;")) {
                            // Populate the query template with the data collected from the user
                        	 statement.setString(1, ClientSSN4);
                             statement.setInt(2, Policy_ID);
                             statement.setString(3, ProviderID);
                             statement.setString(4, Street_No4);
                             statement.setString(5, Street_Name4);
                             statement.setString(6, SuiteNo4 );
                             statement.setString(7, City4);
                             statement.setString(8, State4 );
                             statement.setString(9, Zip4 );
                             statement.setString(10, PolicyType);
                                                      
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                    
                    System.out.println("Please enter Client SSN");
                	final String ClientSSN5 =  sc.nextLine();
                	
                	System.out.println("Please enter Needs Type");
                	
                	final String Needs_Type = sc.nextLine();
                	
                	System.out.println("Please enter Needs Rank");
                	final int Needs_Rank = sc.nextInt();
                	                	                    
                	System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                   
                	try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDNEEDS_LIST @Client_SSN=?, @Needs_Type=?, @Needs_Rank=?;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, ClientSSN5);
                            statement.setString(2, Needs_Type);
                            statement.setInt(3, Needs_Rank);
                                                    
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                
                	                    
                    break;
                    
                case "3": // Enter a Volunteer into into the Database and associate him with Teams, Option 1
                	 // Collect the new Person, Additional_Contact, Emergency_Contact,Volunteer data from the user
                	System.out.println("Please enter Person Name");
                	sc.nextLine();
                	final String Name31 = sc.nextLine();
                	                	
                	System.out.println("Please enter Person SSN");
                     final String SSN31 = sc.nextLine();
                	
                	System.out.println("Please enter Birth Date");
                	final String Birth_Date31 = sc.nextLine();
                	
                	System.out.println("Race");
                	final String Race31 = sc.nextLine();
                	
                	System.out.println("Gender");
                	final String Gender31 = sc.nextLine();
                	
                	System.out.println("Street No.");
                	final String Street_No31 = sc.nextLine();
                	
                	System.out.println("Street Name");
                	final String Street_Name31 = sc.nextLine();
                	
                	System.out.println("City");
                	final String City31 = sc.nextLine();
                	
                	System.out.println("State");
                	final String State31 = sc.nextLine();
                	
                	System.out.println("Zip");
                	final int Zip31 = sc.nextInt();
                	
                	System.out.println("On Mailing List?  Yes or No");
                	sc.nextLine();
                	final String On_Mailing_List31 = sc.nextLine();
                	
                	System.out.println("Profession_Name");
                	final String Profession_Name31 = sc.nextLine();
                	
                	try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDPERSON @Name=?, @SSN=?, @Birth_Date=?, @Race=?, @Gender=?, @Street_No=?, @Street_Name=?, @City=?, @State=?, @Zip=?, @On_Mailing_List=?, @Profession_Name=?;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, Name31);
                            statement.setString(2, SSN31);
                            statement.setString(3, Birth_Date31);
                            statement.setString(4, Race31);
                            statement.setString(5, Gender31);
                            statement.setString(6, Street_No31);
                            statement.setString(7, Street_Name31);
                            statement.setString(8, City31);
                            statement.setString(9, State31);
                            statement.setInt(10, Zip31);
                            statement.setString(11, On_Mailing_List31);
                            statement.setString(12, Profession_Name31);
                                                    
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                      	
                                        
                    System.out.println("Please enter Person SSN");
                     final String SSN32 =  sc.nextLine();
                	
                	System.out.println("Please enter EmailAddress");
                	 final String Email_Address32 = sc.nextLine();
                	
                	System.out.println("Please enter Work Phone");
                	final String Work_Phone32 = sc.nextLine();
                	
                	System.out.println("Cell Phone");
                	final String Cell_Phone32 = sc.nextLine();
                	
                	System.out.println("Home Phone");
                	final String Home_Phone32 = sc.nextLine();
                    
                	System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDCONTACT @SSN =?, @Email_Address =?, @Work_Phone = ?, @Cell_Phone = ?, @Home_Phone =? ;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, SSN32);
                            statement.setString(2, Email_Address32);
                            statement.setString(3, Work_Phone32);
                            statement.setString(4, Cell_Phone32);
                            statement.setString(5, Home_Phone32);
                                                     
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                
                                   
                    System.out.println("Please enter Person SSN");
                	final String SSN33 =  sc.nextLine();
                	
                	System.out.println("Please enter Contact Name");
                	final String Emergency_Contact_Name33= sc.nextLine();
                	
                	System.out.println("Please enter Email Address");
                	final String Emergency_Contact_Email_Address33 = sc.nextLine();
                	
                	System.out.println("Work Phone");
                	final String Emergency_Contact_Work_Phone33 = sc.nextLine();
                	
                	System.out.println("Cell Phone");
                	final String Emergency_Contact_Cell_Phone33 = sc.nextLine();
                	
                	System.out.println("Home Phone");
                	final String Emergency_Contact_Home_Phone33 = sc.nextLine();
                	
                	System.out.println("Relationship Type");
                	final String Relationship_Type33 = sc.nextLine();
                	               	
                   
                	System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDEMERGENCYCONTACT @SSN =?, @Emergency_Contact_Name =?, @Emergency_Contact_Email_Address = ?,  @Emergency_Contact_Work_Phone =?,  @Emergency_Contact_Cell_Phone =?, @Emergency_Contact_Home_Phone =?, @Relationship_Type = ?;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, SSN33);
                            statement.setString(2, Emergency_Contact_Name33);
                            statement.setString(3, Emergency_Contact_Email_Address33);
                            statement.setString(4, Emergency_Contact_Work_Phone33);
                            statement.setString(5, Emergency_Contact_Cell_Phone33);
                            statement.setString(6, Emergency_Contact_Home_Phone33);
                            statement.setString(7, Relationship_Type33);
                                                  
                                                     
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                    
                    System.out.println ("Please enter Volunteer SSN");
                    final String Volunteer_SSN3 = sc.nextLine();
                    
                    System.out.println("Please enter Date_Joined");
                    final String Date_Joined3 = sc.nextLine();
                    
                    System.out.println("Please enter Date_Training_Course");
                    final String Date_Training_Course3 = sc.nextLine();
                    
                    System.out.println("Please enter Location_Training_Course");
                    final String Location_Training_Course3 = sc.nextLine();
                    
                    System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDVOLUNTEER @Volunteer_SSN=?, @Date_Joined=?, @Date_Training_Course=?, @Location_Training_Course=?;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, Volunteer_SSN3);
                            statement.setString(2, Date_Joined3);
                            statement.setString(3, Date_Training_Course3);
                            statement.setString(4, Location_Training_Course3);
                                                  
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                    
                    // adding client care will likely need to segment the data
                    
                    System.out.println ("Please enter Client SSN");
                    final String Client_SSN33 = sc.nextLine();
                    
                    System.out.println("Please enter Team Name");
                    final String Team_Name33 = sc.nextLine();
                    
                    System.out.println("Please enter Volunteer SSN");
                    final String Volunteer_SSN33 = sc.nextLine();
                    
                    System.out.println("Is Client Active");
                    final String Client_Active = sc.nextLine();
                    
                    System.out.println("Is Volunteer Active");
                    final String Volunteer_Active = sc.nextLine();
                    
                    
                    System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDCLIENT_CARE @Client_SSN=?, @Team_Name=?, @Volunteer_SSN=?, @Client_Active=?, @Volunteer_Active=?;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, Client_SSN33);
                            statement.setString(2, Team_Name33);
                            statement.setString(3, Volunteer_SSN33);
                            statement.setString(4, Client_Active);
                            statement.setString(5, Volunteer_Active);
                                                  
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                 
                break;
              
                case "4":
                	System.out.println ("Please enter Client SSN");
                	sc.nextLine();
                    final String Client_SSN4 = sc.nextLine();
                    
                    System.out.println("Please enter Volunteer Assigned to Team");
                    final String Team_Team_Name4 = sc.nextLine();
                    
                    System.out.println ("Please enter Volunteer SSN");
                	final String Volunteer_SSN4 = sc.nextLine();
                    
                    System.out.println("Please enter Month being Tracked");
                    final String Month4 = sc.nextLine();
                    
                    System.out.println("Hrs Worked this Month for Team");
                    final float  Hrs_Worked4 = sc.nextFloat();
                                                          
                    System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDMONTHLY_TRACKING @Client_SSN=?, @Team_Name=?, @Volunteer_SSN=?, @Month=?, @Hrs_Worked=?;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, Client_SSN4);
                            statement.setString(2, Team_Team_Name4);
                            statement.setString(3, Volunteer_SSN4);
                            statement.setString(4, Month4);
                            statement.setFloat(5, Hrs_Worked4);
                                                                            
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                    
                   break;
             
              case "5":
            	  
            	  System.out.println("Please enter Person Name");
              	sc.nextLine();
              	final String Name51 = sc.nextLine();
              	                	
              	System.out.println("Please enter Person SSN");
                   final String SSN51 = sc.nextLine();
              	
              	System.out.println("Please enter Birth Date");
              	final String Birth_Date51 = sc.nextLine();
              	
              	System.out.println("Race");
              	final String Race51 = sc.nextLine();
              	
              	System.out.println("Gender");
              	final String Gender51 = sc.nextLine();
              	
              	System.out.println("Street No.");
              	final String Street_No51 = sc.nextLine();
              	
              	System.out.println("Street Name");
              	final String Street_Name51 = sc.nextLine();
              	
              	System.out.println("City");
              	final String City51 = sc.nextLine();
              	
              	System.out.println("State");
              	final String State51 = sc.nextLine();
              	
              	System.out.println("Zip");
              	final int Zip51 = sc.nextInt();
              	
              	System.out.println("On Mailing List?  Yes or No");
              	sc.nextLine();
              	final String On_Mailing_List51 = sc.nextLine();
              	
              	System.out.println("Profession_Name");
              	final String Profession_Name51 = sc.nextLine();
              	
              	try (final Connection connection = DriverManager.getConnection(URL)) {
                      try (
                          final PreparedStatement statement = connection.prepareStatement("ADDPERSON @Name=?, @SSN=?, @Birth_Date=?, @Race=?, @Gender=?, @Street_No=?, @Street_Name=?, @City=?, @State=?, @Zip=?, @On_Mailing_List=?, @Profession_Name=?;")) {
                          // Populate the query template with the data collected from the user
                          statement.setString(1, Name51);
                          statement.setString(2, SSN51);
                          statement.setString(3, Birth_Date51);
                          statement.setString(4, Race51);
                          statement.setString(5, Gender51);
                          statement.setString(6, Street_No51);
                          statement.setString(7, Street_Name51);
                          statement.setString(8, City51);
                          statement.setString(9, State51);
                          statement.setInt(10, Zip51);
                          statement.setString(11, On_Mailing_List51);
                          statement.setString(12, Profession_Name51);
                                                  
                          System.out.println("Dispatching the query...");
                          // Actually execute the populated query
                          final int rows_inserted = statement.executeUpdate();
                          System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                      }
                  }
          	                	
                System.out.println("Please enter Person SSN");
                final String SSN52 =  sc.nextLine();
              	
              	System.out.println("Please enter EmailAddress");
              	final String Email_Address52 = sc.nextLine();
              	
              	System.out.println("Please enter Work Phone");
              	final String Work_Phone52 = sc.nextLine();
              	
              	System.out.println("Cell Phone");
              	final String Cell_Phone52 = sc.nextLine();
              	
              	System.out.println("Home Phone");
              	final String Home_Phone52 = sc.nextLine();
                  
              	System.out.println("Connecting to the database...");
                  // Get a database connection and prepare a query statement
                  try (final Connection connection = DriverManager.getConnection(URL)) {
                      try (
                          final PreparedStatement statement = connection.prepareStatement("ADDCONTACT @SSN =?, @Email_Address =?, @Work_Phone = ?, @Cell_Phone = ?, @Home_Phone =? ;")) {
                          // Populate the query template with the data collected from the user
                          statement.setString(1, SSN52);
                          statement.setString(2, Email_Address52);
                          statement.setString(3, Work_Phone52);
                          statement.setString(4, Cell_Phone52);
                          statement.setString(5, Home_Phone52);
                                                
                          System.out.println("Dispatching the query...");
                          // Actually execute the populated query
                          final int rows_inserted = statement.executeUpdate();
                          System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                      }
                  }
             
                                
                System.out.println("Please enter Person SSN");
              	final String SSN53 =  sc.nextLine();
              	
              	System.out.println("Please enter Contact Name");
              	final String Emergency_Contact_Name53= sc.nextLine();
              	
              	System.out.println("Please enter Email Address");
              	final String Emergency_Contact_Email_Address53 = sc.nextLine();
              	
              	System.out.println("Work Phone");
              	final String Emergency_Contact_Work_Phone53 = sc.nextLine();
              	
              	System.out.println("Cell Phone");
              	final String Emergency_Contact_Cell_Phone53 = sc.nextLine();
              	
              	System.out.println("Home Phone");
              	final String Emergency_Contact_Home_Phone53 = sc.nextLine();
              	
              	System.out.println("Relationship Type");
              	final String Relationship_Type53 = sc.nextLine();
              	             	
                  System.out.println("Connecting to the database...");
                  // Get a database connection and prepare a query statement
                  try (final Connection connection = DriverManager.getConnection(URL)) {
                      try (
                          final PreparedStatement statement = connection.prepareStatement("ADDEMERGENCYCONTACT @SSN =?, @Emergency_Contact_Name =?, @Emergency_Contact_Email_Address = ?,  @Emergency_Contact_Work_Phone =?,  @Emergency_Contact_Cell_Phone =?, @Emergency_Contact_Home_Phone =?, @Relationship_Type = ?;")) {
                          // Populate the query template with the data collected from the user
                          statement.setString(1, SSN53);
                          statement.setString(2, Emergency_Contact_Name53);
                          statement.setString(3, Emergency_Contact_Email_Address53);
                          statement.setString(4, Emergency_Contact_Work_Phone53);
                          statement.setString(5, Emergency_Contact_Cell_Phone53);
                          statement.setString(6, Emergency_Contact_Home_Phone53);
                          statement.setString(7, Relationship_Type53);
                                                  
                           System.out.println("Dispatching the query...");
                          // Actually execute the populated query
                          final int rows_inserted = statement.executeUpdate();
                          System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                      }
                  }
                  
                  System.out.println ("Please enter Employee SSN");
                  final String Employee_SSN51 = sc.nextLine();
                  
                  System.out.println("Please enter Date_Hired");
                  final String Date_Hired51 = sc.nextLine();
                  
                  System.out.println("Please enter Employee Salary");
                  final float Employee_Salary51 = sc.nextFloat();
                  
                  System.out.println("Please enter Marital Status");
                  sc.nextLine();
                  final String Marital_Status51 = sc.nextLine();
                                   
                  System.out.println("Connecting to the database...");
                  // Get a database connection and prepare a query statement
                  try (final Connection connection = DriverManager.getConnection(URL)) {
                      try (
                          final PreparedStatement statement = connection.prepareStatement("ADDEMPLOYEE @Employee_SSN=?, @Date_Hired=?, @Employee_Salary=?, @Marital_Status=?;")) {
                          // Populate the query template with the data collected from the user
                          statement.setString(1, Employee_SSN51);
                          statement.setString(2, Date_Hired51);
                          statement.setFloat(3, Employee_Salary51);
                          statement.setString(4, Marital_Status51);
                                                
                          System.out.println("Dispatching the query...");
                          // Actually execute the populated query
                          final int rows_inserted = statement.executeUpdate();
                          System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                      }
                  }
                  
                  System.out.println ("Please enter Team Name");
                  final String Team_NameSSN5 = sc.nextLine();
                  
                  System.out.println("Please enter Employee Assigned to Team");
                  final String Employee_SSN5 = sc.nextLine();
                  
                  System.out.println("Please enter Employee Report Description");
                  final String Employee_Team_Report_Description = sc.nextLine();
                                    
                  System.out.println("Date of Report Employees Makes on Team");
                  final String Employee_Date_of_Report5 = sc.nextLine();
                                                                        
                  System.out.println("Connecting to the database...");
                  // Get a database connection and prepare a query statement
                  try (final Connection connection = DriverManager.getConnection(URL)) {
                      try (
                          final PreparedStatement statement = connection.prepareStatement("ADDTEAM_REPORTS @Team_Name=?, @Employee_SSN=?, @Description=?, @Date_of_Report=?;")) {
                          // Populate the query template with the data collected from the user
                          statement.setString(1, Team_NameSSN5);
                          statement.setString(2, Employee_SSN5);
                          statement.setString(3, Employee_Team_Report_Description);
                          statement.setString(4, Employee_Date_of_Report5);
                                                                          
                          System.out.println("Dispatching the query...");
                          // Actually execute the populated query
                          final int rows_inserted = statement.executeUpdate();
                          System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                      }
                  }
                  
              break;
              
              case "6":
            	  System.out.println ("Please enter Employee's SSN that has an expense report");
              	  sc.nextLine();
                  final String Employee_SSN6 = sc.nextLine();
                  
                  System.out.println("Please Enter Date of Expense");
                  final String Expense_Date = sc.nextLine();
                  
                  System.out.println("Please Enter Amount oF Expense");
                  final float Expense_Amount = sc.nextFloat();
                  
                  System.out.println("Description of Expense");
                  sc.nextLine();
                  final  String  Expense_Description = sc.nextLine();
                                                   
                  System.out.println("Connecting to the database...");
                  // Get a database connection and prepare a query statement
                  try (final Connection connection = DriverManager.getConnection(URL)) {
                      try (
                          final PreparedStatement statement = connection.prepareStatement("ADDEMPLOYEE_EXPENSES @Employee_SSN=?, @Date_of_Expense=?, @Amount_Expensed=?, @Description=?;" )) {
                          // Populate the query template with the data collected from the user
                          statement.setString(1, Employee_SSN6);
                          statement.setString(2, Expense_Date);
                          statement.setFloat(3, Expense_Amount);
                          statement.setString(4, Expense_Description);
                                                                          
                          System.out.println("Dispatching the query...");
                          // Actually execute the populated query
                          final int rows_inserted = statement.executeUpdate();
                          System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                      }
                  }
                  
                  break;
              
              case "7":
            
            	 System.out.println ("Please enter Organization Name");
             	 sc.nextLine();
                 final String Organization_Name7 = sc.nextLine();
                 
                 System.out.println("Please Enter Street_No");
                 final String Street_No7 = sc.nextLine();
                 
                 System.out.println("Please Enter Street Name");
                 final String Street_Name7 = sc.nextLine();
                 
                 System.out.println("Enter Name of City");
                 final  String  City7 = sc.nextLine();
              
                 System.out.println("Enter Name of State");
                 final  String  State7 = sc.nextLine();

                 System.out.println("Enter Zip");
                 final  String  Zip7 = sc.nextLine();
                                   
                 System.out.println("Enter Phone_No");
                 final  String  Phone_No7 = sc.nextLine();
              
                 
                 System.out.println("Connecting to the database...");
                 // Get a database connection and prepare a query statement
                 try (final Connection connection = DriverManager.getConnection(URL)) {
                     try (
                         final PreparedStatement statement = connection.prepareStatement("ADDORGANIZATION @Organization_Name=?, @Street_No=?, @Street_Name=?, @City=?, @State=?, @Zip=?, @Phone_Number=?;" )) {
                         // Populate the query template with the data collected from the user
                         statement.setString(1, Organization_Name7);
                         statement.setString(2, Street_No7);
                         statement.setString (3, Street_Name7);
                         statement.setString(4, City7);
                         statement.setString(5, State7);
                         statement.setString(6, Zip7);
                         statement.setString(7, Phone_No7);
                                                                         
                         System.out.println("Dispatching the query...");
                         // Actually execute the populated query
                         final int rows_inserted = statement.executeUpdate();
                         System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                     }
                 }
                 
                 System.out.println("Please enter Organization Name");
                 final String OrganizationName84 = sc.nextLine();
                 
                 System.out.println("Business Type");
                 final String BusinessType84 = sc.nextLine();
                  
                 System.out.println("Business Size");
                 final int BusinessSize84 = sc.nextInt();
               	
                 System.out.println("Company Web Site");
                 sc.nextLine();
                 final String CompanyWebSite84 = sc.nextLine(); 
                  
               	System.out.println("Connecting to the database...");
                 // Get a database connection and prepare a query statement
                 try (final Connection connection = DriverManager.getConnection(URL)) {
                     try (
                         final PreparedStatement statement = connection.prepareStatement("ADDBUSINESS  @Organization_Name=?, @Business_Type=?, @Business_Size=?, @Company_Web_Site=?;")) {
                         // Populate the query template with the data collected from the user
                         statement.setString(1, OrganizationName84);
                         statement.setString(2, BusinessType84);	
                         statement.setInt(3, BusinessSize84);
                         statement.setString(4, CompanyWebSite84);
                         
                         System.out.println("Dispatching the query...");
                         // Actually execute the populated query
                         final int rows_inserted = statement.executeUpdate();
                         System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                     }
                 }
                 
                 System.out.println ("Please enter Organization Sponsoring Team");
             	 
                 final String OrganizationTeam_Name7 = sc.nextLine();
                 
                 System.out.println("Please Enter Team Name Sponsored by Organization");
                 
                 final String OrganizationTeam_TeamName7 = sc.nextLine();
                 
                 System.out.println("Connecting to the database...");
                 // Get a database connection and prepare a query statement
                 try (final Connection connection = DriverManager.getConnection(URL)) {
                     try (
                         final PreparedStatement statement = connection.prepareStatement("ADDORGANIZATON_SPONSORS @Organization_Name=?, @Team_Name=?;" )) {
                         // Populate the query template with the data collected from the user
                         statement.setString(1, OrganizationTeam_Name7);
                         statement.setString(2, OrganizationTeam_TeamName7);
                                                                                                 
                         System.out.println("Dispatching the query...");
                         // Actually execute the populated query
                         final int rows_inserted = statement.executeUpdate();
                         System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                     }
                 }
                             	  
                    break;
                 
               case "8":
            	
                System.out.println("Is the Donor Already an Employee? Enter 0 for Yes and 1 for No");
                
            	int i = sc.nextInt();
            	
            	System.out.println("Is this the first donation for the same donor? Enter 1 for yes and 0 for no");
            	
            	int j = sc.nextInt();
            	
            	System.out.println("Is this donation being made by check or credit card? Enter 1 for credit card and 2 for check");
            	
            	int k = sc.nextInt();
            	            	
            	if (j ==1) {
            	
            	if(i == 1) {
            		
            		
            	System.out.println("Please enter Person Name");
               	sc.nextLine();
               	final String Name81 = sc.nextLine();
               	                	
               	System.out.println("Please enter Person SSN");
                final String SSN81 = sc.nextLine();
               	
               	System.out.println("Please enter Birth Date");
               	final String Birth_Date81 = sc.nextLine();
               	
               	System.out.println("Race");
               	final String Race81 = sc.nextLine();
               	
               	System.out.println("Gender");
               	final String Gender81 = sc.nextLine();
               	
               	System.out.println("Street No.");
               	final String Street_No81 = sc.nextLine();
               	
               	System.out.println("Street Name");
               	final String Street_Name81 = sc.nextLine();
               	
               	System.out.println("City");
               	final String City81 = sc.nextLine();
               	
               	System.out.println("State");
               	final String State81 = sc.nextLine();
               	
               	System.out.println("Zip");
               	final int Zip81 = sc.nextInt();
               	
               	System.out.println("On Mailing List?  Yes or No");
               	sc.nextLine();
               	final String On_Mailing_List81 = sc.nextLine();
               	
               	System.out.println("Profession_Name");
               	final String Profession_Name81 = sc.nextLine();
               	
               	try (final Connection connection = DriverManager.getConnection(URL)) {
                       try (
                           final PreparedStatement statement = connection.prepareStatement("ADDPERSON @Name=?, @SSN=?, @Birth_Date=?, @Race=?, @Gender=?, @Street_No=?, @Street_Name=?, @City=?, @State=?, @Zip=?, @On_Mailing_List=?, @Profession_Name=?;")) {
                           // Populate the query template with the data collected from the user
                           statement.setString(1, Name81);
                           statement.setString(2, SSN81);
                           statement.setString(3, Birth_Date81);
                           statement.setString(4, Race81);
                           statement.setString(5, Gender81);
                           statement.setString(6, Street_No81);
                           statement.setString(7, Street_Name81);
                           statement.setString(8, City81);
                           statement.setString(9, State81);
                           statement.setInt(10, Zip81);
                           statement.setString(11, On_Mailing_List81);
                           statement.setString(12, Profession_Name81);
                                                   
                           System.out.println("Dispatching the query...");
                           // Actually execute the populated query
                           final int rows_inserted = statement.executeUpdate();
                           System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                       }
                   }
             	                	
                                       
                System.out.println("Please enter Person SSN");
                final String SSN82 =  sc.nextLine();
               	
               	System.out.println("Please enter EmailAddress");
               	 final String Email_Address82 = sc.nextLine();
               	
               	System.out.println("Please enter Work Phone");
               	final String Work_Phone82 = sc.nextLine();
               	
               	System.out.println("Cell Phone");
               	final String Cell_Phone82 = sc.nextLine();
               	
               	System.out.println("Home Phone");
               	final String Home_Phone82 = sc.nextLine();
                   
               	System.out.println("Connecting to the database...");
                   // Get a database connection and prepare a query statement
                   try (final Connection connection = DriverManager.getConnection(URL)) {
                       try (
                           final PreparedStatement statement = connection.prepareStatement("ADDCONTACT @SSN =?, @Email_Address =?, @Work_Phone = ?, @Cell_Phone = ?, @Home_Phone =? ;")) {
                           // Populate the query template with the data collected from the user
                           statement.setString(1, SSN82);
                           statement.setString(2, Email_Address82);
                           statement.setString(3, Work_Phone82);
                           statement.setString(4, Cell_Phone82);
                           statement.setString(5, Home_Phone82);
                          
                       
                           System.out.println("Dispatching the query...");
                           // Actually execute the populated query
                           final int rows_inserted = statement.executeUpdate();
                           System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                       }
                   }
               
                                  
                System.out.println("Please enter Person SSN");
               	final String SSN83 =  sc.nextLine();
               	
               	System.out.println("Please enter Contact Name");
               	final String Emergency_Contact_Name83= sc.nextLine();
               	
               	System.out.println("Please enter Email Address");
               	final String Emergency_Contact_Email_Address83 = sc.nextLine();
               	
               	System.out.println("Work Phone");
               	final String Emergency_Contact_Work_Phone83 = sc.nextLine();
               	
               	System.out.println("Cell Phone");
               	final String Emergency_Contact_Cell_Phone83 = sc.nextLine();
               	
               	System.out.println("Home Phone");
               	final String Emergency_Contact_Home_Phone83 = sc.nextLine();
               	
               	System.out.println("Relationship Type");
               	final String Relationship_Type83 = sc.nextLine();
               	
                  System.out.println("Connecting to the database...");
                   // Get a database connection and prepare a query statement
                   try (final Connection connection = DriverManager.getConnection(URL)) {
                       try (
                           final PreparedStatement statement = connection.prepareStatement("ADDEMERGENCYCONTACT @SSN =?, @Emergency_Contact_Name =?, @Emergency_Contact_Email_Address = ?,  @Emergency_Contact_Work_Phone =?,  @Emergency_Contact_Cell_Phone =?, @Emergency_Contact_Home_Phone =?, @Relationship_Type = ?;")) {
                           // Populate the query template with the data collected from the user
                           statement.setString(1, SSN83);
                           statement.setString(2, Emergency_Contact_Name83);
                           statement.setString(3, Emergency_Contact_Email_Address83);
                           statement.setString(4, Emergency_Contact_Work_Phone83);
                           statement.setString(5, Emergency_Contact_Cell_Phone83);
                           statement.setString(6, Emergency_Contact_Home_Phone83);
                           statement.setString(7, Relationship_Type83);
                                                  
                                                    
                           System.out.println("Dispatching the query...");
                           // Actually execute the populated query
                           final int rows_inserted = statement.executeUpdate();
                           System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                       }
                   }
            	}
                    System.out.println("Please enter Donor SSN");
                    sc.nextLine();
                  	final String Donor_SSN8 = sc.nextLine();
                    
                  	System.out.println("Does Donor Wish to Remain Anonymous");
                  	 final String Donor_IsAnonymous8 = sc.nextLine();
                  	
                  	System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDDONOR @Donor_SSN=?, @Is_Anonymous=?;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, Donor_SSN8);
                            statement.setString(2, Donor_IsAnonymous8);	
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
            	}
                    System.out.println("Please enter Date_of_Donation");
                    sc.nextLine();
                    final String Donation_Date8 = sc.nextLine();
                    
                  	System.out.println("Amount_of_Donation");
                    final float Donation_Amount8 = sc.nextFloat();
                  	
                    System.out.println("Name of Fund Raising Campaign");
                    sc.nextLine();
                    final String Campaign_Name8 = sc.nextLine();
                    
                    System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDDONATION_DETAILS @Date_of_Donation=?, @Amount_of_Donation=?, @Name_of_Fund_Raising_Campaign=?;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, Donation_Date8);
                            statement.setFloat(2, Donation_Amount8);
                            statement.setString(3, Campaign_Name8);
                               
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                    
                    System.out.println("Please enter Donor SSN");
                    final String Donor_Donation_SSN8 = sc.nextLine();
                    
                  	System.out.println("Donor Donation Date");
                     final String Donor_Donation_Date_of_Donation8 = sc.nextLine();
                  	
                  	System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDDONOR_MAKES  @Donor_SSN=?, @Date_of_Donation=?;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, Donor_Donation_SSN8);
                            statement.setString(2, Donor_Donation_Date_of_Donation8);	
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                    
                    System.out.println("Please enter Donor SSN");
                    final String Donor_SSN81 = sc.nextLine();
                    
                  	System.out.println("Donor Donation Date");
                    final String Date_of_Donation81 = sc.nextLine();
                     
                     System.out.println("Payment Type");
                     final String Payment_Type81 = sc.nextLine();
                  	
                  	System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDTYPE_OF_PAYMENT  @Donor_SSN=?, @Date_of_Donation=?, @Payment_Type=?;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, Donor_SSN81);
                            statement.setString(2, Date_of_Donation81);	
                            statement.setString(3, Payment_Type81);
                            
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                    
                    if (k ==1) {
                    
                    System.out.println("Please enter Donor SSN");
                    final String Donor_SSN82 = sc.nextLine();
                    
                  	System.out.println("Donor Donation Date");
                    final String Date_of_Donation82 = sc.nextLine();
                     
                     System.out.println("Payment Type");
                     final String Payment_Type82 = sc.nextLine();
                     
                     System.out.println("Credit Card Number");
                     final String Credit_Card82 = sc.nextLine();
                     
                     System.out.println("Credit Card Type");
                     final String Credit_CardType82 =  sc.nextLine();;
                  	
                     System.out.println("Expiration Date");
                     final String Expiration_Date = sc.nextLine();
                     
                  	System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (
                            final PreparedStatement statement = connection.prepareStatement("ADDCREDIT_CARD   @Donor_SSN=?, @Date_of_Donation=?, @Payment_Type=?, @Credit_Card_No=?, @Card_Type=?, @Expiration_Date=?;")) {
                            // Populate the query template with the data collected from the user
                            statement.setString(1, Donor_SSN82);
                            statement.setString(2, Date_of_Donation82);	
                            statement.setString(3, Payment_Type82);
                            statement.setString(4, Credit_Card82);
                            statement.setString(5, Credit_CardType82);
                            statement.setString(6, Expiration_Date);
                                                        
                            System.out.println("Dispatching the query...");
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                    }
                    
                    else
                    {
                        
                        System.out.println("Please enter Donor SSN");
                        final String Donor_SSN83 = sc.nextLine();
                        
                      	System.out.println("Donor Donation Date");
                        final String Date_of_Donation83 = sc.nextLine();
                         
                         System.out.println("Payment Type");
                         final String Payment_Type83 = sc.nextLine();
                         
                         System.out.println("Check No");
                         final int Check83 = sc.nextInt();
                                                                          
                      	System.out.println("Connecting to the database...");
                        // Get a database connection and prepare a query statement
                        try (final Connection connection = DriverManager.getConnection(URL)) {
                            try (
                                final PreparedStatement statement = connection.prepareStatement("ADDCHECKS @Donor_SSN=?, @Date_of_Donation=?, @Payment_Type=?, @CheckNo=?;")) {
                                // Populate the query template with the data collected from the user
                                statement.setString(1, Donor_SSN83);
                                statement.setString(2, Date_of_Donation83);	
                                statement.setString(3, Payment_Type83);
                                statement.setInt(4, Check83);
                              
                                                            
                                System.out.println("Dispatching the query...");
                                // Actually execute the populated query
                                final int rows_inserted = statement.executeUpdate();
                                System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                            }
                        }
                        }
                    	
                    
                    
                    break;
                    
               case "9":
           	   
            	System.out.println("Is this the first donation for the same donor? Enter 1 for yes and 0 for no");
               	
               	int l = sc.nextInt();
               	
               	System.out.println("Is this donation being made by check or credit card? Enter 1 for credit card and 2 for check");
               	
               	int m = sc.nextInt();
               	            	
               	if (l ==1) {
               	
                           	   
            	   System.out.println ("Please enter Organization Name");
               	   sc.nextLine();
                   final String Organization_Name9 = sc.nextLine();
                   
                   System.out.println("Please Enter Street_No");
                   final String Street_No9 = sc.nextLine();
                   
                   System.out.println("Please Enter Street Name");
                   final String Street_Name9 = sc.nextLine();
                   
                   System.out.println("Enter Name of City");
                   final  String  City9 = sc.nextLine();
                
                   System.out.println("Enter Name of State");
                   final  String  State9 = sc.nextLine();

                   System.out.println("Enter Zip");
                   final  String  Zip9 = sc.nextLine();
                                     
                   System.out.println("Enter Phone_No");
                   final  String  Phone_No9 = sc.nextLine();
                   
                   System.out.println("Connecting to the database...");
                   // Get a database connection and prepare a query statement
                   try (final Connection connection = DriverManager.getConnection(URL)) {
                       try (
                           final PreparedStatement statement = connection.prepareStatement("ADDORGANIZATION @Organization_Name=?, @Street_No=?, @Street_Name=?, @City=?, @State=?, @Zip=?, @Phone_Number=?;" )) {
                           // Populate the query template with the data collected from the user
                           statement.setString(1, Organization_Name9);
                           statement.setString(2, Street_No9);
                           statement.setString (3, Street_Name9);
                           statement.setString(4, City9);
                           statement.setString(5, State9);
                           statement.setString(6, Zip9);
                           statement.setString(7, Phone_No9);
                                                                           
                           System.out.println("Dispatching the query...");
                           // Actually execute the populated query
                           final int rows_inserted = statement.executeUpdate();
                           System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                       }
                   }
                  
                   System.out.println("Please enter Organization Name");
                   final String OrganizationName94 = sc.nextLine();
                   
                   System.out.println("Business Type");
                   final String BusinessType94 = sc.nextLine();
                    
                   System.out.println("Business Size");
                   final int BusinessSize94 = sc.nextInt();
                 	
                   System.out.println("Company Web Site");
                   sc.nextLine();
                   final String CompanyWebSite94 = sc.nextLine(); 
                    
                 	System.out.println("Connecting to the database...");
                   // Get a database connection and prepare a query statement
                   try (final Connection connection = DriverManager.getConnection(URL)) {
                       try (
                           final PreparedStatement statement = connection.prepareStatement("ADDBUSINESS  @Organization_Name=?, @Business_Type=?, @Business_Size=?, @Company_Web_Site=?;")) {
                           // Populate the query template with the data collected from the user
                           statement.setString(1, OrganizationName94);
                           statement.setString(2, BusinessType94);	
                           statement.setInt(3, BusinessSize94);
                           statement.setString(4, CompanyWebSite94);
                           
                           System.out.println("Dispatching the query...");
                           // Actually execute the populated query
                           final int rows_inserted = statement.executeUpdate();
                           System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                       }
                   }
                   
               	}               
                   System.out.println("Please enter Date_of_Donation");
                   sc.nextLine();
                   final String Donation_Date91 = sc.nextLine();
                   
                 	System.out.println("Amount_of_Donation");
                   final float Donation_Amount91 = sc.nextFloat();
                 	
                   System.out.println("Name of Fund Raising Campaign");
                   sc.nextLine();
                   final String Campaign_Name91 = sc.nextLine();
                   
                   System.out.println("Connecting to the database...");
                   // Get a database connection and prepare a query statement
                   try (final Connection connection = DriverManager.getConnection(URL)) {
                       try (
                           final PreparedStatement statement = connection.prepareStatement("ADDORGANIZATION_DONATION_DETAILS @Date_of_Donation=?, @Amount_of_Donation=?, @Name_of_Fund_Raising_Campaign=?;")) {
                           // Populate the query template with the data collected from the user
                           statement.setString(1, Donation_Date91);
                           statement.setFloat(2, Donation_Amount91);
                           statement.setString(3, Campaign_Name91);
                              
                           System.out.println("Dispatching the query...");
                           // Actually execute the populated query
                           final int rows_inserted = statement.executeUpdate();
                           System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                       }
                   }
                    
                   System.out.println("Please enter Organization Name");
                   final String OrganizationName91 = sc.nextLine();
                   
                 	System.out.println("Donor Donation Date");
                    final String Date_of_Donation91 = sc.nextLine();
                 	
                 	System.out.println("Connecting to the database...");
                   // Get a database connection and prepare a query statement
                   try (final Connection connection = DriverManager.getConnection(URL)) {
                       try (
                           final PreparedStatement statement = connection.prepareStatement("ADDORGANIZATION_MAKES @Organization_Name=?, @Date_of_Donation=?;")) {
                           // Populate the query template with the data collected from the user
                           statement.setString(1, OrganizationName91);
                           statement.setString(2, Date_of_Donation91);	
                           System.out.println("Dispatching the query...");
                           // Actually execute the populated query
                           final int rows_inserted = statement.executeUpdate();
                           System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                       }
                   }
                   
                                     
                   
                   System.out.println("Please enter Organization Name");
                   final String OrganizationName92 = sc.nextLine();
                   
                 	System.out.println("Donor Donation Date");
                   final String Date_of_Donation92 = sc.nextLine();
                    
                    System.out.println("Payment Type");
                    final String Payment_Type92 = sc.nextLine();
                 	
                 	System.out.println("Connecting to the database...");
                   // Get a database connection and prepare a query statement
                   try (final Connection connection = DriverManager.getConnection(URL)) {
                       try (
                           final PreparedStatement statement = connection.prepareStatement("ADDORGANIZATION_TYPE_OF_PAYMENT  @Organization_Name=?, @Date_of_Donation=?, @Payment_Type=?;")) {
                           // Populate the query template with the data collected from the user
                           statement.setString(1, OrganizationName92);
                           statement.setString(2, Date_of_Donation92);	
                           statement.setString(3, Payment_Type92);
                           
                           System.out.println("Dispatching the query...");
                           // Actually execute the populated query
                           final int rows_inserted = statement.executeUpdate();
                           System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                       }
                   }
                   
                   if (m ==1) { 
                                                       
                   System.out.println("Please enter Organization Name");
                   final String OrganizationName93 = sc.nextLine();
                   
                 	System.out.println("Donor Donation Date");
                   final String Date_of_Donation93 = sc.nextLine();
                    
                    System.out.println("Payment Type");
                    final String Payment_Type93 = sc.nextLine();
                    
                    System.out.println("Credit Card Number");
                    final String Credit_Card93 = sc.nextLine();
                    
                    System.out.println("Credit Card Type");
                    final String Credit_CardType93 =  sc.nextLine();;
                 	
                    System.out.println("Expiration Date");
                    final String Expiration_Date93 = sc.nextLine();
                    
                 	System.out.println("Connecting to the database...");
                   // Get a database connection and prepare a query statement
                   try (final Connection connection = DriverManager.getConnection(URL)) {
                       try (
                           final PreparedStatement statement = connection.prepareStatement("ADDORGANIZATION_CREDIT_CARD  @Organization_Name=?, @Date_of_Donation=?, @Payment_Type=?, @Credit_Card_No=?, @Card_Type=?, @Expiration_Date=?;")) {
                           // Populate the query template with the data collected from the user
                           statement.setString(1, OrganizationName93);
                           statement.setString(2, Date_of_Donation93);	
                           statement.setString(3, Payment_Type93);
                           statement.setString(4, Credit_Card93);
                           statement.setString(5, Credit_CardType93);
                           statement.setString(6, Expiration_Date93);
                           
                           
                           System.out.println("Dispatching the query...");
                           // Actually execute the populated query
                           final int rows_inserted = statement.executeUpdate();
                           System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                       }
                   }
                   }
                   
                   else
                   {
                       
                       System.out.println("Please enter Organization Name");
                       final String OrganizationName94 = sc.nextLine();
                       
                     	System.out.println("Donor Donation Date");
                       final String Date_of_Donation94 = sc.nextLine();
                        
                        System.out.println("Payment Type");
                        final String Payment_Type94 = sc.nextLine();
                        
                        System.out.println("Check No");
                        final int Check94 = sc.nextInt();
                                                                         
                     	System.out.println("Connecting to the database...");
                       // Get a database connection and prepare a query statement
                       try (final Connection connection = DriverManager.getConnection(URL)) {
                           try (
                               final PreparedStatement statement = connection.prepareStatement("ADDORGANIZATION_CHECKS  @Organization_Name=?, @Date_of_Donation=?, @Payment_Type=?, @CheckNo=?;")) {
                               // Populate the query template with the data collected from the user
                               statement.setString(1, OrganizationName94);
                               statement.setString(2, Date_of_Donation94);	
                               statement.setString(3, Payment_Type94);
                               statement.setInt(4, Check94);
                             
                                                           
                               System.out.println("Dispatching the query...");
                               // Actually execute the populated query
                               final int rows_inserted = statement.executeUpdate();
                               System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                           }
                       }
                       }
                   
                	   
                   
                break;
                    
                case "10":
                	
                	System.out.println("Please enter Client_SSN");
                    sc.nextLine();
                	final String Client_No = sc.nextLine();
                    
                	System.out.println("Connecting to the database...");
                    // Get the database connection, create statement and execute it right away, as no user input need be collected
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        System.out.println("Dispatching the query...");
                        try (
                        		final PreparedStatement statement = connection.prepareStatement("Query10 @CLIENT_NO = ?;" )){
                        		statement.setString(1, Client_No);
                        	
                                final ResultSet resultSet = statement.executeQuery();
                                               	
                                System.out.println("Retrieve the name and phone number of the doctor of a particular client:");
                                System.out.println("Doctor_Name | Doctor_Phone   ");

                                // Unpack the tuples returned by the database and print them out to the user
                                while (resultSet.next()) {
                                System.out.println(String.format("%s | %s  ",
                                					resultSet.getString(1), 
                                					resultSet.getString(2)));
                        }
                        }
            }

                    break;
                    
                case "11":
                	
                	System.out.println("Please enter Date1");
                    sc.nextLine();
                	final String date1 = sc.nextLine();
                	
                	System.out.println("Please enter Date2");
                	final String date2 = sc.nextLine();
                	
                	 System.out.println("Connecting to the database...");
                     // Get the database connection, create statement and execute it right away, as no user input need be collected
                     try (final Connection connection = DriverManager.getConnection(URL)) {
                         System.out.println("Dispatching the query...");
                         try (
                         		final PreparedStatement statement = connection.prepareStatement("Query11 @date1 = ?, @date2 = ?;" )){
                        	    statement.setString(1, date1);
                        	    statement.setString(2, date2);
                         	
                                 final ResultSet resultSet = statement.executeQuery();

                                 System.out.println("Retrieve the employee name and sum expensed:");
                                 System.out.println("Employee_Name | Sum Expensed   ");

                                 // Unpack the tuples returned by the database and print them out to the user
                                 while (resultSet.next()) {
                                 System.out.println(String.format("%s | %s  ",
                                 					resultSet.getString(1), 
                                 					resultSet.getString(2)));
                                 
                             }
                         }
             }

                     break;
             
                case "12":
                	System.out.println("Please enter Team_Name");
                    sc.nextLine();
                	final String Team_Name12 = sc.nextLine();
                	
                	System.out.println("Please Client_SSN");
                	final String Client_SSN12 = sc.nextLine();
                	
                	 System.out.println("Connecting to the database...");
                     // Get the database connection, create statement and execute it right away, as no user input need be collected
                     try (final Connection connection = DriverManager.getConnection(URL)) {
                         System.out.println("Dispatching the query...");
                         try (
                         		final PreparedStatement statement = connection.prepareStatement("Query12 @TeamName = ?, @ClientNo = ?;" )){
                        	    statement.setString(1, Team_Name12);
                        	    statement.setString(2, Client_SSN12);
                         	
                                 final ResultSet resultSet = statement.executeQuery();

                                 System.out.println("Retrieve the Volunteer SSN:");
                                 System.out.println("Volunteer SSN   ");

                                 // Unpack the tuples returned by the database and print them out to the user
                                 while (resultSet.next()) {
                                 System.out.println(String.format("%s ",
                                 			resultSet.getString(1)));
                                 
                             }
                         }
             }

                    break;
                    
                                	
                case "13":
                	System.out.println("Connecting to the database...");
                    // Get the database connection, create statement and execute it right away, as no user input need be collected
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        System.out.println("Dispatching the query...");
                        try (
                            final Statement statement = connection.createStatement();
                            final ResultSet resultSet = statement.executeQuery("Query13")) {

                                System.out.println("Retrieval of list of Clients that Match Query 13.:");
                                System.out.println("Client SSN | Client Name | Birth Date | Race | Gender | Street_No | Street Name | City | State | Zip ");

                                // Unpack the tuples returned by the database and print them out to the user
                                while (resultSet.next()) {
                                System.out.println(String.format("%s | %s | %s | %s | %s | %s | %s | %s | %s  | %s",
                                		resultSet.getString(1),
                                		resultSet.getString(2),
                                        resultSet.getString(3),
                                        resultSet.getString(4),
                                        resultSet.getString(5),
                                        resultSet.getString(6),
                                        resultSet.getString(7),
                                        resultSet.getString(8),
                                        resultSet.getString(9),
                                        resultSet.getString(10)));
                                                                       		
                        }
                        }
                    }

                    break;   
                    
                case "14":
                	System.out.println("Connecting to the database...");
                    // Get the database connection, create statement and execute it right away, as no user input need be collected
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        System.out.println("Dispatching the query...");
                        try (
                            final Statement statement = connection.createStatement();
                            final ResultSet resultSet = statement.executeQuery("Query14")) {

                                System.out.println("Retrieve the SSN, Amount Donated and Is Anonymous for Donors that are also Employees.:");
                                System.out.println("Donor_SSN |Is_Anonymous| Amount of Donation ");

                                // Unpack the tuples returned by the database and print them out to the user
                                while (resultSet.next()) {
                                System.out.println(String.format("%s |%s||%s  ",
                                					resultSet.getString(1),
                                					resultSet.getString(2),
                                					resultSet.getString(3)));
                                
                            }
                        }
                    }
                	
                break;
                
               case "15":
                	
                	System.out.println("Please enter Date");
                    sc.nextLine();
                	final String Date1 = sc.nextLine();
                	
                    System.out.println("Connecting to the database...");
                    // Get the database connection, create statement and execute it right away, as no user input need be collected
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        System.out.println("Dispatching the query...");
                        try (
                        		final PreparedStatement statement = connection.prepareStatement("Query15 @DATEENTER = ?;" )) {
                                
                        	    statement.setString(1, Date1);
                        	
                                final ResultSet resultSet = statement.executeQuery();
                        	
                                System.out.println("Retrieve the names of all teams that were founded after a particular date.:");
                                System.out.println("Team_List  ");

                                // Unpack the tuples returned by the database and print them out to the user
                                while (resultSet.next()) {
                                System.out.println(String.format("%s  ",
                                					resultSet.getString(1)));
                                
                            }
                        }
                    }
                    
                    break;
                    
                  case "16":
                	
                	System.out.println("Connecting to the database...");
                    // Get the database connection, create statement and execute it right away, as no user input need be collected
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        System.out.println("Dispatching the query...");
                        try (
                            final Statement statement = connection.createStatement();
                            final ResultSet resultSet = statement.executeQuery("Query16")) {

                                System.out.println("Increase the salary by 10% of all employees to whom more than one team must report.:");
                                System.out.println("Employee_Name | Employee_Salary  ");

                                // Unpack the tuples returned by the database and print them out to the user
                                while (resultSet.next()) {
                                System.out.println(String.format("%s|%s  ",
                                					resultSet.getString(1),
                                					resultSet.getString(2)));
                                
                            }
                        }
                    }
                    
                    break;
                    
                case "17":
                	
                 System.out.println("Connecting to the database...");
                    // Get the database connection, create statement and execute it right away, as no user input need be collected
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        System.out.println("Dispatching the query...");
                        try (
                            final Statement statement = connection.createStatement();
                            final ResultSet resultSet = statement.executeQuery("Query17")) {

                                System.out.println("Delete all clients who do not have health insurance and whose value of importance for transportation is less than 5.:");
                                System.out.println("Client_SSN  ");

                                // Unpack the tuples returned by the database and print them out to the user
                                while (resultSet.next()) {
                                System.out.println(String.format("%s  ",
                                					resultSet.getString(1)));
                                
                            }
                        }
                    }
                	 	
                break;
                
                case "18":
                	
                	System.out.println("Please enter FileName1");
                    sc.nextLine();
                	final String FileName1 = sc.nextLine();
                	
                	System.out.println("Connecting to the database...");
                    // Get the database connection, read contents of CSV file and send to Database
                	
                	try (final Connection connection = DriverManager.getConnection(URL)) {
                        System.out.println("Dispatching the query...");
                        
                        try (
                        		final PreparedStatement statement = connection.prepareStatement("INSERT INTO Team (Team_Name, Team_Type, Date_Formed) VALUES(?,?,?);" ))  {  
                	
                	try (
                            Reader reader = Files.newBufferedReader(Paths.get(FileName1));
                            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                                    .withFirstRecordAsHeader()
                                    .withIgnoreHeaderCase()
                                    .withTrim());
                        ) {
                            for (CSVRecord csvRecord : csvParser) {
                                // Accessing values by Header names
                                String name = csvRecord.get("Name");
                                String type = csvRecord.get("Type");
                                String Date = csvRecord.get("Date");
                                
                                statement.setString(1, name);
                                statement.setString(2, type);
                                statement.setString(3, Date);
                                final int rows_inserted = statement.executeUpdate();
                             
                            }
                	
                	}
                        }
                	}
                
                break;
               
                case "19":

                	System.out.println("Please enter FileName");
                    sc.nextLine();
                	final String FileName = sc.nextLine();
                	
                	System.out.println("Connecting to the database...");
                    // Get the database connection, write contents to CSV file
                	
                	try (final Connection connection = DriverManager.getConnection(URL)) {
                        System.out.println("Dispatching the query...");
                	                    
                	
                	 try (
                	            BufferedWriter writer = Files.newBufferedWriter(Paths.get(FileName));

                	            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                	                    .withHeader("Name", "Street_No", "Street_Name", "City", "State", "Zip"));
                	        ) 
                	 
                	 {
                	            
                		 try (
                                 final Statement statement = connection.createStatement();
                                 final ResultSet resultSet = statement.executeQuery("Query19")) {
                			 
                			 while (resultSet.next()) {
                                  
                		        csvPrinter.printRecord(resultSet.getString(1),resultSet.getString(2), resultSet.getString(3),resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                	                           	                        	            
                			 }

                	            csvPrinter.flush();            
                	        }
                	 }
                	}
                	
                break;
                            
                 case "20": // Do nothing, the while loop will terminate upon the next iteration
                    System.out.println("Exiting! Goodbye!");
                   
                default: // Unrecognized option, re-prompt the user for the correct one
                    System.out.println(String.format(
                        "Unrecognized option: %s\n" + 
                        "Please try again!", 
                        option));
                    break;
            }
        }

        sc.close(); // Close the scanner before exiting the application
    }
}
