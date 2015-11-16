package TDDTaskCode;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;

public class InputAndOutput {

	public void writeToFile(FileOutputStream outputStream, String toWrite) throws IOException {
		outputStream.write(toWrite.getBytes());
	}

	public String readFromFile(Reader input) throws IOException {
		BufferedReader bufferedRead = new BufferedReader(input);
		StringBuilder makeString = new StringBuilder();
		String line = bufferedRead.readLine();

		while (line != null) {
			makeString.append(line);
			makeString.append("\n");
			line = bufferedRead.readLine();
		}
		String toBeRead = makeString.toString();
		return toBeRead;
	}

}
