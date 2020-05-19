package de.slotmachine.rest.model;

import java.util.ArrayList;
import java.util.List;

public class SpinResult {
	
	// Will be printed in RestCall
	public List<ReelStripe> reelStripes = new ArrayList<ReelStripe>();
	public List<Payline> winlines = new ArrayList<Payline>();
	public int win = 0;

	public void setResult(List<ReelStripe> stripes, Paytable paytable) {
		this.reelStripes = stripes;
		this.winlines = paytable.getPaylines(reelStripes);
		this.win = paytable.getWinAmount(reelStripes);
	}
}
