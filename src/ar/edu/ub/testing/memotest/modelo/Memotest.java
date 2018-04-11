package ar.edu.ub.testing.memotest.modelo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import ar.edu.ub.testing.memotest.modelo.dificultad.Dificultad;
import ar.edu.ub.testing.memotest.modelo.exception.MemotestSinCreadorDeTableroException;
import ar.edu.ub.testing.memotest.modelo.exception.MemotestSinDificultadException;
import ar.edu.ub.testing.memotest.modelo.exception.MemotestSinJugadoresException;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestCalculadorDePuntos;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestCarta;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestCreadorTablero;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestJugador;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestTablero;
import ar.edu.ub.testing.memotest.modelo.interno.OrdenarJugadorPorPuntos;

/**
 * Memotest es la clase que contiene todas las reglas de juego del Memotest per se
 * publica funciones para poder implementar un juego en cualquier interfaz de usuario ( Consola o Ventana )
 * @author wduartes
 *
 * Historial
 * ---------
 * 2018/04/08	wduartes	Se valida que para construir un Memotest haya 
 * 							una dificultad y una lista de jugadores
 */
public class Memotest 
{
	
	private static final Integer CANTIDAD_CARTAS_NECESARIAS_POR_TURNO = 2;
	
	private MemotestJugador            	jugadorDeTurno;
	private MemotestJugador[]           memotestJugadores;
	private MemotestTablero            	tablero;
	private List<MemotestCarta>        	cartasBocaArriba;
	private MemotestCalculadorDePuntos  calculadorDePuntos;
	
	private void inicializarJuego(Dificultad dificultad, Jugador[] jugadores, MemotestCreadorTablero creadorDeTableros) 
	{		
		
		if( dificultad == null )
			throw new MemotestSinDificultadException();
		
		if( !this.validarHayJugadores( jugadores ) )
			throw new MemotestSinJugadoresException();
		
		if( creadorDeTableros == null )
			throw new MemotestSinCreadorDeTableroException();
		
		this.inicializarJugadores( jugadores );
	
		this.setJugadorDeTurno( this.getMemotestPrimerJugador() );
	
		this.setTablero( creadorDeTableros.crearTablero( dificultad, Memotest.CANTIDAD_CARTAS_NECESARIAS_POR_TURNO ) );		
		
		this.setCalculadorDePuntos(new MemotestCalculadorDePuntos() );
				
		this.vaciarListaCartasBocaArriba();
	}
	
	private boolean validarHayJugadores(Jugador[] jugadores)
	{
		if( jugadores == null || jugadores.length <= 1 )
			return false;
		
		for( int posicion = 0; posicion < jugadores.length; posicion++ )
		{
			if( jugadores[posicion] == null )
				return false;
		}
		
		return true;
	}

	private MemotestJugador getJugadorDeTurno() 
	{
		return jugadorDeTurno;
	}

	private void setJugadorDeTurno(MemotestJugador jugadorDeTurno) 
	{
		this.jugadorDeTurno = jugadorDeTurno;
	}
	
	private MemotestTablero getTablero() 
	{
		return tablero;
	}
	
	private void setTablero(MemotestTablero tablero) 
	{
		this.tablero = tablero;
	}	
	
	private MemotestJugador getMemotestPrimerJugador() 
	{
		return this.getMemotestJugadores()[0];
	}

	private void vaciarListaCartasBocaArriba() 
	{
		this.setListaDeCartasBocaArriba( new ArrayList<MemotestCarta>() );		
	}
	
	public boolean tengoCartasParaVoltear() 
	{
		boolean tengoCartas = false;
		
		for( int fila = 0; fila < this.getCantidadFilas() && !tengoCartas; fila++ )
		{
			for( int columna = 0; columna < this.getCantidadColumnas() && !tengoCartas; columna++ )
			{
				tengoCartas = this.getMemotestCarta(fila, columna).estaBocaAbajo();
			}
		}
		
		return tengoCartas;
	}
	
	public void cambiarJugadorDeTurno() 
	{
		this.setJugadorDeTurno( this.getJugadorDeTurno().getProximoJugador() );
	}
	
	private void voltearCartasBocaAbajo() 
	{
		if( this.hayCartasBocaArriba() )
		{		
			MemotestCarta[] cartasBocaArriba = this.obtenerCartasBocaArriba();
			
			for( int posicion = 0; posicion < cartasBocaArriba.length; posicion++)
				cartasBocaArriba[ posicion ].voltearBocaAbajo();
			
			this.vaciarListaCartasBocaArriba();
		}
	}
	
