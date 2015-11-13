package TDDTaskCode;

public class Utility {

	public int turnToInt(String bitString) {
		if(bitString.length() > 24)
			throw new IllegalArgumentException();
		
		int value = 0;
		for(int i = 0; i < bitString.length(); i++){
			if(bitString.charAt(i) == '1'){
				value = value + (int) Math.pow(2, bitString.length() - i - 1);
			}
		}
		
		return value;
	}

	public String turnToString(int i) {
		return "00000000000000000000001";
	}

}
