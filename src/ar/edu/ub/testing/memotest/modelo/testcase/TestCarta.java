package ar.edu.ub.testing.memotest.modelo.testcase;

import ar.edu.ub.testing.memotest.modelo.Carta;
import ar.edu.ub.testing.memotest.modelo.exception.CartaSinDibujoException;
import ar.edu.ub.testing.memotest.modelo.exception.CartaSinDibujoLomoException;
import junit.framework.TestCase;

public class TestCarta extends TestCase
{
	public void testCartaSinDibujo()
	{
		try
		{
			assertNull( new Carta( null ) );
		}
		catch (CartaSinDibujoException e)
		{
			
		}
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
}
