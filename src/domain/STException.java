package domain;

public class STException extends Exception{
	//Atributes Messages
	public final static String TAMANO_TABLERO_NO_VALIDO = "Los valores ingresados para el tablero no son válidos";

	//Methods
	/**
	* Constructor of STExceptions
	* @param String message
	*/
	public STException(String message){
		super(message);
	}
}