package ar.edu.ub.testing.memotest.consola.testcase;

import ar.edu.ub.testing.memotest.consola.Consola;
import ar.edu.ub.testing.memotest.consola.MemotestConsola;
import ar.edu.ub.testing.memotest.consola.testingutils.ConsolaTecladoEmulada;
import ar.edu.ub.testing.memotest.modelo.Jugador;
import ar.edu.ub.testing.memotest.modelo.Memotest;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestCreadorTablero;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestCreadorTableroNoMezclado;
import junit.framework.TestCase;

public class TestMemotestConsola extends TestCase
{
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	public void testJugarFacilEmpate()
	{
		Consola                consola = new ConsolaTecladoEmulada( new String[] { 
																					//Elijo la dificultad facil
																					"1", 
																					
																					//Jugador 1 - carta ok
																					"1", "1", "1","2","N",
																					
																					//Jugador 2 - carta ok
																					"1", "3", "1","4","N",
																					
																					//Jugador 1 - carta ok
																					"2", "1", "2","2","N",
																					
																					//Jugador 2 - carta ok																					
																					"2", "3", "2","4","N",
																					
																					//Jugador 1 - carta ok
																					"3", "1", "3","2","N",
																					
																					//Jugador 2 - carta ok
																					"3", "3", "3","4","N",
																					
																					//Jugador 1 - carta ok
																					"4", "1", "4","2","N",
																					
																					//Jugador 2 - carta ok
																					"4", "3", "4","4","N",
																					
																					//Elijo salir de la aplicacion
																					"S"
																				});
		
		MemotestCreadorTablero creadorDeTablero = new MemotestCreadorTableroNoMezclado();			
		MemotestConsola        memotest = new MemotestConsola( consola, creadorDeTablero )
		{			
			@Override
			protected void mostrarJugadoresOrdenadosPorPuntos(Memotest memotest)
			{
				//Verifico que el primer jugador tenga los mismos puntos que el segundo
				Jugador[] jugadores = memotest.jugadoresOrdenadosPorPuntos();
				
				//Verifico que los puntos esten bien
				assertEquals( jugadores[0].getPuntos(), jugadores[1].getPuntos() );						
				assertEquals( new Integer( 12 ), jugadores[0].getPuntos() );
				
				//Verifico que no sean el mismo jugador
				assertNotSame( jugadores[0], jugadores[1] );
			}
		};	
		
		//
		
		try
		{
			memotest.jugar();
						
		}
		catch (RuntimeException e)
		{
			assertTrue( false );
		}	
	}
	
	///////////////////////////////////////////////////////////////////////////
	//
		
	public void testJugarFacilGanaJugador1()
	{
		Consola                consola = new ConsolaTecladoEmulada( new String[] { 
																				//Elijo la dificultad facil
																				"1", 
																				
																				//Jugador 1 - carta ok
																				"1", "1", "1","2","N",
																				
																				//Jugador 2 - carta error
																				"1", "3", "2","4","N",
																				
																				//Jugador 1 - carta ok
																				"1", "3", "1","4","N",
																				
																				//Jugador 1 - carta ok
																				"2", "1", "2","2","N",
																				
																				//Jugador 2 - carta ok																					
																				"2", "3", "2","4","N",
																				
																				//Jugador 1 - carta ok
																				"3", "1", "3","2","N",
																				
																				//Jugador 2 - carta ok
																				"3", "3", "3","4","N",
																				
																				//Jugador 1 - carta ok
																				"4", "1", "4","2","N",
																				
																				//Jugador 2 - carta ok
																				"4", "3", "4","4","N",
																				
																				//Elijo salir de la aplicacion
																				"S"
																		});
		
		MemotestCreadorTablero creadorDeTablero = new MemotestCreadorTableroNoMezclado();			
		MemotestConsola        memotest = new MemotestConsola( consola, creadorDeTablero )
		{			
			@Override
			protected void mostrarJugadoresOrdenadosPorPuntos(Memotest memotest)
			{
				//Verifico que el primer jugador tenga los mismos puntos que el segundo
				Jugador[] jugadoresPorPuntos = memotest.jugadoresOrdenadosPorPuntos();
				Jugador[] jugadores = memotest.getJugadores();
				
				//Verifico los puntos de los jugadores
				assertTrue( jugadoresPorPuntos[0].getPuntos() > jugadoresPorPuntos[1].getPuntos() );
				assertEquals( new Integer(11), jugadoresPorPuntos[0].getPuntos() ); 
				assertEquals( new Integer(9), jugadoresPorPuntos[1].getPuntos() );
				
				//Veo que sean los mismos jugadores en orden
				assertEquals( jugadores[0], jugadoresPorPuntos[0] );
				assertEquals( jugadores[1], jugadoresPorPuntos[1] );
			}
		};	
		
		//
		
		try
		{
			memotest.jugar();
			
		}
		catch (RuntimeException e)
		{
			assertTrue( false );
		}			
	}
}
