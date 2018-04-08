package ar.edu.ub.testing.memotest.modelo.interno;

import ar.edu.ub.testing.memotest.modelo.Carta;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestTableroCantidadColumnasInvalidaException;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestTableroCantidadFilasInvalidaException;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestTableroColumnaNoExisteException;
import ar.edu.ub.testing.memotest.modelo.interno.exception.MemotestTableroFilaNoExisteException;

/**
 * MemotestTablero modela el tablero dentro del memotest
 * En cada posicion del tablero hay MemotestCarta con sus respectivos estados y dibujos
 * @author Walter Duartes
 * 
 * Historial
 * ---------
 * 2018/04/08	wduartes	getCarta ahora llama a getMemotestCarta
 * 2018/04/08	wduartes	Se agrega el manejo de excepciones en getMemotestCarta
 * 							 cuando se pide una carta en una coordenada inexistente
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

	/**
	 * Pide una Carta en un par de coordenadas
	 * @param fila nro de fila del tablero de la carta deseada
	 * @param columna nro de columna del tablero de la carta deseada
	 * @return un Carta con la carta en la fila, columna
	 * @exception MemotestTableroFilaNoExisteException si la fila no existe en el tablero
	 * @exception MemotestTableroColumnaNoExisteException si la fila no existe en el tablero
	 */
	public Carta getCarta( Integer fila, Integer columna) 
	{		
		return this.getMemotestCarta(fila, columna);
	}

	/**
	 * Pide una MemotestCarta en un par de coordenadas
	 * @param fila nro de fila del tablero de la carta deseada
	 * @param columna nro de columna del tablero de la carta deseada
	 * @return un MemotestCarta con la carta en la fila, columna
	 * @exception MemotestTableroFilaNoExisteException si la fila no existe en el tablero
	 * @exception MemotestTableroColumnaNoExisteException si la fila no existe en el tablero
	 */	
	public MemotestCarta getMemotestCarta( Integer fila, Integer columna) 
	{
		if( !this.existeFila(fila))
			throw new MemotestTableroFilaNoExisteException(fila);
		
		if( !this.existeColumna(columna))
			throw new MemotestTableroColumnaNoExisteException(columna);		
		
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
	 * @exception MemotestTableroFilaNoExisteException si la fila no existe en el tablero
	 * @exception MemotestTableroColumnaNoExisteException si la fila no existe en el tablero
	 */
	public void ponerCarta(Integer fila, Integer columna, Carta carta) 
	{			
		if( !this.existeFila(fila))
			throw new MemotestTableroFilaNoExisteException(fila);
		
		if( !this.existeColumna(columna))
			throw new MemotestTableroColumnaNoExisteException(columna);			
		
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
		if( !this.validarDimension( cantidadFilas ) )
			throw new MemotestTableroCantidadFilasInvalidaException();
		
		this.cantidadFilas = cantidadFilas;
	}

	private void setCantidadColumnas(Integer cantidadColumnas) 
	{
		
		if( !this.validarDimension( cantidadColumnas ) )
			throw new MemotestTableroCantidadColumnasInvalidaException();
		
		this.cantidadColumnas = cantidadColumnas;
	}
	
	private boolean validarDimension(Integer dimension)
	{
		return !( dimension == null || dimension <= 0 );
	}

	public boolean existeFila( Integer fila )
	{
		return fila >= 0 && fila <= this.getCantidadFilas();
	}

	public boolean existeColumna( Integer columna )
	{
		return columna >= 0 && columna <= this.getCantidadColumnas();
	}	
	
	
}
