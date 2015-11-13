package TDDTaskCode;

public class Utility {

	public int turnToInt(String bitString) {
		if(bitString.length() > 24)
			throw new IllegalArgumentException();
		
		int value = 0;
		for(int i = 0; i < bitString.length(); i++){
			if(bitString.charAt(i) == '1'){
				value += (int) Math.pow(2, bitString.length() - i - 1);
			}
		}
		
		return value;
	}

	public String turnToString(int value) {
		StringBuilder string = new StringBuilder();
		
		for(int i = 23; i >= 0; i--){
			if(value >= Math.pow(2, i)){
				string.append('1');
				value -= Math.pow(2, i);
			}else{
			string.append('0');
			}
		}	
		
		String bitString = string.toString();
		return bitString;
	}
}
