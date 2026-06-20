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
		removeAll();
		
		//add title
        add(gui.title("edit "+ move.getName()), BorderLayout.NORTH);        
        
        //create form panel
        JPanel formPanel = new JPanel(new GridLayout(4, 2)); 
        
        //get types for type dropdown
        Type[] types = Type.values();

        //create labels and text fields
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(move.getName(), 10);
        JLabel typeLabel = new JLabel("Type:");
        JComboBox typeField = new JComboBox(Type.values());
        try {
            typeField.setSelectedItem(Type.valueOf(move.getType()));
        } catch (IllegalArgumentException ex) {
            System.out.println("BAD TYPE VALUE: [" + move.getType() + "]");
            ex.printStackTrace();
        }
        JLabel dmgLabel = new JLabel("Damage:");
        JTextField dmgField = new JTextField(Integer.toString(move.getDamage()), 5);
        JLabel cdLabel = new JLabel("Cooldown:");
        JTextField cdField = new JTextField(Integer.toString(move.getCooldown()),5);
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
        	String typeText = typeField.getSelectedItem().toString().trim().toLowerCase();
        	int dmg, cd;
        	
        	//create move
        	try {
        		//check for valid type
        		dmg = Integer.parseInt(dmgField.getText().trim());
        		cd = Integer.parseInt(cdField.getText().trim());
        		Type type = Type.valueOf(typeText);
        		
        		move.setName(name);
        		move.setType(typeText);
        		move.setDamage(dmg);
        		move.setCd(cd);
        		
        		//write success
            	success.setText(name + " was edited!");
	
        	} catch (IllegalArgumentException err) {
        		success.setText("Invalid type, damage, or cooldown entered");
        	}
        	
        	//reset text fields
        	nameField.setText("");
        	typeField.setSelectedItem("");
        	dmgField.setText("");
        	cdField.setText("");
        	
        	//success test clears after 1.5 seconds
        	new Timer(1500, ev -> success.setText("")).start();
        });
        
        //back panel
        add(gui.backPanel("CHOOSEEDITMOVE"), BorderLayout.SOUTH);
        
        revalidate();
    	repaint();
	}
}
