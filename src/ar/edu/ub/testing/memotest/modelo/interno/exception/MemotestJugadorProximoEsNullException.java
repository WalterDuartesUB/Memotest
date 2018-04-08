package ar.edu.ub.testing.memotest.modelo.interno.exception;

public class MemotestJugadorProximoEsNullException extends MemotestJugadorException
{

	private static final long serialVersionUID = 1L;

	public MemotestJugadorProximoEsNullException()
	{
		super("El proximo Jugador no puede ser null.");
	}

}
