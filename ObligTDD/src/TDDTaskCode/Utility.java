package TDDTaskCode;

public class Utility {

	public int turnToInt(String bitString) {
		if(bitString.length() > 24){
			throw new IllegalArgumentException();
		}
		for(int i = 0; i < bitString.length(); i++){
			if(bitString.charAt(i) != '0' && bitString.charAt(i) != '1'){
				throw new IllegalArgumentException();
			}
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

		StringBuilder bitString = new StringBuilder();

		for(int i = 23; i >= 0; i--){
			if(value >= Math.pow(2, i)){
				bitString.append('1');
				value -= Math.pow(2, i);
			}else{
				bitString.append('0');
			}
		}	

		return bitString.toString();
	}

	public int turnToIntFromHex(String hex) {
		if(hex.length() > 6){
			throw new IllegalArgumentException();
		}
		for(int i = 0; i < hex.length(); i++){
			if(hex.charAt(i) != '0' && hex.charAt(i) != '1' && hex.charAt(i) != '2' && hex.charAt(i) != '3' &&
					hex.charAt(i) != '4' && hex.charAt(i) != '5' && hex.charAt(i) != '6' && hex.charAt(i) != '7' &&
					hex.charAt(i) != '8' && hex.charAt(i) != '9' && hex.charAt(i) != 'a' && hex.charAt(i) != 'b' &&
					hex.charAt(i) != 'c' && hex.charAt(i) != 'd' && hex.charAt(i) != 'e' && hex.charAt(i) != 'f'){
				throw new IllegalArgumentException();
			}
		}

		int value = 0;
		for(int i = 0; i < hex.length(); i++){
			for(int j = 0; j < 9; j++){
				if(hex.charAt(i) == '0'+j){
					value += j * (int) Math.pow(16, hex.length() - i - 1);
				}
				else if(hex.charAt(i) == 'a'+j){
					value += (10+j) * (int) Math.pow(16, hex.length() - i - 1);
				}
			}
		}
		return value;
	}

	public String turnToHex(int value) {
		if(value > 16777215 || value < 0){
			throw new IllegalArgumentException();
		}

		StringBuilder hexString = new StringBuilder();

		for(int i = 5; i >= 0; i--){
			if(value >= Math.pow(16, i)){
				for(int j = 15; j >= 0; j--){
					if(value >= j*Math.pow(16,i)){
						if(j >= 10){
							hexString.append((char)('a'-10+j));
						}else{
							hexString.append(j);
						}
						value -= j*Math.pow(16, i);
						break;
					}
				}
			}else{
				hexString.append('0');
			}
		}

		return hexString.toString();
	}

	public String operator(String operator, String firstBit, String secondBit) {
		int firstBitValue = turnToInt(firstBit);
		int secondBitValue = turnToInt(secondBit);

		if(operator.equals("1")){
			return turnToString(firstBitValue & secondBitValue);
		}else if(operator.equals("2")){
			return turnToString(firstBitValue | secondBitValue);
		}
		
		throw new IllegalArgumentException();
	}
}
