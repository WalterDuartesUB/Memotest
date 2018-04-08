package ar.edu.ub.testing.memotest.modelo.interno.exception;

public class MemotestTableroFilaNoExisteException extends MemotestTableroException
{
	private static final long serialVersionUID = 1L;
	
	public MemotestTableroFilaNoExisteException( Integer fila  )
	{
		super( String.format("No se puede obtener/poner una carta en la fila %d porque no existe en el tablero.", fila));
	}

}
