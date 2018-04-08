package ar.edu.ub.testing.memotest.modelo.dificultad.testcase;

import ar.edu.ub.testing.memotest.modelo.dificultad.Dificultad;
import ar.edu.ub.testing.memotest.modelo.dificultad.exception.DificultadSinNombreException;
import junit.framework.TestCase;

public class TestDificultad extends TestCase
{
	public void testDificultadNombreNull()
	{
		try
		{
			assertNull( new Dificultad( null, 1, 2 ) );
		} 
		catch (DificultadSinNombreException e)
		{
			
		}		
	}
	
	public void testDificultadNombreVacio()
	{
		try
		{
			assertNull( new Dificultad( "", 1, 2 ) );
		} 
		catch (DificultadSinNombreException e)
		{
			
		}		
	}	
	
	public void testDificultadNombreEspacioEnBlanco()
	{
		try
		{
			assertNull( new Dificultad( " ", 1, 2 ) );
		} 
		catch (DificultadSinNombreException e)
		{
			
		}		
	}		
}
