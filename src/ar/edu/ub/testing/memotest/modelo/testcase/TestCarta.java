package ar.edu.ub.testing.memotest.modelo.testcase;

import ar.edu.ub.testing.memotest.modelo.Carta;
import ar.edu.ub.testing.memotest.modelo.exception.CartaSinCartaException;
import ar.edu.ub.testing.memotest.modelo.exception.CartaSinDibujoException;
import ar.edu.ub.testing.memotest.modelo.exception.CartaSinDibujoLomoException;
import junit.framework.TestCase;

public class TestCarta extends TestCase
{
	public void testCartaSinDibujo()
	{
		try
		{
			String dibujo = null;
			assertNull( new Carta( dibujo ) );
		}
		catch (CartaSinDibujoException e)
		{
			
		}
	}
	
	public void testCartaSinCarta()
	{
		try
		{
			Carta unaCarta = null;
			assertNull( new Carta( unaCarta ) );
		}
		catch (CartaSinCartaException e)
		{
			
		}
	}
	
	public void testCartaConCartaDibujo()
	{
		String dibujoCarta = "DASC";
		Carta unaCarta = new Carta( dibujoCarta );
		Carta otraCarta = new Carta( unaCarta );
		
		assertEquals(dibujoCarta, unaCarta.getDibujo() );
		assertEquals(dibujoCarta, otraCarta.getDibujo() );
	}
	
	public void testCartaConCartaDibujoYLomo()
	{
		String dibujoCarta = "DASC";
		String dibujoLomo = "DFAS";
		Carta unaCarta = new Carta( dibujoCarta, dibujoLomo );
		Carta otraCarta = new Carta( unaCarta );
		
		assertEquals(dibujoCarta, otraCarta.getDibujo() );
		assertEquals(dibujoLomo, otraCarta.getDibujoLomo() );
	}
	
	public void testCartaConDibujoSinDibujoLomo()
	{
		try
		{
			assertNull( new Carta( "?", null ) );
		}
		catch (CartaSinDibujoLomoException e)
		{
		}
	}	
	
	public void testCartaSinDibujoSinDibujoLomo()
	{
		try
		{
			assertNull( new Carta( null, null ) );
		}
		catch (CartaSinDibujoException e)
		{
		}
		catch (CartaSinDibujoLomoException e)
		{
		}
	}	
	
	public void testCartaConDibujo()
	{
		String dibujoCarta = "ABC";
		Carta carta = new Carta( dibujoCarta );
		
		assertEquals( dibujoCarta, carta.getDibujo());
	}	
		
	public void testCartaConDibujoConDibujoLomo()
	{
		String dibujoLomo = "ABC";
		String dibujoCarta = "DCA";
		Carta carta = new Carta( dibujoCarta, dibujoLomo );
		
		assertEquals( dibujoCarta, carta.getDibujo());
		assertEquals( dibujoLomo, carta.getDibujoLomo());
	}	
	
	///////////////////////////////////////////////////////////////////////////
	//Pruebas del metodo esIgualA
	
	public void testCartaEsIgualANull()
	{
		String dibujoCarta = "ABC";
		Carta carta = new Carta( dibujoCarta );
		
		assertFalse( carta.esIgualA( null ) );
	}		
	
	public void testCartaEsIgualASiMismo()
	{
		String dibujoCarta = "ABC";
		Carta carta = new Carta( dibujoCarta );
		
		assertTrue( carta.esIgualA( carta ) );
	}
	
	public void testCartaEsIgualAOtraCartaIgual()
	{
		String dibujoCarta = "ABC";
		Carta carta = new Carta( dibujoCarta );
		Carta carta2 = new Carta( dibujoCarta );
		
		assertTrue( carta.esIgualA( carta2 ) );
	}
	
	public void testCartaEsIgualAUnaCartaDistina()
	{
		String dibujoCarta = "ABC";
		String dibujoCarta2 = "ABCD";
		
		Carta carta = new Carta( dibujoCarta );
		Carta carta2 = new Carta( dibujoCarta2 );
		
		assertFalse( carta.esIgualA( carta2 ) );
	}		
	
	public void testCartaEsIgualAOtraCartaIgualConDistintoLomo()
	{
		String dibujoCarta = "ABC";
		
		String dibujoLomo = "F";
		String dibujoLomo2 = "H";
		
		Carta carta = new Carta( dibujoCarta, dibujoLomo );
		Carta carta2 = new Carta( dibujoCarta, dibujoLomo2 );
		
		assertTrue( carta.esIgualA( carta2 ) );
	}	
	
	public void testCartaEsIgualAUnaCartaDistinaConDistintoLomo()
	{
		String dibujoCarta = "ABC";
		String dibujoCarta2 = "ABCD";
		
		String dibujoLomo = "123";
		String dibujoLomo2 = "bas";
		
		Carta carta = new Carta( dibujoCarta, dibujoLomo );
		Carta carta2 = new Carta( dibujoCarta2, dibujoLomo2 );
		
		assertFalse( carta.esIgualA( carta2 ) );
	}		
		
}
