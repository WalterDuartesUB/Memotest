package ar.edu.ub.testing.memotest.modelo.exception;

public class JugadorSinAliasException extends JugadorException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JugadorSinAliasException()
	{
		super("El alias del jugador no puede ser vacio o null.");
	}	
}
