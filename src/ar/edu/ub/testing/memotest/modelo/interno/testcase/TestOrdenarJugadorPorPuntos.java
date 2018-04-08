package ar.edu.ub.testing.memotest.modelo.interno.testcase;

import ar.edu.ub.testing.memotest.modelo.Jugador;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestJugador;
import ar.edu.ub.testing.memotest.modelo.interno.OrdenarJugadorPorPuntos;
import junit.framework.TestCase;

public class TestOrdenarJugadorPorPuntos extends TestCase
{
	public void testCompareMenor()
	{
		MemotestJugador jugador = new MemotestJugador( new Jugador("J1") );
		MemotestJugador jugador2 = new MemotestJugador( new Jugador("J2") );
		OrdenarJugadorPorPuntos comparador = new OrdenarJugadorPorPuntos();
		
		jugador.sumarPuntos( 100 );
		jugador2.sumarPuntos( 1 );
		
		assertTrue( comparador.compare( jugador, jugador2) < 0 );
	}
	
	public void testCompareMayor()
	{
		MemotestJugador jugador = new MemotestJugador( new Jugador("J1") );
		MemotestJugador jugador2 = new MemotestJugador( new Jugador("J2") );
		OrdenarJugadorPorPuntos comparador = new OrdenarJugadorPorPuntos();
		
		jugador.sumarPuntos( 1 );
		jugador2.sumarPuntos( 100 );
		
		assertTrue( comparador.compare( jugador, jugador2) > 0 );
	}
	
	public void testCompareIgual()
	{
		MemotestJugador jugador = new MemotestJugador( new Jugador("J1") );
		
		OrdenarJugadorPorPuntos comparador = new OrdenarJugadorPorPuntos();
		
		jugador.sumarPuntos( 1 );
		
		
		assertTrue( comparador.compare( jugador, jugador) == 0 );
	}
}
