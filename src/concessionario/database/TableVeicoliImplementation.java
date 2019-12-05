package concessionario.database;

import java.util.Collection;

import concessionario.core.Dipendente;
import concessionario.core.Veicolo;

public class TableVeicoliImplementation implements TableInterface<String, Veicolo> {

	private DriverInterface<Veicolo> driver;
	
	public TableVeicoliImplementation(DriverInterface<Veicolo> driver) {
		this.driver = driver;
	}
	
	@Override
	public Boolean insert(Veicolo v) {
		Collection<Veicolo> veicoli = driver.read();
		for(Veicolo veicolo : veicoli) {
			if(veicolo.getTarga() == v.getTarga()) {
				return false;
			}
		}
		veicoli.add(v);
		return driver.write(veicoli);
	}

	@Override
	public Collection<Veicolo> get() {
		return driver.read();
	}

	@Override
	public Veicolo get(String k) {
		Collection<Veicolo> veicoli = driver.read();
		for(Veicolo veicolo : veicoli) {
			if(veicolo.getTarga() == k) {
				return veicolo;
			}
		}
		
		return null;
	}

	@Override
	public Veicolo update(Veicolo v) {
		Collection<Veicolo> veicoli = driver.read();
		for (Veicolo veicolo : veicoli) {
			if (veicolo.getTarga() == v.getTarga()) {
				veicolo.setPrezzo(v.getPrezzo());
				driver.write(veicoli);
				return veicolo;
			}
		}
		
		return null;
	} 

	@Override
	public Boolean delete(String k) {
		Collection<Veicolo> veicoli = driver.read();
		for (Veicolo veicolo : veicoli) {
			if(veicolo.getTarga() == k) {
				veicoli.remove(veicolo);
				driver.write(veicoli);
				return true;
			}
		}
		return false;
	}

	@Override
	public void setDriver(DriverInterface<Veicolo> d) {
		this.driver = d;
		}


}