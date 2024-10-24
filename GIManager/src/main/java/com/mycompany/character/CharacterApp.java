/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.character;

import java.sql.SQLException;

import com.mycompany.consts.AllCharacters;
import com.mycompany.consts.CharacterName;
import com.mycompany.consts.Vision;
import com.mycompany.consts.Weapon;
import com.mycompany.database.SQLCommandsApp;
import com.mycompany.consts.Rarity;
import com.mycompany.consts.ConstellationsLevel;

/**
 *
 * @author luisr
 */
public class CharacterApp {
    // TODO: update the character existance check.
    
    public static void main(String[] args){       
        SQLCommandsApp.loadDriver();
        SQLCommandsApp.createConnection();

        Character char1 = new Character(CharacterName.ALHAITHAM, Vision.DENDRO, Weapon.SWORD, Rarity.FIVE_STARS, ConstellationsLevel.C3, "22/03/2022");

        CharacterName characterName = char1.getName();
        Vision characterVision = char1.getVision();
        Weapon characterWeapon = char1.getWeapon();
        Rarity characterRarity = char1.getRarity();
        ConstellationsLevel characterConstellationsLevel = char1.getConstellationsLevel();
        String characterMeetDate = char1.getMeetDate();
        
        // Checking if exists a Genshin Impact character with parameters given.
        boolean characterExists = false;
        for (AllCharacters character : AllCharacters.values()){
            if (characterName != character.getCharacterName()){
                System.out.println("Character not exists!");
            }
            else if (characterVision != character.getCharacterVision()){
                System.out.println("Character not exists!");
            }
            else if (characterWeapon != character.getCharacterWeapon()){
                System.out.println("Character not exists!");
            }
            else if (characterRarity != character.getCharacterRarity()){
                System.out.println("Character not exists!");
            }
            else{characterExists = true;}
        }
        // End check.
        
        if (characterExists){            
            try {
                SQLCommandsApp.insertObtainedCharacter(characterName,
                                                       characterVision,
                                                       characterWeapon,
                                                       characterRarity,
                                                       characterConstellationsLevel,
                                                       characterMeetDate);
            } catch (SQLException characterInsertionError) {
                System.out.println("Character insertion failed!");
            }
        } else{System.out.println("Character insertion failed!");}

        /*
        try {
            SQLCommandsApp.deleteObtainedCharacter(CharacterName.ARLECCHINO);
        } catch (SQLException characterRemotionError) {
            System.out.println("Character remotion failed!");
        }
        */

        /*
        try{
            character = SQLCommandsApp.selectObtainedCharacter(CharacterName.KINICH);
        } catch (SQLException characterSelectionError) {
            System.out.println("Character selection failed");
        }
        System.out.println(character.getName());
        System.out.println(character.getVision());
        System.out.println(character.getWeapon());
        System.out.println(character.getRarity());
        System.out.println(character.getConstellationsLevel());
        System.out.println(character.getMeetDate());
        */

        /*
        try {
            SQLCommandsApp.updateObtainedCharacter(CharacterName.NEUVILLETTE);
        } catch (SQLException characterUpdateError) {
            System.out.println("Character update failed!");
        }
        */
    }
}
