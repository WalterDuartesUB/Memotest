package ar.edu.ub.testing.memotest.consola;

import java.util.Scanner;

/**
 * Wrapper para tener centralizado las prestaciones de Scanner y evitar cerrar el System.in en medio del programa
 * @author wduartes
 *
 */

public final class Consola 
{
	private static Scanner in;

	/**
	 * metodo para inicializar los recursos para manejo de consola
	 * debe invocarse solo una vez al inicio de la aplicacion para habilitar el uso de la consola
	 */
	public static void inicializar()
	{
		if( getIn() == null )
			setIn(new Scanner( System.in ));
	}
	/**
	 * metodo para liberar los recursos tomados por la consola
	 * Debe ser la ultima linea de la implementacion a ser ejecutada
	 * No puede volver a utilizarse inicializar despues de llamar a este metodo
	 */
	public static void finalizar()
	{
		if( getIn() == null )
			getIn().close();
	}
		
	/**
	 * Obtiene una linea ingresada por consola
	 * @return String con el contenido de la linea de la consola
	 */
	public static String nextLine()
	{
		Consola.inicializar();
		
		return getIn().nextLine();
	}
	
	/**
	 * Limpia la pantalla de la consola
	 */
	public static void limpiarPantalla() 
	{
		for( int i = 0; i < 300;i++)
			System.out.println();		
	}

	private static Scanner getIn() 
	{
		return in;
	}

	private static void setIn(Scanner in) 
	{
		Consola.in = in;
	}

}
