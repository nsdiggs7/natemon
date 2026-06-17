package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class CreatePanel extends JPanel{
	private NatemonGUI gui;

    public CreatePanel(NatemonGUI gui) {
        this.gui = gui;
        setLayout(new BorderLayout());
        
        //add title
        add(gui.title("create"), BorderLayout.NORTH);
        
        JLabel text = new JLabel("What would you like to create?", SwingConstants.CENTER);
        text.setFont(new Font("Arial", Font.BOLD, 24));
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //panel creation
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //button creation
        JButton natemonBtn = new JButton("Natemon");
        JButton moveBtn = new JButton("Move");
        
        //add buttons to panel
        buttonPanel.add(natemonBtn);
        buttonPanel.add(moveBtn);
        
        // center wrapper for button panel
        JPanel choiceCenterWrapper = new JPanel();
        choiceCenterWrapper.setLayout(new BoxLayout(choiceCenterWrapper, BoxLayout.Y_AXIS));
        choiceCenterWrapper.add(Box.createVerticalGlue());  // pushes block to center
        choiceCenterWrapper.add(text);
        choiceCenterWrapper.add(Box.createRigidArea(new Dimension(0, 12))); // small gap
        choiceCenterWrapper.add(buttonPanel);
        choiceCenterWrapper.add(Box.createVerticalGlue());  // balances bottom	    
        
        //add panels to screen
        add(choiceCenterWrapper, BorderLayout.CENTER);
        add(gui.backPanel(null), BorderLayout.SOUTH);
       
        
        //button functionalities
        natemonBtn.addActionListener(e -> gui.showScreen(""));
        moveBtn.addActionListener(e -> gui.showScreen(""));
        
        
    }
}
