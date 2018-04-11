package ar.edu.ub.testing.memotest.modelo.interno.exception;

public class MemotestCreadorTableroDificultadInvalidaException extends MemotestCreadorTableroException
{
	private static final long serialVersionUID = 1L;

	public MemotestCreadorTableroDificultadInvalidaException()
	{
		super("La dificultad para crear un tablero no puede ser null, o tener cantidad de filas o columnas en 0.");
	}

}
