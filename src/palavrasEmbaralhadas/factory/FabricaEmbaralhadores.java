package palavrasEmbaralhadas.factory;

import palavrasEmbaralhadas.Embaralhador;
import palavrasEmbaralhadas.impl.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FabricaEmbaralhadores {

	private static enum Embaralhadores {
		reverso, shuffle
	}
	
	private static final List<Embaralhadores> VALUES =
		    Collections.unmodifiableList(Arrays.asList(Embaralhadores.values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
		
	// retorna um embaralhador aleatoriamente
	public static Embaralhador constroiEmbaralhador() {
		Embaralhadores e = getRandomImpl();
		
		switch(e) {
			
			case reverso:
				return new EmbaralhadorReverso();
								
			case shuffle:
				return new EmbaralhadorShuffle();
				
			default:
				return new EmbaralhadorShuffle();
		}
	}
	
	private static Embaralhadores getRandomImpl() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
	
}
