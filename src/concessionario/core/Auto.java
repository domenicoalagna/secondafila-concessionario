package concessionario.core;

import java.util.*;

import concessionario.database.csv.CSVSerializerInterface;

public class Auto  extends Veicolo implements CSVSerializerInterface{
	
	private Integer porte;
	
	
	public Auto(String targa, String produttore,Integer prezzo, String modello, String alimentazione,Integer porte)
	{
		super(targa,produttore,prezzo,modello,alimentazione);
		this.porte=porte;
	}
	
	

	public Auto(Scanner input)
	{
		super(input);
		
		System.out.println("Inserire numero porte: ");
		this.porte=input.nextInt();
		
	}
	
	public Auto() {
		
	}

	public Integer getPorte() 
	{
		return porte;
	}
	
	public String toString()
	{
		return ("AUTO \n"
				+"TARGA: "+getTarga() + "\n"
				+ "PRODUTTORE: "+getProduttore() + "\n"
				+ "PREZZO: "+getPrezzo()+"\n"
				+"MODELLO: "+getModello()+"\n"
				+"ALIMENTAZIONE: "+getAlimentazione()+"\n"
				+"N.PORTE: "+this.porte);
	}

	@Override
	public String toCSV() {
		return "auto;" + getTarga() + ";" + getProduttore()  + ";" + getPrezzo() +";"
		 + getModello()+ ";" + getAlimentazione()  + ";" +this.porte;
	}
	
	public static Object fromCSV(String s) {
		String[] values = s.split(";");
		return new Auto(values[1], values[2], Integer.parseInt(values[3]), values[4],values[5],Integer.parseInt(values[6]));
	}
	
	

}