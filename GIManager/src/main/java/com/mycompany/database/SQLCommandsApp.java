/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
        } catch (ClassNotFoundException notFoundDriver) {
        }
    }

    public static void createConnection(){
        try {
            connection = DriverManager.getConnection(DATABASE_PATH, USER, PASSWORD);
        } catch (SQLException connectionError) {
        }
    }

    /**
     * 
     * @param characterName
     * @return
     * @throws SQLException
     */
    public static boolean checkingCharacterExistanceInObtainedCharacters(CharacterName characterName, JButton buttonPressed) throws SQLException{
        boolean characterNotYetRegistered = false;
        String tableName = "obtained_characters";

        try {
            Character characterToInsert = selectObtainedCharacterByName(characterName, tableName);
            JOptionPane.showMessageDialog(buttonPressed, characterToInsert.getName()+" is already registered!", "Character insertion failed!", 2);
        } catch (IllegalArgumentException characterSelectionError) {
            characterNotYetRegistered = true;
        }

        return characterNotYetRegistered;
    }

    public static boolean checkingCharacterExistanceInAllCharacters(CharacterName characterName) throws SQLException{
        boolean characterNotYetRegistered = false;
        String tableName = "all_characters";

        try {
            Character characterToInsert = selectObtainedCharacterByName(characterName, tableName);
            System.out.println(characterToInsert+" is already registered!");
        } catch (IllegalArgumentException characterSelectionError) {
            characterNotYetRegistered = true;
        }

        return characterNotYetRegistered;
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
    public static void insertInObtainedCharacters(CharacterName characterName,
                                               Vision characterVision,
                                               Weapon characterWeapon,
                                               Rarity characterRarity,
                                               ConstellationsLevel characterConstellationsLevel,
                                               String characterMeetDate,
                                               JButton buttonPressed) throws SQLException{

    /* Checking if character already exists in table */
        boolean characterNotYetRegistered = checkingCharacterExistanceInObtainedCharacters(characterName, buttonPressed);

    /* Inserting character */
        Character character = new Character(characterName, characterVision, characterWeapon, characterRarity, characterConstellationsLevel, characterMeetDate);
        if (characterNotYetRegistered){
            String name = character.getName().toString();
            String vision = character.getVision().toString();
            String weapon = character.getWeapon().toString();
            String rarity = character.getRarity().toString();
            String constellationsLevel = character.getConstellationsLevel().toString();
    
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
                JOptionPane.showMessageDialog(buttonPressed, name+" was registered!", "Character insertion successful!", 1);
            } catch (SQLException characterInsertionError) {
                JOptionPane.showMessageDialog(buttonPressed, "", "Character insertion failed!", 0);
            }
        }
    }

    public static void updateObtainedCharacter(CharacterName characterName,
                                               ConstellationsLevel characterConstellationsLevel,
                                               String characterMeetDate,
                                               JPanel obtainedCharactersPanel) throws SQLException{
        String characterToUpdateName = characterName.toString();
        String characterToUpdateConstellationsLevel = characterConstellationsLevel.toString();
        try {
            String sqlUpdateObtainedCharacter = "UPDATE obtained_characters SET constellations_level = (?), meet_date = (?) WHERE name = (?)";
            preparedStatement = connection.prepareStatement(sqlUpdateObtainedCharacter);
            preparedStatement.setString(3, characterToUpdateName);
            preparedStatement.setString(1, characterToUpdateConstellationsLevel);
            preparedStatement.setString(2, characterMeetDate);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(obtainedCharactersPanel, characterToUpdateName+" updated!", "Character update successful!", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException characterUpdateError) {
            JOptionPane.showMessageDialog(obtainedCharactersPanel, "Character update failed!", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Delete a character from 'obtained_characters' values.
     * @param charaterName
     * @throws SQLException
     */
    public static void deleteObtainedCharacter(CharacterName charaterName, JPanel obtainedCharactersPanel) throws SQLException{
        
        String characterToRemoveName = charaterName.toString();
        
        try {            
            String sqlDeleteObtainedCharacter = "DELETE FROM obtained_characters WHERE name = (?)";
            preparedStatement = connection.prepareStatement(sqlDeleteObtainedCharacter);
            preparedStatement.setString(1, characterToRemoveName);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(obtainedCharactersPanel, characterToRemoveName+" was removed!", "Character remotion successful!", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException characterRemotionError) {
            JOptionPane.showMessageDialog(obtainedCharactersPanel, "Character remotion failed!", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Select a character from 'obtained_characters' table based on name given.
     * @param characterName
     * @return Character instance with selected character's values
     * @throws SQLException
     */
    public static Character selectObtainedCharacterByName(CharacterName characterName, String tableName) throws SQLException{

        String characterToSelectName = characterName.toString();
        String name;
        String vision;
        String weapon;
        String rarity;
        String constellationsLevel;
        String meetDate;

        try {
            String sqlSelectObtainedCharacter = "SELECT * FROM (?) WHERE name = (?)";
            preparedStatement = connection.prepareStatement(sqlSelectObtainedCharacter);
            preparedStatement.setString(1, tableName);
            preparedStatement.setString(2, characterToSelectName);
            resultSet = preparedStatement.executeQuery();

            if (tableName == "obtained_characters"){
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
            } else if (tableName == "all_characters"){
                while (resultSet.next()) {
                    name = resultSet.getString("name");
                    vision = resultSet.getString("vision");
                    weapon = resultSet.getString("weapon");
                    rarity = resultSet.getString("rarity");

                    Character character = new Character(CharacterName.fromString(name), Vision.fromString(vision), Weapon.fromString(weapon), Rarity.fromString(rarity));
                    return character;
                }
            }
        } catch (SQLException characterSelectionError) {
        }
        throw new IllegalArgumentException("Character selection failed!");
    }

    public static ArrayList<ArrayList<String>> selectAllObtainedCharacters(){
        ArrayList<ArrayList<String>> allCharactersSelectedArrayList = new ArrayList<>();
        try {
            String sqlSelectAllObtainedCharacters = "SELECT * FROM obtained_characters";
            preparedStatement = connection.prepareStatement(sqlSelectAllObtainedCharacters);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                ArrayList<String> characterSelectedArrayList = new ArrayList<String>();
                characterSelectedArrayList.add(resultSet.getString("name"));
                characterSelectedArrayList.add(resultSet.getString("vision"));
                characterSelectedArrayList.add(resultSet.getString("weapon"));
                characterSelectedArrayList.add(resultSet.getString("rarity"));
                characterSelectedArrayList.add(resultSet.getString("constellations_level"));
                characterSelectedArrayList.add(resultSet.getString("meet_date"));

                allCharactersSelectedArrayList.add(characterSelectedArrayList);
            }
        } catch (SQLException allCharactersSelectionError) {
            JOptionPane.showMessageDialog(null, null, "Characters selection failed!", 0);
        }
        
        return allCharactersSelectedArrayList;
    }

    public static void insertInAllCharacters(CharacterName characterName,
                                             Vision characterVision,
                                             Weapon characWeapon,
                                             Rarity characRarity) throws SQLException{

    /* Checking if character already exists in table */
        boolean characterNotYetRegistered = checkingCharacterExistanceInAllCharacters(characterName);

    /* Inserting character */
        Character character = new Character(characterName, characterVision, characWeapon, characRarity);
        if (characterNotYetRegistered){
            String name = character.getName().toString();
            String vision = character.getVision().toString();
            String weapon = character.getWeapon().toString();
            String rarity = character.getRarity().toString();

            try {
                String sqlInsertCharacter = "INSERT INTO all_characters (name, vision, weapon, rarity) VALUES (?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sqlInsertCharacter);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, vision);
                preparedStatement.setString(3, weapon);
                preparedStatement.setString(4, rarity);
                preparedStatement.executeUpdate();
            } catch (SQLException characterInsertionError) {
                System.out.println("Character insertion failed!");
            }
        }
    }

    public static ArrayList<ArrayList<String>> selectAllCharacters(){
        ArrayList<ArrayList<String>> allCharactersSelectedArrayList = new ArrayList<>();
        try {
            String sqlSelectAllCharacters = "SELECT * FROM all_characters";
            preparedStatement = connection.prepareStatement(sqlSelectAllCharacters);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ArrayList<String> characterSelectedArrayList = new ArrayList<String>();
                characterSelectedArrayList.add(resultSet.getString("name"));
                characterSelectedArrayList.add(resultSet.getString("vision"));
                characterSelectedArrayList.add(resultSet.getString("weapon"));
                characterSelectedArrayList.add(resultSet.getString("rarity"));

                allCharactersSelectedArrayList.add(characterSelectedArrayList);
            }
        } catch (SQLException allCharactersSelectionError) {
            System.out.println("Characters selection failed!");
        }
        
        return allCharactersSelectedArrayList;
    }

    /**
     * Close DataBase connection.
     * @throws SQLException
     */
    public void closeConnection() throws SQLException{
        try {
            connection.close();
        } catch (SQLException closeConnectionError) {
        }
    }
}
