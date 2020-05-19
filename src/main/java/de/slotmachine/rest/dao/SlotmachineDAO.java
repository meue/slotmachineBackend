package de.slotmachine.rest.dao;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import de.slotmachine.rest.model.Paytable;
import de.slotmachine.rest.model.ReelStripe;
import de.slotmachine.rest.model.Reels;
import de.slotmachine.rest.model.SpinResult;
 
@Repository
public class SlotmachineDAO 
{
    private static Reels reels = new Reels();
	private static Paytable paytable = new Paytable();
     
    public SpinResult getSpinResult() 
    {
    	SpinResult spinResult = new SpinResult();
    	List<ReelStripe> stripes = reels.getReelStripes();
    	spinResult.setResult(stripes, paytable);
        return spinResult;
    }
}