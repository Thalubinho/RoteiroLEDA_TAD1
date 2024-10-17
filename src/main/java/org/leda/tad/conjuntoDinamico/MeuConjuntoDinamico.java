package org.leda.tad.conjuntoDinamico;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer> {

	private Integer[] meusDados = null;
	private int posInsercao = 0;
	private static final int tamanhoInicial = 1;

	public MeuConjuntoDinamico(){
		this.meusDados = new Integer[1];
	}

	@Override
	public void inserir(Integer item) {
		if (arrayEstaCheio()) {
			aumentarArray();
		}
		meusDados[posInsercao] = item;
		posInsercao++;
	}

	private boolean arrayEstaCheio() {
		return posInsercao == meusDados.length;
    }

	private void aumentarArray() { //Qual é a taxa de aumento desse array? Dobra de tamanho
		// Criar um array maior (arrayMaior)
		Integer[] arrayMaior = new Integer[meusDados.length * 2];

		// Copiar os dados de meusDados (array cheio)
		for(int i = 0; i < meusDados.length; i++){
			arrayMaior[i] = meusDados[i];
		}

		// Colar os dados para o novo array (arrayMaior)
		meusDados = arrayMaior;
	}

	@Override
	public Integer remover(Integer item) throws ConjuntoVazioException{ // Remover a primeira ou todas as ocorrências?, Implementação feita removendo apenas a primeira
		if(posInsercao == 0){
			throw new ConjuntoVazioException();
		}

		int i = 0;
		Integer temp = null;
		do {
			if (meusDados[i].equals(item)) {
				temp = meusDados[i];
				meusDados[i] = null;
				// Realocando os elementos restantes
				for(int j = i+1; j < meusDados.length; j++){
					meusDados[j-1] = meusDados[j];
				}
				posInsercao--;
			}
			i++;
		} while(!item.equals(temp) && i < meusDados.length);

		return temp;
	}

	@Override
	public Integer predecessor(Integer item) throws ConjuntoVazioException {
		Integer predecessor = null;

		if(posInsercao == 0){
			throw new ConjuntoVazioException();
		}

		if(!(item.equals(meusDados[0]) || buscar(item) == null)){
			for (int i = 0; i < meusDados.length; i++) {
				if(meusDados[i].equals(item)){
					predecessor = meusDados[i - 1];
					break;
				}
			}
		}

		return predecessor;
	}

	@Override
	public Integer sucessor(Integer item) throws ConjuntoVazioException {
		Integer sucessor = null;

		if(posInsercao == 0){
			throw new ConjuntoVazioException();
		}

		if(!(item.equals(meusDados[meusDados.length-1]) || buscar(item) == null)){
			for (int i = 0; i < meusDados.length; i++) {
				if(meusDados[i].equals(item)){
					sucessor = meusDados[i + 1];
					break;
				}
			}
		}

		return sucessor;
	}

	@Override
	public int tamanho() {
		return posInsercao;
	}

	@Override
	public Integer buscar(Integer item) throws ConjuntoVazioException {
		if(posInsercao == 0){
			throw new ConjuntoVazioException();
		}

		Integer result = null;
		Integer busca = 0;
		int i = 0;
		do {
			if (meusDados[i].equals(item)) {
				busca = meusDados[i];
			}
			i++;
		} while (!busca.equals(item) && i < meusDados.length); // NullPointerException?

		if (busca.equals(item)) {
			result = busca;
		}
		return result;
	}

	@Override
	public Integer minimum() throws ConjuntoVazioException {
		if(posInsercao == 0){
			throw new ConjuntoVazioException();
		}

		Integer minimo = meusDados[0];
        for (Integer elemento : meusDados) {
            if (elemento < minimo) {
                minimo = elemento;
            }
        }
		return minimo;
	}

	@Override
	public Integer maximum() throws ConjuntoVazioException {
		if(posInsercao == 0){
			throw new ConjuntoVazioException();
		}

		Integer maximo = meusDados[0];
        for (Integer elemento : meusDados) {
            if (elemento > maximo) {
                maximo = elemento;

            }
        }
		return maximo;
	}

}
