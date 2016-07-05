import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import palavrasEmbaralhadas.impl.EmbaralhadorReverso;
import palavrasEmbaralhadas.Embaralhador;
import palavrasEmbaralhadas.BancoDePalavras;


public class TesteEmbaralhorReverso {

	@Test
	public void testConstrutor() {
		Embaralhador embaralhador = new EmbaralhadorReverso();
		assertNotNull(embaralhador);
	}
	
	@Test
	public void testImplementação() {
		Embaralhador embaralhador = new EmbaralhadorReverso();
		assertThat(embaralhador, instanceOf(Embaralhador.class));
		assertThat(embaralhador, instanceOf(EmbaralhadorReverso.class));
	}
	
	@Test
	public void testEmbaralhaPalavra() {
		String palavra = BancoDePalavras.retornarPalavra();
		Embaralhador embaralhador = new EmbaralhadorReverso();
		String palavraEmbaralhada = embaralhador.embaralha(palavra);
		String palavraReversa = new StringBuilder(palavra).reverse().toString();
		assertEquals(palavraEmbaralhada, palavraReversa);
	}
	
}
