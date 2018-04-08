package ar.edu.ub.testing.memotest.modelo.interno;

import ar.edu.ub.testing.memotest.modelo.Jugador;

/**
 * MemotestJugador representa a un Jugador dentro del Memotest
 * @author wduartes
 *
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
		this.proximoJugador = proximoJugador;
	}	
}
