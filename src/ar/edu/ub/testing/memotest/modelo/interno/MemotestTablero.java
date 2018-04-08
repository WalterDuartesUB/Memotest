package ar.edu.ub.testing.memotest.modelo.interno;

import ar.edu.ub.testing.memotest.modelo.Carta;

/**
 * MemotestTablero modela el tablero dentro del memotest
 * En cada posicion del tablero hay MemotestCarta con sus respectivos estados y dibujos
 * @author Walter Duartes
 * 
 * Historial
 * ---------
 * 2018/04/08	wduartes	getCarta ahora llama a getMemotestCarta
 */
public class MemotestTablero 
{
	private MemotestCarta[][] cartas;
	private Integer cantidadFilas;
	private Integer cantidadColumnas;

	public MemotestTablero(Integer cantidadFilas, Integer cantidadColumnas) 
	{
		this.setCantidadColumnas(cantidadColumnas);
		this.setCantidadFilas(cantidadFilas);		
		this.setCartas( new MemotestCarta[cantidadFilas][cantidadColumnas] );
	}

	public Carta getCarta( Integer fila, Integer columna) 
	{		
		return this.getMemotestCarta(fila, columna);
	}

	public MemotestCarta getMemotestCarta( Integer fila, Integer columna) 
	{
		return this.getCartas()[fila][columna];
	}
	
	private MemotestCarta[][]getCartas()
	{
		return this.cartas;
	}
	
	private void setCartas(MemotestCarta[][] cartas) 
	{
		this.cartas = cartas;
	}

	/**
	 * Coloca una Carta en una fila columna del tablero
	 * Si la fila columna no pertenece al tablero, hace nada
	 * @param fila nro de fila donde colocar la carta en el tablero
	 * @param columna nro de columna donde colocar la carta en el tablero
	 * @param carta Carta a colocar en el tablero
	 */
	public void ponerCarta(Integer fila, Integer columna, Carta carta) 
	{		
		if( this.validarFilaColumna( fila,columna ) )
			this.getCartas()[fila][columna] = new MemotestCarta( carta ); 		
	}

	public Integer getCantidadFilas() 
	{
		return this.cantidadFilas;
	}

	public Integer getCantidadColumnas() 
	{		
		return this.cantidadColumnas;
	}

	private void setCantidadFilas(Integer cantidadFilas) 
	{
		this.cantidadFilas = cantidadFilas;
	}

	private void setCantidadColumnas(Integer cantidadColumnas) 
	{
		this.cantidadColumnas = cantidadColumnas;
	}
	
	public boolean existeFila( Integer fila )
	{
		return fila >= 0 && fila <= this.getCantidadFilas();
	}

	public boolean existeColumna( Integer columna )
	{
		return columna >= 0 && columna <= this.getCantidadColumnas();
	}	
	
	private boolean validarFilaColumna( Integer fila, Integer columna )
	{
		return this.existeFila(fila ) && this.existeColumna( columna );
	}
}
