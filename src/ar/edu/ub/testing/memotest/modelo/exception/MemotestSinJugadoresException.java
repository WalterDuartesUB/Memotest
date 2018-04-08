package ar.edu.ub.testing.memotest.modelo.exception;

public class MemotestSinJugadoresException extends MemotestException
{
	private static final long serialVersionUID = 1L;

	public MemotestSinJugadoresException()
	{
		super("Debe haber por lo menos un jugador para poder inicializar el memotest.");
	}

}
