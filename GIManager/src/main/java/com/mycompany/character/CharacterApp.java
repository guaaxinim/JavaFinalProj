/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.character;

import java.sql.SQLException;

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
    
    private static Character character;
    
    public static void main(String[] args){       
        Character char1 = new Character(CharacterName.KINICH, Vision.DENDRO, Weapon.CLAYMORE, Rarity.FIVE_STARS, ConstellationsLevel.C1, "18/09/2024");

        SQLCommandsApp.loadDriver();
        SQLCommandsApp.createConnection();
        /*
        try {
            SQLCommandsApp.insertObtainedCharacter(char1.getName(),
                                                   char1.getVision(),
                                                   char1.getWeapon(),
                                                   char1.getRarity(),
                                                   char1.getConstellationsLevel(),
                                                   char1.getMeetDate());
        } catch (SQLException characterInsertionError) {
            System.out.println("Character insertion failed!");
        }*/

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

        try {
            SQLCommandsApp.updateObtainedCharacter(CharacterName.NEUVILLETTE);
        } catch (SQLException characterUpdateError) {
            System.out.println("Character update failed!");
        }
    }
}
