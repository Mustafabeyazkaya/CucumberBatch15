package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {
    static Connection connection = null;
    static Statement statement = null;
    private static ResultSet rSet;
    private static ResultSetMetaData rSetMetaData;

    // this method create connection to database,execute query and return abject for resultSet
    public static ResultSet getResultSet(String sqlQuery) {
        try {
            connection = DriverManager.getConnection(ConfigReader.getPropertyValue("urlDB"),
                    ConfigReader.getPropertyValue("usernameDB"),
                    ConfigReader.getPropertyValue("passwordDB"));

            statement = connection.createStatement();

            rSet = statement.executeQuery(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rSet;
    }


    // this method will return the object of ResultSetMetaData
    public static ResultSetMetaData getrSetMetaData(String query) {// this is not sqlQuery
        rSet = getResultSet(query); // pay attention this "getResultSet is a method name which we implemented above"
        rSetMetaData = null; // we make it null because we haven't provided data yet
        // we use this line to get the data in tabular format so that
        // we can use these in column keys and values for retrieval operation
        try {
            rSetMetaData = rSet.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rSetMetaData;
    }


    // this method is extracting the data which will be stored in list of maps
    public static List<Map<String, String>> getListOfMapsFromRset(String query) {
        rSetMetaData = getrSetMetaData(query);// pay attention this " getrSetMetaData is a method name which we implemented above"
        List<Map<String, String>> listFromRset = new ArrayList<>();
        try {
            while (rSet.next()) {
                Map<String, String> map = new LinkedHashMap<>();
                for (int i = 1; i <= rSetMetaData.getColumnCount(); i++) {
                    String key = rSetMetaData.getColumnName(i);
                    String value = rSet.getString(key);
                    map.put(key, value);
                }
                System.out.println(map);
                listFromRset.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResultSet(rSet);
            closeStatement(statement);
            closeConnection(connection);
        }
        return listFromRset;
    }


    // order to make connection
    // connection
    // statement
    // resultSet

    // close resulSet
    // close statement
    // close connection


    // close resulSet
    public static void closeResultSet(ResultSet rSet){
        if (rSet!=null){
            try {
                rSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // close statement
    public static void closeStatement(Statement statement){
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // close connection
    public static void closeConnection(Connection connec){
        if (connec!=null){
            try {
                connec.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
