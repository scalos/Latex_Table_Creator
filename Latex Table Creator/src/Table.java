import java.util.ArrayList;

public class Table {
	String rawData;
	int columnNumber;
	String label;
	String header;
	String caption;
	String footer;
	char seperationChar;
	ArrayList<Row> Rows = new ArrayList<Row>();
	
	public Table(String caption,String label, String rawData, int columnNumber,char seperationChar) {
		this.caption = caption;
		this.label = label;
		this.rawData = rawData;
		this.seperationChar = seperationChar;
		this.columnNumber = columnNumber;
		this.parseRows();
		this.header = this.generateHeader();
		this.footer = this.generateFooter();
	}
	
	public void parseRows() {
		int columnStart = 0;
		int columnCount = 0;
		for(int i=0; i<rawData.length();i++) {
			if(rawData.charAt(i)==seperationChar) {columnCount++;}
			
			if(columnCount==columnNumber) {
				Row row = new Row(rawData.substring(columnStart,i),seperationChar);
				Rows.add(row);
				columnStart = i+1;
				columnCount = 0;
			}
		}
	}
	
	public String generateHeader() {
		String header = "\\begin{table}[ht]\n" + 
				"\\caption{"+caption+ "}\n" + 
				"\\begin{center}\n" + 
				"\\begin{tabular}{|";
		for(int i=0;i<columnNumber;i++) {
			header = header.concat("c|");
		}
		
		header = header.concat("}");
		return header;	
	}
	
	public String generateFooter() {
		String footer = "\\hline\n" + 
				"\\end{tabular}\n" + 
				"\\end{center}\n" + 
				"\\label{table:"+label+"}\n" + 
				"\\end{table}";
		
		return footer;
	}
	
	public String print() {
		String printStr = header+"\n";
		
		for(Row r:Rows) {
			printStr = printStr.concat(r.formattedData+"\n");
		}
		
		printStr = printStr.concat(footer);
		
		return printStr;
	}
}
