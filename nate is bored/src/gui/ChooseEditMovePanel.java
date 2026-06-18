package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import game.Move;
import game.Natemon;
import game.NatemonRunner;

public class ChooseEditMovePanel extends JPanel {
	private NatemonGUI gui;
	
	public ChooseEditMovePanel(NatemonGUI gui) {
		this.gui = gui;
		setLayout(new BorderLayout());
		display();
	}
	
	public void display() {
    	removeAll();
    	
        //add title + back panel
        add(gui.title("select move to edit"), BorderLayout.NORTH);
        add(gui.backPanel("EDIT"), BorderLayout.SOUTH); 
        
      //panel for all move boxes
        JPanel boxPanel = new JPanel(new GridLayout(0, 5, 10, 10));
        
        //create box for each move
        for(Move move : NatemonRunner.moves) {
        	//create box
        	JPanel box = new JPanel();
            box.setPreferredSize(new Dimension(125, 125));
            box.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
            
            //get move info
        	String name = move.getName();
        	String type = move.getType();
        	int dmg  = move.getDamage();
        	int cd = move.getCooldown();
        	
        	//create labels
        	JLabel nameLabel = new JLabel(name);
        	JLabel typeLabel = new JLabel("Type: "+ type);
        	JLabel dmgLabel = new JLabel("DMG: " + Integer.toString(dmg));
        	JLabel cdLabel = new JLabel("Cooldown: " + Integer.toString(cd));
        	
        	//set fonts
        	nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        	typeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        	dmgLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        	cdLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        	
        	//align to middle
        	nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        	typeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        	dmgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        	cdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        	
        	//add to box + panel
        	box.add(nameLabel);
        	box.add(typeLabel);
        	box.add(dmgLabel);
        	box.add(cdLabel);
        	boxPanel.add(box); 
        	
        	//to description
        	box.addMouseListener(new MouseAdapter() {
        		public void mousePressed(MouseEvent e) {
        			//set move and change screen
        	        gui.editMovePanel.setMove(move);
        	        gui.editMovePanel.display();
        	        gui.showScreen("EDITMOVE");
        	    }
        	});
        }
                     
       //center boxPanel 
        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.add(boxPanel);
        
        //add centerWrapper to screen
        add(centerWrapper, BorderLayout.CENTER);   	
    	  	
    	revalidate();
    	repaint();
    
	}
 }
