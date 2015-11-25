package TDDTaskCode;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

public class InputAndOutput {

	HashMap<Integer, StoredData> map = new HashMap<Integer,StoredData>();
	ArrayList<String> errorList = new ArrayList<>();



	public String readFromFile(BufferedReader input) throws IOException {
		StringBuilder makeString = new StringBuilder();
		String line = input.readLine();

		while (line != null) {
			handleLine(makeString, line);
			line = input.readLine();
		}
		String allInput = makeString.toString();
		return allInput;
	}

	public void handleLine(StringBuilder makeString, String line) {
		String[] split = line.split(" ");
		if(split.length != 4){
			throw new IllegalArgumentException();
		}

		if(map.get(split[0].hashCode()) != null || (!split[1].equals("1") && !split[1].equals("2"))){
			errorList.add(line);
		}else{
			map.put(split[0].hashCode(), new StoredData(split[0], split [1], split[2], split[3]));
		}

		makeString.append(line);
		makeString.append("\n");
	}

	public void writeToFile(FileOutputStream outputStream) throws IOException {
		for (HashMap.Entry<Integer, StoredData> storedElement : map.entrySet()){
			outputStream.write((storedElement.getValue().getHex() + " " + storedElement.getValue().getOperator() + " " 
		+ storedElement.getValue().getFirstBitString() + " " + storedElement.getValue().getSecondBitString() + "\n").getBytes());
		}
	}

	public int getSize(){
		return map.size();
	}

	public int getErrorSize() {
		return errorList.size();
	}

	public StoredData getElement(String hex) {
		return map.get(hex.hashCode());
	}

}