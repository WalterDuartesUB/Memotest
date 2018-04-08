package ar.edu.ub.testing.memotest.modelo.interno.testcase;

import ar.edu.ub.testing.memotest.modelo.Carta;
import ar.edu.ub.testing.memotest.modelo.exception.CartaSinCartaException;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestCarta;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestCartaVoltearCartaQuitadaException;
import junit.framework.TestCase;

public class TestMemotestCarta extends TestCase
{
	public void testMemotestCartaNull()
	{
		try
		{
			Carta carta = null;
			assertNull( new MemotestCarta(carta));
		}
		catch (CartaSinCartaException e)
		{
		}
	}
	
	public void testMemotestCartaDibujo()
	{
			
		String dibujoCarta = "ASD";
		Carta carta = new Carta( dibujoCarta );
		MemotestCarta memotestCarta = new MemotestCarta(carta);
			
		assertEquals(dibujoCarta, memotestCarta.getDibujo());
	}
	
	public void testMemotestCartaDibujoLomo()
	{
		
		String dibujoCarta = "ASD";
		String dibujoLomo = "DSA";
		Carta carta = new Carta( dibujoCarta, dibujoLomo );
		MemotestCarta memotestCarta = new MemotestCarta(carta);
		
		assertEquals(dibujoLomo, memotestCarta.getDibujoLomo());
	}
	
	
	public void testMemotestCartaSeCreaBocaAbajo()
	{
			
		String dibujoCarta = "ASD";
		Carta carta = new Carta( dibujoCarta );
		MemotestCarta memotestCarta = new MemotestCarta(carta);
			
		assertTrue( memotestCarta.estaBocaAbajo() );
		assertFalse( memotestCarta.estaBocaArriba() );
	}
	
	public void testMemotestCartaVoltearBocaArriba()
	{
		
		String dibujoCarta = "ASD";
		Carta carta = new Carta( dibujoCarta );
		MemotestCarta memotestCarta = new MemotestCarta(carta);
		
		memotestCarta.voltearBocaArriba();
		
		assertTrue( memotestCarta.estaBocaArriba() );
		assertFalse( memotestCarta.estaBocaAbajo() );
	}
	
	public void testMemotestCartaVoltearBocaArribaDosVeces()
	{
		
		String dibujoCarta = "ASD";
		Carta carta = new Carta( dibujoCarta );
		MemotestCarta memotestCarta = new MemotestCarta(carta);
		
		memotestCarta.voltearBocaArriba();
		memotestCarta.voltearBocaArriba();
		
		assertTrue( memotestCarta.estaBocaArriba() );
		assertFalse( memotestCarta.estaBocaAbajo() );
	}
	
	public void testMemotestCartaVoltearBocaAbajo()
	{
		
		String dibujoCarta = "ASD";
		Carta carta = new Carta( dibujoCarta );
		MemotestCarta memotestCarta = new MemotestCarta(carta);
		
		memotestCarta.voltearBocaArriba();
		memotestCarta.voltearBocaAbajo();
		
		assertFalse( memotestCarta.estaBocaArriba() );
		assertTrue( memotestCarta.estaBocaAbajo() );
	}
	
	public void testMemotestCartaVoltearBocaAbajoDosVeces()
	{
		
		String dibujoCarta = "ASD";
		Carta carta = new Carta( dibujoCarta );
		MemotestCarta memotestCarta = new MemotestCarta(carta);
				
		memotestCarta.voltearBocaAbajo();
		memotestCarta.voltearBocaAbajo();
		
		assertFalse( memotestCarta.estaBocaArriba() );
		assertTrue( memotestCarta.estaBocaAbajo() );
	}
	
