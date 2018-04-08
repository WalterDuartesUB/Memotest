package ar.edu.ub.testing.memotest.modelo.interno.exception;

public class MemotestTableroCantidadColumnasInvalidaException extends MemotestTableroException
{
	private static final long serialVersionUID = 1L;
	
	public MemotestTableroCantidadColumnasInvalidaException()
	{
		super("La cantidad de columnas para el tablero debe ser mayor a cero y no puede ser null.");
	}	

}
