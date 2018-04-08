import ar.edu.ub.testing.memotest.consola.Consola;
import ar.edu.ub.testing.memotest.consola.MemotestConsola;
/**
 * Se pretende implementar una solucion para el siguiente problema:
 * A) Memotest:
 * Es el clásico juego en que hay que voltear tarjetas intentando encontrar las idénticas.
 * - Tendrá 3 niveles de dificultad: fácil (tablero de 4x4), medio (tablero de 6x6) y difícil (tablero de 8x8).
 * - Será multijugador local: un intento por turno. En caso de encontrar una coincidencia, se otorgará un punto al jugador que la haya encontrado. 
 * Si lo hizo al voltear cada tarjeta por primera vez, recibirá 3 puntos.
 * - No es necesario que tenga interfaz gráfica; en caso de ser por consola, utilizar como "imágenes" los números del 0 al 9 y las letras de la "a" a la "z".
 * - La usabilidad del programa corre por cuenta del desarrollador.
 * @author Walter Duartes
 * @date 2018/04/06
 * 
 */

public class Aplicacion 
{

	public static void main(String[] args) 
	{

		MemotestConsola memotest = new MemotestConsola();
				
		memotest.jugar();
		
		Consola.finalizar();
	}

}
