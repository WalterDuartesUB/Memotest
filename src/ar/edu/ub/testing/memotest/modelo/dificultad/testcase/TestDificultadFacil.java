package ar.edu.ub.testing.memotest.modelo.dificultad.testcase;

import ar.edu.ub.testing.memotest.modelo.dificultad.Dificultad;
import ar.edu.ub.testing.memotest.modelo.dificultad.DificultadFacil;
import junit.framework.TestCase;

public class TestDificultadFacil extends TestCase
{
	public void testCreacion()
	{
		Dificultad dificultad = new DificultadFacil();
		
		assertEquals( new Integer(4), dificultad.getCantidadColumnas());
		assertEquals( new Integer(4), dificultad.getCantidadColumnas());
		assertEquals( "Fácil", dificultad.getNombre() );
	}
}
