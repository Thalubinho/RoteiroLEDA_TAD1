package org.leda.tad.pilha;

import java.util.NoSuchElementException;

public class MinhaPilha implements PilhaIF<Integer> {
	
	private int tamanho = 5;
	private int cabeca = -1;
	private Integer[] meusDados = null;

	public MinhaPilha(int tamanho) {
		this.tamanho = tamanho;
		meusDados = new Integer[tamanho];
	}
	
	public MinhaPilha() {
		meusDados = new Integer[tamanho];
	}

	@Override
	public Integer[] getMeusDados() {
		return meusDados;
	}

	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		if(cabeca == meusDados.length-1) {
			throw new PilhaCheiaException();
		} else {
			meusDados[++cabeca] = item;
		}
	}

	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		if(isEmpty()){
			throw new PilhaVaziaException();
		} else {
			return meusDados[cabeca--];
		}
	}

	@Override
	public Integer topo() throws PilhaVaziaException {
		if(!isEmpty()){
			return meusDados[cabeca];
		} else {
			throw new PilhaVaziaException();
		}
	}

	@Override
	public PilhaIF<Integer> multitop(int k) throws PilhaVaziaException {
		PilhaIF<Integer> pilhaMultiTop = new MinhaPilha(k);
		int i = cabeca;

		if(k > meusDados.length) {
			throw new PilhaVaziaException();
		}

		while (k != 0){
            try {
                pilhaMultiTop.empilhar(meusDados[i]);
            } catch (PilhaCheiaException e) {
                throw new RuntimeException(e);
            }
            k--;
			i--;
		}

		return pilhaMultiTop;
	}

	@Override
	public boolean isEmpty() {
		return cabeca == -1;
	}

}
