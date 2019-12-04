package concessionario.core;

public class Auto  extends Veicolo {
	
	private Integer porte;
	

	public Auto(String targa, String produttore, Double prezzo, String modello, String alimentazione,Integer porte) {
		super(targa, produttore, prezzo, modello, alimentazione);
		this.porte=porte;
		
	}

	public Integer getPorte() {
		return porte;
	}

}
