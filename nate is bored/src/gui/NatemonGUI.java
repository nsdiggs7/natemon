package gui;

import javax.swing.*;
import java.awt.*;

public class NatemonGUI extends JFrame {
	private CardLayout cards;
    private JPanel container;

    public HomePanel homePanel;
    public ViewPanel viewPanel;
    
    public NatemonGUI() {
        setTitle("Natemon");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cards = new CardLayout();
        container = new JPanel(cards);

        homePanel = new HomePanel(this);
        viewPanel = new ViewPanel(this);

        container.add(homePanel, "HOME");
        container.add(viewPanel, "VIEW");
        add(container);
        setVisible(true);

        showScreen("HOME"); 
    }
    
    public void showScreen(String name) {
        cards.show(container, name);
    }
}
