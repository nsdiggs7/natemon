package gui;

import javax.swing.*;
import java.awt.*;
import game.NatemonRunner;

public class ViewPanel extends JPanel {

    private NatemonGUI gui;

    public ViewPanel(NatemonGUI gui) {
        this.gui = gui;
        setLayout(new BorderLayout());
        
        //add title
        JLabel title = new JLabel("VIEW!!!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 48));
        add(title, BorderLayout.NORTH);
        
        JLabel text = new JLabel("What would you like to view?", SwingConstants.CENTER);
        text.setFont(new Font("Arial", Font.BOLD, 24));
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //panel creation
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel homePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); //right aligned flow layout
        
        //button creation
        JButton homeBtn = new JButton("Home");
        JButton natemonsBtn = new JButton("Natemons");
        JButton movesBtn = new JButton("Moves");
        
        //add buttons to panel
        buttonPanel.add(natemonsBtn);
        buttonPanel.add(movesBtn);
        homePanel.add(homeBtn);
        
        // center wrapper for button panel
        JPanel choiceCenterWrapper = new JPanel();
        choiceCenterWrapper.setLayout(new BoxLayout(choiceCenterWrapper, BoxLayout.Y_AXIS));
//	    choiceCenterWrapper.add(text);
//	    choiceCenterWrapper.add(buttonPanel);
        choiceCenterWrapper.add(Box.createVerticalGlue());  // pushes block to center
        choiceCenterWrapper.add(text);
        choiceCenterWrapper.add(Box.createRigidArea(new Dimension(0, 12))); // small gap
        choiceCenterWrapper.add(buttonPanel);
        choiceCenterWrapper.add(Box.createVerticalGlue());  // balances bottom	    
        
        //add panels to screen
        add(choiceCenterWrapper, BorderLayout.CENTER);
        add(homePanel, BorderLayout.SOUTH);
       
        
        //button functionalities
        homeBtn.addActionListener(e -> gui.showScreen("HOME"));
        
        
    }
}