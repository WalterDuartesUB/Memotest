package ar.edu.ub.testing.memotest.consola.testingutils.testcase;

import ar.edu.ub.testing.memotest.consola.testingutils.ConsolaTecladoEmulada;
import ar.edu.ub.testing.memotest.consola.testingutils.exception.ConsolaTecladoEmuladaNoHayInputsException;
import ar.edu.ub.testing.memotest.consola.testingutils.exception.ConsolaTecladoEmuladaNoHayMasInputsException;
import junit.framework.TestCase;

public class TestConsolaTecladoEmulada extends TestCase
{
	public void testArrayInputNull()
	{
		try
		{
			String[] inputsEmulados = null;
			
			assertNull( new ConsolaTecladoEmulada( inputsEmulados ) );
		}
		catch (ConsolaTecladoEmuladaNoHayInputsException e)
		{			
		}		
	}
	
	public void testArrayInputVacio()
	{
		try
		{
			String[] inputsEmulados = new String[] {};
			
			assertNull( new ConsolaTecladoEmulada( inputsEmulados ) );
		}
		catch (ConsolaTecladoEmuladaNoHayInputsException e)
		{			
		}		
	}
	
	public void testArrayInputAlgunNull()
	{
		try
		{
			String[] inputsEmulados = new String[] {"asd", null, "dsa"};
			
			assertNull( new ConsolaTecladoEmulada( inputsEmulados ) );
		}
		catch (ConsolaTecladoEmuladaNoHayInputsException e)
		{			
		}		
	}
	
	public void testArrayInputTodosValidos()
	{
		String[] inputsEmulados = new String[] {"asd", "123", "dsa"};
		ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada( inputsEmulados );
		
		for( int posicion = 0; posicion < inputsEmulados.length; posicion++ )
		{
			assertEquals( inputsEmulados[posicion], consola.nextLine() );
		}
		
	}
	
	public void testArrayInputPedirMasInputsQueLosCargados()
	{
		
		String[] inputsEmulados = new String[] {"asd", "123", "dsa"};
		ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada( inputsEmulados );
		
		for( int posicion = 0; posicion < inputsEmulados.length; posicion++ )
		{
			consola.nextLine();
		}
		
		try
		{
			consola.nextLine();
			
			assertTrue(false);
		}
		catch (ConsolaTecladoEmuladaNoHayMasInputsException e)
		{
			
		}
		
		
	}
}
