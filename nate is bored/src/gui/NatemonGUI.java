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
    public CreatePanel createPanel;
    public CreateNatemonPanel createNatemonPanel;
    public CreateMovePanel createMovePanel;
    
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
        createPanel= new CreatePanel(this);
        createNatemonPanel= new CreateNatemonPanel(this);
        createMovePanel= new CreateMovePanel(this);
        
        //add screens to container
        container.add(homePanel, "HOME");
        container.add(viewPanel, "VIEW");
        container.add(viewNatemonsPanel, "VIEWNATEMONS");
        container.add(viewMovesPanel, "VIEWMOVES");
        container.add(createPanel, "CREATE");
        container.add(createNatemonPanel, "CREATENATEMON");
        container.add(createMovePanel, "CREATEMOVE");
        add(container);
        setVisible(true);

        showScreen("HOME"); 
    }
    
    //change screen function
    public void showScreen(String name) {
    	if (name.equals("")) {
    		JOptionPane.showMessageDialog(this, "Nothing to show yet...", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    	
    	if (name.equals("VIEWNATEMONS")){
    		viewNatemonsPanel.display();
    	}
    	
        cards.show(container, name);
    }
    
    public JPanel backPanel(String backScreen) {
    	JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	JButton homeBtn = new JButton("Home");
    	JButton backBtn;
    	if(!(backScreen == null)) {
    		backBtn = new JButton("Back");
    		backPanel.add(backBtn);
            backPanel.add(homeBtn);
            homeBtn.addActionListener(e -> showScreen("HOME"));
            backBtn.addActionListener(e -> showScreen(backScreen));
            return backPanel;
    	}else {
    		backPanel.add(homeBtn);
    		homeBtn.addActionListener(e -> showScreen("HOME"));
    		return backPanel;
    	}
    }
    
    public JLabel title(String title) {
    	JLabel out = new JLabel(title, SwingConstants.CENTER);
        out.setFont(new Font("Arial", Font.BOLD, 48));
    	return out;
    }
}
