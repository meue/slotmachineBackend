package de.slotmachine.rest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Reel {
	private List<String> symbols = new ArrayList<String>();
	public Reel(List<String> symbols) {
		this.symbols = symbols;
	}
	
	public ReelStripe getRandomReelStripe(int length) {
		ReelStripe reelStripe = new ReelStripe();
		int startIndex = getRandomIndex();
		for(int i=0; i<length; i++) {
			int currentIndex = getRelativeIndex(startIndex, i);
			reelStripe.addSymbol(this.symbols.get(currentIndex));
		}
		
		return reelStripe;
	}
	
	private int getRandomIndex() {
		Random random = new Random();
		return random.nextInt(this.symbols.size() -1);
	}
	
	private int getRelativeIndex(int index, int step) {
		return (index + step)  % this.symbols.size();
	}
}
