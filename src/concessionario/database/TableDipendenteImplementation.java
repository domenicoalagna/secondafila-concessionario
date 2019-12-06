package concessionario.database;

import java.util.Collection;

import concessionario.core.Dipendente;

public class TableDipendenteImplementation implements TableInterface<Integer, Dipendente> {

	private DriverInterface<Dipendente> driverDipendente;

	public TableDipendenteImplementation(DriverInterface<Dipendente> driverDipendente) {
		this.driverDipendente = driverDipendente;
	}

	@Override
	public Boolean insert(Dipendente v) {
		Collection<Dipendente> dipendenti = driverDipendente.read();
		for (Dipendente dipendente : dipendenti) {
			if (dipendente.getCid() == v.getCid()) {
				return false;
			}
		}
		dipendenti.add(v);
		return driverDipendente.write(dipendenti);
	}

	@Override
	public Collection<Dipendente> get() {
		return driverDipendente.read();
	}

	@Override
	public Dipendente get(Integer k) {
		Collection<Dipendente> dipendenti = driverDipendente.read();
		for (Dipendente dipendente : dipendenti) {
			if (dipendente.getCid() == k) {
				return dipendente;
			}
		}

		return null;
	}

	@Override
	public Dipendente update(Dipendente v) {
		Collection<Dipendente> dipendenti = driverDipendente.read();
		for (Dipendente dipendente : dipendenti) {
			if (dipendente.getCid() == v.getCid()) {
				dipendente.setAmministratore(v.isAmministratore());
				//dipendente.setNome(v.getNome());
				driverDipendente.write(dipendenti);
				return dipendente;
			}
		}
		return null;
	}

	@Override
	public Boolean delete(Integer k) {
		Collection<Dipendente> dipendenti = driverDipendente.read();
		for (Dipendente dipendente : dipendenti) {
			if (dipendente.getCid() == k) {
				dipendenti.remove(dipendente);
				driverDipendente.write(dipendenti);
				return true;
			}
		}

		return false;
	}

	@Override
	public void setDriver(DriverInterface<Dipendente> d) {
		this.driverDipendente = d;
	}

}
