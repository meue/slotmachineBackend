package de.slotmachine.rest.model;

public class PaytableSymbol {
	public String symbolId;
	public int[] winAmounts;
	
	public PaytableSymbol(String symbolId, int[] winAmounts) {
		 this.symbolId = symbolId;
		 this.winAmounts = winAmounts;
	}
}
