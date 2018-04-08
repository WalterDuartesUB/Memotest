package ar.edu.ub.testing.memotest.modelo.exception;

public class MemotestSinDificultadException extends MemotestException
{
	private static final long serialVersionUID = 1L;

	public MemotestSinDificultadException()
	{
		super("La dificultad no puede ser null para construir el memotest.");
	}

}
