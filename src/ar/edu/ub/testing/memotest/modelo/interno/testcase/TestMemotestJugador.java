package ar.edu.ub.testing.memotest.modelo.interno.testcase;

import ar.edu.ub.testing.memotest.modelo.Jugador;
import ar.edu.ub.testing.memotest.modelo.exception.JugadorSinJugadorException;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestJugador;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestJugadorProximoEsMismoJugadorException;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestJugadorProximoEsNullException;
import junit.framework.TestCase;

public class TestMemotestJugador extends TestCase
{
	public void testJugadorNull()
	{
		try
		{
			Jugador jugador = null;
			assertNull( new MemotestJugador(jugador));
		}
		catch (JugadorSinJugadorException e)
		{
		
		}
	}
	
	public void testMemotestJugadorAlias()
	{
		String alias = "asd";
		MemotestJugador	jugador = new MemotestJugador( new Jugador( alias ) );
		
		assertEquals(alias, jugador.getAlias());
	}
	
	public void testMemotestJugadorPuntos()
	{
		String alias = "asd";
		MemotestJugador	jugador = new MemotestJugador( new Jugador( alias ) );
		
		assertEquals( new Integer(0), jugador.getPuntos() );
	}
	
	public void testMemotestJugadorCreadoProximoJugadorEsNull()
	{
		String alias = "asd";
		MemotestJugador	jugador = new MemotestJugador( new Jugador( alias ) );
		
		assertNull( jugador.getProximoJugador() );
	}
	
	public void testProximoJugadorNull()
	{
		try
		{
			MemotestJugador proximoJugador = null;
			MemotestJugador	jugador = new MemotestJugador( new Jugador( "asd" ) );
			
			jugador.setProximoJugador(proximoJugador);
			assertTrue( false );
		}
		catch (MemotestJugadorProximoEsNullException e)
		{
		
		}
	}	
	
	public void testProximoJugadorSelf()
	{
		try
		{
			
			MemotestJugador	jugador = new MemotestJugador( new Jugador( "asd" ) );
			MemotestJugador proximoJugador = jugador;
			
			jugador.setProximoJugador(proximoJugador);
			assertTrue( false );
		}
		catch (MemotestJugadorProximoEsMismoJugadorException e)
		{
			
		}
	}	
	
	public void testProximoJugador()
	{	
		MemotestJugador	jugador = new MemotestJugador( new Jugador( "asd" ) );
		MemotestJugador proximoJugador = new MemotestJugador( new Jugador( "dsa" ) );
		
		jugador.setProximoJugador(proximoJugador);
		
		assertEquals( proximoJugador, jugador.getProximoJugador() );
	}	
		
	public void testProximoJugadorAlias()
	{	
		MemotestJugador	jugador = new MemotestJugador( new Jugador( "asd" ) );
		MemotestJugador proximoJugador = new MemotestJugador( new Jugador( "dsa" ) );
		
		jugador.setProximoJugador(proximoJugador);
		
		assertEquals( proximoJugador.getAlias(), jugador.getProximoJugador().getAlias() );
	}	
	
	public void testSumarPuntos()
	{
		MemotestJugador	jugador = new MemotestJugador( new Jugador( "asd" ) );
		Integer puntosASumar = 100;
		
		jugador.sumarPuntos( puntosASumar );
	
		assertEquals( puntosASumar, jugador.getPuntos() );
	}
	
	public void testSumarPuntosNegativos()
	{
		MemotestJugador	jugador = new MemotestJugador( new Jugador( "asd" ) );
		Integer puntosASumar = -100;
		
		jugador.sumarPuntos( puntosASumar );
		
		assertEquals( new Integer(0), jugador.getPuntos() );
	}
	
	public void testSumarPuntosNegativos2()
	{
		MemotestJugador	jugador = new MemotestJugador( new Jugador( "asd" ) );
		Integer puntosASumar = 100;
		
		jugador.sumarPuntos( puntosASumar );
		jugador.sumarPuntos( -20 );
		
		assertEquals( puntosASumar, jugador.getPuntos() );
	}
	
	public void testSumarPuntosNegativos3()
	{
		MemotestJugador	jugador = new MemotestJugador( new Jugador( "asd" ) );
		Integer puntosASumar = 100;
		Integer puntosASumar2 = 150;
		Integer puntosASumarTotal = puntosASumar + puntosASumar2;
		
		jugador.sumarPuntos( puntosASumar );
		jugador.sumarPuntos( -20 );
		jugador.sumarPuntos( -10 );
		jugador.sumarPuntos( puntosASumar2 );
		
		assertEquals( puntosASumarTotal, jugador.getPuntos() );
	}
}
