package concessionario.core;

import java.util.*;

public class Moto extends Veicolo
{
 private Double altezzaSedile;
 
	public Moto(Scanner input)
	{
		super(input);
		System.out.println("Inserire altezza sedile: ");
		this.altezzaSedile=input.nextDouble();
		
	}

	public Double getAltezzaSedile()
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

}