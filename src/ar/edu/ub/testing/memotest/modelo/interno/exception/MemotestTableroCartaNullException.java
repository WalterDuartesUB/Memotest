package ar.edu.ub.testing.memotest.modelo.interno.exception;

public class MemotestTableroCartaNullException extends MemotestTableroException
{
	private static final long serialVersionUID = 1L;
	
	public MemotestTableroCartaNullException()
	{
		super("No se puede agregar una Carta null.");
	}

}
