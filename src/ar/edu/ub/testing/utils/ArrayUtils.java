package ar.edu.ub.testing.utils;

import java.util.Random;

public class ArrayUtils 
{

	/**
	 * Mezcla una lista de Object
	 * @param array lista de Object a mezclar
	 * @return una nueva lista de Object mezclada
	 */
	public static Object[] mezclar(Object[] array) 
	{
		
		Random   rand = new Random();
		Object[] arrayMezclado = array.clone();
		
	    for (int i = arrayMezclado.length - 1; i > 0; i--) 
	    {
	    	intercambiar(arrayMezclado, i, rand.nextInt(i + 1));
	    }		
	     	    	
		return arrayMezclado;
	}
	
	/**
	 * Intercambia dos posiciones de la lista de Object
	 * @param cartas lista de Object en donde intercambiar los Object
	 * @param i una posicion dentro de la lista de Object
	 * @param j una posicion dentro de la lista de Object
	 */
	private static void intercambiar(Object[] objetos, int i, int j) 
	{
		Object objeto = objetos[i];
		objetos[i] = objetos[j];
		objetos[j] = objeto;		
	}	

}
