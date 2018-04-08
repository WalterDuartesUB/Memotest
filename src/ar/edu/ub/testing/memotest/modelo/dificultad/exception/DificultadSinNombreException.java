package ar.edu.ub.testing.memotest.modelo.dificultad.exception;

public class DificultadSinNombreException extends DificultadException 
{
	private static final long serialVersionUID = 1L;
	
	public DificultadSinNombreException()
	{
		super("El nombre de la dificultad no puede ser null o vacio.");
	}

}
