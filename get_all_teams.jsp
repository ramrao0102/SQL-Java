<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
        <title>Persons</title>
    </head>
    <body>
        <%@page import="Class_Project.Rao_Ramkishore_Task7"%>
        <%@page import="java.sql.ResultSet"%>
        <%
        	// We instantiate the data handler here, and get all the Teams from the database
                    final Rao_Ramkishore_Task7 handler = new Rao_Ramkishore_Task7();
                    final ResultSet Team = handler.getAllTeams();
        %>
        <!-- The table for displaying all the movie records -->
        <table cellspacing="2" cellpadding="2" border="1">
            <tr> <!-- The table headers row -->
              <td align="center">
                <h4>Team_Name</h4>
              </td>
              <td align="center">
                <h4>Team_Type</h4>
              </td>
              <td align="center">
                <h4>Date_Formed</h4>
              </td>
            
            </tr>
            <%
               while(Team.next()) { // For each movie_night record returned...
                   // Extract the attribute values for every row returned
                   final String Team_Name = Team.getString("Team_Name");
                   final String Team_Type = Team.getString("Team_Type");
                   final String Date_Formed = Team.getString("Date_Formed");
                 
                  
                   out.println("<tr>"); // Start printing out the new table row
                   out.println( // Print each attribute value
                        "<td align=\"center\">" + Team_Name +
                        "</td><td align=\"center\"> " + Team_Type +
                       
                        "</td><td align=\"center\"> " + Date_Formed + "</td>");
                   out.println("</tr>");
               }
               %>
          </table>
    </body>
</html>
