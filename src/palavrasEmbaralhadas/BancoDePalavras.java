package palavrasEmbaralhadas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
 * Criado por Alvaro
 */

public class BancoDePalavras {

	private static final Random randomGenerator = new Random();
	private static final ArrayList<String> listaDePalavras;
	
	// inicializacao estatica para garantir que o arquivo sera
	// lido na memoria apenas uma vez
	static {
		BufferedReader in = null;
		try {
		in = new BufferedReader(new FileReader("src/resources/banco_de_palavras"));
		} catch(FileNotFoundException e) {
			System.err.println("Arquivo de banco de palavras não encontrado!");
		}
		
		String str;
		
		listaDePalavras = new ArrayList<String>();
		try {
			while((str = in.readLine()) != null) {
				listaDePalavras.add(str);
			}
		} catch(IOException e) {
			System.err.println("Erro ao ler palavras do banco!");
		} catch(NullPointerException e) {
			System.err.println("Nada para ler!");
		}
	}
	
	// retorna uma palavra aleatoriamente
	public static String retornarPalavra() {
		int r = randomGenerator.nextInt(listaDePalavras.size());
		try {
			return listaDePalavras.get(r);
		} catch(NullPointerException e) {
			throw e;
		}
	}
	
}
