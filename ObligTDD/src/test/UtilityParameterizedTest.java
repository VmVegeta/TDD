package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import TDDTaskCode.Utility;

@RunWith(Parameterized.class)
public class UtilityParameterizedTest {
	Utility utility = new Utility();

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{0,"000000000000000000000000","000000"},{1,"000000000000000000000001","000001"},{2,"000000000000000000000010","000002"},{3,"000000000000000000000011","000003"},
	{4,"000000000000000000000100","000004"},{10,"000000000000000000001010","00000a"},{15,"000000000000000000001111","00000f"},{30,"000000000000000000011110","00001e"},
	{60,"000000000000000000111100","00003c"},{120,"000000000000000001111000","000078"},{240,"000000000000000011110000","0000f0"},{480,"000000000000000111100000","0001e0"},
	{960,"000000000000001111000000","0003c0"},{1920,"000000000000011110000000","000780"},{3840,"000000000000111100000000","000f00"},{7680,"000000000001111000000000","001e00"},
	{8388608,"100000000000000000000000","800000"},{4194305,"010000000000000000000001","400001"},{2097154,"001000000000000000000010","200002"},{5,"000000000000000000000101","000005"},
	{66,"000000000000000001000010","000042"},{42,"000000000000000000101010","00002a"},{24,"000000000000000000011000","000018"},{16777215,"111111111111111111111111","ffffff"},
		});
	}

	@Parameter
	public int number;

	@Parameter(value = 1)
	public String bitString;

	@Parameter(value = 2)
	public String hexString;



	@Test
	public void turnToIntStringTest() {
		assertEquals(number, utility.turnToInt(bitString));
	}
	
	@Test
	public void turnToIntFromHexTest() {
		assertEquals(number,utility.turnToIntFromHex(hexString));
	}
	
	@Test
	public void turnToStringTest() {
		assertEquals(bitString, utility.turnToString(number));
	}
	
	@Test
	public void turnToHexTest() {
		assertEquals(hexString, utility.turnToHex(number));
	}
	
}
