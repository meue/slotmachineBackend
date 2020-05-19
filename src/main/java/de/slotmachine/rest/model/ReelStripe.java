package de.slotmachine.rest.model;

import java.util.ArrayList;
import java.util.List;

public class ReelStripe {

	private List<String> symbols = new ArrayList<String>();
	
	public void addSymbol(String symbol) {
		this.symbols.add(symbol);
	}

	public List<String> getSymbols() {
		return this.symbols;
	}
	
}
