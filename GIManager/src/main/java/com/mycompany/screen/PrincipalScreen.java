package com.mycompany.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import com.mycompany.screen.actions.ButtonsActions;

public class PrincipalScreen {
    static JPanel mainPanel;
    static JPanel homePanel;
    static JPanel homeSideBarPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PrincipalScreen::createAndShowGUI);
    }

    /**
     * Creates the entire frame containing its panels.
     */
    public static void createAndShowGUI(){
        JFrame gIManagerFrame = new JFrame("GIManager");
        gIManagerFrame.setSize(800, 500);
        gIManagerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
    /* Adding panel */
        gIManagerFrame.add(createMainPanel());

    /* Showing */
        gIManagerFrame.setVisible(true);
    }

    /**
     * Creates the base panel containing sub-panels.
     * @return main JPanel
     */
    public static JPanel createMainPanel(){
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new LineBorder(Color.decode("#252625"), 5));

    /* Adding panels */
        homeSideBarPanel = createSideBarPanel();
        mainPanel.add(createHomePanel());
        mainPanel.add(homeSideBarPanel, BorderLayout.EAST);
        mainPanel.add(createHeaderPanel(), BorderLayout.NORTH);

        return mainPanel;
    }

    public static JPanel createHomePanel(){
        homePanel = new JPanel(new GridBagLayout());
        homePanel.setBackground(Color.decode("#252625"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

    /* Creating contents */
        // JButtons //
        gbc.gridx = 0;
        gbc.gridy = 0;
        JButton registerNewObtainedCharacterButton = new JButton("Register New Character");
        homePanel.add(registerNewObtainedCharacterButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JButton viewObtainedCharactersButton = new JButton("View Obtained Characters");
        homePanel.add(viewObtainedCharactersButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JButton viewAllCharactersButton = new JButton("View All Characters");
        homePanel.add(viewAllCharactersButton, gbc);

    /* Configuring Events */
        // JButtons Events //
        registerNewObtainedCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ButtonsActions.showCharacterRegistrationScreen(mainPanel,
                                                               homePanel,
                                                               homeSideBarPanel,
                                                               false);
            }
        });
        viewObtainedCharactersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ButtonsActions.showObtainedCharactersTableScreen(mainPanel,
                                                                 homePanel,
                                                                 homeSideBarPanel);
            }
        });
        viewAllCharactersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ButtonsActions.showAllCharactersTableScreen(mainPanel,
                                                            homePanel,
                                                            homeSideBarPanel);
            }
        });

        return homePanel;
    }

    public static JPanel createSideBarPanel(){
        JPanel sideBarPanel = new JPanel(new GridBagLayout());
        sideBarPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 100, 0));
        sideBarPanel.setBackground(Color.DARK_GRAY);

        return sideBarPanel;
    }

    public static JPanel createHeaderPanel(){
        JPanel headerPanel = new JPanel(new FlowLayout());
        headerPanel.setBackground(Color.DARK_GRAY);
        headerPanel.setBorder(new LineBorder(Color.decode("#252625"), 3));

    /* Creating contents */
        JLabel gIManagerLabel = new JLabel("GIManager");
        gIManagerLabel.setFont(new Font("Helvetica", Font.ITALIC, 18));
        gIManagerLabel.setForeground(Color.GRAY);
        headerPanel.add(gIManagerLabel);

        return headerPanel;
    }

    /**
     * 
     * @return
     */
    public static JPanel getMainPanel(){
        return mainPanel;
    }
}
