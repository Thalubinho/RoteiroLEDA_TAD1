package org.leda.tad.fila;

import org.leda.tad.listasEncadeadas.ListaEncadeadaIF;

public class MinhaFilaEncadeada implements FilaIF<Integer> {

	private ListaEncadeadaIF filaEncadeada = null;

	@Override
	public void enfileirar(Integer item) throws FilaCheiaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer desenfileirar() throws FilaVaziaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer verificarCauda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer verificarCabeca() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

}
