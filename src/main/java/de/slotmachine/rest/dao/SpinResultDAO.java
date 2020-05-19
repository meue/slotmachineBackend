package de.slotmachine.rest.dao;

import java.util.ArrayList;
import java.util.List;

import de.slotmachine.rest.model.Payline;
import de.slotmachine.rest.model.Paytable;
import de.slotmachine.rest.model.ReelStripe;

public class SpinResultDAO {
	
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
