import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SimulationGUI extends JPanel implements KeyListener, ActionListener {
	
	private static final int personShiftX = 500;
	private static final int personShiftY = 400;

	private User currentUser;
	private UHSMap currentMap;
	
	private JFrame parentWindow = new JFrame("Welcome to Urbana High School!");
	
	private Image currentPerson;
	
	int graphicsContextX = 0;
	int graphicsContextY = 0;
	
	int imageX;
	int imageY;
	

	private JMenuItem campusMenuItem = new JMenuItem("Campus");
	private JMenuItem firstFloorMenuItem = new JMenuItem("First Floor");
	private JMenuItem secondFloorMenuItem = new JMenuItem("Second Floor");
	private JMenuItem exitMenuItem  = new JMenuItem("Exit");
	private JMenuItem controlsMenuItem  = new JMenuItem("Controls");

	
	public SimulationGUI(User user, UHSMap uhsMap) {
		this.currentUser = user;
		
		currentMap = uhsMap;		
		
		graphicsContextX = currentMap.getStartX();
		graphicsContextY = currentMap.getStartY();
		
		this.setBackground(Color.BLACK);
		
		
	    JMenuBar menubar = new JMenuBar();
	    
	    JMenu fileMenu = new JMenu("File");
	    JMenu schoolMapMenu = new JMenu("School Map");
	    JMenu helpMenu = new JMenu("Help");
	    
	    fileMenu.add(exitMenuItem);
	    schoolMapMenu.add(campusMenuItem);
	    schoolMapMenu.add(firstFloorMenuItem);
	    schoolMapMenu.add(secondFloorMenuItem);
	    helpMenu.add(controlsMenuItem);
	    
	    menubar.add(fileMenu);
        menubar.add(schoolMapMenu);
        menubar.add(Box.createHorizontalGlue());
        menubar.add(helpMenu);
        
        exitMenuItem.addActionListener(this);
        campusMenuItem.addActionListener(this);
        firstFloorMenuItem.addActionListener(this);
        secondFloorMenuItem.addActionListener(this);
        
        controlsMenuItem.addActionListener(this);
        
        parentWindow.setJMenuBar(menubar);
		parentWindow.setLocationRelativeTo(null);
		parentWindow.setVisible(true);
		parentWindow.setSize(1000,800);
		
	    parentWindow.add(this);		
		
        parentWindow.addKeyListener(this);
        parentWindow.setFocusable(true);
		parentWindow.setLocationRelativeTo(null);
		parentWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(currentMap.getMapImage(), graphicsContextX, graphicsContextY, this);         
        g.drawImage(currentPerson, personShiftX, personShiftY, this);
    }	
	
	public boolean graphicsBlackPixelChecker(int graphicsContextx, int graphicsContexty) {		
		
		
		imageX = -1 * graphicsContextx + personShiftX;
		imageY = -1 * graphicsContexty + personShiftY;
		
		if(currentMap.getBufferedImage().getRGB(imageX, imageY) == -16777216) {
			return false;
		}
			return true;	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
			
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			
			if (graphicsBlackPixelChecker(graphicsContextX,graphicsContextY+currentMap.getPixelIncrement())) {
				graphicsContextY +=currentMap.getPixelIncrement();
				currentPerson = currentUser.getUpImage();
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			if (graphicsBlackPixelChecker(graphicsContextX,graphicsContextY-currentMap.getPixelIncrement())) {
				graphicsContextY -=currentMap.getPixelIncrement();
				currentPerson = currentUser.getDownImage();
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			if (graphicsBlackPixelChecker(graphicsContextX+currentMap.getPixelIncrement(),graphicsContextY)) {
				graphicsContextX +=currentMap.getPixelIncrement();
				currentPerson = currentUser.getLeftImage();
			}
		}
		
	    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {	
	    	
			if (graphicsBlackPixelChecker(graphicsContextX-currentMap.getPixelIncrement(),graphicsContextY)) {
				graphicsContextX -=currentMap.getPixelIncrement();
				currentPerson = currentUser.getRightImage();
			}
		}
		repaint();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {		
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == campusMenuItem) {
			currentMap = UHSMapFactory.create(UHSMapFactory.MapType.CAMPUS);
			graphicsContextX = currentMap.getStartX();
			graphicsContextY = currentMap.getStartY();
		} else if (e.getSource() == firstFloorMenuItem) {
			currentMap = UHSMapFactory.create(UHSMapFactory.MapType.FIRST_FLOOR);
			graphicsContextX = currentMap.getStartX();
			graphicsContextY = currentMap.getStartY();
		} else if (e.getSource() == secondFloorMenuItem) {
			currentMap = UHSMapFactory.create(UHSMapFactory.MapType.SECOND_FLOOR);
			graphicsContextX = currentMap.getStartX();
			graphicsContextY = currentMap.getStartY();
		}
		
		if(e.getSource() == exitMenuItem) {
			int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit?",  JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION)
			{
			   System.exit(0);
			}
		}
			
		if(e.getSource() == controlsMenuItem) {
			
			JOptionPane.showMessageDialog(parentWindow,
				    "Use the arrow keys to control your person.",
				    "Controls",
				    JOptionPane.PLAIN_MESSAGE);
		}
			
		repaint();
	}
}