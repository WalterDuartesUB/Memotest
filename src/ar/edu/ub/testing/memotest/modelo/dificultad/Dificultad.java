package ar.edu.ub.testing.memotest.modelo.dificultad;

/**
 * Dificultad modela el nivel de dificultad para la partida de Memotest
 * la dificultad indica la cantidad de filas y de columnas que debe tener
 *  el tablero de la partida de Memotest
 * @author Walter Duartes
 *
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
		this.nombre = nombre;
	}

	public Integer getCantidadFilas() 
	{
		return cantidadFilas;
	}

	private void setCantidadFilas(Integer cantidadFilas) 
	{
		this.cantidadFilas = cantidadFilas;
	}

	public Integer getCantidadColumnas() 
	{
		return cantidadColumnas;
	}

	private void setCantidadColumnas(Integer cantidadColumnas) 
	{
		this.cantidadColumnas = cantidadColumnas;
	}
	
}
