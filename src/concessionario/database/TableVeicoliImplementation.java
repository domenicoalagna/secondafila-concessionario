package concessionario.database;

import java.util.Collection;


import concessionario.core.Veicolo;

public class TableVeicoliImplementation implements TableInterface<String, Veicolo> {

	private DriverInterface<Veicolo> driverVeicolo;
	
	public TableVeicoliImplementation(DriverInterface<Veicolo> driverVeicolo) {
		this.driverVeicolo = driverVeicolo;
	}
	
	@Override
	public Boolean insert(Veicolo v) {
		Collection<Veicolo> veicoli = driverVeicolo.read();
		for(Veicolo veicolo : veicoli) {
			if(veicolo.getTarga() == v.getTarga()) {
				return false;
			}
		}
		veicoli.add(v);
		return driverVeicolo.write(veicoli);
	}

	@Override
	public Collection<Veicolo> get() {
		return driverVeicolo.read();
	}

	@Override
	public Veicolo get(String k) {
		Collection<Veicolo> veicoli = driverVeicolo.read();
		for(Veicolo veicolo : veicoli) {
			if(veicolo.getTarga() == k) {
				return veicolo;
			}
		}
		
		return null;
	}

	@Override
	public Veicolo update(Veicolo v) {
		Collection<Veicolo> veicoli = driverVeicolo.read();
		for (Veicolo veicolo : veicoli) {
			if (veicolo.getTarga() == v.getTarga()) {
				veicolo.setPrezzo(v.getPrezzo());
				driverVeicolo.write(veicoli);
				return veicolo;
			}
		}
		
		return null;
	} 

	@Override
	public Boolean delete(String k) {
		Collection<Veicolo> veicoli = driverVeicolo.read();
		for (Veicolo veicolo : veicoli) {
			if(veicolo.getTarga() == k) {
				veicoli.remove(veicolo);
				driverVeicolo.write(veicoli);
				return true;
			}
		}
		return false;
	}

	@Override
	public void setDriver(DriverInterface<Veicolo> d) {
		this.driverVeicolo = d;
		}


}