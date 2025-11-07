package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SlowTetrisGUI extends JFrame{
	//Ciclo 0
	public SlowTetrisGUI(){
		super("SlowTetris");
		prepareElements();
		prepareActions();
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
		//Ajustar el cierre para poder aplicar la ventana de confirmación
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	/**
	* Prepares the listener and the actions related to them
	*/
	private void prepareActions(){
		//Oyente para confirmar cierre
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				exit();
			}
		});
	}
	
	/**
	* Shows the confirmation window to exit
	*/
	private void exit(){
		int salir = JOptionPane.showConfirmDialog(
			this,
			"¿Quiere salir de la app?",
			"Confirmar salida",
			JOptionPane.YES_NO_OPTION
		);
		if(salir == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
}