package presentation;
import domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SlowTetrisBoardGUI extends JFrame{
	//Atributes
	private SlowTetris gameStatus;

	private JMenuBar barraMenu;
	private JMenu menu;
	private JMenuItem iCambiar, iModificar;

	private JPanel panelBotones;
	private JButton bOeste, bEste, bRotar, bSoltar;

	private JPanel tableroPreparacion;
	private JPanel tableroJuego;

	//Methods
	/**
	* Constructor of the SlowTetrisBoardGUI
	* @param int height
	* @param int width
	*/
	public SlowTetrisBoardGUI(int height, int width) throws STException{
		super("SlowTetrisBoard");
		if((height > 4 && height <= 25) && (width >= 4 && width <= 15)){
			gameStatus = new SlowTetris(height, width);
			prepareElementsBoard();
			prepareActions();
		}else{
			throw new STException(STException.TAMANO_TABLERO_NO_VALIDO);
		}
	}

	/**
	* Prepares the visual components of the gameboard
	*/
	private void prepareElementsBoard(){
		//Ajustes generales
		setSize(700, 500);
        	setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		prepareElementsMenu();
		prepareBoards();
		prepareElementsButtoner();

	}

	/**
	* Prepares the menu items
	*/
	private void prepareElementsMenu(){
		barraMenu = new JMenuBar();
		menu = new JMenu("Opciones");
		iModificar = new JMenuItem("Modificar");
		iCambiar = new JMenuItem("Cambiar color");
		
		menu.add(iModificar);
		menu.add(iCambiar);
		barraMenu.add(menu);

		setJMenuBar(barraMenu);
	}

	/**
	* prepares the visual elements related to buttons
	*/
	private void prepareElementsButtoner(){
		panelBotones = new JPanel(new GridLayout(2, 2, 10, 10));
		bOeste = new JButton("Oeste");
        	bEste = new JButton("Este");
        	bRotar = new JButton("Rotar");
        	bSoltar = new JButton("Soltar");
		
		panelBotones.add(bOeste);
        		panelBotones.add(bEste);
       		panelBotones.add(bRotar);
       		panelBotones.add(bSoltar);
		add(panelBotones, BorderLayout.SOUTH);
	}

	/**
	* Prepares the visual state of both boards(preparation/game)
	*/
	private void prepareBoards(){
		JPanel panelCentral = new JPanel(new GridLayout(1, 2, 10, 10));
		tableroPreparacion = new JPanel();
        	tableroPreparacion.setBackground(Color.LIGHT_GRAY);
		tableroJuego = new JPanel();
        	tableroJuego.setBackground(Color.WHITE);

		//justamos ubicación de los tableros
		panelCentral.add(tableroPreparacion);
        	panelCentral.add(tableroJuego);
		add(panelCentral, BorderLayout.CENTER);
		
		
		//Actualizamos estado
		refresh();
	}

	/**
	* Updates the boards of the SLowTerisBoardsGUI
	*/
	public void refresh(){
	}

	/**
	* Prepares the listeners and the actions related to them
	*/
	private void prepareActions(){
	}

}