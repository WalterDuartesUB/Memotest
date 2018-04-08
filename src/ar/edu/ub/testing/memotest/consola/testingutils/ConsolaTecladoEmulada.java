package ar.edu.ub.testing.memotest.consola.testingutils;

import ar.edu.ub.testing.memotest.consola.Consola;
import ar.edu.ub.testing.memotest.consola.testingutils.exception.ConsolaTecladoEmuladaNoHayInputsException;
import ar.edu.ub.testing.memotest.consola.testingutils.exception.ConsolaTecladoEmuladaNoHayMasInputsException;

public class ConsolaTecladoEmulada extends Consola
{
	private String[] inputsEmulados;
	private Integer posicionInputEmulado;
	
	public ConsolaTecladoEmulada( String[] inputsEmulados )
	{
		if( inputsEmulados == null || inputsEmulados.length == 0 )
			throw new ConsolaTecladoEmuladaNoHayInputsException();
		
		this.setInputsEmulados(inputsEmulados);
		this.setPosicionInputEmulado( 0 );
	}

	@Override
	public void limpiarPantalla()
	{
	}

	@Override
	public String nextLine()
	{
		
		if( this.getPosicionInputEmulado() == inputsEmulados.length )
			throw new ConsolaTecladoEmuladaNoHayMasInputsException();
		
		String inputEmulado = this.getInputsEmulados()[ this.getPosicionInputEmulado() ];
		
		this.setPosicionInputEmulado( this.getPosicionInputEmulado() + 1 );
		
		return inputEmulado;
	}

	@Override
	public void print(String s)
	{
	}

	@Override
	public void println()
	{
	}

	@Override
	public void println(String s)
	{
	}

	@Override
	public void finalizar()
	{
	}

	private String[] getInputsEmulados()
	{
		return inputsEmulados;
	}

	private void setInputsEmulados(String[] inputsEmulados)
	{
		this.inputsEmulados = inputsEmulados;
	}

	private Integer getPosicionInputEmulado()
	{
		return posicionInputEmulado;
	}

	private void setPosicionInputEmulado(Integer posicionInputEmulado)
	{
		this.posicionInputEmulado = posicionInputEmulado;
	}

}
