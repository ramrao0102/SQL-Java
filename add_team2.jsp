<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Query Result</title>
</head>
    <body>
    <%@page import="Class_Project.Rao_Ramkishore_Task7b"%>
    <%@page import="java.sql.ResultSet"%>
    <%@page import="java.sql.Array"%>
      
    <%
          	// The handler is the one in charge of establishing the connection.
              Rao_Ramkishore_Task7b handler2 = new Rao_Ramkishore_Task7b();

              // Get the attribute values passed from the input form.
                     
                  String Date_Formed= request.getParameter("Date_Formed");
                  final ResultSet Team = handler2.getAllTeams(Date_Formed);
          %>
        <h2>The Date Assigned:</h2>
        <ul>
                  
            <li>Date_Formed:  <%=Date_Formed%></li>
          </ul>

        <h2>Was successfully Viewed.</h2>
        
        <a href="get_all_teams1.jsp">See all Teams.</a>
         <%
        
         %>
         <!-- The table for displaying all the Team Records -->
         <table cellspacing="2" cellpadding="2" border="1">
             <tr> <!-- The table headers row -->
               <td align="center">
                 <h4>Team_Name</h4>
               </td>
              
             </tr>
             <%
         
             while(Team.next()) { // For each Team returned...
             // Extract the attribute values for every row returned
             
             final String Team_Name = Team.getString("Team_Name");
                               
             out.println("<tr>"); // Start printing out the new table row
             out.println( // Print each attribute value
                  
                  "</td><td align=\"center\"> " + Team_Name + "</td>");
             out.println("</tr>");
         }
         %>

    </body>
</html>
