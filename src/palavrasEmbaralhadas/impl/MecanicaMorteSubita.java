package palavrasEmbaralhadas.impl;

import palavrasEmbaralhadas.Embaralhador;
import palavrasEmbaralhadas.MecanicaDoJogo;
import palavrasEmbaralhadas.factory.FabricaEmbaralhadores;

public class MecanicaMorteSubita implements MecanicaDoJogo {

	/*
	 * - acaba no primeiro erro
	 * - cada acerto vale 20 pontos x multiplicador de dificuldade do embaralhador
	 */
	
	private static final int PONTOS_ACERTO = 20;
	private int pontuacao;
	private Embaralhador embaralhador;

	public MecanicaMorteSubita() {
		this.embaralhador = FabricaEmbaralhadores.constroiEmbaralhador();
		this.pontuacao = 0;
	}
	
	public boolean checaTentativa(String palavra, String tentativa) {
		if(palavra.equalsIgnoreCase(tentativa)) {
			this.pontuacao+=(embaralhador.getMultiplicadorDificuldade()*PONTOS_ACERTO);
			System.out.println("Parabéns! Você acertou!");
			System.out.println("Pontuação atual: "+pontuacao+" pontos");
			return true;
		} else {
			System.out.println("Que pena! Você errou.");
			System.out.println("Pontuação final: "+pontuacao+" pontos");
			this.reiniciaJogo();
			return false;
		}
	}
	
	public void finalizaJogo() {
		return;
	}
	
	public String embaralhaPalavra(String palavra) {
		return this.embaralhador.embaralha(palavra);
	}
	
	public void reiniciaJogo() {
		this.pontuacao = 0;
	}
	
	@Override
	public String toString() {
		return "Jogo de morte subita:\n"
				+ "* Errou, acabou\n"
				+ "* Cada acerto vale "+PONTOS_ACERTO+" pontos\n"
				+ embaralhador.toString()
				+ "\n\n";
	}
	
}
