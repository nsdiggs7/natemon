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
        add(gui.title("view moves"), BorderLayout.NORTH);
        
        //back panel
        add(gui.backPanel("VIEW"), BorderLayout.SOUTH);
    }
}
