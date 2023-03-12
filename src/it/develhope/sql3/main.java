package it.develhope.sql3;

import java.sql.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/newdb";
        String user = "developer";
        String password = "passwordhere";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            ArrayList<String> surnames = new ArrayList<>();
            while(resultSet.next()){
                String name = resultSet.getString("first_name");
                System.out.println(name);
                surnames.add(resultSet.getString("last_name"));
            }
            System.out.println(surnames);
            resultSet.close();
            connection.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}


