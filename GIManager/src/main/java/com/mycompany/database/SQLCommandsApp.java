/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mycompany.consts.CharacterName;
import com.mycompany.consts.Vision;
import com.mycompany.consts.Weapon;
import com.mycompany.consts.Rarity;
import com.mycompany.consts.ConstellationsLevel;

/**
 *
 * @author luisr
 */
public class SQLCommandsApp implements DataBaseConsts{

    static Connection connection = null;
    static PreparedStatement preparedStatement;
    
    public static void loadDriver() {
        try {
            Class.forName(DRIVER);
            System.out.println("Driver founded!");
        } catch (ClassNotFoundException notFoundDriver) {
            System.out.println("Driver JDBC not founded!");
        }
    }


    public static void createConnection(){
        try {
            connection = DriverManager.getConnection(DATABASE_PATH, USER, PASSWORD);
            System.out.println("Connection created!");
        } catch (SQLException connectionError) {
            System.out.println("Connection failed!");
        }
    }

    /**
     * Insert a new character in 'obtained_characters' table.
     * @throws SQLException
     */
    public static void insertObtainedCharacter(CharacterName characterName, Vision characterVision, Weapon characterWeapon, Rarity characterRarity, ConstellationsLevel characterConstellationsLevel, String characterMeetDate) throws SQLException{
       
       String name = characterName.toString();
       String vision = characterVision.toString();
       String rarity = characterRarity.toString();
       String weapon = characterWeapon.toString();
       String constellationsLevel = characterConstellationsLevel.toString();

        try {
            String sqlInsertObtainedCharacter = "INSERT INTO obtained_characters (name, vision, weapon, rarity, constellations_level, meet_date) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlInsertObtainedCharacter);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, vision);
            preparedStatement.setString(3, weapon);
            preparedStatement.setString(4, rarity);
            preparedStatement.setString(5, constellationsLevel);
            preparedStatement.setString(6, characterMeetDate);
            preparedStatement.executeUpdate();
            System.out.println("Character insertion successful!");
        } catch (SQLException statementCreationError) {
            System.out.println("SQL Query execution failed!");
        }
    }


    /**
     * Close DataBase connection.
     * @throws SQLException
     */
    public void closeConnection() throws SQLException{
        try {
            connection.close();
        } catch (SQLException closeConnectionError) {
            System.out.println("Connection close failed!");
        }
    }
}
