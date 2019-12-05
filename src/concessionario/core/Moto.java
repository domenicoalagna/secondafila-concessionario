package concessionario.core;

public class Moto extends Veicolo {
 private Integer altezzaSedile;
 
	public Moto(String targa, String produttore, Double prezzo, String modello, String alimentazione,Integer altezzaSedile){
		super(targa, produttore, prezzo, modello, alimentazione);
		this.altezzaSedile=altezzaSedile;
		
	}

	public Integer getAltezzaSedile() {
		return altezzaSedile;
	}
	

}
