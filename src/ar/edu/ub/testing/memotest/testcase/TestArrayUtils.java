package ar.edu.ub.testing.memotest.testcase;

import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.testing.utils.ArrayUtils;
import junit.framework.TestCase;

public class TestArrayUtils extends TestCase 
{
	
	///////////////////////////////////////////////////////////////////////////
	//Pruebas de arrays con null
	
	public void testMezclarNull()
	{
		assertEquals( ArrayUtils.mezclar( null ), null );
	}
	
	public void testMezclarArrayNulls()
	{
		String[] array = new String[] { null, null, null };
		assertNotNull(  ArrayUtils.mezclar( array ) );
	}
	
	public void testMezclarArrayNullsTamanio()
	{
		String[] array = new String[] { null, null, null };
		assertEquals( ArrayUtils.mezclar( array ).length, array.length );
	}
	
	///////////////////////////////////////////////////////////////////////////
	//Pruebas de arrays vacios
	
	public void testMezclarArrayVacio()
	{		
		Object []			array = new Object[] {};		
		
		assertNotNull(  ArrayUtils.mezclar( array ) );
	}
	
	public void testMezclarArrayVacioTamanio()
	{		
		Object []			array = new Object[] {};		
		
		assertEquals(0, ArrayUtils.mezclar( array ).length );
	}
		
	public void testMezclarArrayVacioCopia()
	{		
		Object []			array = new Object[] {};		
		
		assertNotSame( array, ArrayUtils.mezclar( array ) );
	}
	
	///////////////////////////////////////////////////////////////////////////
	//Pruebas de arrays con valores
	
	public void testMezclarArrayTamanio()
	{
		String[] array = new String[] { "a", "b", "c" };
		assertEquals( ArrayUtils.mezclar( array ).length, array.length );
	}	
	
	public void testMezclarArrayCopia()
	{		
		String[] array = new String[] { "a", "b", "c" };
		
		assertNotSame( array, ArrayUtils.mezclar( array ) );
	}	
		
	public void testMezclarArrayVerificarExistenciaTodosLosValores()
	{		
		String[] array = new String[] { "a", "b", "c" };
		String[] arrayMezclado = ( String[] ) ArrayUtils.mezclar( array );
		
		//Creo un mapa para tener simplificada la busqueda de los elementos
		Map<String, String> mapaValores = new HashMap<String,String>();
		
		for( int posicion = 0; posicion < array.length; posicion++)
			mapaValores.put( array[ posicion ], array[ posicion ] );
		
		//Busco que todos los valores existan en el array mezclado
		for( int posicion = 0; posicion < arrayMezclado.length; posicion++ )
		{
			assertEquals( arrayMezclado[posicion], mapaValores.get( arrayMezclado[posicion]) );
		}
	}
}
