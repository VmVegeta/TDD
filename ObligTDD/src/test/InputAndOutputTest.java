package test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;
import static junit.framework.TestCase.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.junit.Test;
import org.mockito.InOrder;

import TDDTaskCode.InputAndOutput;

public class InputAndOutputTest{

	InputAndOutput inputAndOutput = new InputAndOutput();
	private FileOutputStream outputStreamMock;
	
	

	@Test
	public void testWrite() throws Exception {
		this.outputStreamMock = mock(FileOutputStream.class);
		inputAndOutput.writeToFile(this.outputStreamMock, "test");
		InOrder inOrder = inOrder(this.outputStreamMock);
		inOrder.verify(this.outputStreamMock).write("test".getBytes());
		this.outputStreamMock = null;
	}
	
	@Test
	public void testRead() throws Exception {
		File file = new File("TestFile.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		FileReader inputMock = new FileReader("TestFile.txt");
		assertEquals("", inputAndOutput.readFromFile(inputMock));
	}
}
