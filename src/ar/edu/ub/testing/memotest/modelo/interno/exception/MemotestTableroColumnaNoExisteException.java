package ar.edu.ub.testing.memotest.modelo.interno.exception;

public class MemotestTableroColumnaNoExisteException extends MemotestTableroException
{

	private static final long serialVersionUID = 1L;
	public MemotestTableroColumnaNoExisteException( Integer columna  )
	{
		super( String.format("No se puede obtener una carta de la columna %d porque no existe en el tablero.", columna));
	}
}
