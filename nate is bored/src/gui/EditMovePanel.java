package gui;

import javax.swing.*;

import game.*;

import java.awt.*;

public class EditMovePanel extends JPanel {
	private NatemonGUI gui;
	private Move move;
	
	public EditMovePanel(NatemonGUI gui) {
		this.gui = gui;
        setLayout(new BorderLayout());
	}
	
	public void setMove(Move move) {
		this.move = move;
		display();
	}
	
	public void display() {
		//add title
        add(gui.title("edit "+ move.getName()), BorderLayout.NORTH);        
        
        //create form panel
        JPanel formPanel = new JPanel(new GridLayout(4, 2)); 

        //create labels and text fields
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(10);
        JLabel typeLabel = new JLabel("Type:");
        JTextField typeField = new JTextField(10);
        JLabel dmgLabel = new JLabel("Damage:");
        JTextField dmgField = new JTextField(5);
        JLabel cdLabel = new JLabel("Cooldown:");
        JTextField cdField = new JTextField(5);
        JLabel success = new JLabel("");
        
        //create create button
        JButton createBtn = new JButton("Edit");
        
        //add all components to form panel
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(typeLabel);
        formPanel.add(typeField);
        formPanel.add(dmgLabel);
        formPanel.add(dmgField);
        formPanel.add(cdLabel);
        formPanel.add(cdField);

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
        	int dmg, cd;
        	
        	//create move
        	try {
        		//check for valid type
        		dmg = Integer.parseInt(dmgField.getText().trim());
        		cd = Integer.parseInt(cdField.getText().trim());
        		Type type = Type.valueOf(typeText);
        		
        		Move m = new Move(name, typeText, dmg, cd);
        		NatemonRunner.moves.add(m);
        		
        		//write success
            	success.setText(name + " was edited!");
	
        	} catch (IllegalArgumentException err) {
        		success.setText("Invalid type, damage, or cooldown entered");
        	}
        	
        	//reset text fields
        	nameField.setText("");
        	typeField.setText("");
        	dmgField.setText("");
        	cdField.setText("");
        	
        	//success test clears after 1.5 seconds
        	new Timer(1500, ev -> success.setText("")).start();
        });
        
        //back panel
        add(gui.backPanel("CHOOSEEDITMOVE"), BorderLayout.SOUTH);
	}
}
