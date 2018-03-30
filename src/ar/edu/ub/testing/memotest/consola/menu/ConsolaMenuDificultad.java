package ar.edu.ub.testing.memotest.consola.menu;
import ar.edu.ub.testing.memotest.modelo.dificultad.Dificultad;

public class ConsolaMenuDificultad 
{
	public static Dificultad mostrarMenu( String tituloMenu, ConsolaMenuItem[] MenuItem)
	{
		return (Dificultad) ConsolaMenu.mostrarMenu(tituloMenu, MenuItem).getItemData();
	}
}
