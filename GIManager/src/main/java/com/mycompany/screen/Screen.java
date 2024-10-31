package com.mycompany.screen;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.DateFormatter;

import com.mycompany.consts.CharacterName;
import com.mycompany.consts.ConstellationsLevel;
import com.mycompany.consts.Rarity;
import com.mycompany.consts.Vision;
import com.mycompany.consts.Weapon;
import com.mycompany.database.SQLCommandsApp;

/**
 * 
 */
public class Screen {

    public static void main(String[] args) {
        SQLCommandsApp.loadDriver();
        SQLCommandsApp.createConnection();
        SwingUtilities.invokeLater(Screen::createAndShowGUI);
    }
    
    /**
     * Creates the entire frame containing its panels.
     */
    public static void createAndShowGUI(){
        JFrame characterRegistrationFrame = new JFrame("Learning Swing");
        characterRegistrationFrame.setSize(800, 500);
        characterRegistrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
    /* Adding panel */
        characterRegistrationFrame.add(createMainPanel());

    /* Showing */
        characterRegistrationFrame.setVisible(true);
    }

    /**
     * Creates the base panel containing sub-panels.
     * @return main JPanel
     */
    public static JPanel createMainPanel(){
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new LineBorder(Color.decode("#252625"), 5));

    /* Adding panels */
        mainPanel.add(createRegistrationPanel());
        mainPanel.add(createSideBarPanel(), BorderLayout.EAST);
        mainPanel.add(createHeaderPanel(), BorderLayout.NORTH);

        return mainPanel;
    }

    /**
     * Creates the main panel containing the character registration contents.
     * @return content JPanel
     */
    public static JPanel createRegistrationPanel(){
        JPanel registrationPanel = new JPanel(new GridBagLayout());
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
        JButton saveCharacterButton = new JButton("Save");
        registrationPanel.add(saveCharacterButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        JButton clearInputFieldsButton = new JButton("Clear");
        registrationPanel.add(clearInputFieldsButton, gbc);

        // JComboBoxes //
        gbc.gridx = 0;
        gbc.gridy = 1;
        JComboBox<String> charactersNamesComboBox = (createStringValuesComboBox(CharacterName.class));
        registrationPanel.add(charactersNamesComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JComboBox<String> charactersVisionsComboBox = (createStringValuesComboBox(Vision.class));
        registrationPanel.add(charactersVisionsComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        JComboBox<String> charactersWeaponsComboBox = (createStringValuesComboBox(Weapon.class));
        registrationPanel.add(charactersWeaponsComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        JComboBox<String> charactersRaritiesComboBox = (createStringValuesComboBox(Rarity.class));
        registrationPanel.add(charactersRaritiesComboBox, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        JComboBox<String> charactersConstellationsLevelsComboBox = (createStringValuesComboBox(ConstellationsLevel.class));
        registrationPanel.add(charactersConstellationsLevelsComboBox, gbc);

        // TextField //
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        DateFormatter dateFormatter = new DateFormatter(simpleDateFormat);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        JFormattedTextField characterMeetdateFormattedTextField = new JFormattedTextField(dateFormatter);
        characterMeetdateFormattedTextField.setColumns(10);
        characterMeetdateFormattedTextField.setValue(new Date());
        registrationPanel.add(characterMeetdateFormattedTextField, gbc);

    /* Configuring Events */
        // JButtons Events //
        saveCharacterButton.addActionListener(new ActionListener() {
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
                    System.out.println("Character insertion failed!");
                }
            }
        });
        clearInputFieldsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ButtonsActions.clearInputFields(charactersNamesComboBox,
                                                charactersVisionsComboBox,
                                                charactersWeaponsComboBox,
                                                charactersRaritiesComboBox,
                                                charactersConstellationsLevelsComboBox,
                                                characterMeetdateFormattedTextField);
            }
        });

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
        
        // JTextFields Events //
        
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
        JButton button1 = new JButton("View Obtained");
        sideBarPanel.add(button1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JButton button2 = new JButton("View All");
        sideBarPanel.add(button2, gbc);

        gbc.insets = new Insets(200, 5, 10, 5);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JButton button3 = new JButton("Back");
        sideBarPanel.add(button3, gbc);
        
        return sideBarPanel;
    }

    /**
     * Creates a header for the frame containing 'GIManager' value JLabel
     * @return header JPanel
     */
    public static JPanel createHeaderPanel(){
        JPanel headerPanel = new JPanel(new FlowLayout());
        headerPanel.setBackground(Color.DARK_GRAY);
        headerPanel.setBorder(new LineBorder(Color.decode("#252625"), 3));

    /* Creating contents */
        JLabel giManagerLabel = new JLabel("GIManager");
        giManagerLabel.setFont(new Font("Helvetica", Font.ITALIC, 18));
        giManagerLabel.setForeground(Color.GRAY);
        headerPanel.add(giManagerLabel);

        return headerPanel;
    }

    /**
     * Takes a Enum Class and creates a JComboBox containing the constants String values.
     * @return JComboBox with String values
     */
    public static <T extends Enum<T>> JComboBox<String> createStringValuesComboBox(Class<T> enumClass){
        ArrayList<String> items = new ArrayList<String>();
        items.add("");
        for (T item : enumClass.getEnumConstants()){ // Adding each String value Enum constant in the ArrayList
            items.add(item.toString());
        }

        return new JComboBox<String>(items.toArray(String[]::new));
    }
}
