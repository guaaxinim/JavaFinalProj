package com.mycompany.screen;

import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

import com.mycompany.character.Character;
import com.mycompany.consts.*;
import com.mycompany.database.SQLCommandsApp;


public class ButtonsActions {

    public static void characterInsertion(String name,
                                          String vision,
                                          String weapon,
                                          String rarity,
                                          String constellationsLevel,
                                          String meetDate,
                                          JButton buttonPressed) throws SQLException{
        try {
            Character character = new Character(CharacterName.fromString(name),
                                                Vision.fromString(vision),
                                                Weapon.fromString(weapon),
                                                Rarity.fromString(rarity),
                                                ConstellationsLevel.fromString(constellationsLevel),
                                                meetDate);

            SQLCommandsApp.insertObtainedCharacter(character.getName(),
                                                   character.getVision(),
                                                   character.getWeapon(),
                                                   character.getRarity(),
                                                   character.getConstellationsLevel(),
                                                   character.getMeetDate(),
                                                   buttonPressed);
        } catch (SQLException characterInsertionError) {
            System.out.println("Character insertion failed!");
        } catch (IllegalArgumentException characterInsertionError) {
            JOptionPane.showMessageDialog(buttonPressed, "Cannot insert a character with empty values!", "Character insertion failed!", 0);
        }
    }

    public static void clearInputFields(JComboBox<String> namesComboBox,
                                        JComboBox<String> visionsComboBox,
                                        JComboBox<String> weaponsCombobox,
                                        JComboBox<String> raritiesComboBox,
                                        JComboBox<String> constellationsLevelsComboBox,
                                        JFormattedTextField meetDateFormattedTextField){
        namesComboBox.setSelectedIndex(0);
        visionsComboBox.setSelectedIndex(0);
        weaponsCombobox.setSelectedIndex(0);
        raritiesComboBox.setSelectedIndex(0);
        constellationsLevelsComboBox.setSelectedIndex(0);
        meetDateFormattedTextField.setValue(new Date());
    }
}
