package ar.edu.ub.testing.memotest.modelo.interno.exception;

public class MemotestTableroCantidadFilasInvalidaException extends MemotestTableroException
{
	private static final long serialVersionUID = 1L;
	public MemotestTableroCantidadFilasInvalidaException()
	{
		super("La cantidad de filas para el tablero debe ser mayor a cero y no puede ser null.");
	}
}
