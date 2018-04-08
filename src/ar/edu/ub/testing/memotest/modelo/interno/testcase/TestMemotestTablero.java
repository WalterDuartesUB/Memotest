package ar.edu.ub.testing.memotest.modelo.interno.testcase;

import ar.edu.ub.testing.memotest.modelo.interno.MemotestTablero;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestTableroCantidadColumnasInvalidaException;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestTableroCantidadFilasInvalidaException;
import junit.framework.TestCase;

public class TestMemotestTablero extends TestCase
{
	///////////////////////////////////////////////////////////////////////////
	// Test de constructor
	
	public void testCrearTableroFilaColumnaNull()
	{
		try
		{
			assertNull( new MemotestTablero( null, null) );
		}
		catch (MemotestTableroCantidadFilasInvalidaException e)
		{
		}
		catch (MemotestTableroCantidadColumnasInvalidaException e)
		{
		}		
	}
	
	public void testCrearTableroFilaColumnaCero()
	{
		try
		{
			assertNull( new MemotestTablero( 0, 0) );
		}
		catch (MemotestTableroCantidadFilasInvalidaException e)
		{
		}
		catch (MemotestTableroCantidadColumnasInvalidaException e)
		{
		}		
	}
	
	public void testCrearTableroFilaColumnaNegativos()
	{
		try
		{
			assertNull( new MemotestTablero( -1, -2) );
		}
		catch (MemotestTableroCantidadFilasInvalidaException e)
		{
		}
		catch (MemotestTableroCantidadColumnasInvalidaException e)
		{
		}		
	}
	
	public void testCrearTableroFilaNull()
	{
		try
		{
			assertNull( new MemotestTablero( null, 8) );
		}
		catch (MemotestTableroCantidadFilasInvalidaException e)
		{
		}
	}
	
	public void testCrearTableroFilaCero()
	{
		try
		{
			assertNull( new MemotestTablero( 0, 8) );
		}
		catch (MemotestTableroCantidadFilasInvalidaException e)
		{
		}
	}
	
	public void testCrearTableroFilaNegativa()
	{
		try
		{
			assertNull( new MemotestTablero( -10, 8) );
		}
		catch (MemotestTableroCantidadFilasInvalidaException e)
		{
		}
	}
	
	public void testCrearTableroColumnaNull()
	{
		try
		{
			assertNull( new MemotestTablero( 10, null) );
		}
		catch (MemotestTableroCantidadColumnasInvalidaException e)
		{
		}
	}
	
	public void testCrearTableroColumnaCero()
	{
		try
		{
			assertNull( new MemotestTablero( 10, 0) );
		}
		catch (MemotestTableroCantidadColumnasInvalidaException e)
		{
		}
	}
	
	public void testCrearTableroColumnaNegativa()
	{
		try
		{
			assertNull( new MemotestTablero( 10, -8) );
		}
		catch (MemotestTableroCantidadColumnasInvalidaException e)
		{
		}
	}
	
	public void testCrearTablero()
	{
		try
		{
			assertNotNull( new MemotestTablero( 10, 8) );
		}
		catch (MemotestTableroCantidadFilasInvalidaException e)
		{
			assertTrue( false );
		}		
		catch (MemotestTableroCantidadColumnasInvalidaException e)
		{
			assertTrue( false );
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	// Test de fila
	
	public void testExisteFilaExisteCero()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		assertTrue( tablero.existeFila(0));
	}
	
	public void testExisteFilaNegativo()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		assertFalse( tablero.existeFila(-10));
	}
	
	public void testExisteFilaMayor()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		assertFalse( tablero.existeFila(10));
	}
	
	///////////////////////////////////////////////////////////////////////////
	// Test de columna
	
	public void testExisteFilaCantidadFila()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		assertFalse( tablero.existeFila( tablero.getCantidadFilas() ));
	}	
	
	public void testExisteColumnaExisteCero()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		assertTrue( tablero.existeColumna(0));
	}
	
	public void testExisteColumnaNegativo()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		assertFalse( tablero.existeColumna(-10));
	}
	
	public void testExisteColumnaMayor()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		assertFalse( tablero.existeColumna(10));
	}
	
	public void testExisteFilaCantidadColumna()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		assertFalse( tablero.existeColumna( tablero.getCantidadColumnas() ));
	}	
}
