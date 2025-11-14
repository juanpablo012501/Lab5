package domain;

public class SlowTetris{
	//Atributes
	private int[][] prepareBoard;
	private int[][] gameBoard;

	//Methods
	/**
	* Constructor of SlowTetris
	* @param int height
	* @param int width
	*/
	public SlowTetris(int height, int width){
		
	}
	
	/**
	* Gives the gameBoard state
	* return int[][]
	*/
	public int[][] getGameBoard(){
		return gameBoard;
	}

	/**
	* Gives the prepareBoard status
	* return int[][]
	*/
	public int[][] getPrepareBoard(){
		return prepareBoard;
	}
}