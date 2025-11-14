package presentation;
import domain.STException;

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

	private BoardPanel tableroPreparacion;
	private BoardPanel tableroJuego;

	//Methods
	/**
	* Constructor of the SlowTetrisBoardGUI
	* @param int height
	* @param int width
	*/
	public SlowTetrisBoardGUI(int height, int width) throws STException{
		super("SlowTetrisBoard");
		if((height > 10 && height <= 20) && (width >= 5 && width <= 10)){
			gameStatus = new SlowTetris(height, width);
			prepareElementsBoard(height, width);
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
	* @param int height
	* @param int width
	*/
	private void prepareBoards(int height, int width){
		//Contenedor de los tableros
		JPanel panelCentral = new JPanel(new GridLayout(2, 1, 10, 10));

		//Tableros
		tableroPreparacion = new BoardPanel(() -> gameStatus.getPrepareBoard());
		tableroPreparacion.setBorder(BorderFactory.createTitledBorder("Preparación"));
		
		tableroJuego = new BoardPanel(()  -> gameStatus.getGameBoard());
		tableroJuego.setBorder(BorderFactory.createTitledBorder("Juego"));

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
		tableroPreparacion.repaint();
		tableroJuego.repaint();
	}

	/**
	* Prepares the listeners and the actions related to them
	*/
	private void prepareActions(){
		//oyente para confirmar cierre
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				exit();
			}
		});
		//acciones del menú
		prepareActionsMenu();
	}

	/**
	* Prepares the listeners and actions related to them that concern to the menu
	*/
	public void prepareActionsMenu(){
		
	}

	/**
	* Closes the board game
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

}