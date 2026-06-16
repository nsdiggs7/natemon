package gui;

import javax.swing.*;
import java.awt.*;

public class NatemonGUI extends JFrame {
	private CardLayout cards;
    private JPanel container;

    //create screens
    public HomePanel homePanel;
    public ViewPanel viewPanel;
    public ViewNatemonsPanel viewNatemonsPanel;
    public ViewMovesPanel viewMovesPanel;
    
    public NatemonGUI() {
        setTitle("Natemon");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cards = new CardLayout();
        container = new JPanel(cards);

        //initialize screens
        homePanel = new HomePanel(this);
        viewPanel = new ViewPanel(this);
        viewNatemonsPanel = new ViewNatemonsPanel(this);
        viewMovesPanel = new ViewMovesPanel(this);
        
        //add screens to container
        container.add(homePanel, "HOME");
        container.add(viewPanel, "VIEW");
        container.add(viewNatemonsPanel, "VIEWNATEMONS");
        container.add(viewMovesPanel, "VIEWMOVES");
        add(container);
        setVisible(true);

        showScreen("HOME"); 
    }
    
    //change screen function
    public void showScreen(String name) {
        cards.show(container, name);
    }
}
