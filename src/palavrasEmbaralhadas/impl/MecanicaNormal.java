package palavrasEmbaralhadas.impl;

import palavrasEmbaralhadas.Embaralhador;
import palavrasEmbaralhadas.MecanicaDoJogo;
import palavrasEmbaralhadas.factory.FabricaEmbaralhadores;

public class MecanicaNormal implements MecanicaDoJogo {

	int pontosAcerto = 5;
	int tentativas;
	int pontuacao;
	Embaralhador embaralhador;
	
	@Override
	public String toString() {
		return "Jogo normal:\n"
				+ "* Você pode errar até 3 vezes\n"
				+ "* Cada acerto vale 5 pontos\n"
				+ embaralhador.toString()
				+ "\n\n";
	}
	
	public boolean checaTentativa(String palavra, String tentativa) {
		if(palavra.equalsIgnoreCase(tentativa)) {
			this.pontuacao+=(embaralhador.getMultiplicadorDificuldade()*pontosAcerto);
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
	
	public MecanicaNormal() {
		this.embaralhador = FabricaEmbaralhadores.constroiEmbaralhador();
		this.tentativas = 3;
		this.pontuacao = 0;
	}
	
	public void reiniciaJogo() {
		this.tentativas = 3;
		this.pontuacao = 0;
	}
	
	
	
}
