package palavrasEmbaralhadas;

public interface MecanicaDoJogo {

	public boolean checaTentativa(String palavra, String tentativa);
	
	public void reiniciaJogo();
	
	public void finalizaJogo();
	
	public String embaralhaPalavra(String palavra);
	
}
