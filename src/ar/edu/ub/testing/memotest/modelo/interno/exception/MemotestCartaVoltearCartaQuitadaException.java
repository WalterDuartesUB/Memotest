package ar.edu.ub.testing.memotest.modelo.interno.exception;

public class MemotestCartaVoltearCartaQuitadaException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MemotestCartaVoltearCartaQuitadaException(  )
	{
		super ( "No se puede voltear una carta que fue quitada." );
	}

}
