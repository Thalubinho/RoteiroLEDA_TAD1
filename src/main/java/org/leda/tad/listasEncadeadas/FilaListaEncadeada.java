package org.leda.tad.listasEncadeadas;

import org.leda.tad.fila.FilaCheiaException;
import org.leda.tad.fila.FilaIF;
import org.leda.tad.fila.FilaVaziaException;

public class FilaListaEncadeada implements FilaIF<NodoListaEncadeada<Integer>> {
	
	private ListaEncadeadaIF<Integer> fila;

	@Override
	public void enfileirar(NodoListaEncadeada<Integer> item) throws FilaCheiaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NodoListaEncadeada<Integer> desenfileirar() throws FilaVaziaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodoListaEncadeada<Integer> verificarCauda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodoListaEncadeada<Integer> verificarCabeca() {
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
