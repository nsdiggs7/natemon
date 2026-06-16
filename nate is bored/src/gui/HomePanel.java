package gui;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    private NatemonGUI gui;

    public HomePanel(NatemonGUI gui) {
        this.gui = gui;
        setLayout(new BorderLayout());

        // title at the top
        JLabel title = new JLabel("Welcome to Natemon!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 48));
        add(title, BorderLayout.NORTH);

        // buttons in the center
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        
        JButton playBtn = new JButton("Play");
        JButton createBtn = new JButton("Create");
        JButton viewBtn = new JButton("View");
        JButton editBtn = new JButton("Edit");

        buttonPanel.add(playBtn);
        buttonPanel.add(createBtn);
        buttonPanel.add(viewBtn);
        buttonPanel.add(editBtn);

        // center the button panel so it doesn't stretch wall to wall
        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.add(buttonPanel);
        add(centerWrapper, BorderLayout.CENTER);

        // wire up buttons
        playBtn.addActionListener(e -> gui.showScreen("TEAM_SELECT"));
        createBtn.addActionListener(e -> gui.showScreen("CREATE"));
        viewBtn.addActionListener(e -> gui.showScreen("VIEW"));
        editBtn.addActionListener(e -> gui.showScreen("EDIT"));
    }
}