package gui;

import javax.swing.*;
import java.awt.*;
import game.NatemonRunner;

public class ViewMovesPanel extends JPanel {
	private NatemonGUI gui;

    public ViewMovesPanel(NatemonGUI gui) {
        this.gui = gui;
        setLayout(new BorderLayout());
        
        //add title
        JLabel title = new JLabel("VIEW MOVES!!!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 48));
        add(title, BorderLayout.NORTH);
        
        //back panel
        JPanel backPanel = gui.backPanel("VIEW");
        add(backPanel, BorderLayout.SOUTH);
    }
}
