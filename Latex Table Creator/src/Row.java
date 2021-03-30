
public class Row {
	int dataLength;
	String rawData;
	String formattedData;
	char seperationChar;
	
	public Row(String rawData,char seperationChar) {
		this.seperationChar = seperationChar;
		this.rawData = rawData;
		formattedData = this.format();
				
	}
	
	public String format() {
		String toReturn = "\\hline ";
		toReturn = toReturn.concat(rawData.replace(seperationChar, '&'));
		toReturn = toReturn.concat(" \\\\");
		return toReturn;
		
	}
}
