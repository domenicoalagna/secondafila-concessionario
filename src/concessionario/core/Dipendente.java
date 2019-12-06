package concessionario.core;

public class Dipendente {

	private Integer cid;
	private String nome;
	private String cognome;
	private boolean amministratore;
	
	public Dipendente(Integer cid, String nome, String cognome, boolean amministratore ) {
		this.cid = cid;
		this.nome = nome;
		this.cognome = cognome;
		this.amministratore= amministratore;
		
	}
	
	public Dipendente(Integer cid, String nome, String cognome ) {
		this.cid = cid;
		this.nome = nome;
		this.cognome = cognome;
		this.amministratore= false;
		
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
		return this.cid + ". " + this.nome + " " + this.cognome + " AMM: " + this.amministratore;
	}

	public boolean isAmministratore() {
		return amministratore;
	}

	public void setAmministratore(boolean amministratore) {
		this.amministratore = amministratore;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
