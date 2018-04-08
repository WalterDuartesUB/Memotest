package ar.edu.ub.testing.memotest.modelo;

import ar.edu.ub.testing.memotest.modelo.exception.CartaSinCartaException;
import ar.edu.ub.testing.memotest.modelo.exception.CartaSinDibujoException;
import ar.edu.ub.testing.memotest.modelo.exception.CartaSinDibujoLomoException;
import ar.edu.ub.testing.utils.ArrayUtils;

/**
 * @author Walter Duartes
 * 
 * Historial
 * ---------
 * 2018/04/08	wduartes	Se modifica el metodo esIgualA para que si la carta
 * 							que llega por parametro es null, devuelva false
 * 2018/04/08	wduartes	Se agregan las excepciones para el dibujo y el 
 * 							dibujo del lomo de la carta
 * 2018/04/08	wduartes	Aparece un nuevo constructor para crear un Carta
 * 							con otro Carta
 */
public class Carta 
{

	private String dibujo;
	private String dibujoLomo;

	public Carta( String dibujo)
	{
		this( dibujo, "?");
	}
	
	public Carta(String dibujo, String dibujoLomo) 
	{
		setDibujo( dibujo );
		setDibujoLomo(dibujoLomo);
	}
	
	
	public Carta(Carta carta)
	{
		if( carta == null )
			throw new CartaSinCartaException();
		
		this.setDibujo(carta.getDibujo());
		this.setDibujoLomo(carta.getDibujoLomo());
	}

	public String getDibujo()
	{	
		return this.dibujo;
	}
	
	private void setDibujo(String dibujo) 
	{
		if( dibujo == null)
			throw new CartaSinDibujoException();
		
		this.dibujo = dibujo;
	}
	
	public String getDibujoLomo() 
	{
		return this.dibujoLomo;
	}
	
	private void setDibujoLomo(String dibujoLomo) 
	{
		if( dibujoLomo == null)
			throw new CartaSinDibujoLomoException();
		
		this.dibujoLomo = dibujoLomo;
	}

	/**
	 * Determina si dos cartas son iguales
	 * 
	 * @param carta una Carta a comparar
	 * @return true si el dibujo de la carta es igual
	 * @return false si el dibujo de la carta no es igual
	 * @return false si la carta que llega por parametro es null
	 */
	
	public boolean esIgualA(Carta carta) 
	{
		if( carta == null )
			return false;
		
		return this.getDibujo().compareTo( carta.getDibujo() ) == 0;
	}

	public static Carta[] mezclar(Carta[] cartas) {		
		return (Carta[]) ArrayUtils.mezclar( cartas );		
	}
}
