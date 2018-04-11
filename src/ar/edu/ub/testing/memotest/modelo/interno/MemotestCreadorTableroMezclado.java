package ar.edu.ub.testing.memotest.modelo.interno;

import ar.edu.ub.testing.memotest.modelo.Carta;
import ar.edu.ub.testing.memotest.modelo.dificultad.Dificultad;

public class MemotestCreadorTableroMezclado extends MemotestCreadorTablero
{

	/**
	 * Crea una cantidad de cartas con determinada cantidad de repeticiones
	 * @param cantidadTotalDeCartas cantidad de cartas totales a crear
	 * @param cantidadRepeticiones cantidad de repeticiones de los dibujos de las cartas en la lista
	 * @return una lista de MemotestCarta con repeticiones de dibujos
	 */
	
	@Override
	protected Carta[] crearCartas( Dificultad dificultad,Integer cantidadRepeticiones ) 
	{
		int     cantidadTotalDeCartas = dificultad.getCantidadFilas() * dificultad.getCantidadColumnas();
		Carta[] cartas = new Carta[ cantidadTotalDeCartas ];
		String  dibujo  = "";
				
		for( int posicion = 0; posicion < cantidadTotalDeCartas; posicion++ )
		{
			//Creo un dibujo nuevo cada vez que consigo la cantidad de repeticiones que necesito para el tablero
			if( ( posicion % cantidadRepeticiones  ) == 0 )
				dibujo = String.format( "%c%c", 65 + posicion / dificultad.getCantidadColumnas(), 65 + posicion % dificultad.getCantidadColumnas() );			
				
			cartas[posicion] = new Carta( new String( dibujo ) ); 
		}
		
		return cartas;
	}

}
