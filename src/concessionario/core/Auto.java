package concessionario.core;

import java.util.*;

public class Auto  extends Veicolo {
	
	private Integer porte;
	

	public Auto(Scanner input)
	{
		super(input);
		
		System.out.println("Inserire numero porte: ");
		this.porte=input.nextInt();
		
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

}