package com.mycompany.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mycompany.consts.CharacterName;
import com.mycompany.database.SQLCommandsApp;
import com.mycompany.screen.actions.ButtonsActions;

public class ObtainedCharactersTableScreen {

    static JPanel mainPanel = PrincipalScreen.getMainPanel();
    static JPanel obtainedCharactersPanel;
    static JPanel sideBarPanel;

    public static JPanel createObtainedCharactersPanel(){
        obtainedCharactersPanel = new JPanel(new GridBagLayout());
        obtainedCharactersPanel.setBackground(Color.decode("#252625"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

    /* Creating contents */
        // JTables //
        /* Creating DefaultTableModel */
        ArrayList<ArrayList<String>> allObtainedCharacters = new ArrayList<>();
        allObtainedCharacters = SQLCommandsApp.selectAllObtainedCharacters();

        String[] characterAttributes = {"Name", "Vision", "Weapon", "Rarity", "Consts", "Meet Date"};
        Object[][] characterValues = new Object[allObtainedCharacters.size()][];
        for (int i = 0; i < allObtainedCharacters.size(); i++){
            characterValues[i] = allObtainedCharacters.get(i).toArray();
        }
        DefaultTableModel obtainedCharactersTableModel = new DefaultTableModel(characterValues, characterAttributes);
        /* Creating JTable */
        JTable obtainedCharactersTable = new JTable(obtainedCharactersTableModel);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        JScrollPane obtainedCharactersRollPane = new JScrollPane(obtainedCharactersTable);
        obtainedCharactersRollPane.setPreferredSize(new Dimension(550, 350));
        obtainedCharactersPanel.add(obtainedCharactersRollPane, gbc);
    
    /* Configuring Events */
        // JTables Events //
        obtainedCharactersTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                String selectedObtainedCharacterName;
                String selectedObtainedCharacterConstellationsLevel;
                String selectedObtainedCharacterMeetDate;
                
                int row = obtainedCharactersTable.getSelectedRow();
                if (row != -1){
                    selectedObtainedCharacterName = (String) obtainedCharactersTable.getValueAt(row, 0);
                    selectedObtainedCharacterConstellationsLevel = (String) obtainedCharactersTable.getValueAt(row, 4);
                    selectedObtainedCharacterMeetDate = (String) obtainedCharactersTable.getValueAt(row, 5);

                    Object[] options = {"Delete", "Update", "Cancel"};

                    int userSelection = JOptionPane.showOptionDialog(obtainedCharactersPanel,
                                                                     "What do you want to do?",
                                                                     "You selected "+selectedObtainedCharacterName+"!",
                                                                     JOptionPane.YES_NO_CANCEL_OPTION,
                                                                     JOptionPane.QUESTION_MESSAGE,
                                                                     null,
                                                                     options,
                                                                     options[2]);
                    if (userSelection == 0){
                        try {
                            SQLCommandsApp.deleteObtainedCharacter(CharacterName.fromString(selectedObtainedCharacterName), obtainedCharactersPanel);
                            obtainedCharactersTableModel.removeRow(row);
                        } catch (SQLException characterRemotionError) {
                            JOptionPane.showMessageDialog(obtainedCharactersPanel, "Character remotion failed!", null, JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else if (userSelection == 1){
                        ButtonsActions.showCharacterUpdateScreen(mainPanel,
                                                                 obtainedCharactersPanel,
                                                                 sideBarPanel,
                                                                 selectedObtainedCharacterName,
                                                                 selectedObtainedCharacterConstellationsLevel,
                                                                 selectedObtainedCharacterMeetDate);
                    }
                }
            }
        });

        return obtainedCharactersPanel;
    }

    public static JPanel createSideBarPanel(){
        sideBarPanel = new JPanel(new GridBagLayout());
        sideBarPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 100, 0));
        sideBarPanel.setBackground(Color.DARK_GRAY);
        
        GridBagConstraints gbc = new GridBagConstraints();

    /* Creating contents */
        gbc.insets = new Insets(10, 5, 10, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JButton showCharacterRegistrationScreen = new JButton("Register New");
        sideBarPanel.add(showCharacterRegistrationScreen, gbc);

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
        showCharacterRegistrationScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ButtonsActions.showCharacterRegistrationScreen(mainPanel,
                                                               obtainedCharactersPanel,
                                                               sideBarPanel,
                                                               false);
            }
        });
        viewAllCharactersTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ButtonsActions.showAllCharactersTableScreen(mainPanel,
                                                            obtainedCharactersPanel,
                                                            sideBarPanel);
            }
        });
        backToPreviousPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ButtonsActions.backToPreviousPanel(mainPanel,
                                                   obtainedCharactersPanel,
                                                   sideBarPanel);
            }
        });

        return sideBarPanel;
    }

    public static JPanel getObtainedCharactersTablePanel(){
        return obtainedCharactersPanel;
    }
}
