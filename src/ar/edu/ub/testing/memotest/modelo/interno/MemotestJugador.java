package ar.edu.ub.testing.memotest.modelo.interno;

import ar.edu.ub.testing.memotest.modelo.Jugador;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestJugadorProximoEsMismoJugadorException;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestJugadorProximoEsNullException;

/**
 * MemotestJugador representa a un Jugador dentro del Memotest
 * @author wduartes
 *
 * Historial
 * ---------
 * 2018/04/08	wduartes	Aparecen las excepciones al tratar de 
 * 							settear como proximo jugador a si mismo o null
 */
public class MemotestJugador extends Jugador 
{

	private MemotestJugador proximoJugador;
	
	public MemotestJugador(Jugador jugador) 
	{
		super( jugador );	
		
		//Se inicializa por confianza en null sin usar el setter
		this.proximoJugador = null;
	}
	
	public void sumarPuntos( Integer puntos ) 
	{
		if( this.validadPuntosMayorCero( puntos ) )
			this.setPuntos( getPuntos() + puntos );
	}

	private boolean validadPuntosMayorCero(Integer puntos) 
	{
		return puntos > 0;
	}

	public MemotestJugador getProximoJugador() 
	{
		return proximoJugador;
	}

	public void setProximoJugador(MemotestJugador proximoJugador) 
	{
		if( proximoJugador == null )
			throw new MemotestJugadorProximoEsNullException();
		
		if( this == proximoJugador )
			throw new MemotestJugadorProximoEsMismoJugadorException();
		
		this.proximoJugador = proximoJugador;
	}	
}
