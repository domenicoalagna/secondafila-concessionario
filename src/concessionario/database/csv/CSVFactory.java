package concessionario.database.csv;

import concessionario.core.Dipendente;

public class CSVFactory {
	public static Object createFromCSV(String csvLine) {
		Object result = null;
		String dataType = csvLine.split(";")[0];
		switch(dataType) {
		case "dipendente":
			result = (new Dipendente()).fromCSV(csvLine);
			break;
		default:
			break;
		}
		
		return result;
	}
}
