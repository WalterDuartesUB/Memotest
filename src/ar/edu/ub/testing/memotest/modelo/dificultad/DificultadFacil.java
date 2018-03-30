package ar.edu.ub.testing.memotest.modelo.dificultad;

public class DificultadFacil extends Dificultad 
{	
	private static final Integer DIFICULTAD_FACIL_CANTIDAD_FILAS = 4;
	private static final Integer DIFICULTAD_FACIL_CANTIDAD_COLUMNAS = 4;

	public DificultadFacil() 
	{
		super( "Fácil", DIFICULTAD_FACIL_CANTIDAD_FILAS, DIFICULTAD_FACIL_CANTIDAD_COLUMNAS); 
	}

}
