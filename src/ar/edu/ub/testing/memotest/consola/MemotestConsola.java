package ar.edu.ub.testing.memotest.consola;

import ar.edu.ub.testing.memotest.consola.exception.ConsolaEsNullException;
import ar.edu.ub.testing.memotest.consola.menu.ConsolaMenuDificultad;
import ar.edu.ub.testing.memotest.consola.menu.ConsolaMenuFinJuego;
import ar.edu.ub.testing.memotest.consola.menu.ConsolaMenuFinJuego.DecisionFinJuego;
import ar.edu.ub.testing.memotest.consola.menu.ConsolaMenuItem;
import ar.edu.ub.testing.memotest.modelo.Carta;
import ar.edu.ub.testing.memotest.modelo.Jugador;
import ar.edu.ub.testing.memotest.modelo.Memotest;
import ar.edu.ub.testing.memotest.modelo.dificultad.Dificultad;
import ar.edu.ub.testing.memotest.modelo.dificultad.DificultadDificil;
import ar.edu.ub.testing.memotest.modelo.dificultad.DificultadFacil;
import ar.edu.ub.testing.memotest.modelo.dificultad.DificultadMedia;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestCreadorTablero;
import ar.edu.ub.testing.memotest.modelo.interno.MemotestCreadorTableroMezclado;
import ar.edu.ub.testing.utils.StringUtils;

/**
 * MemotestConsola permite jugar al Memotest usando una consola de usuario mediante las funciones
 * prestadas por la clase Memotest.
 * @author wduartes
 *
 */
public class MemotestConsola 
{
	
	/**
	 * Al pedir las coordenadas de una carta al usuario, se utiliza este campo para destacar la fila seleccionada
	 */
	private Integer filaSeleccionada;	
	private Consola consola;
	private MemotestCreadorTablero creadorDeTablero;
	
	public MemotestConsola( Consola consola )
	{
		this( consola, new MemotestCreadorTableroMezclado() );
	}
		
	public MemotestConsola( Consola consola, MemotestCreadorTablero creadorDeTablero )
	{
		this.setConsola(consola);
		this.setCreadorDeTablero(creadorDeTablero);
	}	
	/**
	 * Metodo para jugar al memotest por consola
	 * Al terminar una partida, pregunta al usuario si desea:
	 * - revancha ( misma dificultad )
	 * - partida nueva ( volver a elegir la dificultad)
	 * - salir de la aplicacion
	 */
	public void jugar()
	{
		Jugador[]          jugadores = this.crearJugadores();		
		Dificultad         dificultad = this.elegirDificultad();
		DecisionFinJuego   decisionUsuario = DecisionFinJuego.DFJ_JUGAR_JUEGO_NUEVO_ELIGIENDO_DIFICULTAD;
		
		while( decisionUsuario != DecisionFinJuego.DFJ_SALIR_APLICACION )
		{
			this.jugarPartida(dificultad, jugadores);
			
			//Preguinto al usuario si quiere volver a jugar o salir de la app
			decisionUsuario = ConsolaMenuFinJuego.mostrarMenu( this.getConsola() );
			
			//Si marca la opcion de reiniciar, pido que elijan la dificultad nueva
			if( decisionUsuario == DecisionFinJuego.DFJ_JUGAR_JUEGO_NUEVO_ELIGIENDO_DIFICULTAD )
			{				
				dificultad = this.elegirDificultad();
			}			
		}
	}
	
	private void jugarPartida( Dificultad dificultad, Jugador[] jugadores)
	{
		Memotest           memotest = Memotest.crearMemotest( dificultad, jugadores, this.getCreadorDeTablero() );
		 
		this.quitarSeleccionFila();
		
		while( memotest.tengoCartasParaVoltear() )
		{
			this.pedirCartasAlJugadorDeTurno( memotest );
		   
			//Muestro el tablero para mostrar las cartas boca arriba
			this.imprimir( memotest );
			
			if( memotest.sumarPuntosAlJugadorDeTurno() )
				this.imprimirLasCartasSonIguales();
			else
				this.imprimirLasCartasNoSonIguales();
		       
		    memotest.cambiarJugadorDeTurno();
		    
		}  
		
		this.mostrarJugadoresOrdenadosPorPuntos( memotest );
		
	}

	private void imprimirLasCartasNoSonIguales() 
	{
		this.getConsola().println("Las cartas NO son iguales!\nEl jugador de turno NO suma puntos.\nApreta enter para pasar al proximo turno.");
		
		this.getConsola().nextLine();
		
	}

