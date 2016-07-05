package palavrasEmbaralhadas.factory;

import palavrasEmbaralhadas.MecanicaDoJogo;
import palavrasEmbaralhadas.impl.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FabricaMecanicaDoJogo {

	private static enum Mecanicas {
		normal, morte_subita
	}
	
	private static final List<Mecanicas> VALUES =
		    Collections.unmodifiableList(Arrays.asList(Mecanicas.values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
		
	public static MecanicaDoJogo constroiMecanicaDoJogo() {
		Mecanicas m = getRandomImpl();
		
		switch(m) {
			
			case normal:
				return new MecanicaNormal();
								
			case morte_subita:
				return new MecanicaMorteSubita();
				
			default:
				return new MecanicaNormal();
		}
	}
	
	private static Mecanicas getRandomImpl() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
	
}
