<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add Date</title>
    </head>
    <body>
        <h2>Add Date</h2>
        <!--
            Form for collecting user input for the new Team record.
            Upon form submission, add_team.jsp file will be invoked.
        -->
        <form action="add_team2.jsp">
            <!-- The form organized in an HTML table for better clarity. -->
            <table border=1>
                <tr>
                    <th colspan="2">Enter the Date_Formed Data:</th>
                </tr>
                <tr>
                    <td>Date_Formed:</td>
                    <td><div style="text-align: center;">
                    <input type=text name=Date_Formed>
                    </div></td>
                </tr>
                 <tr>
                    <td><div style="text-align: center;">
                    <input type=reset value=Clear>
                    </div></td>
                    <td><div style="text-align: center;">
                    <input type=submit value=Insert>
                    </div></td>
                </tr>
            </table>
        </form>
    </body>
</html>

