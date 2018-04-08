package ar.edu.ub.testing.memotest.modelo.exception;

public class CartaSinDibujoLomoException extends CartaException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CartaSinDibujoLomoException()
	{
		super("El dibujo del lomo de la carta no puede ser null.");
	}

}
