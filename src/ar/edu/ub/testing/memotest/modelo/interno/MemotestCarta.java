package ar.edu.ub.testing.memotest.modelo.interno;

import ar.edu.ub.testing.memotest.modelo.Carta;

/**
 * Representa una Carta dentro del Memotest
 * A diferencia de la Carta MemotestCarta tiene la informacion sobre su estado dentro del Memotest (fu,fd,q)
 * @author Walter Duartes
 *
 * Historial
 * ---------
 * 2018/04/08	wduartes	Se agrega la validacion que no se puede crear una 
 * 							MemotestCarta con una Carta null
 */
public class MemotestCarta extends Carta 
{

	private enum EstadoCarta
	{
		CARTA_BOCA_ARRIBA,
		CARTA_BOCA_ABAJO,
		CARTA_QUITADA_DE_TABLERO
	};
	
	private EstadoCarta estadoCarta;
	private Integer cantidadVecesBocaArriba;	
	
	public MemotestCarta(Carta carta) 
	{
		super( carta );	
		 
		setCantidadVecesBocaArriba(0);
		voltearBocaAbajo();
	}

	public void voltearBocaAbajo() 
	{
		this.setEstadoCarta( EstadoCarta.CARTA_BOCA_ABAJO );		
	}
	
	public void voltearBocaArriba() 
	{
		this.setEstadoCarta( EstadoCarta.CARTA_BOCA_ARRIBA );	
		this.setCantidadVecesBocaArriba( this.getCantidadVecesBocaArriba() + 1 );
	}
	
	public void quitarCarta() 
	{
		this.setEstadoCarta( EstadoCarta.CARTA_QUITADA_DE_TABLERO );		
	}

	private void setEstadoCarta(EstadoCarta estadoCarta) 
	{
		this.estadoCarta = estadoCarta;
	}
	
	private EstadoCarta getEstadoCarta() 
	{
		return this.estadoCarta;
	}
	
	public boolean estaBocaAbajo() 
	{		
		return getEstadoCarta() == EstadoCarta.CARTA_BOCA_ABAJO;
	}

	public boolean estaBocaArriba() 
	{
		return getEstadoCarta() == EstadoCarta.CARTA_BOCA_ARRIBA;
	}

	private Integer getCantidadVecesBocaArriba() 
	{
		return cantidadVecesBocaArriba;
	}

	private void setCantidadVecesBocaArriba(Integer cantidadVecesBocaArriba) 
	{
		this.cantidadVecesBocaArriba = cantidadVecesBocaArriba;
	}

	public boolean fueVolteadaSoloUnaVez()
	{
		return this.getCantidadVecesBocaArriba() == 1;
	}
}
