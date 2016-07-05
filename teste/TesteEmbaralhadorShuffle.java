import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import palavrasEmbaralhadas.impl.EmbaralhadorShuffle;
import palavrasEmbaralhadas.Embaralhador;
import palavrasEmbaralhadas.BancoDePalavras;


public class TesteEmbaralhadorShuffle {

	@Test
	public void testConstrutor() {
		Embaralhador embaralhador = new EmbaralhadorShuffle();
		assertNotNull(embaralhador);
	}
	
	@Test
	public void testImplementação() {
		Embaralhador embaralhador = new EmbaralhadorShuffle();
		assertThat(embaralhador, instanceOf(Embaralhador.class));
		assertThat(embaralhador, instanceOf(EmbaralhadorShuffle.class));
	}
	
	@Test
	public void testEmbaralhaPalavra() {
		String palavra = BancoDePalavras.retornarPalavra();
		Embaralhador embaralhador = new EmbaralhadorShuffle();
		String palavraEmbaralhada = embaralhador.embaralha(palavra);
		assertTrue(this.isAnagram(palavra, palavraEmbaralhada));
	}
	
	private boolean isAnagram(String firstWord, String secondWord) {
	     char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
	     char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
	     Arrays.sort(word1);
	     Arrays.sort(word2);
	     return Arrays.equals(word1, word2);
	}
	
}
