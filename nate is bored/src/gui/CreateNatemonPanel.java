package gui;

import java.awt.*;
import javax.swing.*;
import game.*;

public class CreateNatemonPanel extends JPanel {
	private NatemonGUI gui;
	
	public CreateNatemonPanel(NatemonGUI gui) {
		this.gui = gui;
        setLayout(new BorderLayout());
        
        //NatemonRunner.viewNatemons();
        
        //add title
        add(gui.title("create natemons"), BorderLayout.NORTH);        
        
        //create form panel
        JPanel formPanel = new JPanel(new GridLayout(3, 2)); 

        //create labels and text fields
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(10);
        JLabel typeLabel = new JLabel("Type:");
        JTextField typeField = new JTextField(10);
        JLabel hpLabel = new JLabel("HP:");
        JTextField hpField = new JTextField(5);
        JLabel success = new JLabel("");
        
        //create create button
        JButton createBtn = new JButton("Create");
        
        //add all components to form panel
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(typeLabel);
        formPanel.add(typeField);
        formPanel.add(hpLabel);
        formPanel.add(hpField);

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
        success.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //add wrappers to stack
        stack.add(formWrapper);
        stack.add(Box.createRigidArea(new Dimension(0, 10))); 
        stack.add(buttonWrapper);       
        stack.add(success);
        
        //center stack in middle
        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.add(stack);
        add(centerWrapper, BorderLayout.CENTER);
       
        //createbtn functionality
        createBtn.addActionListener(e -> {
        	//get info from text fields
        	String name = nameField.getText().trim();
        	String typeText = typeField.getText().trim().toLowerCase();
        	int hp;
        	
        	//create natemon
        	try {
        		//check for valid type
        		hp = Integer.parseInt(hpField.getText().trim());
        		Type type = Type.valueOf(typeText);
        		
        		Natemon n = new Natemon(name, typeText, hp);
        		NatemonRunner.natemons.add(n);
        		
        		//write success
            	success.setText(name + " was created!");
	
        	} catch (IllegalArgumentException err) {
        		success.setText("Invalid type or hp entered");
        	}
        	
        	//reset text fields
        	nameField.setText("");
        	typeField.setText("");
        	hpField.setText("");
        	
        	//success test clears after 1.5 seconds
        	new Timer(1500, ev -> success.setText("")).start();
        });
        
        //back panel
        add(gui.backPanel("CREATE"), BorderLayout.SOUTH);
		
	}
}
