//to add: in depth info on press
package gui;

import javax.swing.*;
import java.awt.*;
import game.NatemonRunner;

public class ViewNatemonsPanel extends JPanel {
	private NatemonGUI gui;

    public ViewNatemonsPanel(NatemonGUI gui) {
        this.gui = gui;
        setLayout(new BorderLayout());
        
        //add title
        add(gui.title("view natemons"), BorderLayout.NORTH);
        
        //panel for all natemon boxes
        JPanel boxPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        
        //create box for each natemon
        for(game.Natemon natemon : game.NatemonRunner.natemons) {
        	//create box
        	JPanel box = new JPanel();
            box.setPreferredSize(new Dimension(100, 100));
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
        }
                     
       //center boxPanel 
        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.add(boxPanel);
        
        add(centerWrapper, BorderLayout.CENTER);
        
        
        //back panel
        add(gui.backPanel("VIEW"), BorderLayout.SOUTH);
    }
    
}
