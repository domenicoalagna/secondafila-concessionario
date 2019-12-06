package concessionario.core;

import java.util.*;

public abstract class Veicolo {

	private String targa;
	private String produttore;
	private Integer prezzo;
	private String modello;
	private String alimentazione;

	public Veicolo(Scanner input) {
		
		System.out.println("Inserire targa: ");
		this.targa = input.next();
		
		System.out.println("Inserire produttore: ");
		this.produttore =input.next();
		
		System.out.println("Inserire prezzo: ");
		this.prezzo = input.nextInt();
		
		System.out.println("Inserire modello: ");
		this.modello = input.next();
		
		System.out.println("Inserire alimentazione: ");
		this.alimentazione = input.next();

	}

	public String getTarga() {
		return targa;
	}

	public String getProduttore() {
		return produttore;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public String getModello() {
		return modello;
	}

	public String getAlimentazione() {
		return alimentazione;
	}
	
	public String toString() {
		return ("TARGA: "+this.targa + "\n"
				+ "PRODUTTORE: "+this.produttore + "\n"
				+ "PREZZO: "+this.prezzo+"\n"
				+"MODELLO: "+this.modello+"\n"
				+"ALIMENTAZIONE: "+this.alimentazione);
	}

}