package ar.edu.ub.testing.memotest.consola.menu;

import ar.edu.ub.testing.memotest.consola.Consola;

public class ConsolaMenu 
{

	private String tituloMenu;
	private ConsolaMenuItem[] menuItem;
	private ConsolaMenuItem menuItemElegido;
	private boolean ignorarMayusculas;
	
	private ConsolaMenu(String tituloMenu, ConsolaMenuItem[] MenuItem)
	{
		this.setTituloMenu(tituloMenu);
		this.setMenuItem(MenuItem);		
		this.setIgnorarMayusculas( true );
	}
	
	public static ConsolaMenuItem mostrarMenu( String tituloMenu, ConsolaMenuItem[] MenuItem)
	{
		ConsolaMenu menu = new ConsolaMenu( tituloMenu, MenuItem );		
		
		return menu.mostrarMenu();
	}

	public ConsolaMenuItem mostrarMenu() 
	{
		
		this.imprimir();
		this.elegirMenuItem();
		
		while( this.noEligioOpcion() )
		{		
			Consola.limpiarPantalla();
			
			this.imprimir();			
			this.imprimirOpcionInvalida();
			this.elegirMenuItem();
		}
		
		return this.getMenuItemElegido();
	}

	private void imprimirOpcionInvalida() 
	{
		System.out.println("(La opción ingresada no es valida. Por favor, ingrese otra.)");		
	}

	private void imprimir()
	{
		this.imprimirTitulo();
		this.imprimirOpciones();		
	}
	
	private boolean elegirMenuItem() 
	{
		String  opcionElegidaPorUsuario = Consola.nextLine();
		boolean pudeElegirOpcion = this.existeMenuItemConOpcion( opcionElegidaPorUsuario );
				
		if( pudeElegirOpcion )
			this.elegirMenuItem( opcionElegidaPorUsuario );
		
		return pudeElegirOpcion;
	}

	private void elegirMenuItem(String opcionElegidaPorUsuario) 
	{
		boolean existeItem = false;
		
		for( int posicion = 0; posicion < this.getMenuItems().length && existeItem == false; posicion++ )
		{
			existeItem = this.getMenuItems()[posicion].esLaOpcion( opcionElegidaPorUsuario, this.getIgnorarMayusculas() );
			
			if( existeItem )
				this.setMenuItemElegido( this.getMenuItems()[posicion] );
		}
		
	}

	private boolean existeMenuItemConOpcion(String opcionElegidaPorUsuario) 
	{
		boolean existeItem = false;
		
		for( int posicion = 0; posicion < this.getMenuItems().length && existeItem == false; posicion++ )
			existeItem = this.getMenuItems()[posicion].esLaOpcion( opcionElegidaPorUsuario, this.getIgnorarMayusculas() );
			
		return existeItem;
	}

	private boolean noEligioOpcion() 
	{
		return this.getMenuItemElegido() == null;
	}

	private void imprimirOpciones() {
		for( int posicion = 0; posicion < this.getMenuItems().length; posicion++ )
			this.imprimir( this.getMenuItems()[posicion]);
		
	}

	private void imprimir(ConsolaMenuItem menuItem) 
	{
		System.out.println( String.format("%3s - %-20s", menuItem.getOpcionEnConsola(), menuItem.getDescripcion() ) );
	}

	private void imprimirTitulo() 
	{
		System.out.println( this.getTituloMenu() );
		System.out.println( String.format("%-" + new Integer( this.getTituloMenu().length( )).toString() + "s", " ").replace(" ", "-")  );
	}

	public String getTituloMenu() 
	{
		return tituloMenu;
	}

	private void setTituloMenu(String tituloMenu) 
	{
		this.tituloMenu = tituloMenu;
	}

	public ConsolaMenuItem[] getMenuItems() 
	{
		return this.menuItem;
	}

	private void setMenuItem(ConsolaMenuItem[] MenuItem) 
	{
		this.menuItem = MenuItem;
	}

	private ConsolaMenuItem getMenuItemElegido() 
	{
		return this.menuItemElegido;
	}

	private void setMenuItemElegido(ConsolaMenuItem menuItemElegido) 
	{
		this.menuItemElegido = menuItemElegido;
	}

	private boolean getIgnorarMayusculas() {
		return ignorarMayusculas;
	}

	private void setIgnorarMayusculas(boolean ignorarMayusculas) {
		this.ignorarMayusculas = ignorarMayusculas;
	}
	
}
