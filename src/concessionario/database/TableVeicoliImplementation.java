package concessionario.database;

import java.util.Collection;

import concessionario.core.Dipendente;

public class TableVeicoliImplementation implements TableInterface<Integer, Veicolo> {

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
	public Veicolo get(Integer k) {
		Collection<Veicolo> veicoli = driver.read();
		for(Veicolo veicolo : veicoli) {
			if(veicolo.getTarga() == k) {
				return veicolo;
			}
		}
		
		return null;
	}

	@Override
	public Dipendente update(Dipendente v) {
		
		
		return null;
	}

	@Override
	public Boolean delete(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDriver(DriverInterface<Dipendente> d) {
		// TODO Auto-generated method stub
		
	}

}