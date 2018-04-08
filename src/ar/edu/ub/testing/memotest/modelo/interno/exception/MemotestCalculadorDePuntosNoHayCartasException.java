package ar.edu.ub.testing.memotest.modelo.interno.exception;

public class MemotestCalculadorDePuntosNoHayCartasException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	public MemotestCalculadorDePuntosNoHayCartasException()
	{
		super("La lista de cartas debe tener Carta no null y no puede ser null");
	}
}
