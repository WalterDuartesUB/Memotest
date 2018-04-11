package ar.edu.ub.testing.memotest.modelo.testcase;

import ar.edu.ub.testing.memotest.modelo.Jugador;
import ar.edu.ub.testing.memotest.modelo.Memotest;
import ar.edu.ub.testing.memotest.modelo.dificultad.Dificultad;
import ar.edu.ub.testing.memotest.modelo.dificultad.DificultadDificil;
import ar.edu.ub.testing.memotest.modelo.dificultad.DificultadFacil;
import ar.edu.ub.testing.memotest.modelo.dificultad.DificultadMedia;
import ar.edu.ub.testing.memotest.modelo.exception.MemotestSinCreadorDeTableroException;
import ar.edu.ub.testing.memotest.modelo.exception.MemotestSinDificultadException;
import ar.edu.ub.testing.memotest.modelo.exception.MemotestSinJugadoresException;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestCreadorTablero;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestCreadorTableroNoMezclado;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestCreadorTableroDificultadCantidadDeCopiasInvalidasException;
import junit.framework.TestCase;

public class TestMemotest extends TestCase
{
	
	public void testCrearDificultadNull()
	{
		Dificultad dificultad = null;
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		try
		{
			Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
			assertTrue( false );
		}
		catch ( MemotestSinDificultadException e)
		{
			
		}
	}
	
	public void testCrearJugadoresNull()
	{
		Dificultad dificultad = new Dificultad("Una dificultad", 4, 4);
		Jugador[]  jugadores = null;
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		try
		{
			Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
			assertTrue( false );
		}
		catch ( MemotestSinJugadoresException e)
		{
			
		}
	}
	
	public void testCrearCreadorDeTablerosNull()
	{
		Dificultad dificultad = new Dificultad("Una dificultad", 4, 4);
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = null;
		
		try
		{
			Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
			assertTrue( false );
		}
		catch ( MemotestSinCreadorDeTableroException e)
		{
			
		}
	}
	
	public void testCrearUnSoloJugador()
	{
		Dificultad dificultad = new Dificultad("Una dificultad", 4, 4);
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		try
		{
			Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
			assertTrue( false );
		}
		catch ( MemotestSinJugadoresException e)
		{
			
		}
	}
	
	public void testCrearAlgunJugadorNull()
	{
		Dificultad dificultad = new Dificultad("Una dificultad", 4, 4);
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), null };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		try
		{
			Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
			assertTrue( false );
		}
		catch ( MemotestSinJugadoresException e)
		{
			
		}
	}
	
	public void testCrearTodosJugadorNull()
	{
		Dificultad dificultad = new Dificultad("Una dificultad", 4, 4);
		Jugador[]  jugadores = new Jugador[] { null, null };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		try
		{
			Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
			assertTrue( false );
		}
		catch ( MemotestSinJugadoresException e)
		{
			
		}
	}
	
	public void testCrearJugadoresVacios()
	{
		Dificultad dificultad = new Dificultad("Una dificultad", 4, 4);
		Jugador[]  jugadores = new Jugador[] { };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		try
		{
			Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
			assertTrue( false );
		}
		catch ( MemotestSinJugadoresException e)
		{
			
		}
	}
	
	public void testCrearDificultadInvalida1()
	{
		Dificultad dificultad = new Dificultad("Una dificultad", 3, 5);
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		try
		{
			Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
			assertTrue( false );
		}
		catch ( MemotestCreadorTableroDificultadCantidadDeCopiasInvalidasException e)
		{
			
		}
	}	
	
	public void testCrearDificultadInvalida2()
	{
		Dificultad dificultad = new Dificultad("Una dificultad", 7, 1);
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		try
		{
			Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
			assertTrue( false );
		}
		catch ( MemotestCreadorTableroDificultadCantidadDeCopiasInvalidasException e)
		{
			
		}
	}	
	public void verificarMemotestEstadoInicial( Dificultad dificultad )
	{
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		//
		
		assertNotNull( memotest );
		assertTrue( memotest.tengoCartasParaVoltear() );
		assertFalse( memotest.elegiSuficientesCartas() );
		assertFalse( memotest.sumarPuntosAlJugadorDeTurno() );
		
		assertEquals( dificultad.getCantidadColumnas(), memotest.getCantidadColumnas());
		assertEquals( dificultad.getCantidadFilas(), memotest.getCantidadFilas() );		
		
		assertEquals( jugadores.length, memotest.getJugadores().length );
		assertEquals( jugadores.length, memotest.jugadoresOrdenadosPorPuntos().length );
		assertTrue( memotest.esJugadorDeTurno( memotest.getJugadores()[0] ) );
		
		//Veo que todas las cartas esten boca abajo
		for( int fila = 0; fila < memotest.getCantidadFilas(); fila++ )
		{
			for( int columna = 0; columna < memotest.getCantidadColumnas(); columna++ )
			{
				assertTrue( memotest.estaLaCartaBocaAbajo(fila, columna));
				assertFalse( memotest.estaLaCartaBocaArriba(fila, columna));
				assertNotNull( memotest.getCarta(fila, columna));				
			}
		}			
	}
	
	public void testCrearDificultadFacil()
	{
		verificarMemotestEstadoInicial( new DificultadFacil() );
	}	
	
	public void testCrearDificultadMedio()
	{
		verificarMemotestEstadoInicial( new DificultadMedia() );
	}	
	
	public void testCrearDificultadDificil()
	{
		verificarMemotestEstadoInicial( new DificultadDificil() );
	}	
	
	public void verificarCambioJugadorTurno( Dificultad dificultad)
	{

		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		//Pido la lista de jugadores del memotest y veo que cambien segun el jugador de turno
		jugadores = memotest.getJugadores();

		//Verifico que sea el primero el del turno
		assertTrue( memotest.esJugadorDeTurno(jugadores[0]));
		assertFalse( memotest.esJugadorDeTurno(jugadores[1]));
		
		//Paso al segundo
		memotest.cambiarJugadorDeTurno();
		
		assertFalse( memotest.esJugadorDeTurno(jugadores[0]));
		assertTrue( memotest.esJugadorDeTurno(jugadores[1]));
		
		//Vuelvo al primer jugador
		memotest.cambiarJugadorDeTurno();
		assertTrue( memotest.esJugadorDeTurno(jugadores[0]));
		assertFalse( memotest.esJugadorDeTurno(jugadores[1]));			
	}
	
	public void testCambioJugadorTurnoFacil()
	{
		verificarCambioJugadorTurno( new DificultadFacil() );	
	}
	
	public void testCambioJugadorTurnoMedia()
	{
		verificarCambioJugadorTurno( new DificultadMedia() );	
	}
	
	public void testCambioJugadorTurnoDificil()
	{
		verificarCambioJugadorTurno( new DificultadDificil() );	
	}
}
