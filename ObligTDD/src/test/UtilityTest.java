package test;

import static org.junit.Assert.*;

import org.junit.Test;

import TDDTaskCode.Utility;

public class UtilityTest {
	
	Utility utility = new Utility();

	@Test
	public void test() {
		String valueTo1 = "0000001";
		assertEquals(1, utility.turnToInt(valueTo1));
	}

}
