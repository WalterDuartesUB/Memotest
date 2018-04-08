package ar.edu.ub.testing.memotest.modelo.dificultad.exception;

public class DificultadSinCantidadColumnasException extends DificultadException 
{
	private static final long serialVersionUID = 1L;

	public DificultadSinCantidadColumnasException()
	{
		super("La cantidad de columnas debe ser mayor a cero y no null");
	}
}
