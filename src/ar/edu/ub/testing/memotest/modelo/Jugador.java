package ar.edu.ub.testing.memotest.modelo;

/**
 * Jugador representa la informacion de un jugador
 * @author wduartes
 *
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

	public String getAlias() 
	{
		return alias;
	}

	private void setAlias(String alias) 
	{
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
