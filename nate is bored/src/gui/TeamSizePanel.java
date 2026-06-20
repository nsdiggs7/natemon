package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import game.*;

import game.Type;

public class TeamSizePanel extends JPanel {
	private NatemonGUI gui;
	
	public TeamSizePanel(NatemonGUI gui) {
		this.gui = gui;
        setLayout(new BorderLayout());
        
        //add title + back
        add(gui.title("play"), BorderLayout.NORTH); 
        add(gui.backPanel(null), BorderLayout.SOUTH);
        
        //create form panel
        JPanel formPanel = new JPanel(new GridLayout(2, 1)); 

        //create labels and text fields
        JLabel sizeLabel = new JLabel("How many Natemons per team?");
        JTextField sizeField = new JTextField(10);
        
        //create create button
        JButton createBtn = new JButton("Apply");
        
        //error field
        JLabel error = new JLabel("");
        
        //add all components to form panel
        formPanel.add(sizeLabel);
        formPanel.add(sizeField);

        //create wrappers 
        JPanel formWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel buttonWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        //add components to wrappers
        formWrapper.add(formPanel);
        buttonWrapper.add(createBtn);
        
        //stack wrapper
        JPanel stack = new JPanel();
        stack.setLayout(new BoxLayout(stack, BoxLayout.Y_AXIS));
        formWrapper.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonWrapper.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //add wrappers to stack
        stack.add(formWrapper);
        stack.add(Box.createRigidArea(new Dimension(0, 10))); 
        stack.add(buttonWrapper);       
        stack.add(error);
        
        //center stack in middle
        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.add(stack);
        add(centerWrapper, BorderLayout.CENTER);
        
        //button functionalities
        createBtn.addActionListener(e -> {
        	try {
        		int size = Integer.parseInt(sizeField.getText().trim());
            	System.out.println(size);
        	} catch (IllegalArgumentException err) {
        		error.setText(err.toString());
        		
        	}
        });
		
	}
}
