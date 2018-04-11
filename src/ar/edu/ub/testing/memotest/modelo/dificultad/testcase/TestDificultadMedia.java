package ar.edu.ub.testing.memotest.modelo.dificultad.testcase;

import ar.edu.ub.testing.memotest.modelo.dificultad.Dificultad;
import ar.edu.ub.testing.memotest.modelo.dificultad.DificultadMedia;
import junit.framework.TestCase;

public class TestDificultadMedia extends TestCase
{
	public void testCreacion()
	{
		Dificultad dificultad = new DificultadMedia();
		
		assertEquals( new Integer(6), dificultad.getCantidadColumnas());
		assertEquals( new Integer(6), dificultad.getCantidadColumnas());
		assertEquals( "Medio", dificultad.getNombre() );
	}
}
