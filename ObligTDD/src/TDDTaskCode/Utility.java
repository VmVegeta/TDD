package TDDTaskCode;

public class Utility {

	public int turnToInt(String bitString) {
		if(bitString.length() > 24){
			throw new IllegalArgumentException();
		}
		
		int value = 0;
		for(int i = 0; i < bitString.length(); i++){
			if(bitString.charAt(i) == '1'){
				value += (int) Math.pow(2, bitString.length() - i - 1);
			}
		}
		
		return value;
	}

	public String turnToString(int value) {
		if(value > 16777215 || value < 0){
			throw new IllegalArgumentException();
		}
		
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

	public int turnToIntFromHex(String hex) {
		if(hex.length() > 6){
			throw new IllegalArgumentException();
		}
		
		int value = 0;
		for(int i = 0; i < hex.length(); i++){
			for(int j = 0; j < 9; j++){
				if(hex.charAt(i) == '0'+j){
					value += j * (int) Math.pow(16, hex.length() - i - 1);
				}
				else if(hex.charAt(i) == 'A'+j){
					value += (10+j) * (int) Math.pow(16, hex.length() - i - 1);
				}
			}
		}
		return value;
	}
}
