package org.leda.tad.pilha;

public interface PilhaIF<E> {
	
	public void empilhar(E item) throws PilhaCheiaException;
	
	public E desempilhar() throws PilhaVaziaException;
	
	public E topo() throws PilhaVaziaException;
	
	public PilhaIF<E> multitop(int k) throws PilhaVaziaException;
	
	public boolean isEmpty();

	public Integer[] getMeusDados();
}
