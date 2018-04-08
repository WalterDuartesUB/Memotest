package ar.edu.ub.testing.memotest.modelo.interno.exception;

public class MemotestJugadorProximoEsMismoJugadorException extends MemotestJugadorException
{
	private static final long serialVersionUID = 1L;

	public MemotestJugadorProximoEsMismoJugadorException()
	{
		super("El proximo Jugador no puede ser igual al Jugador actual."); 
	}

}
