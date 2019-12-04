package concessionario.core;

public abstract class Veicolo {

	private String targa;
	private String produttore;
	private Double prezzo;
	private String modello;
	private String alimentazione;

	public Veicolo(String targa, String produttore, Double prezzo, String modello, String alimentazione) {
		this.targa = targa;
		this.produttore = produttore;
		this.prezzo = prezzo;
		this.modello = modello;
		this.alimentazione = alimentazione;

	}

	public String getTarga() {
		return targa;
	}

	public String getProduttore() {
		return produttore;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public String getModello() {
		return modello;
	}

	public String getAlimentazione() {
		return alimentazione;
	}

}
