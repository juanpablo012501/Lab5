package presentation;

import javax.swing.*;
import javax.awt.*;

public class SlowTetrisGUI extends JFrame{
	//Ciclo 0
	public SlowTetrisGUI(){
		super("SlowTetris");
		prepareElements();
	}
	
	/**
	* Creates the game and makes it visible
	* @param String[] args
	*/
	public static void main(String[] args){
		SlowTetrisGUI vista = new SlowTetrisGUI();
		vista.setVisible(true);
	}

	/**
	* Adjust the visual elements of the GUI
	*/
	private void prepareElements(){
		//dimensionar
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenDimension.width/4;
		int height = screenDimension.height/4;
		setSize(width, height);
		//ubicar
		setLocationRelativeTo(null);
	}
}