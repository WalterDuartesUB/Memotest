package ar.edu.ub.testing.memotest.modelo.interno;

import ar.edu.ub.testing.memotest.modelo.Carta;
import ar.edu.ub.testing.memotest.modelo.dificultad.Dificultad;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestCreadorTableroDificultadCantidadDeCopiasInvalidasException;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestCreadorTableroDificultadInvalidaException;

public abstract class MemotestCreadorTablero
{
	/**
	 * Crea una cantidad de cartas con determinada cantidad de repeticiones
	 * @param cantidadTotalDeCartas cantidad de cartas totales a crear
	 * @param cantidadRepeticiones cantidad de repeticiones de los dibujos de las cartas en la lista
	 * @return una lista de MemotestCarta con repeticiones de dibujos
	 */
	
	protected abstract Carta[] crearCartas( Dificultad dificultad, Integer cantidadCartasNecesariasPorTurno);
	
	protected Carta[] mezclarCartas(Carta[] cartas)
	{
		return Carta.mezclar(cartas);
	}
	
	/**
	 * Creo un tablero basado en una dificultad y la cantidad de copias necesarias
	 * @param dificultad
	 * @param cantidadCopiasCartas
	 * @return un MemotestTablero con Carta listo para jugar
	 */
	public MemotestTablero crearTablero(Dificultad dificultad, Integer cantidadCopiasCartas)
	{		
		if( !this.validarDificultad( dificultad ) )
			throw new MemotestCreadorTableroDificultadInvalidaException();
		
		if( !this.validarDificultad( dificultad, cantidadCopiasCartas ) )
			throw new MemotestCreadorTableroDificultadCantidadDeCopiasInvalidasException();
		
		MemotestTablero tablero = new MemotestTablero( dificultad.getCantidadFilas(), dificultad.getCantidadColumnas() );
		
		Carta[] cartas =  this.mezclarCartas( this.crearCartas( dificultad, cantidadCopiasCartas ) );
	
		///////////////////////////////////////////////////////////////////////
		//Coloco las cartas que cree en el tablero
		
		for( int posicion = 0; posicion < cartas.length; posicion++ )
			tablero.ponerCarta(posicion / dificultad.getCantidadColumnas(), posicion % dificultad.getCantidadColumnas(), cartas[posicion] );
		
		return tablero;	
	}

	private boolean validarDificultad(Dificultad dificultad, Integer cantidadCopiasCartas)
	{
		if( cantidadCopiasCartas == null || cantidadCopiasCartas <= 0)
			return false;
		
		return ( ( dificultad.getCantidadColumnas() * dificultad.getCantidadFilas() ) % cantidadCopiasCartas ) == 0;
	}

	private boolean validarDificultad(Dificultad dificultad)
	{
		if( dificultad == null)
			return false;
		
		return !( ( dificultad.getCantidadColumnas() <= 0 ) || ( dificultad.getCantidadFilas() <= 0 ) );
	}
	
}
