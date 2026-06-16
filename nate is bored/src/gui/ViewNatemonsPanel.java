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
        
        //home + back button filler implementation
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton homeBtn = new JButton("Home");
        JButton backBtn = new JButton("Back");
        backPanel.add(homeBtn);
        backPanel.add(backBtn);
        add(backPanel, BorderLayout.SOUTH);
        homeBtn.addActionListener(e -> gui.showScreen("HOME"));
        backBtn.addActionListener(e -> gui.showScreen("VIEW"));
    }
}
