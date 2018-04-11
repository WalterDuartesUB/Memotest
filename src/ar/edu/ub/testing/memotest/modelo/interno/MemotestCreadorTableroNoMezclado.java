package ar.edu.ub.testing.memotest.modelo.interno;

import ar.edu.ub.testing.memotest.modelo.Carta;

public class MemotestCreadorTableroNoMezclado extends MemotestCreadorTableroMezclado
{
	@Override
	protected Carta[] mezclarCartas(Carta[] cartas)
	{
		return cartas.clone();
	}
}