	public void testMemotestCartaVoltearBocaArribaVariasVeces()
	{
		
		String dibujoCarta = "ASD";
		Carta carta = new Carta( dibujoCarta );
		MemotestCarta memotestCarta = new MemotestCarta(carta);
		
		memotestCarta.voltearBocaArriba();
		memotestCarta.voltearBocaAbajo();
		
		memotestCarta.voltearBocaArriba();
		memotestCarta.voltearBocaAbajo();
		
		memotestCarta.voltearBocaArriba();
		memotestCarta.voltearBocaAbajo();
		
		memotestCarta.voltearBocaArriba();
		
		assertTrue( memotestCarta.estaBocaArriba() );
		assertFalse( memotestCarta.estaBocaAbajo() );
	}
	
	public void testMemotestCartaVoltearBocaAbajoVariasVeces()
	{
		
		String dibujoCarta = "ASD";
		Carta carta = new Carta( dibujoCarta );
		MemotestCarta memotestCarta = new MemotestCarta(carta);
		
		memotestCarta.voltearBocaArriba();
		memotestCarta.voltearBocaAbajo();
		
		memotestCarta.voltearBocaArriba();
		memotestCarta.voltearBocaAbajo();
		
		memotestCarta.voltearBocaArriba();
		memotestCarta.voltearBocaAbajo();		
		
		assertFalse( memotestCarta.estaBocaArriba() );
		assertTrue( memotestCarta.estaBocaAbajo() );
	}

	public void testMemotestCartaQuitarCartaCreada()
	{
		
		String dibujoCarta = "ASD";
		Carta carta = new Carta( dibujoCarta );
		MemotestCarta memotestCarta = new MemotestCarta(carta);
		
		memotestCarta.quitarCarta();	
		
		assertFalse( memotestCarta.estaBocaArriba() );
		assertFalse( memotestCarta.estaBocaAbajo() );
	}
	
	public void testMemotestCartaQuitarCartaVolteadaBocaArriba()
	{
		
		String dibujoCarta = "ASD";
		Carta carta = new Carta( dibujoCarta );
		MemotestCarta memotestCarta = new MemotestCarta(carta);
		
		memotestCarta.voltearBocaArriba();
		memotestCarta.quitarCarta();	
		
		assertFalse( memotestCarta.estaBocaArriba() );
		assertFalse( memotestCarta.estaBocaAbajo() );
	}
	
	public void testMemotestCartaQuitarCartaVolteadaBocaAbajo()
	{
		
		String dibujoCarta = "ASD";
		Carta carta = new Carta( dibujoCarta );
		MemotestCarta memotestCarta = new MemotestCarta(carta);
		
		memotestCarta.voltearBocaArriba();
		memotestCarta.voltearBocaAbajo();
		memotestCarta.quitarCarta();	
		
		assertFalse( memotestCarta.estaBocaArriba() );
		assertFalse( memotestCarta.estaBocaAbajo() );
	}
	
	public void testMemotestCartaVoltearBocaAbajoCartaQuitada()
	{
		
		String dibujoCarta = "ASD";
		Carta carta = new Carta( dibujoCarta );
		MemotestCarta memotestCarta = new MemotestCarta(carta);
		
		memotestCarta.quitarCarta();	
		
		try
		{
			memotestCarta.voltearBocaAbajo();			
		}
		catch (MemotestCartaVoltearCartaQuitadaException e)
		{
			
		}
		
		assertFalse( memotestCarta.estaBocaArriba() );
		assertFalse( memotestCarta.estaBocaAbajo() );		
	}
	
	public void testMemotestCartaVoltearBocaArribaCartaQuitada()
	{
		
		String dibujoCarta = "ASD";
		Carta carta = new Carta( dibujoCarta );
		MemotestCarta memotestCarta = new MemotestCarta(carta);
		
		memotestCarta.quitarCarta();	
		
		try
		{
			memotestCarta.voltearBocaArriba();			
		}
		catch (MemotestCartaVoltearCartaQuitadaException e)
		{
			
		}
		
		assertFalse( memotestCarta.estaBocaArriba() );
		assertFalse( memotestCarta.estaBocaAbajo() );		
	}
		
}
