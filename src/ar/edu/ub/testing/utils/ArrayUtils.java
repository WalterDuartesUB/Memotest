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
	 * 2018/04/10	wduartes	Me aseguro que el array mezclado 
	 * 							en mezclar tenga elementos en 
	 * 							orden diferente al array original
	 * 
	 */
	public static Object[] mezclar(Object[] array) 
	{
		
		//Si viene null, retorno null
		if( array == null )
			return null;
		
		Random   rand = new Random();
		Object[] arrayMezclado = array.clone();
		
		if( ArrayUtils.sePuedeMezclar( array ) )
		{
			do
			{
			    for (int i = arrayMezclado.length - 1; i > 0; i--) 
			    {
			    	intercambiar(arrayMezclado, i, rand.nextInt(i + 1));
			    }		
			}
			while( !ArrayUtils.tienenAlgunElementoDiferente( array, arrayMezclado ) );
		}
		
		return arrayMezclado;
	}
	
	private static boolean sePuedeMezclar(Object[] array)
	{
		//Si es un array de un solo elemento, no debo mezclarlo
		if( array.length < 2)
			return false;
		
		//Si todos los elementos son iguales, no debo mezclarlo
		boolean hayAlgunElementoDiferente = false;
		
		for( int posicion = 0; posicion < array.length - 1 && !hayAlgunElementoDiferente; posicion++ )
		{
			hayAlgunElementoDiferente = ( array[posicion] != array[posicion+1] );
		}
		
		return hayAlgunElementoDiferente;
	}

	private static boolean tienenAlgunElementoDiferente(Object[] array, Object[] arrayMezclado)
	{
		//Si tiene tamaño 1, son diferentes
		if( array.length == 1 )
			return true;
		
		for( int posicion = 0; posicion < array.length; posicion++ )
			if( array[posicion] != arrayMezclado[posicion])
				return true;
		
		return false;
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
