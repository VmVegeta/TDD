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

}
