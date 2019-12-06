package concessionario.core;

import java.util.*;

import concessionario.database.csv.CSVSerializerInterface;

public class Moto extends Veicolo implements CSVSerializerInterface
{
 private Integer altezzaSedile;
 
	public Moto(Scanner input)
	{
		super(input);
		System.out.println("Inserire altezza sedile: ");
		this.altezzaSedile=input.nextInt();
		
	}
	
	

	public Moto(String targa, String produttore,Integer prezzo, String modello, String alimentazione,Integer altezzaSedile)
	{
		super(targa,produttore,prezzo,modello,alimentazione);
		this.altezzaSedile=altezzaSedile;
	}
	
	public Moto() {
		
	}

	public Integer getAltezzaSedile()
	{
		return altezzaSedile;
	}
	
	
	public String toString()
	{
		return ("MOTO \n"
				+"TARGA: "+getTarga() + "\n"
				+ "PRODUTTORE: "+getProduttore() + "\n"
				+ "PREZZO: "+getPrezzo()+"\n"
				+"MODELLO: "+getModello()+"\n"
				+"ALIMENTAZIONE: "+getAlimentazione()+"\n"
				+"ALTEZZA SEDILE: "+this.altezzaSedile);
	}
	
	
	@Override
	public String toCSV() {
		return "moto;" + getTarga() + ";" + getProduttore()  + ";" + getPrezzo()+";"
		 + getModello()+ ";" + getAlimentazione()  + ";" +this.altezzaSedile;
	}
	
	public static Object fromCSV(String s) {
		String[] values = s.split(";");
		return new Moto(values[1], values[2], Integer.parseInt(values[3]), values[4],values[5],Integer.parseInt(values[6]));
	}

}