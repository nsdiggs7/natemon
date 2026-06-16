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
        JLabel title = new JLabel("VIEW NATEMONS!!!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 48));
        add(title, BorderLayout.NORTH);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //back panel
        JPanel backPanel = gui.backPanel("VIEW");
        add(backPanel, BorderLayout.SOUTH);
    }
    
}
