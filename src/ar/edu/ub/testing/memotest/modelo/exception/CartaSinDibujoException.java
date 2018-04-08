package ar.edu.ub.testing.memotest.modelo.exception;

public class CartaSinDibujoException extends CartaException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CartaSinDibujoException()
	{
		super("El dibujo de la carta no puede ser null.");
	}
}
