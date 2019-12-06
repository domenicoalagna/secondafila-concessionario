
package concessionario.core;

import java.util.*;
import concessionario.database.csv.CSVSerializerInterface;

public class Dipendente implements CSVSerializerInterface {


	private Integer cid;
	private String nome;
	private String cognome;
	private boolean amministratore;
	
	public Dipendente(Scanner input ) 
	{
		System.out.println("Inserire CID: ");
		this.cid = input.nextInt();
		
		System.out.println("Inserire nome: ");
		this.nome = input.next();
		
		System.out.println("Inserire cognome: ");
		this.cognome = input.next();
		
		System.out.println("E' un amministratore? ");
		this.amministratore= input.nextBoolean();
		
	}
	

	public Dipendente() {
		
	}
	
	public Dipendente(Integer cid, String nome, String cognome) {

		this.cid = cid;
		this.nome = nome;
		this.cognome = cognome;
		this.amministratore= false;
		
	}
	
	
	
	public Integer getCid()
	{
		return cid;
	}

	public String getNome()
	{
		return nome;
	}

	public String getCognome()
	{
		return cognome;
	}

	public String toString() 
	{
		return ("NOME: "+this.nome + "\n"
				+ "COGNOME: "+this.cognome + "\n"
				+ "CID: "+this.cid+"\n"
				+ "AMMINISTRATORE: "+this.amministratore);
	}

	public boolean isAmministratore()
	{
		return amministratore;
	}

	public void setAmministratore(boolean amministratore)
	{
		this.amministratore = amministratore;
	}

	@Override
	public String toCSV() {
		return "dipendente;" + this.cid + ";" + this.nome + ";" + this.cognome;
	}

	public static Object fromCSV(String s) {
		String[] values = s.split(";");
		return new Dipendente(Integer.parseInt(values[1]), values[2], values[3]);
	}
	
}
	
	
	