	private void quitarCartasBocaArriba() 
	{
		if( this.hayCartasBocaArriba() )
		{		
			MemotestCarta[] cartasBocaArriba = this.obtenerCartasBocaArriba();			
			
			for( int posicion = 0; posicion < cartasBocaArriba.length; posicion++)
				cartasBocaArriba[ posicion ].quitarCarta();
						
			this.vaciarListaCartasBocaArriba();
		}
	}
	
	private boolean hayCartasBocaArriba() 
	{ 
		return this.obtenerCartasBocaArriba().length > 0;
	}
	
	private boolean todasLasCartasBocaArribaSonIguales() 
	{
		if( this.noHayCartasBocaArriba() )
			return false;

		Carta[] cartasBocaArriba = this.obtenerCartasBocaArriba();
		boolean todasLasCartasSonIguales = true;
		
		Carta   primeraCarta = cartasBocaArriba[0];				
		
		for( int posicion = 1; posicion < cartasBocaArriba.length && todasLasCartasSonIguales; posicion++)
		{
			todasLasCartasSonIguales = primeraCarta.esIgualA( cartasBocaArriba[posicion] );
		}
		
		return todasLasCartasSonIguales;
	}
	
	private boolean noHayCartasBocaArriba() 
	{
		return !this.hayCartasBocaArriba();
	}
	
	private MemotestCarta[] obtenerCartasBocaArriba() 
	{
		
		MemotestCarta[] cartasBocaArriba = new MemotestCarta[ getListaDeCartasBocaArriba().size() ];
		
		this.getListaDeCartasBocaArriba().toArray( cartasBocaArriba  );
		
		return cartasBocaArriba;
	}
	
	/**
	 * Voltea una carta en fila columna boca arriba
	 * Si fila columna no pertencen al tablero, hace nada
	 * Si la carta ya esta boca arriba, hace nada
	 * @param fila nro de fila de la carta a voltear
	 * @param columna nro de columna de la carta a voltear
	 */
	
	public void voltearCartaBocaArriba(Integer fila, Integer columna) 
	{
		
		if( this.validarFilaColumna( fila, columna ) && this.esCartaBocaAbajo( fila, columna ) )
		{
			this.getMemotestCarta( fila, columna).voltearBocaArriba();		
			this.agregarCartaBocaArriba( this.getMemotestCarta( fila, columna) );
		}
	}
	
	private boolean esCartaBocaAbajo(Integer fila, Integer columna) 
	{
		return this.getMemotestCarta(fila, columna).estaBocaAbajo();
	}
	
	private void agregarCartaBocaArriba(MemotestCarta carta) 
	{
		this.getListaDeCartasBocaArriba().add( carta );		
	}
	
	/**
	 * Devuelve una carta en las coordenadas fila columna
	 * @param fila nro de fila de la carta
	 * @param columna nro de columna de la carta
	 * @return una Carta en las coordenadas fila columna
	 * @return null si las coordenadas no pertenecen a una carta
	 */
	public Carta getCarta(Integer fila, Integer columna) 
	{
		if( this.validarFilaColumna( fila, columna ) )
			return this.getTablero().getCarta(fila,columna);
		
		return null;
	}
	
	private MemotestCarta getMemotestCarta(Integer fila, Integer columna) 
	{
		return this.getTablero().getMemotestCarta(fila,columna);
	}	
	
	public boolean esJugadorDeTurno(Jugador jugador) 
	{
		return jugador == this.getJugadorDeTurno();
	}
	
	public Integer getCantidadFilas() 
	{	
		return this.getTablero().getCantidadFilas();
	}
	
	public Integer getCantidadColumnas() 
	{		
		return this.getTablero().getCantidadColumnas();
	}
	
	private List<MemotestCarta> getListaDeCartasBocaArriba() 
	{
		return this.cartasBocaArriba;
	}
	
	private void setListaDeCartasBocaArriba(List<MemotestCarta> listaDeCartasBocaArriba) 
	{
		this.cartasBocaArriba = listaDeCartasBocaArriba;
	}
	
	public static Memotest crearMemotest(Dificultad dificultad, Jugador[] jugadores, MemotestCreadorTablero creadorDeTablero) 
	{
		Memotest memotest = new Memotest();
		
		memotest.inicializarJuego(dificultad, jugadores, creadorDeTablero );
		
		return memotest;
	}
	
	public Jugador[] getJugadores() 
	{
		return memotestJugadores.clone();
	}
	
	private MemotestJugador[] getMemotestJugadores() 
	{
		return memotestJugadores;
	}
	
