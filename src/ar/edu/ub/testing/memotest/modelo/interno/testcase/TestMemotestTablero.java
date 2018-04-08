package ar.edu.ub.testing.memotest.modelo.interno.testcase;

import ar.edu.ub.testing.memotest.modelo.Carta;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestTablero;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestTableroCantidadColumnasInvalidaException;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestTableroCantidadFilasInvalidaException;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestTableroCartaNullException;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestTableroColumnaNoExisteException;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestTableroException;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestTableroFilaNoExisteException;
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
	
	public void testCrearTableroGetFila()
	{
		Integer cantidadFilas = 6;
		Integer cantidadColumnas = 9;
		
		MemotestTablero tablero = new MemotestTablero( cantidadFilas, cantidadColumnas );
		
		assertEquals(cantidadFilas, tablero.getCantidadFilas() );
	}
	
	public void testCrearTableroGetColumna()
	{
		Integer cantidadFilas = 6;
		Integer cantidadColumnas = 9;
		
		MemotestTablero tablero = new MemotestTablero( cantidadFilas, cantidadColumnas );
		
		assertEquals(cantidadColumnas, tablero.getCantidadColumnas() );
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
	
	///////////////////////////////////////////////////////////////////////////
	// Test de ponerCarta
	
	public void testPonerCartaNull()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		
		try
		{
			tablero.ponerCarta(0, 0, null);
			assertTrue( false );
		}
		catch (MemotestTableroCartaNullException e)
		{
		}
	}	
	
	public void testPonerCartaFilaInvalida()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		int fila = tablero.getCantidadFilas();
		int columna = 0;
		Carta carta = new Carta("X");
		
		try
		{			
			tablero.ponerCarta( fila, columna, carta);
			assertTrue( false );
		}
		catch (MemotestTableroFilaNoExisteException e)
		{
		}
	}	
	
	public void testPonerCartaFilaNegativa()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		int fila = -100;
		int columna = 0;
		Carta carta = new Carta("X");
		
		try
		{			
			tablero.ponerCarta( fila, columna, carta);
			assertTrue( false );
		}
		catch (MemotestTableroFilaNoExisteException e)
		{
		}
	}	
	
	public void testPonerCartaColumnaInvalida()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		int columna = tablero.getCantidadColumnas();
		int fila = 0;
		Carta carta = new Carta("X");
		
		try
		{			
			tablero.ponerCarta( fila, columna, carta);
			assertTrue( false );
		}
		catch (MemotestTableroColumnaNoExisteException e)
		{
		}
	}	
	
	public void testPonerCartaColumnaNegativa()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		int columna = -100;
		int fila = 0;
		Carta carta = new Carta("X");
		
		try
		{			
			tablero.ponerCarta( fila, columna, carta);
			assertTrue( false );
		}
		catch (MemotestTableroColumnaNoExisteException e)
		{
		}
	}	
	
	public void testPonerCarta()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		int columna = 0;
		int fila = 0;
		Carta carta = new Carta("X");
		
		try
		{			
			tablero.ponerCarta( fila, columna, carta);			
		}
		catch (MemotestTableroException e)
		{
			assertTrue( false );
		}
	}	
	
	///////////////////////////////////////////////////////////////////////////
	// Test de getCarta / getMemotestCarta
	
	public void testGetCartaIgual()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		int columna = 0;
		int fila = 0;
		Carta carta = new Carta("X");
		
		tablero.ponerCarta( fila, columna, carta);
		
		assertTrue( carta.esIgualA( tablero.getCarta(fila, columna) ) );
		
	}	
	
	public void testGetMemotestCartaIgual()
	{
		MemotestTablero tablero = new MemotestTablero(6, 6);
		int columna = 0;
		int fila = 0;
		Carta carta = new Carta("X");
		
		tablero.ponerCarta( fila, columna, carta);
		
		assertTrue( carta.esIgualA( tablero.getMemotestCarta(fila, columna) ) );
		
	}	
}
