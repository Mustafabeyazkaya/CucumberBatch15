package DBTest;

import java.sql.*;

public class DatabaseTest {
    public static void main(String[] args) {
    /* to build the connection with the database
    we need 3 things,URL,username, password
     */
        String url= "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql" ;
                                    // jdbc = java database connector.
                                    // mysql = which database you use (in this example mysql, it might be oracle or any other)
                                    // 3.239.253.255:3306 = address of your database which is providing by your company or developers
                                    // syntaxhrm_mysql = database name that you need to work on

        String username= "syntax_hrm"; // provide by company or developer
        String password = "syntaxhrm123"; // provide by company or developer


        try {// add this code into try catch
            // we need to establish the connection to the database(mysql)
            Connection connection =DriverManager.getConnection(url,username,password); // always follow the insertion, connection class should be java.sql
            System.out.println("Connection is created for Batch15");

            // create a statement to send sql queries
            Statement statement = connection.createStatement(); // Statement class should be java.sql
            // when we send any query to the database then db returns
            // result set ( tables with rows and columns)
            ResultSet result= statement.executeQuery("select FirstName,LastName from person"); // ResultSet class should be java.sql
            result.next(); // we put this code to have access to the first value by passing by header of table

            String firstName= result.getString("FirstName");
            String lastname=result.getString("LastName");
            System.out.println(firstName + " " + lastname);

            // this is the bad approach to retrieve values , go and check the DatabaseTestTwo class for better approach
            result.next(); // we put this code to have access to the first value by passing by header of table
            firstName= result.getString("FirstName");
            lastname=result.getString("LastName");
            System.out.println(firstName + " " + lastname);

        } catch (SQLException e) {
            e.printStackTrace(); // if you add this, your console will print nothing
        }

    }
}
