package palavrasEmbaralhadas.impl;

import palavrasEmbaralhadas.Embaralhador;
import palavrasEmbaralhadas.MecanicaDoJogo;
import palavrasEmbaralhadas.factory.FabricaEmbaralhadores;

public class MecanicaNormal implements MecanicaDoJogo {

	/*
	 * - ate tres erros
	 * - cada acerto vale 5 pontos x multiplicador de dificuldade do embaralhador
	 */
	
	private static final int PONTOS_ACERTO = 5;
	private int tentativas;
	private int pontuacao;
	private Embaralhador embaralhador;
	
	public MecanicaNormal() {
		this.embaralhador = FabricaEmbaralhadores.constroiEmbaralhador();
		this.tentativas = 3;
		this.pontuacao = 0;
	}
	
	public boolean checaTentativa(String palavra, String tentativa) {
		if(palavra.equalsIgnoreCase(tentativa)) {
			this.pontuacao+=(embaralhador.getMultiplicadorDificuldade()*PONTOS_ACERTO);
			System.out.println("Parabéns! Você acertou!");
			System.out.println("Pontuação atual: "+pontuacao+" pontos");
			return true;
		} 
		
		tentativas--;
		
		if(tentativas != 0) {
			System.out.println("Que pena! Você errou.");
			System.out.println("Você tem mais "+tentativas+" tentativas");
			return false;
		} else {
			System.out.println("Que pena! Você errou.");
			System.out.println("Suas tentativas acabaram. Fim de jogo.");
			System.out.println("Pontuação final: "+pontuacao+" pontos.");
			this.reiniciaJogo();
			return false;
		}
	}
	
	public void finalizaJogo() {
		if(tentativas > 0) {
			System.out.println("Pontuação final: "+pontuacao+" pontos");
		}
	}
	
	public String embaralhaPalavra(String palavra) {
		return this.embaralhador.embaralha(palavra);
	}
	
	public void reiniciaJogo() {
		this.tentativas = 3;
		this.pontuacao = 0;
	}
	
	@Override
	public String toString() {
		return "Jogo normal:\n"
				+ "* Você pode errar até 3 vezes\n"
				+ "* Cada acerto vale "+PONTOS_ACERTO+" pontos\n"
				+ embaralhador.toString()
				+ "\n\n";
	}

}
