package ar.edu.ub.testing.memotest.modelo.dificultad;

import ar.edu.ub.testing.memotest.modelo.dificultad.exception.DificultadSinCantidadColumnasException;
import ar.edu.ub.testing.memotest.modelo.dificultad.exception.DificultadSinCantidadFilasException;
import ar.edu.ub.testing.memotest.modelo.dificultad.exception.DificultadSinNombreException;

/**
 * Dificultad modela el nivel de dificultad para la partida de Memotest
 * la dificultad indica la cantidad de filas y de columnas que debe tener
 *  el tablero de la partida de Memotest
 * @author Walter Duartes
 *
 * Historial
 * ---------
 * 2018/04/08	wduartes	Se agregan las excepciones al constructor para validar los campos
 */
public class Dificultad 
{
	private String nombre;
	private Integer cantidadFilas;
	private Integer cantidadColumnas;
		
	public Dificultad(String nombre, Integer cantidadFilas, Integer cantidadColumnas)
	{		
		setNombre( nombre );
		setCantidadColumnas(cantidadColumnas);
		setCantidadFilas(cantidadFilas);		
	}

	public String getNombre() 
	{
		return nombre;
	}

	private void setNombre(String nombre)
	{
		if( nombre == null || nombre.trim().isEmpty() )
			throw new DificultadSinNombreException();
		
		this.nombre = nombre;
	}

	public Integer getCantidadFilas() 
	{
		return cantidadFilas;
	}

	private void setCantidadFilas(Integer cantidadFilas)
	{
		if( cantidadFilas == null || cantidadFilas <= 0 )
			throw new DificultadSinCantidadFilasException();
		
		this.cantidadFilas = cantidadFilas;
	}

	public Integer getCantidadColumnas() 
	{
		return cantidadColumnas;
	}

	private void setCantidadColumnas(Integer cantidadColumnas)
	{
		if( cantidadColumnas == null || cantidadColumnas <= 0 )
			throw new DificultadSinCantidadColumnasException();
		
		this.cantidadColumnas = cantidadColumnas;
	}
	
}
