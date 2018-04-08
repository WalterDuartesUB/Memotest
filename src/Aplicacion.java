import ar.edu.ub.testing.memotest.consola.Consola;
import ar.edu.ub.testing.memotest.consola.MemotestConsola;
/**
 * Se pretende implementar una solucion para el siguiente problema:
 * A) Memotest:
 * Es el cl�sico juego en que hay que voltear tarjetas intentando encontrar las id�nticas.
 * - Tendr� 3 niveles de dificultad: f�cil (tablero de 4x4), medio (tablero de 6x6) y dif�cil (tablero de 8x8).
 * - Ser� multijugador local: un intento por turno. En caso de encontrar una coincidencia, se otorgar� un punto al jugador que la haya encontrado. 
 * Si lo hizo al voltear cada tarjeta por primera vez, recibir� 3 puntos.
 * - No es necesario que tenga interfaz gr�fica; en caso de ser por consola, utilizar como "im�genes" los n�meros del 0 al 9 y las letras de la "a" a la "z".
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
