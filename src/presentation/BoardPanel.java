package presentation;
import domain.*;

import javax.swing.*;
import java.awt.*;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.Arrays;

public class BoardPanel extends JPanel{
	//Atributes
	private final Supplier<int[][]> proveedorStatus;
	private final int celdaTam = 25; // tamaño de cada cubito de las fichas
	private ArrayList<Color> tokenColors = new ArrayList<>(Arrays.asList(
		Color.CYAN,
		Color.BLUE,
		Color.YELLOW,
		Color.ORANGE,
		Color.GREEN,
		Color.RED,
		Color.MAGENTA
	));

	//Methods
	/**
	* Constructor of BoardPanel
	* @param Supplier<int[][]> proveedor 
	*/
	public BoardPanel(Supplier<int[][]> proveedor){
		setBackground(Color.BLACK);
		proveedroStatus = proveedor;
	}

	/**
	* Updates the board status
	*/
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int[][] actualStatus =  proveedorStatus.get();
		int rows = actualStatus.length;
		int columns = actualStatus[0].length;

		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				//interior cuadrito
				g.setColor(this.getColor(actualStatus[i][j]));
				g.fillRect(j*celdaTam, i*celdaTam, celdaTam, celdaTam);
				//borde celda
				g.setColor(Color.LIGHT_GRAY);
				g.drawRect(j*celdaTam, i*celdaTam, celdaTam, celdaTam);
			}
		}
	}

	/**
	* Gives the color that corresponds to the number
	* @param int numberToken
	* @return Color
	*/
	private Color getColor(int tokenNumber){
		switch(tokenNumber){
			case 1: return tokenColors.get(0);
			case 2: return tokenColors.get(1);
			case 3: return tokenColors.get(2);
			case 4: return tokenColors.get(3);
			case 5: return tokenColors.get(4);
			case 6: return tokenColors.get(5);
			case 7: return tokenColors.get(6);
			default: return new Color(30, 30, 30);;
		}
	}
}