	private void imprimirLasCartasSonIguales() 
	{
		this.getConsola().println("Las cartas son iguales!\nApreta enter para pasar al proximo turno.");
	
		this.getConsola().nextLine();		
	}

	protected void mostrarJugadoresOrdenadosPorPuntos(Memotest memotest) 
	{
		Jugador[] jugadoresPorRanking = memotest.jugadoresOrdenadosPorPuntos( );
	
		this.imprimirCabeceraTablaDeJugadores();		
		
		for( int posicion = 0; posicion < jugadoresPorRanking.length; posicion++)
			this.imprimirJugadorEnTabla( new Integer(posicion + 1).toString() + "-", jugadoresPorRanking[posicion] );
		
		//Dejo una linea entre la tabla de jugadores y el menu de fin de juego
		this.getConsola().println();		
	}

	/**
	 * Crea una lista de Jugador con los jugadores que van a jugar la partida
	 * @return Jugador[] con los jugadores que van a jugar la partida
	 */
	private Jugador[] crearJugadores() 
	{
		return new Jugador[] { new Jugador("Jugador 1"), new Jugador("Jugador 2")  };
	}

	/**
	 * Presenta un menu de dificultades para que el usuario elija una para jugar
	 * @return Dificultad elegida para jugar al Memotest
	 */
	private Dificultad elegirDificultad() 
	{
		ConsolaMenuItem[] listaOpcionesMenu = new ConsolaMenuItem[] 
											{ 
												new ConsolaMenuItem("Facil", "1", new DificultadFacil() ),
												new ConsolaMenuItem("Media", "2", new DificultadMedia() ),
												new ConsolaMenuItem("Dificil", "3", new DificultadDificil() )
											};
		
		return ConsolaMenuDificultad.mostrarMenu( this.getConsola(), "Elegi la dificultad para el juego", listaOpcionesMenu );
	}

	private void pedirCartasAlJugadorDeTurno(Memotest memotest) 
	{
		
		while( !memotest.elegiSuficientesCartas() )
		{
			Integer filaUsuario = this.obtenerFilaDelUsuario( memotest );
			Integer columnaUsuario = this.obtenerColumnaDelUsuario( memotest );
			
			//Solo puedo dar vuelta la carta si esta boca abajo
			if( memotest.estaLaCartaBocaAbajo(filaUsuario, columnaUsuario))
				memotest.voltearCartaBocaArriba( filaUsuario, columnaUsuario );
			else
				this.imprimirEsaCartaYaEstaBocaArriba();
			
			this.quitarSeleccionFila();
		}	
	}

	private void imprimirEsaCartaYaEstaBocaArriba() 
	{
		this.getConsola().println("Esa carta ya fue elegida, por favor elija otra.");
		
		this.getConsola().nextLine();			
	}

	private void quitarSeleccionFila() 
	{
		this.setFilaSeleccionada( -1 );		
	}

	private Integer obtenerColumnaDelUsuario(Memotest memotest) 
	{
		return this.obtenerCoordenadaMemotestUsuario( memotest, "Ingrese el nro de columna de la carta que desea voltear: ",  1, memotest.getCantidadColumnas() );
	}

	private Integer obtenerFilaDelUsuario(Memotest memotest) 
	{
		 Integer  filaUsuario = this.obtenerCoordenadaMemotestUsuario( memotest, "Ingrese el nro de fila de la carta que desea voltear: ",  1, memotest.getCantidadFilas() );
		 
		 this.setFilaSeleccionada( filaUsuario );
		 
		 return filaUsuario;
	}
	
	private Integer obtenerCoordenadaMemotestUsuario(Memotest memotest, String mensajeUsuario, Integer valorMinimo, Integer valorMaximo) 
	{
		Integer filaUsuario = 0;
		String  inputUsuario = "";
		
		//Pido un nro hasta tener el valor dentro de las coordenadas del memotest
		while( filaUsuario < valorMinimo || filaUsuario > valorMaximo || !StringUtils.isNumeric( inputUsuario ) )
		{
			this.imprimir( memotest );		
			this.getConsola().print( mensajeUsuario );
			inputUsuario = this.getConsola().nextLine();
			
			//Si es un nro, lo convierto
			if( StringUtils.isNumeric( inputUsuario ) )
				filaUsuario = Integer.parseInt( inputUsuario );			
		}
		
		return filaUsuario - 1 ;
	}

	/**
	 * Imprime el estado(puntos y tablero) del memotest en un turno determinado en el tiempo
	 * @param memotest Memotest a mostrar
	 */
	
