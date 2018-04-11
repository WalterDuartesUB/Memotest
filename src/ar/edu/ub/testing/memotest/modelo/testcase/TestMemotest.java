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
		
		///////////////////////////////////////////////////////////////////////
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
		
		///////////////////////////////////////////////////////////////////////
		//Verifico que todos los jugadores sean los mismos
		
		Jugador[] jugadoresMemotest = memotest.getJugadores();
		
		for( int posicion = 0; posicion < jugadoresMemotest.length; posicion++ )
			assertEquals(jugadores[posicion].getAlias(), jugadoresMemotest[posicion].getAlias() ); 
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
	
	public void testEsJugadorTurnoNull()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertFalse( memotest.esJugadorDeTurno(null) );
	}	
	
	public void testPedirCartaFilaInvalida()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertNull( memotest.getCarta(-1, 0) );
	}
	
	public void testPedirCartaColumnaInvalida()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertNull( memotest.getCarta(0, -1) );
	}
	
	public void testPedirCartaFilaInvalida2()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertNull( memotest.getCarta(memotest.getCantidadFilas() + 100 , 0) );
	}
	
	public void testPedirCartaColumnaInvalida2()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertNull( memotest.getCarta(0, memotest.getCantidadColumnas() + 100 ) );
	}
	
	
	public void testEsCartaBocaArribaFilaInvalida()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertFalse( memotest.estaLaCartaBocaArriba(-1, 0) );
	}
	
	public void testEsCartaBocaArribaColumnaInvalida()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertFalse( memotest.estaLaCartaBocaArriba(0, -1) );
	}
	
	public void testEsCartaBocaArribaFilaInvalida2()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertFalse( memotest.estaLaCartaBocaArriba(memotest.getCantidadFilas() + 100 , 0) );
	}
	
	public void testEsCartaBocaArribaColumnaInvalida2()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertFalse( memotest.estaLaCartaBocaArriba(0, memotest.getCantidadColumnas() + 100 ) );
	}
	
	
	public void testEsCartaBocaAbajoFilaInvalida()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertFalse( memotest.estaLaCartaBocaAbajo(-1, 0) );
	}
	
	public void testEsCartaBocaAbajoColumnaInvalida()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertFalse( memotest.estaLaCartaBocaAbajo(0, -1) );
	}
	
	public void testEsCartaBocaAbajoFilaInvalida2()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertFalse( memotest.estaLaCartaBocaAbajo(memotest.getCantidadFilas() + 100 , 0) );
	}
	
	public void testEsCartaBocaAbajoColumnaInvalida2()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertFalse( memotest.estaLaCartaBocaAbajo(0, memotest.getCantidadColumnas() + 100 ) );
	}
	
	public void testEsCartaBocaAbajo()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertTrue( memotest.estaLaCartaBocaAbajo(0, 0 ) );
		assertFalse( memotest.estaLaCartaBocaArriba(0, 0 ) );
	}
	
	public void testEsCartaBocaAbajo2()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertTrue( memotest.estaLaCartaBocaAbajo( memotest.getCantidadFilas() - 1, memotest.getCantidadColumnas() - 1 ) );
		assertFalse( memotest.estaLaCartaBocaArriba( memotest.getCantidadFilas() - 1, memotest.getCantidadColumnas() - 1 ) );
	}
	
	public void testEsCartaBocaArriba()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		memotest.voltearCartaBocaArriba( 0, 0);
		
		assertFalse( memotest.estaLaCartaBocaAbajo(0, 0 ) );
		assertTrue( memotest.estaLaCartaBocaArriba(0, 0 ) );
	}
	
	public void testEsCartaBocaArriba2()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		memotest.voltearCartaBocaArriba(memotest.getCantidadFilas() - 1, memotest.getCantidadColumnas() - 1);
		
		assertFalse( memotest.estaLaCartaBocaAbajo( memotest.getCantidadFilas() - 1, memotest.getCantidadColumnas() - 1 ) );
		assertTrue( memotest.estaLaCartaBocaArriba( memotest.getCantidadFilas() - 1, memotest.getCantidadColumnas() - 1 ) );
	}
	
	
	public void testVoltearBocaArribaVariasVeces()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		memotest.voltearCartaBocaArriba( 0, 0);
		memotest.voltearCartaBocaArriba( 0, 0);
		memotest.voltearCartaBocaArriba( 0, 0);
		memotest.voltearCartaBocaArriba( 0, 0);
		memotest.voltearCartaBocaArriba( 0, 0);
		
		assertFalse( memotest.estaLaCartaBocaAbajo(0, 0 ) );
		assertTrue( memotest.estaLaCartaBocaArriba(0, 0 ) );
	}	
	
	public void testVoltearBocaArribaVariasVeces2()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		memotest.voltearCartaBocaArriba( 0, 0);
		memotest.voltearCartaBocaArriba( 0, 0);
		
		assertFalse( memotest.estaLaCartaBocaAbajo(0, 0 ) );
		assertTrue( memotest.estaLaCartaBocaArriba(0, 0 ) );
	}	
	
	public void testElegiSuficientesCartasMismaCarta()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertFalse( memotest.elegiSuficientesCartas() );
		
		memotest.voltearCartaBocaArriba( 0, 0);
		
		assertFalse( memotest.elegiSuficientesCartas() );
		
		memotest.voltearCartaBocaArriba( 0, 0);
		
		assertFalse( memotest.elegiSuficientesCartas() );
	}	
	
	public void testElegiSuficientesCartasDistintasCartas()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertFalse( memotest.elegiSuficientesCartas() );
		
		memotest.voltearCartaBocaArriba( 0, 0);
		
		assertFalse( memotest.elegiSuficientesCartas() );
		
		memotest.voltearCartaBocaArriba( 0, 1);
		
		assertTrue( memotest.elegiSuficientesCartas() );
	}	
	
	public void testElegiSuficientesCartasDistintasCartasSinSumarPuntos()
	{
		Dificultad dificultad = new DificultadFacil();
		Jugador[]  jugadores = new Jugador[] { new Jugador("J1"), new Jugador("J2") };
		MemotestCreadorTablero creadorTablero = new MemotestCreadorTableroNoMezclado();
		
		//
		
		Memotest memotest = Memotest.crearMemotest(dificultad, jugadores, creadorTablero);
		
		assertFalse( memotest.elegiSuficientesCartas() );
		
		memotest.voltearCartaBocaArriba( 0, 0);
		
		assertFalse( memotest.elegiSuficientesCartas() );
		
		memotest.voltearCartaBocaArriba( 0, 1);
		
		assertTrue( memotest.elegiSuficientesCartas() );
		
		memotest.voltearCartaBocaArriba( 0, 2);
		

		assertTrue( memotest.estaLaCartaBocaAbajo( 0, 2) );
		assertFalse( memotest.estaLaCartaBocaArriba( 0, 2) );
		assertTrue( memotest.elegiSuficientesCartas() );

	}	
}
