package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

import game.Natemon;
import game.NatemonRunner;
import game.Type;

public class EditNatemonPanel extends JPanel {
	private NatemonGUI gui;
	private Natemon natemon;
	
	public EditNatemonPanel(NatemonGUI gui) {
		this.gui = gui;
        setLayout(new BorderLayout());
	}
	
	public void setNatemon(Natemon natemon) {
		this.natemon = natemon;
		display();
	}
	
	public void display() {
		removeAll();
		
		//add title
        add(gui.title("edit " + natemon.getName()), BorderLayout.NORTH);        
        
        //create form panel
        JPanel formPanel = new JPanel(new GridLayout(3, 2)); 
        
        //get types for type dropdown
        Type[] types = Type.values();

        //create labels and text fields
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(natemon.getName(), 10);
        JLabel typeLabel = new JLabel("Type:");
        JComboBox typeField = new JComboBox(Type.values());
        try {
            typeField.setSelectedItem(Type.valueOf(natemon.getType()));
        } catch (IllegalArgumentException ex) {
            System.out.println("BAD TYPE VALUE: [" + natemon.getType() + "]");
            ex.printStackTrace();
        }
        JLabel hpLabel = new JLabel("HP:");
        JTextField hpField = new JTextField(Integer.toString(natemon.getHp()), 5);
        JLabel success = new JLabel("");
        
        //create create button
        JButton createBtn = new JButton("Edit");
        
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
        	String typeText = typeField.getSelectedItem().toString().trim().toLowerCase();
        	int hp;
        	
        	//create natemon
        	try {
        		//check for valid type
        		hp = Integer.parseInt(hpField.getText().trim());
        		Type type = Type.valueOf(typeText);
        		
        		natemon.setName(name);
        		natemon.setType(typeText);
        		natemon.setHp(hp);
        		
        		
        		//write success
            	success.setText(name + " was edited!");
	
        	} catch (IllegalArgumentException err) {
        		success.setText("Invalid type or hp entered");
        	}
        	
        	//reset text fields
        	nameField.setText("");
        	typeField.setSelectedItem("");
        	hpField.setText("");
        	
        	//success test clears after 1.5 seconds
        	new Timer(1500, ev -> success.setText("")).start();
        });
        
        //back panel
        add(gui.backPanel("CHOOSEEDITNATEMON"), BorderLayout.SOUTH);
		
        revalidate();
    	repaint();
	}
}
