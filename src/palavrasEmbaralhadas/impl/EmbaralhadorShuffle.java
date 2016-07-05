package palavrasEmbaralhadas.impl;

import java.util.ArrayList;
import java.util.List;

import palavrasEmbaralhadas.Embaralhador;

public class EmbaralhadorShuffle implements Embaralhador {

	private static final int multiplicadorDificuldade = 4;
	
	public String embaralha(String palavra) {
		List<Character> characters = new ArrayList<Character>();
        for(char c : palavra.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(palavra.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
	}
	
	public int getMultiplicadorDificuldade() {
		return multiplicadorDificuldade;
	}
		
	@Override
	public String toString() {
		return "Embaralhador shuffle\n"
				+ "* Multiplicador de pontuação: x4";
	}
	
}
