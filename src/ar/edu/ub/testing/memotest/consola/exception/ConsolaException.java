package ar.edu.ub.testing.memotest.consola.exception;

public class ConsolaException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public ConsolaException()
	{
		super("Solo puede haber una instancia de Consola por ejecución.");
	}
}
