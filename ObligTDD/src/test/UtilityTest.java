package test;

import static org.junit.Assert.*;

import org.junit.Test;

import TDDTaskCode.Utility;

public class UtilityTest {
	
	Utility utility = new Utility();

	@Test
	public void one_turnToInt_1() {
		String valueTo1 = "0000001";
		assertEquals(1, utility.turnToInt(valueTo1));
	}
	
	@Test
	public void two_turnToInt_2() {
		String valueTo2 = "00000010";
		assertEquals(2, utility.turnToInt(valueTo2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void stringLength25_turnToInt_throwIllegal() {
		String toBig = "00000000000000000000000000";
		utility.turnToInt(toBig);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void unknownSigns_turnToInt_throwIllegal() {
		String unknownSigns = "qwer45376+!3#";
		utility.turnToInt(unknownSigns);
	}
	
	@Test
	public void highEdgeCase_turnToInt_16777215() {
		String highEdge = "111111111111111111111111";
		assertEquals(16777215, utility.turnToInt(highEdge));
	}
	
	@Test
	public void lowEdgeCase_turnToInt_0() {
		String lowEdge = "";
		assertEquals(0, utility.turnToInt(lowEdge));
	}
	
	@Test
	public void one_turnToString_1() {
		String stringFor1 = "000000000000000000000001";
		assertEquals(stringFor1, utility.turnToString(1));
	}
	
	@Test
	public void two_turnToString_2() {
		String stringFor2 = "000000000000000000000010";
		assertEquals(stringFor2, utility.turnToString(2));
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void over24_turnToString_throwIllegal() {
       utility.turnToString(66777215);
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void under0_turnToString_throwIllegal() {
        utility.turnToString(-1);
    }
	
	@Test
	public void highEdge_turnToString_16777215() {
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
	
	@Test
	public void turnToIntFromHex_31() {
		String valueTo31 = "00001f";
		assertEquals(31, utility.turnToIntFromHex(valueTo31));
	}
	
	@Test
	public void turnToIntFromHex_highEdge() {
		String valueOfHigh = "ffffff";
		assertEquals(16777215, utility.turnToIntFromHex(valueOfHigh));
	}
	
	@Test
	public void turnToIntFromHex_lowEdge() {
		String valueOfLow = "";
		assertEquals(0, utility.turnToIntFromHex(valueOfLow));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void turnToIntFromHex_over6() {
		String overSixLength = "0000000";
		assertEquals(0, utility.turnToIntFromHex(overSixLength));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void turnToHex_unknownSigns() {
		String unknownSigns = "s3G#å!";
		assertEquals(0, utility.turnToIntFromHex(unknownSigns));
	}
	
	@Test
	public void turnToHex_1() {
		String hexOf1 = "000001";
		assertEquals(hexOf1, utility.turnToHex(1));
	}
	
	@Test
	public void turnToHex_31() {
		String hexFor31 = "00001f";
		assertEquals(hexFor31, utility.turnToHex(31));
	}
	
	@Test
	public void turnToHex_lowEdge() {
		String hexForLowEdge = "000000";
		assertEquals(hexForLowEdge, utility.turnToHex(0));
	}
	
	@Test
	public void turnToHex_highEdge() {
		String hexForHighEdge = "ffffff";
		assertEquals(hexForHighEdge, utility.turnToHex(16777215));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void turnToHex_overEdge() {
		assertEquals("", utility.turnToHex(16777216));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void turnToHex_underEdge() {
		assertEquals("", utility.turnToHex(-1));
	}
	
	@Test
	public void threeAnd3_operator_3() {
		assertEquals("000000000000000000000011", utility.operator("1", "011", "011"));
	}
	
	@Test
	public void fiveOr5_operator_5() {
		assertEquals("000000000000000000000101", utility.operator("2", "101", "101"));
	}
	
	@Test
	public void threeAnd5_operator_1() {
		assertEquals("000000000000000000000001", utility.operator("1", "11", "000000101"));
	}
	
	@Test
	public void threeOr5_operator_1() {
		assertEquals("000000000000000000000111", utility.operator("2", "000011", "0000101"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void operator3_operator_illegal() {
		utility.operator("3", "0", "0");
	}
	
}
