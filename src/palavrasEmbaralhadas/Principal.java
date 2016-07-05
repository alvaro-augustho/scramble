package palavrasEmbaralhadas;

import java.util.Scanner;
import palavrasEmbaralhadas.factory.*;

public class Principal {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		MecanicaDoJogo mecanica = FabricaMecanicaDoJogo
				.constroiMecanicaDoJogo();

		System.out.println(mecanica);

		boolean naoSairJogo = true;
		while (naoSairJogo) { // loop ate o jogador decidir parar
			try {
				String palavra = BancoDePalavras.retornarPalavra();
				String palavraEmbaralhada = mecanica.embaralhaPalavra(palavra);
				System.out.println("Que palavra é esta? " + palavraEmbaralhada);

				String tentativa = in.nextLine();

				System.out.println("Você digitou: " + tentativa);

				System.out.println("\n\n");

				if (!mecanica.checaTentativa(palavra, tentativa)) {
					while (true) {
						System.out.println("Deseja continuar jogando? (y/n)");
						String resposta = in.nextLine();

						if (resposta.equalsIgnoreCase("n")) {
							mecanica.finalizaJogo();
							System.out.println("Até mais.");
							naoSairJogo = false;
							break;
						} else if (!resposta.equalsIgnoreCase("y")) {
							System.out
									.println("Por favor, responda com (y/n): ");
							continue;
						}

						break;
					}
				}

			} catch (NullPointerException e) {
				System.out.println("Erro ao iniciar jogo!");
			}
		}
	}
}
