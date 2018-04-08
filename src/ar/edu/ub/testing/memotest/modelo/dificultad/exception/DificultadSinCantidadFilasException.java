package ar.edu.ub.testing.memotest.modelo.dificultad.exception;

public class DificultadSinCantidadFilasException extends DificultadException 
{
	private static final long serialVersionUID = 1L;


	public DificultadSinCantidadFilasException()
	{
		super("La cantidad de filas debe ser mayor a cero y no null");
	}	
}
