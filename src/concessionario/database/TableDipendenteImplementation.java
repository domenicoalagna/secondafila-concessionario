package concessionario.database;

import concessionario.core.Dipendente;
import java.util.Collection;

public class TableDipendenteImplementation implements TableInterface<Integer, Dipendente> 
{
	
	
	/*
	 *  inizializzo l'interfaccia driver con il tipo di oggetto che andrà ad usare.
	 *  Dopo lo richiamo nel costruttore.
	 */
	private DriverInterface<Dipendente> driver;
	
	public TableDipendenteImplementation(DriverInterface<Dipendente> driver) 
	{
		this.driver = driver;
	}
	
	
	
	/*
	 * Con questa funzione inserisco un nuovo dipendente se non ha lo stesso CID di un dipendente
	 * già in memoria. Per farlo scorro tutti i dipendenti in memoria e li salvo in una collection.
	 * Dopo con un ciclo for each controllo che il CID non sia uguale, se lo è ritorno false. 
	 * Altrimenti aggiungo il dipendente nuovo e riscrivo la modifica effettuata sulla memoria o sul file.
	 */
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
	
	
	
	/*
	 * Con questa funzione vado a leggere nella memoria e restituisco i dipendenti totali presenti.
	 */
	@Override
	public Collection<Dipendente> get() 
	{
		return driver.read();
	}
	
	
	
	/*
	 * Con questa funzione voglio restituire un singolo dipendente tramite il suo CID. Per farlo 
	 * inserisco il CID in questione, poi leggo i dipendenti in memoria e li salvo. Dopo con un ciclo
	 * for each controllo se il CID coincide con un altro CID in memoria. Se succede allora ritorno
	 * il dipendente altrimenti ritorno null.
	 */
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
	
	
	
	/* 
	 * Con questa funzione voglio modificare l'attributo amministratore di un dipendente. Per farlo
	 * inserisco il dipendente con la modifica. Salvo tutti i clienti in memoria in una collection e 
	 * con un ciclo for cerco il dipendente con lo stesso CID. Una volta trovato uso setAmministratore
	 * del dipendente in memoria con all'interno il isAmministratore di quello nuovo. Cosi facendo sto
	 * cambiando l'attributo Amministratore. Infine riscrivo in memoria la nuova collezione.
	 */
	@Override
	public Dipendente update(Dipendente v) 
	{
		Collection<Dipendente> dipendenti = driver.read();
		for(Dipendente dipendente : dipendenti)
		{
			if(dipendente.getCid() == v.getCid()) 
			{
				dipendente.setAmministratore(v.isAmministratore());
				driver.write(dipendenti);
				return dipendente;
			}
		}
		return null;
	}

	
	
	/*
	 * Con questa funzione voglio andare a cercare un dipendente in memoria tramite il CID ed eliminarlo.
	 * Per farlo salvo in una collection i dipendenti presenti in memoria. Poi con un ciclo for each 
	 * controllo che il CID coincida, in caso positivo rimuovo il dipendente selezionato e apporto
	 * la modifica in memoria.
	 */
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