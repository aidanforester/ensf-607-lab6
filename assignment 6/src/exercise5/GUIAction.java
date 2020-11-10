package exercise5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class GUIAction implements MouseListener, ActionListener{
	
	private char mark;
	JButton buttonTopLeft, buttonTopMid, buttonTopRight, buttonMidLeft, buttonMidMid,
	buttonMidRight, buttonBotLeft, buttonBotMid, buttonBotRight;
	
	JTextPane playerText;
	JTextField playerNameText;
	
	private int row, col;
	private String name;
	private PrintWriter scoketOut;
	boolean enable=false;
	boolean clicked=false;
	
	public GUIAction(JTextField playerNameText, char mark, JButton buttonTopLeft, JButton buttonTopMid,
			JButton buttonTopRight, JButton buttonMidLeft, JButton buttonMidMid, JButton buttonMidRight,
			JButton buttonBotLeft, JButton buttonBotMid, JButton buttonBotRight) {
		
		this.playerNameText = playerNameText;
		this.mark = mark;
		this.buttonTopLeft = buttonTopLeft;
		this.buttonTopMid = buttonTopMid;
		this.buttonTopRight = buttonTopRight;
		this.buttonMidLeft = buttonMidLeft;
		this.buttonMidMid = buttonMidMid;
		this.buttonMidRight = buttonMidRight;
		this.buttonBotLeft = buttonBotLeft;
		this.buttonBotMid = buttonBotMid;
		this.buttonBotRight = buttonBotRight;
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		String text = "the box has already been clicked";
		if(Character.isLetter(mark) && enable) 
			row = -1;
			col = -1;
			
		//top row
		if(e.getSource() == buttonTopLeft) {
			if(buttonTopLeft.getText()=="") {
				buttonTopLeft.setText(mark + "");
				clicked = true;
				row = 0;
				col = 0;
				
			}else
				playerText.setText(text);
		}else if(e.getSource() == buttonTopMid) {
			if(buttonTopMid.getText()=="") {
				buttonTopMid.setText(mark + "");
				clicked = true;
				row = 0;
				col = 1;
				
			}else
				playerText.setText(text);
		}else if(e.getSource() == buttonTopRight) {
			if(buttonTopRight.getText()=="") {
				buttonTopRight.setText(mark + "");
				clicked = true;
				row = 0;
				col = 2;
				
			}else
				playerText.setText(text);
			
		//middle row	
		}else if(e.getSource() == buttonMidLeft) {
			if(buttonMidLeft.getText()=="") {
				buttonMidLeft.setText(mark + "");
				clicked = true;
				row = 1;
				col = 0;
				
			}else
				playerText.setText(text);
		}else if(e.getSource() == buttonMidMid) {
			if(buttonMidMid.getText()=="") {
				buttonMidMid.setText(mark + "");
				clicked = true;
				row = 1;
				col = 1;
				
			}else
				playerText.setText(text);
		}else if(e.getSource() == buttonMidRight) {
			if(buttonMidRight.getText()=="") {
				buttonMidRight.setText(mark + "");
				clicked = true;
				row = 1;
				col = 2;
				
			}else
				playerText.setText(text);
			
			
		//bottom row
		}else if(e.getSource() == buttonBotLeft) {
			if(buttonBotLeft.getText()=="") {
				buttonBotLeft.setText(mark + "");
				clicked = true;
				row = 2;
				col = 0;
				
			}else
				playerText.setText(text);
		}else if(e.getSource() == buttonBotMid) {
			if(buttonBotMid.getText()=="") {
				buttonBotMid.setText(mark + "");
				clicked = true;
				row = 2;
				col = 1;
				
			}else
				playerText.setText(text);
		}else if(e.getSource() == buttonBotRight) {
			if(buttonBotRight.getText()=="") {
				buttonBotRight.setText(mark + "");
				clicked = true;
				row = 2;
				col = 2;
				
			}else
				playerText.setText(text);
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == playerNameText) {
			name = playerNameText.getText();
			playerNameText.setEditable(false);
			playerNameText.setText(name);
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public char getMark() {
		return mark;
	}
	public void setMark(char mark) {
		this.mark = mark;
	}


	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}

	
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public PrintWriter getScoketOut() {
		return scoketOut;
	}
	public void setScoketOut(PrintWriter scoketOut) {
		this.scoketOut = scoketOut;
	}


	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}


	public boolean isClicked() {
		return clicked;
	}
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

}
