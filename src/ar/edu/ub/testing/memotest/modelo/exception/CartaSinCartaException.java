package ar.edu.ub.testing.memotest.modelo.exception;

public class CartaSinCartaException extends CartaException
{
	private static final long serialVersionUID = 1L;

	public CartaSinCartaException()
	{
		super("Una Carta no puede ser construido con una Carta null.");
	}

}
