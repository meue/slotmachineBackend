package de.slotmachine.rest.dao;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import de.slotmachine.rest.model.Paytable;
import de.slotmachine.rest.model.ReelStripe;
import de.slotmachine.rest.model.Reels;
 
@Repository
public class SlotmachineDAO 
{
    private static Reels reels = new Reels();
	private static Paytable paytable = new Paytable();
     
    public SpinResultDAO getSpinResult() 
    {
    	SpinResultDAO spinResult = new SpinResultDAO();
    	List<ReelStripe> stripes = reels.getReelStripes();
    	spinResult.setResult(stripes, paytable);
        return spinResult;
    }
}