package test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;
import static junit.framework.TestCase.assertEquals;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import TDDTaskCode.InputAndOutput;

public class InputAndOutputTest{

	InputAndOutput inputAndOutput = new InputAndOutput();



	@Test
	public void oneLine_readFromFile_theSameLine() throws IOException{
		BufferedReader mockBuffer = mock(BufferedReader.class);
		when(mockBuffer.readLine()).thenReturn("000001 1 01010101010101010101010 111111110000000011111111", (String) null);
		assertEquals("000001 1 01010101010101010101010 111111110000000011111111\n", inputAndOutput.readFromFile(mockBuffer));
	}

	@Test
	public void oneLine_readFromFile_addedToMap() throws IOException {
		BufferedReader mockBuffer = mock(BufferedReader.class);
		when(mockBuffer.readLine()).thenReturn("000001 1 01010101010101010101010 111111110000000011111111", (String) null);
		inputAndOutput.readFromFile(mockBuffer);
		assertEquals(1, inputAndOutput.getSize());
	}

	@Test
	public void twoLinesSameID_readFromFile_addedOnlyOneToMap() throws IOException {
		BufferedReader mockBuffer = mock(BufferedReader.class);
		when(mockBuffer.readLine()).thenReturn("000001 1 01010101010101010101010 111111110000000011111111",
				"000001 2 10101010101010101010101 000000001111111100000000", (String) null);
		inputAndOutput.readFromFile(mockBuffer);
		assertEquals(1, inputAndOutput.getSize());
	}

	@Test(expected = IllegalArgumentException.class)
	public void fiveArguments_handleLine_throwIllegal() {
		inputAndOutput.handleLine((StringBuilder) null, "000001 1 01010101010101010101010 111111110000000011111111 1001010101");
	}

	@Test(expected = IllegalArgumentException.class)
	public void threeArguments_handleLine_throwIllegal() {
		inputAndOutput.handleLine((StringBuilder) null, "000001 1 01010101010101010101010");
	}


	@Test
	public void twoLinesSameID_readfromFile_addedToError() throws IOException {
		BufferedReader mockBuffer = mock(BufferedReader.class);
		when(mockBuffer.readLine()).thenReturn("000001 1 01010101010101010101010 111111110000000011111111",
				"000001 2 10101010101010101010101 000000001111111100000000", (String) null);
		inputAndOutput.readFromFile(mockBuffer);
		assertEquals(1, inputAndOutput.getErrorSize());
	}

	@Test
	public void wrongOperator_readfromFile_addedToError() throws IOException {
		BufferedReader mockBuffer = mock(BufferedReader.class);
		when(mockBuffer.readLine()).thenReturn("000001 3 01010101010101010101010 111111110000000011111111", (String) null);
		inputAndOutput.readFromFile(mockBuffer);
		assertEquals(1, inputAndOutput.getErrorSize());
	}

	@Test
	public void testReadGetFirstElement() throws IOException {
		BufferedReader mockBuffer = mock(BufferedReader.class);
		when(mockBuffer.readLine()).thenReturn("000001 1 01010101010101010101010 111111110000000011111111", (String) null);
		inputAndOutput.readFromFile(mockBuffer);
		assertEquals("000001", inputAndOutput.getElement("000001").getHex());
	}

	@Test
	public void outputstram_writeToFile_storedMap() throws IOException {
		FileOutputStream outputStreamMock = mock(FileOutputStream.class);
		BufferedReader mockBuffer = mock(BufferedReader.class);
		when(mockBuffer.readLine()).thenReturn("000001 1 01010101010101010101010 111111110000000011111111", (String) null);
		inputAndOutput.readFromFile(mockBuffer);
		inputAndOutput.writeToFile(outputStreamMock);
		verify(outputStreamMock).write("000001 1 01010101010101010101010 111111110000000011111111\n".getBytes());
	}
}
