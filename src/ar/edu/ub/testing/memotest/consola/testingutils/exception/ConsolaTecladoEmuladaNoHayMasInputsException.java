package ar.edu.ub.testing.memotest.consola.testingutils.exception;

public class ConsolaTecladoEmuladaNoHayMasInputsException extends ConsolaTecladoEmuladaException
{
	private static final long serialVersionUID = 1L;

	public ConsolaTecladoEmuladaNoHayMasInputsException()
	{
		super( "No hay m�s inputs emulados para nextLine" );
	}

}