	private void imprimir(Memotest memotest) 
	{
		
		this.getConsola().limpiarPantalla();
		
		this.imprimirTablaDeJugadores( memotest );

		//Dejo una linea entre la tabla de jugadores y el memotest
		this.getConsola().println();
		
		//Imprimo el memotest
		this.imprimirTablero( memotest );
		
	}

	/**
	 * Imprime el tablero del memotest en un turno determinado en el tiempo
	 * @param memotest Memotest a mostrar
	 */
	private void imprimirTablero(Memotest memotest) 
	{		
		this.imprimirNroColumnas( memotest.getCantidadColumnas() );
		
		this.imprimirSeparadorDeFilas( memotest, this.esFilaSeleccionada( 0 ) );
		
		for( int fila = 0; fila < memotest.getCantidadFilas(); fila++ )
		{			
			//Imprimo el nro de fila antes de mostrar las cartas
			this.getConsola().print( String.format("%2d |", fila + 1 ) );
			
			for( int columna = 0; columna < memotest.getCantidadColumnas(); columna++ )
				this.imprimir( memotest, fila, columna );
			
			this.getConsola().println();
			
			this.imprimirSeparadorDeFilas(memotest, this.esFilaSeleccionada( fila ) || this.esFilaSeleccionada( fila + 1) );
		}
		
	}

	private void imprimirNroColumnas(Integer cantidadColumnas) 
	{
		this.getConsola().print("   |");
		
		for( int columna = 0; columna < cantidadColumnas; columna++)
			this.getConsola().print( String.format( " %-2d |", columna + 1 ) );
		
		this.getConsola().println();
	}

	private boolean esFilaSeleccionada(Integer fila) 
	{
		return this.getFilaSeleccionada() == fila;
	}

	private void imprimirSeparadorDeFilas(Memotest memotest, boolean esFilaSeleccionada) 
	{
		this.getConsola().println( String.format("%-"+ new Integer( 4 + memotest.getCantidadColumnas() * 5 ).toString() + "s", " ").replace(" ", esFilaSeleccionada ? "*" : "—" ) );
	}

	private void imprimir( Memotest memotest, Integer fila, Integer columna) 
	{
		Carta carta = memotest.getCarta(fila, columna);
				
		if( memotest.estaLaCartaBocaAbajo( fila, columna ) )
			this.getConsola().print( String.format( " %-2s |", carta.getDibujoLomo() ) );			
		else if( memotest.estaLaCartaBocaArriba( fila, columna ) ) 
			this.getConsola().print( String.format( " %-2s |", carta.getDibujo() ) );
		else
			this.getConsola().print( String.format( " %-2s |", "" ) );
		
	}

	/**
	 * Imprime la lista de jugadores en un determinado turno en el tiempo
	 * @param memotest Memotest con los jugadores a mostrar
	 */
	private void imprimirTablaDeJugadores(Memotest memotest) 
	{
		this.imprimirCabeceraTablaDeJugadores();		
		for( int posicion = 0; posicion < memotest.getJugadores().length; posicion++)
			this.imprimirJugadorEnTabla( memotest.esJugadorDeTurno( memotest.getJugadores()[posicion] ) ? ">" : " ", memotest.getJugadores()[posicion] );		
	}

	private void imprimirCabeceraTablaDeJugadores() {
		this.getConsola().println( String.format("   %-20s|%s", "Jugador", "Puntos") );
		this.getConsola().println( String.format("%-32s", " ").replace(" ", "—") );		
	}

	private void imprimirJugadorEnTabla(String indicador, Jugador jugador) 
	{
		this.getConsola().println( String.format("%3s%-20s|%d", indicador, jugador.getAlias(), jugador.getPuntos() ) );		
	}

	private Integer getFilaSeleccionada() 
	{
		return filaSeleccionada;
	}

	private void setFilaSeleccionada(Integer filaSeleccionada) 
	{
		this.filaSeleccionada = filaSeleccionada;
	}

	private Consola getConsola()
	{
		return consola;
	}

	private void setConsola(Consola consola)
	{
		if( consola == null )
			throw new ConsolaEsNullException("No se puede asignar un Consola null a un MemotestConsola.");
		
		this.consola = consola;
	}

	private MemotestCreadorTablero getCreadorDeTablero()
	{
		return creadorDeTablero;
	}


	private void setCreadorDeTablero(MemotestCreadorTablero creadorDeTablero)
	{
		this.creadorDeTablero = creadorDeTablero;
	}
}
