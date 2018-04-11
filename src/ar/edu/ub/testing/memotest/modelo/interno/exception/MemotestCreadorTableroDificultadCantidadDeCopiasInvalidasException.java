package ar.edu.ub.testing.memotest.modelo.interno.exception;

public class MemotestCreadorTableroDificultadCantidadDeCopiasInvalidasException extends MemotestCreadorTableroException
{
	private static final long serialVersionUID = 1L;

	public MemotestCreadorTableroDificultadCantidadDeCopiasInvalidasException()
	{
		super("La cantidad de copias de cartas no puede ser null, cero. La cantidad de copias de cartas debe ser multiplo de la cantidad total de cartas del tablero(filas x columnas)");
	}

}
