package ar.edu.ub.testing.memotest.consola.menu;

public class ConsolaMenuFinJuego 
{
	public enum DecisionFinJuego
	{
		DFJ_JUGAR_REVANCHA_CON_LA_MISMA_DIFICULTAD,
		DFJ_JUGAR_JUEGO_NUEVO_ELIGIENDO_DIFICULTAD,
		DFJ_SALIR_APLICACION
	};
	
	public static DecisionFinJuego mostrarMenu( )
	{
		String 				tituloMenu = "Fin del juego";
		ConsolaMenuItem[] 	menuItem = new ConsolaMenuItem[]
				{
						new ConsolaMenuItem("Jugar la revancha", "R", DecisionFinJuego.DFJ_JUGAR_REVANCHA_CON_LA_MISMA_DIFICULTAD ),
						new ConsolaMenuItem("Jugar una partida nueva eligiendo la dificultad", "V", DecisionFinJuego.DFJ_JUGAR_JUEGO_NUEVO_ELIGIENDO_DIFICULTAD ),
						new ConsolaMenuItem("Salir de la aplicación", "S", DecisionFinJuego.DFJ_SALIR_APLICACION )						
				};
				
		return (DecisionFinJuego) ConsolaMenu.mostrarMenu(tituloMenu, menuItem).getItemData();
	}
}
