package ar.edu.ub.testing.memotest.modelo.testcase;

import ar.edu.ub.testing.memotest.modelo.Jugador;
import ar.edu.ub.testing.memotest.modelo.exception.JugadorSinAliasException;
import junit.framework.TestCase;

public class TestJugador extends TestCase
{
	public void testJugadorAliasNull()
	{
		try
		{
			assertNotNull( new Jugador( null ) );
		}
		catch (JugadorSinAliasException e)
		{
		}
	}
	
	public void testJugadorAliasVacio()
	{
		try
		{
			assertNotNull( new Jugador( "" ) );
		}
		catch (JugadorSinAliasException e)
		{
		}
	}
	
	public void testJugadorAliasEspacioEnBlanco()
	{
		try
		{
			assertNotNull( new Jugador( " " ) );
		}
		catch (JugadorSinAliasException e)
		{
		}
	}
	
	public void testJugadorAlias()
	{
		String alias = "asd";
		Jugador jugador = new Jugador( alias );
		
		assertEquals(alias, jugador.getAlias() );
	}	
	
	public void testJugadorPuntos()
	{
		String alias = "asd";
		Jugador jugador = new Jugador( alias );
		
		assertEquals( new Integer( 0 ), jugador.getPuntos() );
	}	
}
