package de.slotmachine.rest.model;

import java.util.ArrayList;
import java.util.List;

import de.slotmachine.rest.config.Config;

public class Reels {
	private List<Reel> reelList = new ArrayList<Reel>();
    public Reels() {
    	for(int i=0; i<Config.reelsConfig.reels.size(); i++) {
    		reelList.add(new Reel(Config.reelsConfig.reels.get(i)));
    	}
    }
    
    public List<ReelStripe> getReelStripes() {
    	List<ReelStripe> stripes = new ArrayList<ReelStripe>();
    	int stripeLength = Config.reelsConfig.reelStripeLength;
        for(int i=0; i<this.reelList.size(); i++) {
        	Reel reel = this.reelList.get(i);
        	ReelStripe stripe = reel.getRandomReelStripe(stripeLength);
        	stripes.add(stripe);
        }
        return stripes;
    }
}
