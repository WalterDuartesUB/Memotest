package ar.edu.ub.testing.memotest.modelo.dificultad;

public class DificultadDificil extends Dificultad 
{
	private static final Integer DIFICULTAD_DIFICIL_CANTIDAD_FILAS = 8;
	private static final Integer DIFICULTAD_DIFICIL_CANTIDAD_COLUMNAS = 8;
	
	public DificultadDificil() 
	{
		super("Dificil", DIFICULTAD_DIFICIL_CANTIDAD_FILAS, DIFICULTAD_DIFICIL_CANTIDAD_COLUMNAS);
	}

}
