package presentation;
import domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SlowTetrisGUI extends JFrame{
	//Atributes
	private JMenuBar barraMenu;
	private JMenu menu;
	private JMenuItem iNuevo, iAbrir, iGuardar, iSalir;
	private SlowTetrisBoardGUI tablero;

	//Methods
	/**
	* Constructor of the SlowTetrisGUI
	*/
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
		//dimensionar la pantalla
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenDimension.width/4;
		int height = screenDimension.height/4;
		setSize(width, height);
		//ubicar
		setLocationRelativeTo(null);
		//ajustar el cierre para poder aplicar la ventana de confirmación
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		//preparación del menu
		prepareElementsMenu();
	}

	/**
	* Prepares the visual components for the menu
	*/
	private void prepareElementsMenu(){
		//creación elementos
		barraMenu = new JMenuBar();
		menu = new JMenu("Juego");
		iNuevo = new JMenuItem("Nuevo");
		iAbrir = new JMenuItem("Abrir");
		iGuardar = new JMenuItem("Guardar");
		iSalir = new JMenuItem("Salir");
		//organizar el menu
		menu.add(iNuevo);
		menu.addSeparator();
		menu.add(iAbrir);
		menu.add(iGuardar);
		menu.addSeparator();
		menu.add(iSalir);
		//asignar el menu a la barra
		barraMenu.add(menu);
		//asignar la barra de menu
		setJMenuBar(barraMenu);
	}
	
	/**
	* Prepares the listeneres and the actions related to them
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
	* prepares the listener and action related to them for the menu
	*/
	private void prepareActionsMenu(){
		//oyente para salir del juego en el menú
		iSalir.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				exit();
			}
		});
		//oyente para abrir un juego en el archivo
		iAbrir.addActionListener(new  ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JFileChooser ventana = new JFileChooser();
				ventana.setDialogTitle("abrir un juego de SlowTetris");
				int resultado = ventana.showOpenDialog(SlowTetrisGUI.this);
				//Aqui va la lógica de abrir el juego, que no se implementa en este laboratorio
				JOptionPane.showMessageDialog(
					SlowTetrisGUI.this,
					"esta funcionalidad no está implementada"
				);
			}
		});
		//oyente para guardar el juego en un archivo
		iGuardar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JFileChooser ventana = new JFileChooser();
				ventana.setDialogTitle("Guardar o sobreescribir un archivo del juego");
				int resultado = ventana.showSaveDialog(SlowTetrisGUI.this);
				//Aqui va la lógica de guardar o sobreescribir el juego, que no se implementa en este laboratorio
				JOptionPane.showMessageDialog(
					SlowTetrisGUI.this,
					"esta funcionalidad no está implementada"
				);
			}
		});
		//oyente para crear un nuevo juego
		iNuevo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try{
					int ancho = Integer.parseInt(JOptionPane.showInputDialog(SlowTetrisGUI.this, "Ingrese el ancho:"));
					int alto = Integer.parseInt(JOptionPane.showInputDialog(SlowTetrisGUI.this, "Ingrese el alto:"));
					tablero = new SlowTetrisBoardGUI(alto, ancho);
					tablero.setVisible(true);
				}catch(STException ex){
					//valores no válidos
					JOptionPane.showMessageDialog(SlowTetrisGUI.this,
					 ex.getMessage() + "\n" +
					"4 < alto <= 25" + 
					"4 < alto <= 15"
					);
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(SlowTetrisGUI.this, "El formato no es válido, asegurese de ingresar números.");
				}
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