package ar.edu.ub.testing.memotest.modelo.exception;

public class MemotestSinCreadorDeTableroException extends MemotestException
{
	private static final long serialVersionUID = 1L;
	
	public MemotestSinCreadorDeTableroException()
	{
		super("No se puede crear un Memotest con un MemotestCreadorTablero null.");
	}

}
