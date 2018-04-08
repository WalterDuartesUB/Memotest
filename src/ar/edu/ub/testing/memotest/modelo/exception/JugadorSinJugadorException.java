package ar.edu.ub.testing.memotest.modelo.exception;

public class JugadorSinJugadorException extends JugadorException
{
	private static final long serialVersionUID = 1L;
	
	public JugadorSinJugadorException()
	{
		super( "No se puede crear un Jugador con un Jugador null.");
	}
}
