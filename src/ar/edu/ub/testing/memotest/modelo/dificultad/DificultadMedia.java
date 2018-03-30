package ar.edu.ub.testing.memotest.modelo.dificultad;

public class DificultadMedia extends Dificultad 
{
	private static final Integer DIFICULTAD_MEDIA_CANTIDAD_FILAS = 6;
	private static final Integer DIFICULTAD_MEDIA_CANTIDAD_COLUMNAS = 6;
	
	public DificultadMedia() 
	{
		super("Medio", DIFICULTAD_MEDIA_CANTIDAD_FILAS, DIFICULTAD_MEDIA_CANTIDAD_COLUMNAS);
	}

}
