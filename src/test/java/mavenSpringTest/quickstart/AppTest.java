package mavenSpringTest.quickstart;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.slotmachine.rest.model.Reel;
import de.slotmachine.rest.model.ReelStripe;

public class AppTest {
	@Test
	/**
	 * Tests if the Reel contains one of the symbols given
	 */
	public void testReelSymbol() {
		List<String> symbols = new ArrayList<String>();
		symbols.add("A");
		symbols.add("B");
		symbols.add("C");
		Reel reel = new Reel(symbols);
		ReelStripe stripe = reel.getRandomReelStripe(1);
		assertTrue(getStringIsInList(symbols, stripe.getSymbols().get(0)));
	}

	@Test
	/**
	 * Tests if the Reel contains the symbols in correct order
	 */
	public void testReelStripe()
    {
    	List<String> symbols = new ArrayList<String>();
    	symbols.add("A");
    	symbols.add("B");
    	symbols.add("C");
    	symbols.add("D");
    	Reel reel = new Reel(symbols);
    	ReelStripe stripe = reel.getRandomReelStripe(3);
    	
    	int firstSymbolIndex = getIndexOfSymbolInStripe(symbols, stripe.getSymbols().get(0));
    	int secondSymbolIndex = getIndexOfSymbolInStripe(symbols, stripe.getSymbols().get(1));
    	int thirdSymbolIndex = getIndexOfSymbolInStripe(symbols, stripe.getSymbols().get(2));
    	
    	boolean secondAfterFirst = (firstSymbolIndex + 1) % symbols.size() == secondSymbolIndex;
    	boolean thirdAfterSecond = (secondSymbolIndex + 1) % symbols.size() == thirdSymbolIndex;
    	
        assertTrue( secondAfterFirst && thirdAfterSecond );
    }

	private boolean getStringIsInList(List<String> symbols, String symbol) {
		for (int i = 0; i < symbols.size(); i++) {
			if (symbols.get(i).contentEquals(symbol)) {
				return true;
			}
		}
		return false;
	}

	private int getIndexOfSymbolInStripe(List<String> symbols, String symbol) {
		for (int i = 0; i < symbols.size(); i++) {
			if (symbols.get(i).contentEquals(symbol)) {
				return i;
			}
		}
		return -1;
	}
}
