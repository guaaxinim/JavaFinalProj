/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import com.mycompany.character.Character;
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
    static ResultSet resultSet;
    
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
     * @param characterName
     * @param characterVision
     * @param characterWeapon
     * @param characterRarity
     * @param characterConstellationsLevel
     * @param characterMeetDate
     * @throws SQLException
     */
    public static void insertObtainedCharacter(CharacterName characterName, Vision characterVision, Weapon characterWeapon, Rarity characterRarity, ConstellationsLevel characterConstellationsLevel, String characterMeetDate) throws SQLException{

        boolean characterNotYetRegistered = false;

        try {
            Character characterToInsert = selectObtainedCharacter(characterName);
            System.out.println("Character "+characterToInsert.getName()+" is already in list!");
            System.out.println("Insertion failed!");
        } catch (IllegalArgumentException characterSelectionError) {
            characterNotYetRegistered = true;
        }

        if (characterNotYetRegistered){
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
            } catch (SQLException characterInsertionError) {
                System.out.println("Character insertion failed!");
            }
        }
    }

    public static void updateObtainedCharacter(CharacterName characterName) throws SQLException{

            String characterToUpdateName = characterName.toString();
        
        try {
            String sqlUpdateObtainedCharacter = "UPDATE obtained_characters SET constellations_level = (?), meet_date = (?) WHERE name = (?)";
            preparedStatement = connection.prepareStatement(sqlUpdateObtainedCharacter);
            preparedStatement.setString(3, characterToUpdateName);
            preparedStatement.setString(1, "C0");
            preparedStatement.setString(2, "01/01/2024");
            preparedStatement.executeUpdate();
            System.out.println("Character update successful!");
        } catch (SQLException characterUpdateError) {
            System.out.println("Character update failed!");
        }
    }

    /**
     * Delete a character from 'obtained_characters' values.
     * @param charaterName
     * @throws SQLException
     */
    public static void deleteObtainedCharacter(CharacterName charaterName) throws SQLException{
        
        String characterToRemoveName = charaterName.toString();
        
        try {            
            String sqlDeleteObtainedCharacter = "DELETE FROM obtained_characters WHERE name = (?)";
            preparedStatement = connection.prepareStatement(sqlDeleteObtainedCharacter);
            preparedStatement.setString(1, characterToRemoveName);
            preparedStatement.executeUpdate();
            System.out.println("Character remotion successful!");
        } catch (SQLException characterRemotionError) {
            System.out.println("Character remotion failed!");
        }
    }

    /**
     * Select a character from 'obtained_characters' table.
     * @param characterName
     * @return Character instance with selected character's values
     * @throws SQLException
     */
    public static Character selectObtainedCharacter(CharacterName characterName) throws SQLException{

        String characterToSelectName = characterName.toString();
        String name;
        String vision;
        String weapon;
        String rarity;
        String constellationsLevel;
        String meetDate;

        try {
            String sqlSelectObtainedCharacter = "SELECT * FROM obtained_characters WHERE name = (?)";
            preparedStatement = connection.prepareStatement(sqlSelectObtainedCharacter);
            preparedStatement.setString(1, characterToSelectName);
            resultSet = preparedStatement.executeQuery();
            System.out.println("Character Selection successful!");

            while (resultSet.next()) {
                name = resultSet.getString("name");
                vision = resultSet.getString("vision");
                weapon = resultSet.getString("weapon");
                rarity = resultSet.getString("rarity");
                constellationsLevel = resultSet.getString("constellations_level");
                meetDate = resultSet.getString("meet_date");

                Character character = new Character(CharacterName.fromString(name), Vision.fromString(vision), Weapon.fromString(weapon), Rarity.fromString(rarity), ConstellationsLevel.fromString(constellationsLevel), meetDate);
                return character;
            }
        } catch (SQLException characterSelectionError) {
            System.out.println("Character selection failed!");
        }
        throw new IllegalArgumentException("Character selection failed!");
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
