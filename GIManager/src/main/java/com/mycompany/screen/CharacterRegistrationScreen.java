package com.mycompany.screen;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.text.DateFormatter;

import com.mycompany.consts.CharacterName;
import com.mycompany.consts.ConstellationsLevel;
import com.mycompany.consts.Rarity;
import com.mycompany.consts.Vision;
import com.mycompany.consts.Weapon;
import com.mycompany.database.SQLCommandsApp;
import com.mycompany.screen.actions.ButtonsActions;
import com.mycompany.screen.actions.ComboBoxesActions;

/**
 * 
 */
public class CharacterRegistrationScreen {

    static JPanel mainPanel = PrincipalScreen.getMainPanel();
    static JPanel registrationPanel;

    static JButton saveCharacterButton;
    static JButton clearInputFieldsButton;

    static JComboBox<String> charactersNamesComboBox;
    static JComboBox<String> charactersVisionsComboBox;
    static JComboBox<String> charactersWeaponsComboBox;
    static JComboBox<String> charactersRaritiesComboBox;
    static JComboBox<String> charactersConstellationsLevelsComboBox;
    
    static SimpleDateFormat simpleDateFormat;

    static JFormattedTextField characterMeetdateFormattedTextField;

    static ActionListener saveObtainedCharacterActionListener;
    static ActionListener clearInputsFieldsActionListener;

