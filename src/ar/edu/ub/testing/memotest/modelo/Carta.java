package ar.edu.ub.testing.memotest.modelo;

import ar.edu.ub.testing.utils.ArrayUtils;

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
	
	
	public String getDibujo()
	{	
		return this.dibujo;
	}
	
	private void setDibujo(String dibujo) 
	{
		this.dibujo = dibujo;
	}
	
	public String getDibujoLomo() 
	{
		return this.dibujoLomo;
	}
	
	private void setDibujoLomo(String dibujoLomo) 
	{
		this.dibujoLomo = dibujoLomo;
	}

	public boolean esIgualA(Carta carta) 
	{
		return this.getDibujo().compareTo( carta.getDibujo() ) == 0;
	}

	public static Carta[] mezclar(Carta[] cartas) {		
		return (Carta[]) ArrayUtils.mezclar( cartas );		
	}
}
