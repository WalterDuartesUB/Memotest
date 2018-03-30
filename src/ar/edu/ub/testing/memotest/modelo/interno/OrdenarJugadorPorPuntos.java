package ar.edu.ub.testing.memotest.modelo.interno;

import java.util.Comparator;

import ar.edu.ub.testing.memotest.modelo.Jugador;
/**
 * Clase para poder ordenar de forma descendente una lista de Jugador por puntos
 * {@link} https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
 * @author Walter Duartes
 *
 */

public class OrdenarJugadorPorPuntos  implements Comparator<Jugador> 
{
    public int compare(Jugador a, Jugador b)
    {
        return b.getPuntos() - a.getPuntos();
    }
}
	