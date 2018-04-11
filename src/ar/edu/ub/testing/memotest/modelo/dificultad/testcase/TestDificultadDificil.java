package ar.edu.ub.testing.memotest.modelo.dificultad.testcase;

import ar.edu.ub.testing.memotest.modelo.dificultad.Dificultad;
import ar.edu.ub.testing.memotest.modelo.dificultad.DificultadDificil;
import junit.framework.TestCase;

public class TestDificultadDificil extends TestCase
{
	public void testCreacion()
	{
		Dificultad dificultad = new DificultadDificil();
		
		assertEquals( new Integer(8), dificultad.getCantidadColumnas());
		assertEquals( new Integer(8), dificultad.getCantidadColumnas());
		assertEquals( "Dificil", dificultad.getNombre() );
	}
}
