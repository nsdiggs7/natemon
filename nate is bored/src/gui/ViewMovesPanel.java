//to add: in depth info on press, sort by type hp etc
package gui;

import javax.swing.*;
import java.awt.*;
import game.*;

public class ViewMovesPanel extends JPanel {
	private NatemonGUI gui;

    public ViewMovesPanel(NatemonGUI gui) {
        this.gui = gui;
        setLayout(new BorderLayout());
        
        //add title
        add(gui.title("view moves"), BorderLayout.NORTH);
        
      //panel for all move boxes
        JPanel boxPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        
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
        	
        	//create labels
        	JLabel nameLabel = new JLabel(name);
        	JLabel typeLabel = new JLabel("Type: "+ type);
        	JLabel hpLabel = new JLabel("DMG: " + Integer.toString(dmg));
        	
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
        
        //add centerWrapper to screen
        add(centerWrapper, BorderLayout.CENTER);
        
        //back panel
        add(gui.backPanel("VIEW"), BorderLayout.SOUTH);
    }
}
