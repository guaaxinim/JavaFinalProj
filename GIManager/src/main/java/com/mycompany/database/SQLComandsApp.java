/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author luisr
 */
public class SQLComandsApp implements DataBaseConsts{

    public static void main(String[] args) { 
        // Loading driver.
        try {
            Class.forName(DRIVER);
            System.out.println("Driver founded!");
        } catch (ClassNotFoundException notFoundDriver) {
            System.out.println("Driver JDBC not founded!");
        }

        Connection connection = null;

        // Connecting with database.
        try {
            connection = DriverManager.getConnection(DATABASE_PATH, USER, PASSWORD);
        } catch (SQLException connectionError) {
            System.out.println("Connection failed!");
        }

        PreparedStatement preparedStatement;

        // Executing SQL Query.
        try {
            String sqlInsertObtainedCharacter = "INSERT INTO obtained_characters (name, vision, weapon, rarity, constellations_level, meet_date) VALUES (?, ?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sqlInsertObtainedCharacter);
            preparedStatement.setString(1, "Navia");
            preparedStatement.setString(2, "Geo");
            preparedStatement.setString(3, "Claymore");
            preparedStatement.setString(4, "5-stars");
            preparedStatement.setString(5, "C3");
            preparedStatement.setString(6, "18/02/2024");
            preparedStatement.executeUpdate();

        } catch (SQLException statementCreationError) {
            System.out.println("SQL Query execution failed!");
        }

        // Closing connection.
        try {
            connection.close();
        } catch (SQLException closeConnectionError) {
            System.out.println("Connection close failed!");
        }
    }
}
