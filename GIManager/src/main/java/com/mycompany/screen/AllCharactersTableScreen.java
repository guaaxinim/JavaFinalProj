package com.mycompany.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mycompany.database.SQLCommandsApp;
import com.mycompany.screen.actions.ButtonsActions;

public class AllCharactersTableScreen {
    
    static JPanel mainPanel = PrincipalScreen.getMainPanel();
    static JPanel allCharactersPanel;

    public static JPanel createAllCharactersPanel(){
        allCharactersPanel = new JPanel(new GridBagLayout());
        allCharactersPanel.setBackground(Color.decode("#252625"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

    /* Creating contents */
        // JTables //
        /* Creating DefaultTableModel */
        ArrayList<ArrayList<String>> allCharacters = new ArrayList<>();
        allCharacters = SQLCommandsApp.selectAllCharacters();

        String[] characterAttributes = {"Name", "Vision", "Weapon", "Rarity"};
        Object[][] characterValues = new Object[allCharacters.size()][];
        for (int i = 0; i < allCharacters.size(); i++){
            characterValues[i] = allCharacters.get(i).toArray();
        }
        DefaultTableModel allCharactersTableModel = new DefaultTableModel(characterValues, characterAttributes);
        /* Creating JTable */
        JTable allCharactersTable = new JTable(allCharactersTableModel);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        JScrollPane allCharactersRollPane = new JScrollPane(allCharactersTable);
        allCharactersRollPane.setPreferredSize(new Dimension(550, 350));
        allCharactersPanel.add(allCharactersRollPane, gbc);

        return allCharactersPanel;
    }

    public static JPanel createSideBarPanel(){
        JPanel sideBarPanel = new JPanel(new GridBagLayout());
        sideBarPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 100, 0));
        sideBarPanel.setBackground(Color.DARK_GRAY);
        
        GridBagConstraints gbc = new GridBagConstraints();

    /* Creating contents */
        gbc.insets = new Insets(10, 5, 10, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JButton homeButton = new JButton("Home");
        sideBarPanel.add(homeButton, gbc);

        gbc.insets = new Insets(200, 5, 10, 5);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JButton backToPreviousPanelButton = new JButton("Back");
        sideBarPanel.add(backToPreviousPanelButton, gbc);
        
    /* Configuring Events */
        // JButtons Events //
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ButtonsActions.showPrincipalScreen(mainPanel,
                                                   allCharactersPanel,
                                                   sideBarPanel);
            }
        });
        backToPreviousPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ButtonsActions.backToPreviousPanel(mainPanel,
                                                   allCharactersPanel,
                                                   sideBarPanel);
            }
        });

        return sideBarPanel;

    }
}