	private void inicializarJugadores(Jugador[] jugadores) 
	{
		this.memotestJugadores = new MemotestJugador[ jugadores.length ];
		
		//Creo jugadores para el contexto del memotest
		for( int posicion = 0; posicion < jugadores.length; posicion++ )
			this.getMemotestJugadores()[posicion] = new MemotestJugador(jugadores[posicion]);
		
		//Asigno a cada jugador quien es el proximo al pasar el turno
		for( int posicion = 0; posicion < jugadores.length - 1; posicion++ )
			this.getMemotestJugadores()[posicion].setProximoJugador( this.getMemotestJugadores()[posicion+1] );
		
		//Asigno al ultimo jugador que su proximo es el primero jugador
		this.getMemotestJugadores()[ jugadores.length - 1 ].setProximoJugador( this.getMemotestJugadores()[ 0 ] );
	}
	
	/**
	 * Indica si se eligieron suficientes cartas para determinar los puntos a sumar y poder pasar al proximo turno
	 * @return true si se eligieron suficientes cartas para pasar de turno
	 * @return false si todavia faltan elegir cartas para pasar de turno
	 */
	public boolean elegiSuficientesCartas() 
	{
		return this.obtenerCartasBocaArriba().length == Memotest.CANTIDAD_CARTAS_NECESARIAS_POR_TURNO;
	}
	
	/**
	 * Suma los puntos al jugador de turno si corresponde
	 * Debe invocarse luego de que elegiSuficientesCartas() devuelva true
	 * En caso de invocarse con elegiSuficientesCartas() devuelva false, todas las cartas se pasan boca abajo y no se suman puntos
	 * @return true en caso que pueda sumar los puntos por ser todas las cartas boca arriba iguales
	 * @return false en caso de no tener suficientes cartas boca arriba
	 * @return false en caso de que algunas cartas no sean iguales
	 */
	public boolean sumarPuntosAlJugadorDeTurno() 
	{
		boolean pudeSumarPuntos = false;
		
	    if( this.todasLasCartasBocaArribaSonIguales() && this.elegiSuficientesCartas() )
	    {
	    	this.getJugadorDeTurno().sumarPuntos( this.getCalculadorDePuntos().calcular( this.obtenerCartasBocaArriba() ) );
	    	this.quitarCartasBocaArriba();
	    	pudeSumarPuntos = true;
	    }
	    else
	    {		
	    	this.voltearCartasBocaAbajo();
	    }
	    
		return pudeSumarPuntos;
	}
	
	private MemotestCalculadorDePuntos getCalculadorDePuntos() 
	{
		return this.calculadorDePuntos;
	}
	
	private void setCalculadorDePuntos(MemotestCalculadorDePuntos calculadorDePuntos) 
	{
		this.calculadorDePuntos = calculadorDePuntos;
	}

	/**
	 * Indica si la carta en una coordenada esta boca abajo
	 * @param fila nro de fila de la carta
	 * @param columna nro de columna de la carta
	 * @return true si la carta esta boca abajo
	 * @return false si la carta esta boca arriba
	 * @return false si el par fila columna no corresponde a una coordenada dentro del tablero
	 */
	
	public boolean estaLaCartaBocaAbajo(Integer fila, Integer columna) 
	{
		if( this.validarFilaColumna( fila, columna ) )
			return this.getMemotestCarta(fila, columna).estaBocaAbajo();
		
		return false;
	}

	/**
	 * Indica si la carta en una coordenada esta boca arriba
	 * @param fila nro de fila de la carta
	 * @param columna nro de columna de la carta
	 * @return true si la carta esta boca arriba
	 * @return false si la carta esta boca arriba
	 * @return false si el par fila columna no corresponde a una coordenada dentro del tablero
	 */
	
	public boolean estaLaCartaBocaArriba(Integer fila, Integer columna) 
	{ 
		if( this.validarFilaColumna( fila, columna ) )
			return this.getMemotestCarta(fila, columna).estaBocaArriba();
		
		return false;
	}

	private boolean validarFilaColumna(Integer fila, Integer columna) 
	{
		return this.getTablero().existeFila( fila ) && this.getTablero().existeColumna( columna );
	}

	/**
	 * Obtiene la lista de Jugador ordenados por la cantidad de puntos para mostrar al terminar la partida
	 * @return una lista de Jugador ordenados por la cantidad de puntos obtenidos
	 */
	public Jugador[] jugadoresOrdenadosPorPuntos() 
	{

		Jugador[] jugadores = this.getJugadores();
		
		Arrays.sort( jugadores, new OrdenarJugadorPorPuntos() );
		
		return jugadores;
	}	
}
