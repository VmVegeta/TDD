package test;

import static org.junit.Assert.*;

import org.junit.Test;

import TDDTaskCode.Utility;

public class UtilityTest {
	
	Utility utility = new Utility();

	@Test
	public void turnToInt_1() {
		String valueTo1 = "0000001";
		assertEquals(1, utility.turnToInt(valueTo1));
	}
	
	@Test
	public void turnToInt_2() {
		String valueTo2 = "00000010";
		assertEquals(2, utility.turnToInt(valueTo2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void turnToInt_underSize24() {
		String toBig = "00000000000000000000000000";
		assertEquals(0,utility.turnToInt(toBig));
	}
	
	@Test
	public void turnToInt_highEdgeCase() {
		String highEdge = "111111111111111111111111";
		assertEquals(16777215, utility.turnToInt(highEdge));
	}
	
	@Test
	public void turnToInt_lowEdgeCase() {
		String lowEdge = "00000000000000000000000";
		assertEquals(0, utility.turnToInt(lowEdge));
	}
	
	@Test
	public void turnToString_1() {
		String stringFor1 = "000000000000000000000001";
		assertEquals(stringFor1, utility.turnToString(1));
	}
	
	@Test
	public void turnToString_2() {
		String stringFor2 = "000000000000000000000010";
		assertEquals(stringFor2, utility.turnToString(2));
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void turnToString_over24() {
        String stringForOver = "000000000000000000000000";
        assertEquals(stringForOver, utility.turnToString(66777215));
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void turnToString_under0() {
        String stringForOver = "000000000000000000000000";
        assertEquals(stringForOver, utility.turnToString(-1));
    }
	
	@Test
	public void turnToString_highEdge_16777215() {
		String stringForHighCase = "111111111111111111111111";
		assertEquals(stringForHighCase, utility.turnToString(16777215));
	}
	
	@Test
	public void turnToString_lowEdge_0() {
		String stringForLowCase = "000000000000000000000000";
		assertEquals(stringForLowCase, utility.turnToString(0));
	}
	
	@Test
	public void turnToIntFromHex_1() {
		String valueTo1 = "000001";
		assertEquals(1, utility.turnToIntFromHex(valueTo1));
	}

}
