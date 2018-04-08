package ar.edu.ub.testing.memotest.modelo.interno;

import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestCalculadorDePuntosNoHayCartasException;

/**
 * MemotestCalculadorDePuntos es el encargado de saber cuantos puntos debe sumarse con determinadas cartas boca arriba
 * @author Walter Duartes
 * 
 * Historial
 * ---------
 * 2018/04/08	wduartes	calcular ahora da MemotestCalculadorDePuntosNoHayCartasException
 * 							si el parametro carta es null, tamanio cero, algun Carta no esta boca arriba
 * 							 o tiene un null dentro
 * 
 */
public class MemotestCalculadorDePuntos 
{

	private static final Integer CANTIDAD_PUNTOS_UNA_VEZ = 3;
	private static final Integer CANTIDAD_PUNTOS_MAS_DE_UNA_VEZ = 1;

	/**
	 * Calcula la cantidad de puntos a sumar con determinadas cartas
	 * @param cartas lista de Carta para saber cuantos puntos sumar
	 * @return cantidad de puntos a suma
	 * @exception MemotestCalculadorDePuntosNoHayCartasException si cartas es null,
	 * 				cartas tiene tamanio cero, 
	 * 				si algun Carta no esta boca arriba,
	 * 				o alguna Carta en cartas es null.
	 */
	public Integer calcular(MemotestCarta[] cartas) 
	{
		if( !this.hayCartas( cartas ) )
			throw new MemotestCalculadorDePuntosNoHayCartasException();
		
		if( this.todasLasCartasFuernoDadasVueltaSoloUnaVez( cartas ) )
			return getCantidadPuntosUnaVez();
		
		return getCantidadPuntosMasDeUnaVez();
	}

	private boolean hayCartas(MemotestCarta[] cartas)
	{
		if( cartas == null || cartas.length == 0 )
			return false;
		
		for( int posicion = 0; posicion < cartas.length; posicion++)
		{
			if( cartas[posicion] == null )
				return false;
			
			if( !cartas[posicion].estaBocaArriba() )
				return false;
		}
		
		return true;
	}

	private boolean todasLasCartasFuernoDadasVueltaSoloUnaVez(MemotestCarta[] cartas) 
	{
		boolean soloUnaVez = true;
		
		for( int posicion = 0; posicion < cartas.length && soloUnaVez; posicion++)
			soloUnaVez = cartas[posicion].fueVolteadaSoloUnaVez();
		
		return soloUnaVez;
	}

	public static Integer getCantidadPuntosUnaVez()
	{
		return CANTIDAD_PUNTOS_UNA_VEZ;
	}

	public static Integer getCantidadPuntosMasDeUnaVez()
	{
		return CANTIDAD_PUNTOS_MAS_DE_UNA_VEZ;
	}

}
