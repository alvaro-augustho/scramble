package palavrasEmbaralhadas.impl;

import palavrasEmbaralhadas.Embaralhador;

public class EmbaralhadorReverso implements Embaralhador {
	
	static final int multiplicadorDificuldade = 1;
	
	public String embaralha(String palavra) {
		return new StringBuilder(palavra).reverse().toString();
	}
	
	public int getMultiplicadorDificuldade() {
		return this.multiplicadorDificuldade;
	}
	
	@Override
	public String toString() {
		return "Embaralhador reverso\n"
				+ "* Multiplicador de pontuação: x1";
	}
	
}
