package ar.edu.ub.testing.memotest.consola.menu.testcase;

import ar.edu.ub.testing.memotest.consola.menu.ConsolaMenuFinJuego;
import ar.edu.ub.testing.memotest.consola.menu.ConsolaMenuFinJuego.DecisionFinJuego;
import ar.edu.ub.testing.memotest.consola.testingutils.ConsolaTecladoEmulada;
import ar.edu.ub.testing.memotest.consola.testingutils.exception.ConsolaTecladoEmuladaNoHayMasInputsException;
import junit.framework.TestCase;

public class TestConsolaMenuFinJuego extends TestCase
{
	public void testOpcionesInvalidas()
	{
		ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada(  new String[]{ "1", "2", "3" } );
		
		try
		{
			ConsolaMenuFinJuego.mostrarMenu(consola);
			assertTrue( false );
		}
		catch (ConsolaTecladoEmuladaNoHayMasInputsException e)
		{
		}
		
	}
	
	public void testOpcionesVolverAJugar()
	{
		ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada(  new String[]{ "R" } );
		assertEquals( DecisionFinJuego.DFJ_JUGAR_REVANCHA_CON_LA_MISMA_DIFICULTAD, ConsolaMenuFinJuego.mostrarMenu(consola) );		
	}
	
	
	public void testOpcionesVolverAJugarEligiendoDificultad()
	{
		ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada(  new String[]{ "V" } );
		assertEquals( DecisionFinJuego.DFJ_JUGAR_JUEGO_NUEVO_ELIGIENDO_DIFICULTAD, ConsolaMenuFinJuego.mostrarMenu(consola) );		
	}
	
	
	public void testOpcionesSalir()
	{
		ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada(  new String[]{ "S" } );
		assertEquals( DecisionFinJuego.DFJ_SALIR_APLICACION, ConsolaMenuFinJuego.mostrarMenu(consola) );		
	}
	
	public void testOpcionesVolverAJugarDespuesDeAlgunasInvalidas()
	{
		ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada(  new String[]{ "1", "2", "3", "R" } );
		assertEquals( DecisionFinJuego.DFJ_JUGAR_REVANCHA_CON_LA_MISMA_DIFICULTAD, ConsolaMenuFinJuego.mostrarMenu(consola) );		
	}
	
	
	public void testOpcionesVolverAJugarEligiendoDificultadDespuesDeAlgunasInvalidas()
	{
		ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada(  new String[]{ "1", "2", "3", "V" } );
		assertEquals( DecisionFinJuego.DFJ_JUGAR_JUEGO_NUEVO_ELIGIENDO_DIFICULTAD, ConsolaMenuFinJuego.mostrarMenu(consola) );		
	}
	
	
	public void testOpcionesSalirDespuesDeAlgunasInvalidas()
	{
		ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada(  new String[]{ "1", "2", "3", "S" } );
		assertEquals( DecisionFinJuego.DFJ_SALIR_APLICACION, ConsolaMenuFinJuego.mostrarMenu(consola) );		
	}
	
}
