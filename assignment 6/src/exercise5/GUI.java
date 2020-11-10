package exercise5;



import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;


import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Insets;
import javax.swing.JButton;


public class GUI {
	
	private JFrame display;
	private JTextField playerNameText;
	private JTextField charField;
	private JTextPane playerText;
	private GUIAction action;
	//buttons for the top row of the grid
	private JButton buttonTopLeft, buttonTopMid, buttonTopRight, buttonMidLeft, buttonMidMid,
	buttonMidRight, buttonBotLeft, buttonBotMid, buttonBotRight;
	
	
	//add a window to show what your symbol is
	private char mark;
	
	//add a window to type your name
	private JLabel playerNameLabel;
	
	
	
	
	
	public GUI() {
		start();
	}
	
	private void start()  {
		//create frame and set the bounds for the window
		display = new JFrame();
		display.setBounds(100, 100, 800, 500);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setResizable(false);
		
		//create organizer for the frame
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.columnWeights = new double [] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 
				1.0, 0.0, 1.0, Double.MIN_VALUE};
		
		gbl.rowHeights = new int [] {0, 0, 0, 0};
		gbl.rowWeights = new double[] {0.0, 0.0, 1.0, Double.MIN_VALUE };
		
		//add layout to the frame
		display.getContentPane().setLayout(gbl);
		
		JPanel gamePanel = new JPanel();
		GridBagConstraints gbcGameTxt = new GridBagConstraints();
		gbcGameTxt.gridheight = 3;
		gbcGameTxt.fill = GridBagConstraints.BOTH;
		gbcGameTxt.gridx = 9;
		gbcGameTxt.gridy = 0;
		display.getContentPane().add(gamePanel, gbcGameTxt);
		gamePanel.setSize(200,200);
		gamePanel.setLayout(new BorderLayout(0,0));
		
		JLabel gameLabel = new JLabel("Message Window");
		gameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		gameLabel.setBackground(new Color(0,0,0));
		gameLabel.setForeground(Color.black);
		gameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		gamePanel.add(gameLabel, BorderLayout.NORTH);
		
		playerText = new JTextPane();
		playerText.setEditable(false);
		gamePanel.add(playerText, BorderLayout.CENTER);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbcPanel = new GridBagConstraints();
		gbcPanel.gridheight = 3;
		gbcPanel.gridwidth = 8;
		gbcPanel.insets = new Insets(0,0,0,5);
		gbcPanel.fill = GridBagConstraints.BOTH;
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		display.getContentPane().add(panel, gbcPanel);
		
		
		
		//buttons top row
		buttonTopLeft = new JButton("");
		buttonTopLeft.setBounds(22, 44, 60, 60);
		buttonTopLeft.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(buttonTopLeft);
		
		buttonTopMid = new JButton("");
		buttonTopMid.setBounds(94, 44, 60, 60);
		buttonTopMid.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(buttonTopMid);
		
		buttonTopRight = new JButton("");
		buttonTopRight.setBounds(166, 44, 60, 60);
		buttonTopRight.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(buttonTopRight);
		
		
		
		//buttons middle row
		buttonMidLeft = new JButton("");
		buttonMidLeft.setBounds(22, 117, 60, 60);
		buttonMidLeft.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(buttonMidLeft);
		
		buttonMidMid = new JButton("");
		buttonMidMid.setBounds(94, 117, 60, 60);
		buttonMidMid.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(buttonMidMid);
		
		buttonMidRight = new JButton("");
		buttonMidRight.setBounds(166, 117, 60, 60);
		buttonMidRight.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(buttonMidRight);
		
		
		
		
		//buttons bottom row
		buttonBotLeft = new JButton("");
		buttonBotLeft.setBounds(22, 190, 60, 60);
		buttonBotLeft.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(buttonBotLeft);
		
		buttonBotMid= new JButton("");
		buttonBotMid.setBounds(94, 190, 60, 60);
		buttonBotMid.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(buttonBotMid);
		
		buttonBotRight= new JButton("");
		buttonBotRight.setBounds(166, 190, 60, 60);
		buttonBotRight.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(buttonBotRight);
		
		
		
		//add the components for the player name
		playerNameLabel = new JLabel("Name:");
		playerNameLabel.setBounds(65, 303, 56, 16);
		panel.add(playerNameLabel);
		
		playerNameText = new JTextField();
		playerNameText.setBounds(133, 300, 115, 22);
		panel.add(playerNameText);
		playerNameText.setColumns(10);
		
		
		
		//player mark components 
		JLabel charMark = new JLabel("Player");
		charMark.setBounds(65, 268, 56, 16);
		panel.add(charMark);
		
		charField = new JTextField();
		charField.setColumns(10);
		charField.setBounds(133, 265, 33, 22);
		panel.add(charField);
		
		
		action = new GUIAction(playerNameText, mark, buttonTopLeft, buttonTopMid, buttonTopRight,
				buttonMidLeft, buttonMidMid, buttonMidRight, buttonBotLeft, buttonBotMid, buttonBotRight);
		
		buttonTopLeft.addMouseListener(action);
		buttonTopMid.addMouseListener(action);
		buttonTopRight.addMouseListener(action);
		
		buttonMidLeft.addMouseListener(action);
		buttonMidMid.addMouseListener(action);
		buttonMidRight.addMouseListener(action);
		
		buttonBotLeft.addMouseListener(action);
		buttonBotMid.addMouseListener(action);
		buttonBotRight.addMouseListener(action);
		
		display.setVisible(true);
	}

	
	
	public JFrame getDisplay() {
		return display;
	}
	public void setDisplay(JFrame display) {
		this.display = display;
	}

	
	public char getMark() {
		return mark;
	}
	public void setMark(char mark) {
		this.mark = mark;
	}

	
	public JTextPane getPlayerText() {
		return playerText;
	}
	public void setPlayerText(JTextPane playerText) {
		this.playerText = playerText;
	}

	
	public JLabel getPlayerNameLabel() {
		return playerNameLabel;
	}
	public void setPlayerNameLabel(JLabel playerNameLabel) {
		this.playerNameLabel = playerNameLabel;
	}

	
	public JTextField getPlayerNameText() {
		return playerNameText;
	}
	public void setPlayerNameText(JTextField playerNameText) {
		this.playerNameText = playerNameText;
	}
	
	
	public JTextField getCharField() {
		return charField;
	}
	public void setCharField(JTextField charField) {
		this.charField = charField;
	}

	public GUIAction getAction() {
		return action;
	}
	public void enable(boolean check) {
		buttonTopLeft.setEnabled(check);
		buttonTopMid.setEnabled(check);
		buttonTopRight.setEnabled(check);
		buttonMidLeft.setEnabled(check);
		buttonMidMid.setEnabled(check);
		buttonMidRight.setEnabled(check);
		buttonBotLeft.setEnabled(check);
		buttonBotMid.setEnabled(check);
		buttonBotRight.setEnabled(check);
		
		
	}
	
	//uncomment to view GUI
//	public static void main(String [] args) {
//		GUI app = new GUI();
//		
//	}
	
	

}
