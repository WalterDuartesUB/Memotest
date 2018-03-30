package ar.edu.ub.testing.memotest.modelo.interno;

/**
 * MemotestCalculadorDePuntos es el encargado de saber cuantos puntos debe sumarse con determinadas cartas boca arriba
 * @author Walter Duartes
 *
 */
public class MemotestCalculadorDePuntos 
{

	private static final Integer CANTIDAD_PUNTOS_UNA_VEZ = 3;
	private static final Integer CANTIDAD_PUNTOS_MAS_DE_UNA_VEZ = 1;

	public Integer calcular(MemotestCarta[] cartas) 
	{
		
		if( this.todasLasCartasFuernoDadasVueltaSoloUnaVez( cartas ) )
			return CANTIDAD_PUNTOS_UNA_VEZ;
		
		return CANTIDAD_PUNTOS_MAS_DE_UNA_VEZ;
	}

	private boolean todasLasCartasFuernoDadasVueltaSoloUnaVez(MemotestCarta[] cartas) 
	{
		boolean soloUnaVez = true;
		
		for( int posicion = 0; posicion < cartas.length && soloUnaVez; posicion++)
			soloUnaVez = cartas[posicion].fueVolteadaSoloUnaVez();
		
		return soloUnaVez;
	}

}
