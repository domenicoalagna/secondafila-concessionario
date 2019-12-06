package concessionario.database.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import concessionario.database.DriverInterface;

public class DriverCSVFileImplementation<V extends CSVSerializerInterface> implements DriverInterface {

	private File dbFile;
	
	public DriverCSVFileImplementation(String filePath) {
		this.dbFile = new File(filePath);
	}

	@Override
	public Boolean write(Collection v) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(this.dbFile));
		
			for(Object value : v) {
				writer.write(((CSVSerializerInterface) value).toCSV());
				writer.newLine();
			}
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Collection read() {
		List result = new ArrayList<>(); 
		try {
			BufferedReader reader = new BufferedReader(new FileReader(this.dbFile));
			
			String line = null;
			do {
				line = reader.readLine();
				
				if(line != null) {
					String lineTrimmed = line.trim();
					Object newElement = CSVFactory.createFromCSV(lineTrimmed);
					if(newElement != null) {
						result.add(newElement);
					}
				}
			} while(line != null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
