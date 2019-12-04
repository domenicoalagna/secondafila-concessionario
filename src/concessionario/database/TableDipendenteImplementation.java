package concessionario.database;

import java.util.Collection;

import concessionario.core.Dipendente;

public class TableDipendenteImplementation implements TableInterface<Integer, Dipendente> 
{

	private DriverInterface<Dipendente> driver;
	
	public TableDipendenteImplementation(DriverInterface<Dipendente> driver) 
	{
		this.driver = driver;
	}
	
	@Override
	public Boolean insert(Dipendente v)
	{
		Collection<Dipendente> dipendenti = driver.read();
		for(Dipendente dipendente : dipendenti)
		{
			if(dipendente.getCid() == v.getCid())
			{
				return false;
			}
		}
		dipendenti.add(v);
		return driver.write(dipendenti);
	}

	@Override
	public Collection<Dipendente> get() 
	{
		return driver.read();
	}

	@Override
	public Dipendente get(Integer k) 
	{
		Collection<Dipendente> dipendenti = driver.read();
		for(Dipendente dipendente : dipendenti)
		{
			if(dipendente.getCid() == k) 
			{
				return dipendente;
			}
		}
		
		return null;
	}

	@Override
	public Dipendente update(Dipendente v) 
	{
		Collection<Dipendente> dipendenti = driver.read();
		for(Dipendente dipendente : dipendenti)
		{
			if(dipendente.getCid() == v.getCid()) 
			{
				//dipendente.setAmministratore(v.getAmministratore);
				driver.write(dipendenti);
				return dipendente;
			}
		}
		return null;
	}

	
	@Override
	public Boolean delete(Integer k) 
	{
		Collection<Dipendente> dipendenti = driver.read();
		for(Dipendente dipendente : dipendenti)
		{
			if(dipendente.getCid() == k) 
			{
				dipendenti.remove(dipendente);
				driver.write(dipendenti);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void setDriver(DriverInterface<Dipendente> d)
	{
		this.driver=d;
	}

}
