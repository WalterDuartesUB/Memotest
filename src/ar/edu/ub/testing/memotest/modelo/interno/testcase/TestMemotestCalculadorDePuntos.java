package ar.edu.ub.testing.memotest.modelo.interno.testcase;

import ar.edu.ub.testing.memotest.modelo.Carta;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestCalculadorDePuntos;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestCarta;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestCalculadorDePuntosNoHayCartasException;
import junit.framework.TestCase;

public class TestMemotestCalculadorDePuntos extends TestCase
{
	public void testSumarNull()
	{
		MemotestCalculadorDePuntos calculador = new MemotestCalculadorDePuntos();
		
		try
		{			
			calculador.calcular( null );
			assertTrue( false );
		}
		catch (MemotestCalculadorDePuntosNoHayCartasException e)
		{
	
		}
		
	}
	
	public void testSumarVacio()
	{
		MemotestCalculadorDePuntos calculador = new MemotestCalculadorDePuntos();
		
		try
		{			
			calculador.calcular( new MemotestCarta[] {} );
			assertTrue( false );
		}
		catch (MemotestCalculadorDePuntosNoHayCartasException e)
		{
			
		}
		
	}
	
	public void testSumarCartaNull()
	{
		MemotestCalculadorDePuntos calculador = new MemotestCalculadorDePuntos();
		
		try
		{			
			calculador.calcular( new MemotestCarta[] { null } );
			assertTrue( false );
		}
		catch (MemotestCalculadorDePuntosNoHayCartasException e)
		{
			
		}
		
	}
	
	public void testSumarCartaConAlgunNull()
	{
		MemotestCalculadorDePuntos calculador = new MemotestCalculadorDePuntos();
		
		try
		{			
			calculador.calcular( new MemotestCarta[] { new MemotestCarta( new Carta("X" ) ), null } );
			assertTrue( false );
		}
		catch (MemotestCalculadorDePuntosNoHayCartasException e)
		{
			
		}
		
	}
	
	public void testSumarCartasBocaAbajo()
	{
		MemotestCalculadorDePuntos calculador = new MemotestCalculadorDePuntos();
		MemotestCarta[] cartas = new MemotestCarta[] { new MemotestCarta( new Carta("X") ),  new MemotestCarta( new Carta("Y") ) }; 
		try
		{			
			
			cartas[0].voltearBocaAbajo();
			cartas[1].voltearBocaAbajo();
			
			calculador.calcular( cartas );
			assertTrue( false );
		}
		catch (MemotestCalculadorDePuntosNoHayCartasException e)
		{
			
		}
		
	}
	
	public void testSumarCartasAlgunaBocaAbajo()
	{
		MemotestCalculadorDePuntos calculador = new MemotestCalculadorDePuntos();
		MemotestCarta[] cartas = new MemotestCarta[] { new MemotestCarta( new Carta("X") ),  new MemotestCarta( new Carta("Y") ) }; 
		try
		{			
			
			cartas[0].voltearBocaArriba();
			cartas[1].voltearBocaArriba();
			cartas[1].voltearBocaAbajo();
			
			calculador.calcular( cartas );
			assertTrue( false );
		}
		catch (MemotestCalculadorDePuntosNoHayCartasException e)
		{
			
		}
		
	}
	
	public void testSumarCartasAlgunaQuitada()
	{
		MemotestCalculadorDePuntos calculador = new MemotestCalculadorDePuntos();
		MemotestCarta[] cartas = new MemotestCarta[] { new MemotestCarta( new Carta("X") ),  new MemotestCarta( new Carta("Y") ) }; 
		try
		{			
			
			cartas[0].voltearBocaArriba();
			cartas[1].quitarCarta();
			
			calculador.calcular( cartas );
			assertTrue( false );
		}
		catch (MemotestCalculadorDePuntosNoHayCartasException e)
		{
			
		}
		
	}
	
	public void testSumarCartasBocaArribaUnaVez()
	{
		MemotestCalculadorDePuntos calculador = new MemotestCalculadorDePuntos();
		MemotestCarta[] cartas = new MemotestCarta[] { new MemotestCarta( new Carta("X") ),  new MemotestCarta( new Carta("Y") ) }; 
						
		cartas[0].voltearBocaArriba();
		cartas[1].voltearBocaArriba();
		
		assertEquals( MemotestCalculadorDePuntos.getCantidadPuntosUnaVez(), calculador.calcular( cartas ) );	
		
	}
	
	public void testSumarCartasBocaArribaAlgunaMasDeUnaVez()
	{
		MemotestCalculadorDePuntos calculador = new MemotestCalculadorDePuntos();
		MemotestCarta[] cartas = new MemotestCarta[] { new MemotestCarta( new Carta("X") ),  new MemotestCarta( new Carta("Y") ) }; 
		
		cartas[0].voltearBocaArriba();
		cartas[0].voltearBocaAbajo();
		cartas[0].voltearBocaArriba();
		
		cartas[1].voltearBocaArriba();
		
		assertEquals( MemotestCalculadorDePuntos.getCantidadPuntosMasDeUnaVez(), calculador.calcular( cartas ) );	
		
	}
	
	public void testSumarCartasBocaArribaMasDeUnaVez()
	{
		MemotestCalculadorDePuntos calculador = new MemotestCalculadorDePuntos();
		MemotestCarta[] cartas = new MemotestCarta[] { new MemotestCarta( new Carta("X") ),  new MemotestCarta( new Carta("Y") ) }; 
		
		cartas[0].voltearBocaArriba();
		cartas[0].voltearBocaAbajo();
		cartas[0].voltearBocaArriba();
		
		cartas[1].voltearBocaArriba();
		cartas[1].voltearBocaAbajo();
		cartas[1].voltearBocaArriba();
		cartas[1].voltearBocaAbajo();
		cartas[1].voltearBocaArriba();
		
		assertEquals( MemotestCalculadorDePuntos.getCantidadPuntosMasDeUnaVez(), calculador.calcular( cartas ) );	
		
	}
}
