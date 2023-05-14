package DBTest;

import java.sql.*;

public class DatabaseTestTwo {
    public static void main(String[] args) {
        String url= "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql" ;
        // jdbc = java database connector.
        // mysql = which database you use (in this example mysql, it might be oracle or any other)
        // 3.239.253.255:3306 = address of your database which is providing by your company or developers
        // syntaxhrm_mysql = database name that you need to work on

        String username= "syntax_hrm"; // provide by company or developer
        String password = "syntaxhrm123"; // provide by company or developer

        try {// add this code into try catch
            // we need to establish the connection to the database(mysql)
            Connection connection = DriverManager.getConnection(url,username,password); // always follow the insertion, connection class should be java.sql
            System.out.println("Connection is created for Batch15");

            // create a statement to send sql queries
            Statement statement = connection.createStatement(); // Statement class should be java.sql
            // ResultSet result= statement.executeQuery("select FirstName,LastName from person");

           // while (result.next()){ // we are using while loop, because we are working on backend database , which we don't know the size of table
                //String firstname =result.getString("FirstName");
                //String lastname = result.getString("LastName");
                //System.out.println(firstname+ " " +lastname);

            ResultSet result=statement.executeQuery("select firstname,lastname, age, city "
                    +"from person where city is not null");

                // use below code instead of sout
                // Metadata  is having all keys and values and column names to us which come from database
                // ResultSetMetaData - object that contains information about the result
                // information such as in the table how many columns are there,
                // name of the columns, rows and number of the rows

            ResultSetMetaData metaData = result.getMetaData();
            // print all the columns header values (column names)
            for (int i = 1; i <= metaData.getColumnCount(); i++) { // start from 1 and add "<="
                String columnName=metaData.getColumnName(i);
                System.out.println(columnName);
            }// it will execute header of the table

            // we want to loop through every column and every row
            while (result.next()){ // we are using while loop, because we are working on backend database , which we don't know the size of table
                for (int i = 1; i <= metaData.getColumnCount() ; i++) {
                    String value = result.getString(metaData.getColumnName(i));
                    System.out.println(value+ " ");
                }
                // just to change to line statement added below code
                System.out.println();
            }
            }
         catch (SQLException e) {
            e.printStackTrace(); // if you add this, your console will print nothing
        }
    }
}