    /**
     * Creates the main panel containing the character registration contents.
     * @return content JPanel
     */
    public static JPanel createRegistrationPanel(){
        registrationPanel = new JPanel(new GridBagLayout());
        registrationPanel.setBackground(Color.decode("#252625"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
          
    /* Creating contents */
        // JLabels //
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel characterNameLabel = new JLabel("Name");
        characterNameLabel.setForeground(Color.GRAY);
        characterNameLabel.setFont(new Font("Helvetica", Font.ITALIC, 16));
        registrationPanel.add(characterNameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel characterVisionLabel = new JLabel("Vision");
        characterVisionLabel.setForeground(Color.GRAY);
        characterVisionLabel.setFont(new Font("Helvetica", Font.ITALIC, 16));
        registrationPanel.add(characterVisionLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        JLabel characterWeaponLabel = new JLabel("Weapon");
        characterWeaponLabel.setForeground(Color.GRAY);
        characterWeaponLabel.setFont(new Font("Helvetica", Font.ITALIC, 16));
        registrationPanel.add(characterWeaponLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        JLabel characterRarityLabel = new JLabel("Rarity");
        characterRarityLabel.setForeground(Color.GRAY);
        characterRarityLabel.setFont(new Font("Helvetica", Font.ITALIC, 16));
        registrationPanel.add(characterRarityLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        JLabel characterConstellationsLevelLabel = new JLabel("Constellations Level");
        characterConstellationsLevelLabel.setForeground(Color.GRAY);
        characterConstellationsLevelLabel.setFont(new Font("Helvetica", Font.ITALIC, 16));
        registrationPanel.add(characterConstellationsLevelLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        JLabel characterMeetDateLabel = new JLabel("Meet Date");
        characterMeetDateLabel.setForeground(Color.GRAY);
        characterMeetDateLabel.setFont(new Font("Helvetica", Font.ITALIC, 16));
        registrationPanel.add(characterMeetDateLabel, gbc);

        // JButtons //
        gbc.gridx = 0;
        gbc.gridy = 4;
        saveCharacterButton = new JButton("Save");
        registrationPanel.add(saveCharacterButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        clearInputFieldsButton = new JButton("Clear");
        registrationPanel.add(clearInputFieldsButton, gbc);

        // JComboBoxes //
        gbc.gridx = 0;
        gbc.gridy = 1;
        charactersNamesComboBox = (createStringValuesComboBox(CharacterName.class));
        registrationPanel.add(charactersNamesComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        charactersVisionsComboBox = (createStringValuesComboBox(Vision.class));
        registrationPanel.add(charactersVisionsComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        charactersWeaponsComboBox = (createStringValuesComboBox(Weapon.class));
        registrationPanel.add(charactersWeaponsComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        charactersRaritiesComboBox = (createStringValuesComboBox(Rarity.class));
        registrationPanel.add(charactersRaritiesComboBox, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        charactersConstellationsLevelsComboBox = (createStringValuesComboBox(ConstellationsLevel.class));
        registrationPanel.add(charactersConstellationsLevelsComboBox, gbc);

        // TextField //
        simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        DateFormatter dateFormatter = new DateFormatter(simpleDateFormat);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        characterMeetdateFormattedTextField = new JFormattedTextField(dateFormatter);
        characterMeetdateFormattedTextField.setColumns(10);
        characterMeetdateFormattedTextField.setValue(new Date());
        registrationPanel.add(characterMeetdateFormattedTextField, gbc);

    /* Configuring Events */
        // JButtons Events //
        saveObtainedCharacterActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    ButtonsActions.characterInsertion((String) charactersNamesComboBox.getSelectedItem(),
                                                      (String) charactersVisionsComboBox.getSelectedItem(),
                                                      (String) charactersWeaponsComboBox.getSelectedItem(),
                                                      (String) charactersRaritiesComboBox.getSelectedItem(),
                                                      (String) charactersConstellationsLevelsComboBox.getSelectedItem(),
                                                      characterMeetdateFormattedTextField.getText(),
                                                      saveCharacterButton);
                } catch (SQLException characterInsertionEventCallError) {
                    JOptionPane.showMessageDialog(saveCharacterButton, "", "Character insertion failed!", 0);
                }
            }
        };
        saveCharacterButton.addActionListener(saveObtainedCharacterActionListener);

        clearInputsFieldsActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ButtonsActions.clearInputFields(charactersNamesComboBox,
                                                charactersVisionsComboBox,
                                                charactersWeaponsComboBox,
                                                charactersRaritiesComboBox,
                                                charactersConstellationsLevelsComboBox,
                                                characterMeetdateFormattedTextField);
            }
        };
        clearInputFieldsButton.addActionListener(clearInputsFieldsActionListener);

        // JComboBoxes Events //  
        charactersNamesComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e){
                if (e.getStateChange() == ItemEvent.SELECTED){
                    String characterName = (String) charactersNamesComboBox.getSelectedItem();

                    ComboBoxesActions.changeComboBoxesValuesBasedOnName(characterName,
                                                                      charactersVisionsComboBox,
                                                                      charactersWeaponsComboBox,
                                                                      charactersRaritiesComboBox);
                }
            }
        });
        
        return registrationPanel;
    }

    /**
     * Creates the side bar containing navigation buttons
     * @return side JPanel
     */
    public static JPanel createSideBarPanel(){
        JPanel sideBarPanel = new JPanel(new GridBagLayout());
        sideBarPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 100, 0));
        sideBarPanel.setBackground(Color.DARK_GRAY);
        
        GridBagConstraints gbc = new GridBagConstraints();

    /* Creating contents */
        gbc.insets = new Insets(10, 5, 10, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JButton viewObtainedCharactersTableButton = new JButton("View Obtained");
        sideBarPanel.add(viewObtainedCharactersTableButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JButton viewAllCharactersTableButton = new JButton("View All");
        sideBarPanel.add(viewAllCharactersTableButton, gbc);

        gbc.insets = new Insets(200, 5, 10, 5);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JButton backToPreviousPanelButton = new JButton("Back");
        sideBarPanel.add(backToPreviousPanelButton, gbc);
        
    /* Configuring Events */
        // JButtons Events //
        viewObtainedCharactersTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JPanel registrationSideBarPanel = sideBarPanel;
                ButtonsActions.showObtainedCharactersTableScreen(mainPanel,
                                                                 registrationPanel,
                                                                 registrationSideBarPanel);
            }
        });
        viewAllCharactersTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ButtonsActions.showAllCharactersTableScreen(mainPanel,
                                                            registrationPanel,
                                                            sideBarPanel);
            }
        });
        backToPreviousPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ButtonsActions.backToPreviousPanel(mainPanel,
                                                   registrationPanel,
                                                   sideBarPanel);
            }
        });

        return sideBarPanel;
    }

    public static void adaptaingScreenToCharacterUpdateMode(String characterName,
                                                            String characterConstellationsLevel,
                                                            String characterMeetDate){
     /* Updating Input Fields */   
        Date characterMeetDateAsDate = new Date();
        try {
            characterMeetDateAsDate = simpleDateFormat.parse(characterMeetDate);
        } catch (ParseException parseToDateError) {
            parseToDateError.printStackTrace();
        }
        // Populating Fields //
        charactersNamesComboBox.setSelectedItem(characterName);
        charactersConstellationsLevelsComboBox.setSelectedItem(characterConstellationsLevel);
        characterMeetdateFormattedTextField.setValue(characterMeetDateAsDate);

        // Locking Options //
        charactersNamesComboBox.setEnabled(false);    
        charactersVisionsComboBox.setEnabled(false);
        charactersWeaponsComboBox.setEnabled(false);
        charactersRaritiesComboBox.setEnabled(false);

    /* Updating JButtons Events */
        saveCharacterButton.removeActionListener(saveObtainedCharacterActionListener);
        ActionListener updateObtainedCharacterActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JPanel obtainedCharactersPanel = ObtainedCharactersTableScreen.getObtainedCharactersTablePanel();
                String characterConstellationsLevel = (String) charactersConstellationsLevelsComboBox.getSelectedItem();
                String characterMeetDate = characterMeetdateFormattedTextField.getText();
                try {
                    SQLCommandsApp.updateObtainedCharacter(CharacterName.fromString(characterName),
                                                           ConstellationsLevel.fromString(characterConstellationsLevel),
                                                           characterMeetDate,
                                                           obtainedCharactersPanel);
                    ButtonsActions.showObtainedCharactersTableScreen(mainPanel,
                                                                     registrationPanel,
                                                                     null);
                } catch (SQLException characterUpdateError) {
                    characterUpdateError.printStackTrace();
                }
            }
        };
        saveCharacterButton.addActionListener(updateObtainedCharacterActionListener);

        clearInputFieldsButton.removeActionListener(clearInputsFieldsActionListener);
        ActionListener clearUpdateInputsFieldsActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ButtonsActions.clearInputFields(charactersConstellationsLevelsComboBox,
                                                characterMeetdateFormattedTextField);
            }
        };
        clearInputFieldsButton.addActionListener(clearUpdateInputsFieldsActionListener);
    }

    /**
     * Takes a Enum Class and creates a JComboBox containing the constants String values.
     * @return JComboBox with String values
     */
    private static <T extends Enum<T>> JComboBox<String> createStringValuesComboBox(Class<T> enumClass){
        ArrayList<String> items = new ArrayList<String>();
        items.add("");
        for (T item : enumClass.getEnumConstants()){ // Adding each String value Enum constant in the ArrayList
            items.add(item.toString());
        }

        return new JComboBox<String>(items.toArray(String[]::new));
    }
}
