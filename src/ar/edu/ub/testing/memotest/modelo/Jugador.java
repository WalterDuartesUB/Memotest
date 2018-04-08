package ar.edu.ub.testing.memotest.modelo;

import ar.edu.ub.testing.memotest.modelo.exception.JugadorSinAliasException;
import ar.edu.ub.testing.memotest.modelo.exception.JugadorSinJugadorException;

/**
 * Jugador representa la informacion de un jugador
 * @author wduartes
 *
 * Historial
 * ---------
 * 2018/04/08	wduartes	Se agrega la validacion para que el jugador tenga
 * 							un alias al crearse
 * 2018/04/08	wduartes	Aparece un constructor para crear un Jugador
 * 							basado en otro Jugador
 */
public class Jugador 
{
	private String alias;
	private Integer puntos;

	public Jugador(String alias) 
	{
		setAlias(alias);
		setPuntos(0);		
	}

	public Jugador(Jugador jugador)
	{
		if( jugador == null )
			throw new JugadorSinJugadorException();
		
		this.setAlias( jugador.getAlias() );
		this.setPuntos(0);
	}

	public String getAlias() 
	{
		return alias;
	}

	private void setAlias(String alias) 
	{
		if( alias == null || alias.trim().isEmpty() )
			throw new JugadorSinAliasException();
		
		this.alias = alias;
	}

	public Integer getPuntos() 
	{
		return puntos;
	}

	protected void setPuntos(Integer puntos) 
	{
		this.puntos = puntos;
	}

}
