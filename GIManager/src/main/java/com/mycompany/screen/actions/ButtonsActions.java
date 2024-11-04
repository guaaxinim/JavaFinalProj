package com.mycompany.screen.actions;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.mycompany.character.Character;
import com.mycompany.consts.*;
import com.mycompany.consts.CharacterName;
import com.mycompany.database.SQLCommandsApp;
import com.mycompany.screen.AllCharactersTableScreen;
import com.mycompany.screen.CharacterRegistrationScreen;
import com.mycompany.screen.ObtainedCharactersTableScreen;
import com.mycompany.screen.PrincipalScreen;


public class ButtonsActions {

    static JPanel previousHomePanel;
    static JPanel previousSideBarPanel;

    /**
     * Inserts a new character in 'obtained_characters' table
     * @param name
     * @param vision
     * @param weapon
     * @param rarity
     * @param constellationsLevel
     * @param meetDate
     * @param buttonPressed
     * @throws SQLException
     */
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

            SQLCommandsApp.insertInObtainedCharacters(character.getName(),
                                                   character.getVision(),
                                                   character.getWeapon(),
                                                   character.getRarity(),
                                                   character.getConstellationsLevel(),
                                                   character.getMeetDate(),
                                                   buttonPressed);
        } catch (SQLException characterInsertionError) {
            JOptionPane.showMessageDialog(buttonPressed, "", "Character insertion failed!", 0);
        } catch (IllegalArgumentException characterInsertionError) {
            JOptionPane.showMessageDialog(buttonPressed, "Cannot insert a character with empty values!", "Character insertion failed!", 0);
        }
    }

    public static void clearInputFields(JComboBox<String> constellationsLevelsComboBox,
                                        JFormattedTextField meetDateFormattedTextField){
        constellationsLevelsComboBox.setSelectedIndex(0);
        meetDateFormattedTextField.setValue(new Date());
    }

    /**
     * Clear all input fields in registration panel
     * @param namesComboBox
     * @param visionsComboBox
     * @param weaponsCombobox
     * @param raritiesComboBox
     * @param constellationsLevelsComboBox
     * @param meetDateFormattedTextField
     */
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

    /**
     * Remove the home panel from main panel, so add the registration panels
     * @param mainPanel
     * @param homePanel
     * @param characterRegistrationPanel
     * @param sideBarPanel
     * @param headerPanel
     */
    public static void showCharacterRegistrationScreen(JPanel mainPanel, 
                                                       JPanel homePanel,
                                                       JPanel homeSideBarPanel,
                                                       boolean updateScreen){
        mainPanel.remove(homePanel);
        if (homeSideBarPanel != null){
            mainPanel.remove(homeSideBarPanel);
        }
        mainPanel.add(CharacterRegistrationScreen.createRegistrationPanel(), BorderLayout.CENTER);
        if (updateScreen == false){
            mainPanel.add(CharacterRegistrationScreen.createSideBarPanel(), BorderLayout.EAST);
        }

        mainPanel.revalidate();

        previousHomePanel = homePanel;
        previousSideBarPanel = homeSideBarPanel;
    }
    
    /**
     * Remove the home panel from main panel, so add the obtained characters table panels
     * @param mainPanel
     * @param homePanel
     * @param obtainedCharactersPanel
     */
    public static void showObtainedCharactersTableScreen(JPanel mainPanel,
                                                         JPanel homePanel,
                                                         JPanel homeSideBarPanel){
        mainPanel.remove(homePanel);
        if (homeSideBarPanel != null){
            mainPanel.remove(homeSideBarPanel);
        }
        mainPanel.add(ObtainedCharactersTableScreen.createObtainedCharactersPanel(), BorderLayout.CENTER);
        mainPanel.add(ObtainedCharactersTableScreen.createSideBarPanel(), BorderLayout.EAST);

        mainPanel.revalidate();

        previousHomePanel = homePanel;
        previousSideBarPanel = homeSideBarPanel;
    }

    public static void showAllCharactersTableScreen(JPanel mainPanel,
                                                    JPanel homePanel,
                                                    JPanel homeSideBarPanel){
        mainPanel.remove(homePanel);
        mainPanel.remove(homeSideBarPanel);
        mainPanel.add(AllCharactersTableScreen.createAllCharactersPanel(), BorderLayout.CENTER);
        mainPanel.add(AllCharactersTableScreen.createSideBarPanel(), BorderLayout.EAST);

        mainPanel.revalidate();

        previousHomePanel = homePanel;
        previousSideBarPanel = homeSideBarPanel;
    }

    public static void showPrincipalScreen(JPanel mainPanel,
                                           JPanel homePanel,
                                           JPanel homeSideBarPanel){
        mainPanel.remove(homePanel);
        mainPanel.remove(homeSideBarPanel);
        mainPanel.add(PrincipalScreen.createHomePanel(), BorderLayout.CENTER);
        mainPanel.add(PrincipalScreen.createSideBarPanel(), BorderLayout.EAST);

        mainPanel.revalidate();
    }

    public static void showCharacterUpdateScreen(JPanel mainPanel,
                                                 JPanel homePanel,
                                                 JPanel homeSideBarPanel,
                                                 String characterNameToShowInJComboBox,
                                                 String characterConstellationsLevel,
                                                 String characterMeetDate){
        showCharacterRegistrationScreen(mainPanel, homePanel, null, true);
        CharacterRegistrationScreen.adaptaingScreenToCharacterUpdateMode(characterNameToShowInJComboBox,
                                                                         characterConstellationsLevel,
                                                                         characterMeetDate);

        mainPanel.remove(homeSideBarPanel);

        mainPanel.revalidate();
    }

    public static void backToPreviousPanel(JPanel mainPanel,
                                           JPanel homePanel,
                                           JPanel homeSideBarPanel){
        mainPanel.remove(homePanel);
        mainPanel.remove(homeSideBarPanel);
        mainPanel.add(previousHomePanel, BorderLayout.CENTER);
        mainPanel.add(previousSideBarPanel, BorderLayout.EAST);

        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
