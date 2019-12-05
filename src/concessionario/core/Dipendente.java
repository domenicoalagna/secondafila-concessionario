package concessionario.core;

import concessionario.database.csv.CSVSerializerInterface;

public class Dipendente implements CSVSerializerInterface {

	private Integer cid;
	private String nome;
	private String cognome;
	
	public Dipendente() {
		
	}
	
	public Dipendente(Integer cid, String nome, String cognome) {
		this.cid = cid;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public Integer getCid() {
		return cid;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String toString() {
		return this.cid + ". " + this.nome + " " + this.cognome;
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
