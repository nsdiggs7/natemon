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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //back panel
        add(gui.backPanel("VIEW"), BorderLayout.SOUTH);
    }
    
}
