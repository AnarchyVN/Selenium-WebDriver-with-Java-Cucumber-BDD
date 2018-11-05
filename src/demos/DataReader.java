package demos;

import java.util.List;

public class DataReader {

	public static void main(String[] args) {
		readXLS();
	}
	
	public static void readCSV() {
		String filename = "./resources/UserAccounts.csv";
		List <String[]> records = utilities.CSV.get(filename);
		
		// iterating though the list
		for (String[] record : records) {
			for (String field : record) {
				System.out.println(field);
			}
		}
	}
	
	public static void readXLS() {
		String filename = "./resources/UserLogin.xls";
		String[][] data = utilities.Excel.get(filename);
		for (String[] record : data) {
			System.out.println("\nNEW RECORD");
			System.out.println(record[0]);
			System.out.println(record[1]);
			System.out.println(record[2]);
		}
	}
}
