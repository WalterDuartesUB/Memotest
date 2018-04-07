package ar.edu.ub.testing.utils;

import java.util.Random;

public class ArrayUtils 
{

	/**
	 * Mezcla una lista de Object   
	 * 
	 * @param array lista de Object a mezclar
	 * @return una nueva lista de Object mezclada
	 * @return null si el array original es null
	 * 
	 * Historial
	 * ---------
	 * 
	 * 2018/04/07	wduartes	Si el array es null, retorna null
	 * 
	 */
	public static Object[] mezclar(Object[] array) 
	{
		
		//Si viene null, retorno null
		if( array == null )
			return null;
		
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
