//to add: in depth info on press, sort by type hp etc
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import game.*;

public class ViewNatemonsPanel extends JPanel {
	private NatemonGUI gui;

    public ViewNatemonsPanel(NatemonGUI gui) {
        this.gui = gui;
        setLayout(new BorderLayout());
        display();       
    }
    
    //refresh every time panel is opened
    public void display() {
    	removeAll();
    	
    	//add title + back panel
        add(gui.title("view natemons"), BorderLayout.NORTH);
        add(gui.backPanel("VIEW"), BorderLayout.SOUTH);	
    	
        //number of columns - 5 or less
        int cols = NatemonRunner.natemons.size() > 5 ? 5 : NatemonRunner.natemons.size();
        
    	//panel for all natemon boxes
        JPanel boxPanel = new JPanel(new GridLayout(0, cols, 10, 10));
        
        //create box for each natemon
        for(Natemon natemon : NatemonRunner.natemons) {
        	//create box
        	JPanel box = new JPanel();
            box.setPreferredSize(new Dimension(125, 125));
            box.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
            
            //get natemon info
        	String name = natemon.getName();
        	String type = natemon.getType();
        	int hp  = natemon.getHp();
        	
        	//create labels
        	JLabel nameLabel = new JLabel(name);
        	JLabel typeLabel = new JLabel("Type: "+ type);
        	JLabel hpLabel = new JLabel("HP: " + Integer.toString(hp));
        	
        	//set fonts
        	nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        	typeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        	hpLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        	
        	//align to middle
        	nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        	typeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        	hpLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        	
        	//add to box + panel
        	box.add(nameLabel);
        	box.add(typeLabel);
        	box.add(hpLabel);
        	boxPanel.add(box);
        	
        	//to description
        	box.addMouseListener(new MouseAdapter() {
//        		gui.setScreen("NATEMONDESCRIPTION');
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
