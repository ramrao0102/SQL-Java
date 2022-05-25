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
    <%@page import="Class_Project.Rao_Ramkishore_Task7"%>
    <%@page import="java.sql.ResultSet"%>
    <%@page import="java.sql.Array"%>
    <%
    	// The handler is the one in charge of establishing the connection.
        Rao_Ramkishore_Task7 handler = new Rao_Ramkishore_Task7();

        // Get the attribute values passed from the input form.
            String Team_Name= request.getParameter("Team_Name");
            String Team_Type = request.getParameter("Team_Type");
           
            String Date_Formed = request.getParameter("Date_Formed");
                   
            // Now perform the query with the data from the form.
            boolean success = handler.addTeam(Team_Name, Team_Type, Date_Formed);
            if (!success) { // Something went wrong
    %>
                <h2>There was a problem inserting the course</h2>
            <%
        } else { // Confirm success to the user
            %>
            <h2>The Team:</h2>

            <ul>
                <li>Team_Name: <%=Team_Name%></li>
                <li>Team_Type: <%=Team_Type%></li>
               
                <li>Date_Formed:  <%=Date_Formed%></li>
              </ul>

            <h2>Was successfully inserted.</h2>
            
            <a href="get_all_teams.jsp">See all Teams.</a>
             <%
        }
    
    %>
    </body>
</html>
