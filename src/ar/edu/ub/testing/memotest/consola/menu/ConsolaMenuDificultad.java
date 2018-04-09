package ar.edu.ub.testing.memotest.consola.menu;
import ar.edu.ub.testing.memotest.consola.Consola;
import ar.edu.ub.testing.memotest.modelo.dificultad.Dificultad;

public class ConsolaMenuDificultad 
{
	public static Dificultad mostrarMenu(  Consola consola, String tituloMenu, ConsolaMenuItem[] menuItem)
	{
		return (Dificultad) ConsolaMenu.mostrarMenu( consola, tituloMenu, menuItem).getItemData();
	}
}
