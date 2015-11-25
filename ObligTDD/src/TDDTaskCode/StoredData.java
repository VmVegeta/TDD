package TDDTaskCode;

public class StoredData {
	
	Utility utility = new Utility();
	private String hex;
	private String operator;
	private String firstBitString;
	private String secondBitString;
	private String operatedString;
	private int hexInt;
	private int firstBit;
	private int secondBit;
	private int operatedInt;
	
	
	public StoredData(String hex, String operator, String firstBitString, String secondBitString){
		this.hex = hex;
		this.operator = operator;
		this.firstBitString = firstBitString;
		this.secondBitString = secondBitString;
		hexInt = utility.turnToIntFromHex(hex);
		firstBit = utility.turnToInt(firstBitString);
		secondBit = utility.turnToInt(secondBitString);
		operatedString = utility.operator(operator, firstBitString, secondBitString);
		operatedInt = utility.turnToInt(operatedString);
	}

	public int getHexInt() {
		return hexInt;
	}

	public String getOperatedString() {
		return operatedString;
	}

	public int getFirstBit() {
		return firstBit;
	}

	public int getSecondBit() {
		return secondBit;
	}

	public String getHex() {
		return hex;
	}

	public String getOperator() {
		return operator;
	}

	public String getFirstBitString() {
		return firstBitString;
	}

	public String getSecondBitString() {
		return secondBitString;
	}

	public int getOperatedInt() {
		return operatedInt;
	}
}
