package de.slotmachine.rest.model;

import java.util.ArrayList;
import java.util.List;

import de.slotmachine.rest.config.Config;
import de.slotmachine.rest.config.PaytableSymbolConfig;

public class Paytable {
	List<PaytableSymbol> paytableSymbols = new ArrayList<PaytableSymbol>();
	List<Payline> paylines = new ArrayList<Payline>();

	public Paytable() {
		initPaylines();
		initPaytable();
	}

	public int getWinAmount(List<ReelStripe> stripes) {
		int totalWin = 0;
		for (int i = 0; i < paylines.size(); i++) {
			Payline payline = paylines.get(i);
			totalWin += getWinAmountForPayline(payline, stripes);
		}
		return totalWin;
	}

	public List<Payline> getPaylines(List<ReelStripe> stripes) {
		List<Payline> affectedWinLines = new ArrayList<Payline>();
		for (int i = 0; i < paylines.size(); i++) {
			Payline payline = paylines.get(i);
			if (getWinAmountForPayline(payline, stripes) > 0) {
				affectedWinLines.add(payline);
			}
		}
		return affectedWinLines;
	}

	private int getWinAmountForPayline(Payline payline, List<ReelStripe> stripes) {
		List<String> symbolsOnPayline = getSymbolsOnPayline(payline, stripes);
		int winAmount = 0;
		try {
			winAmount = getWinAmountForLine(symbolsOnPayline);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return winAmount;
	}

	private List<String> getSymbolsOnPayline(Payline payline, List<ReelStripe> stripes) {
		List<String> symbols = new ArrayList<String>();
		for (int i = 0; i < payline.indexes.length; i++) {
			int index = payline.indexes[i];
			String symbol = stripes.get(i).getSymbols().get(index);
			symbols.add(symbol);
		}
		return symbols;
	}

	private int getWinAmountForLine(List<String> symbols) throws Exception {
		PaytableSymbol symbol = getPaytableSymbol(symbols.get(0));
		int sameSymbols = 0;
		for (int i = 0; i < symbols.size(); i++) {
			if (!isSymbolMatch(symbol, symbols.get(i))) {
				break;
			}
			sameSymbols++;
		}
		return symbol.winAmounts[sameSymbols -1];
	}

	private boolean isSymbolMatch(PaytableSymbol paytableSymbol, String symbol) {
		return paytableSymbol.symbolId.equals(symbol);
	}

	private PaytableSymbol getPaytableSymbol(String symbolId) throws Exception {
		for (int i = 0; i < paytableSymbols.size(); i++) {
			if(paytableSymbols.get(i).symbolId.contentEquals(symbolId)) {
				return paytableSymbols.get(i);				
			}
		}
		throw new Exception("Symbol " + symbolId + " not found in Paytable.");
	}
	
	private void initPaylines() {
		for(int i=0; i< Config.paylinesConfig.paylines.size(); i++) {
			int[] payline = Config.paylinesConfig.paylines.get(i);
			paylines.add(new Payline(payline));
		}
	}
	private void initPaytable() {
		for(int i=0; i< Config.paytableConfig.paytable.size(); i++) {
			PaytableSymbolConfig symbolConfig = Config.paytableConfig.paytable.get(i);
			paytableSymbols.add(new PaytableSymbol(symbolConfig.symbolId, symbolConfig.winAmount));
		}
	}
}
