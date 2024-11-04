package com.mycompany.screen.actions;

import java.util.ArrayList;

import javax.swing.JComboBox;

import com.mycompany.consts.AllCharacters;
import com.mycompany.consts.Rarity;
import com.mycompany.consts.Vision;
import com.mycompany.consts.Weapon;

public class ComboBoxesActions {
    
    public static void changeComboBoxesValuesBasedOnName(String characterName,
                                                         JComboBox<String> visionsComboBox,
                                                         JComboBox<String> weaponsComboBox,
                                                         JComboBox<String> raritiesComboBox){
        if (characterName != ""){
            for (AllCharacters character : AllCharacters.values()){
                if (character.getCharacterName().toString() == characterName){
                /* Changing vision's value */
                    visionsComboBox.removeAllItems();
                    visionsComboBox.addItem(character.getCharacterVision().toString());
                /* Changing weapon's value */
                    weaponsComboBox.removeAllItems();
                    weaponsComboBox.addItem(character.getCharacterWeapon().toString());
                /* Changing rarity's value */
                    raritiesComboBox.removeAllItems();
                    raritiesComboBox.addItem(character.getCharacterRarity().toString());
                }
            }
        } else if (characterName == ""){
        /* Changing vision's value */
            visionsComboBox.removeAllItems();

            // Creating a new ArrayList containg all visions //
            ArrayList<String> allVisions = new ArrayList<String>();
            allVisions.add("");
            for (Vision vision : Vision.values()){
                allVisions.add(vision.toString());
            }
            // Setting the values of JcomboBox to all visions //
            for (String vision : allVisions){
                visionsComboBox.addItem(vision);
            }
        /* Changing weapon's value */
            weaponsComboBox.removeAllItems();

            // Creating a new ArrayList containing all weapons //
            ArrayList<String> allWeapons = new ArrayList<String>();
            allWeapons.add("");
            for (Weapon weapon : Weapon.values()){
                allWeapons.add(weapon.toString());
            }
            // Setting the values of JComboBox to all weapons //
            for (String weapon : allWeapons){
                weaponsComboBox.addItem(weapon);
            }
        /* Changing rarity's value */
            raritiesComboBox.removeAllItems();

            // Creating a new ArrayList containing all rarities //
            ArrayList<String> allRarities = new ArrayList<String>();
            allRarities.add("");
            for (Rarity rarity : Rarity.values()){
                allRarities.add(rarity.toString());
            }
            // Setting the values of JComboBox to all rarities //
            for (String rarity : allRarities){
                raritiesComboBox.addItem(rarity);
            }
        }

    }
}
