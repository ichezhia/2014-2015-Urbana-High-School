import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InformationGUI extends JPanel implements ActionListener {
	
	private static final String[] shirtOptions = {"Blue","Gray","Red","Yellow"};
	private static final String[] mapChooseOptions = {"Campus","First Floor","Second Floor"};	
	
	private JFrame parentWindow = new JFrame("Urbana High School");


	private JComboBox shirtList = new JComboBox(shirtOptions);
	private JComboBox mapChooseList = new JComboBox(mapChooseOptions);
	
	private JButton enter = new JButton("Enter");
	private JButton quit = new JButton("Quit");
	
	
	public InformationGUI() {
		
		JPanel mainPanel =  new JPanel();
		
		
		mainPanel = new JPanel(new BorderLayout(220,300)) {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image backgroundPic = new ImageIcon("src/images/background.png").getImage();
				g.drawImage(backgroundPic,0,0,this);
			}
		};
		
		JPanel northPanel =  new JPanel();
		JPanel southPanel =  new JPanel();
		JPanel eastPanel =  new JPanel();
		JPanel westPanel =  new JPanel();
		JPanel centerPanel =  new JPanel(new GridLayout(4, 2));		
		
		mainPanel.setOpaque(false);
		northPanel.setOpaque(false);
		southPanel.setOpaque(false);
		eastPanel.setOpaque(false);
		westPanel.setOpaque(false);
		
		mainPanel.add(BorderLayout.NORTH, northPanel);
		mainPanel.add(BorderLayout.SOUTH, southPanel);
		mainPanel.add(BorderLayout.EAST, eastPanel);
		mainPanel.add(BorderLayout.WEST, westPanel);
		mainPanel.add(BorderLayout.CENTER, centerPanel);

		centerPanel.setBackground(Color.YELLOW);
		
		JLabel shirtLabel = new JLabel("Your Shirt Color:");
		JLabel mapChooseLabel = new JLabel("Map to Load:");
		JLabel informationLabel1 = new JLabel("Welcome to Urbana High School!");
		JLabel informationLabel2 = new JLabel("Please select your configuration.");
		
	
		centerPanel.add(informationLabel1);
		centerPanel.add(informationLabel2);
		centerPanel.add(shirtLabel);
		centerPanel.add(shirtList);
		centerPanel.add(mapChooseLabel);
		centerPanel.add(mapChooseList);
		centerPanel.add(enter);
		centerPanel.add(quit);
		
		enter.setBackground(Color.GREEN);
		quit.setBackground(Color.RED);
		

		enter.addActionListener(this);
		quit.addActionListener(this);

		parentWindow.add(mainPanel);
		parentWindow.setSize(1008,782);
		parentWindow.setVisible(true);
		parentWindow.setLocationRelativeTo(null);
		parentWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == enter) {
						
			String shirtColor;
			shirtColor = ((String) shirtList.getSelectedItem());
			User selectedUser = new User(shirtColor);
			
			String mapChoice;
			mapChoice = ((String) mapChooseList.getSelectedItem());
			UHSMap selectedUHSMap = UHSMapFactory.createUHSMap(mapChoice);
			
			
			new SimulationGUI(selectedUser, selectedUHSMap);
			parentWindow.setVisible(false);
			parentWindow.dispose();
		}
		
		if (e.getSource() == quit) {
				JOptionPane.showMessageDialog(null,"Good bye!");
				System.exit(0);
		}
	}
}





