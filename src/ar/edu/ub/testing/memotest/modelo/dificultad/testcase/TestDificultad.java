package ar.edu.ub.testing.memotest.modelo.dificultad.testcase;

import ar.edu.ub.testing.memotest.modelo.dificultad.Dificultad;
import ar.edu.ub.testing.memotest.modelo.dificultad.exception.DificultadSinCantidadColumnasException;
import ar.edu.ub.testing.memotest.modelo.dificultad.exception.DificultadSinNombreException;
import junit.framework.TestCase;

public class TestDificultad extends TestCase
{
	
	///////////////////////////////////////////////////////////////////////////
	// Pruebo el campo nombre
	
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
	
	
	public void testDificultadNombre()
	{	
		String nombre = "dificultad";
		Dificultad dificultad = new Dificultad( nombre, 1, 2 );
		assertEquals( nombre , dificultad.getNombre() );		
	}	
	
	///////////////////////////////////////////////////////////////////////////
	// Pruebo el campo columna
	
	
	public void testDificultadColumnasNull()
	{
		try
		{
			assertNull( new Dificultad( "dificultad", 1, null ) );
		} 
		catch (DificultadSinCantidadColumnasException e)
		{
			
		}		
	}
	
	public void testDificultadColumnasCero()
	{
		try
		{
			assertNull( new Dificultad( "dificultad", 1, 0 ) );
		} 
		catch (DificultadSinCantidadColumnasException e)
		{
			
		}		
	}	
	
	public void testDificultadColumnasNegativo()
	{
		try
		{
			assertNull( new Dificultad( "dificultad", 1, -2 ) );
		} 
		catch (DificultadSinCantidadColumnasException e)
		{
			
		}		
	}
		
}
