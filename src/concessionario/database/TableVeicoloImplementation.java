package concessionario.database;

import concessionario.core.Veicolo;
import concessionario.core.Auto;
import concessionario.core.Moto;
import java.util.Collection;

public class TableVeicoloImplementation implements TableInterface<String, Veicolo> 
{
	
	
	/*
	 *  inizializzo l'interfaccia driver con il tipo di oggetto che andrà ad usare.
	 *  Dopo lo richiamo nel costruttore.
	 */
	private DriverInterface<Veicolo> driver;
	
	public TableVeicoloImplementation(DriverInterface<Veicolo> driver) 
	{
		this.driver = driver;
	}
	
	
	
	/*
	 * Con questa funzione inserisco un nuovo veicolo se non ha lo stessa targa di un altro veicolo
	 * già in memoria. Per farlo scorro tutti i veicoli in memoria e li salvo in una collection.
	 * Dopo con un ciclo for each controllo che la targa non sia uguale, se lo è ritorno false. 
	 * Altrimenti aggiungo il veicolo nuovo e riscrivo la modifica effettuata sulla memoria o sul file.
	 * 
	 * In questa funzione non mi devo preoccupare di distinguere tra auto o moto in quanto la targa è
	 * unica. Quindi il controllo che devo fare è esclusivamente sulla presenza o meno della targa 
	 * nella memoria.
	 */
	@Override
	public Boolean insert(Veicolo v)
	{
		Collection<Veicolo> veicoli = driver.read();
		for(Veicolo veicolo : veicoli)
		{
			if(veicolo.getTarga() == v.getTarga())
			{
				return false;
			}
		}
		veicoli.add(v);
		return driver.write(veicoli);
	}
	
	
	
	/*
	 * Con questa funzione vado a leggere nella memoria e restituisco i veicoli (auto e moto)
	 * totali presenti.
	 */
	@Override
	public Collection<Veicolo> get() 
	{	
		
		return driver.read();
	}
	
	/*INUTILE
	 * Con questa funzione vado a leggere in memoria le auto presenti. Per farlo utilizzo un istanceof 
	 * per verificare che l'oggetto veicolo sia un auto e poi la leggo. 
	 
	public void getAuto() 
	{	
		Collection<Veicolo> veicoli = driver.read();
		for(Veicolo veicolo : veicoli)
		{
			if(veicolo instanceof Auto) 
			{
				System.out.println(veicolo);
			}
		}
		
	}
	
	
	/*INUTILE
	 * Con questa funzione vado a leggere in memoria le moto presenti. Per farlo utilizzo un istanceof 
	 * per verificare che l'oggetto veicolo sia un moto e poi la leggo.
	 
	public void getMoto() 
	{	
		Collection<Veicolo> veicoli = driver.read();
		for(Veicolo veicolo : veicoli)
		{
			if(veicolo instanceof Moto) 
			{
				System.out.println(veicolo);
			}
		}
		
	}*/
	
	
	
	
	/*
	 * Con questa funzione voglio restituire un singolo veicolo tramite la sua targa. Per farlo 
	 * inserisco la targa in questione, poi leggo i veicoli in memoria e li salvo. Dopo con un ciclo
	 * for each controllo se la targa coincide con un altra targa in memoria. Se succede allora controllo
	 * se il veicolo è un auto o una moto e ritorno l'equivalente con il get specifico.
	 */
	@Override
	public Veicolo get(String k) 
	{
		Collection<Veicolo> veicoli = driver.read();
		for(Veicolo veicolo : veicoli)
		{
			if(veicolo.getTarga() == k) 
			{
				if(veicolo instanceof Auto) 
				{
					System.out.println(veicolo);
					
				}
				else if(veicolo instanceof Moto)
				{
					System.out.println(veicolo);
					
				}
			}
		}
		
		return null;
	}
	
	
	
	/* 
	 * Con questa funzione voglio modificare l'attributo prezzo di un veicolo. Per farlo
	 * inserisco il veicolo con la modifica. Salvo tutti i veicoli in memoria in una collection e 
	 * con un ciclo for cerco il veicoloe con la stessa targa. Una volta trovato uso setPrezzo
	 * del veicolo in memoria con all'interno il getPrezzoe di quello nuovo. Cosi facendo sto
	 * cambiando l'attributo prezzo. Infine riscrivo in memoria la nuova collezione.
	 */
	@Override
	public Veicolo update(Veicolo v) 
	{
		Collection<Veicolo> veicoli = driver.read();
		for(Veicolo veicolo :veicoli)
		{
			if(veicolo.getTarga() == v.getTarga()) 
			{
				veicolo.setPrezzo(v.getPrezzo());
				driver.write(veicoli);
				return veicolo;
			}
		}
		return null;
	}

	
	
	/*
	 * Con questa funzione voglio andare a cercare un veicolo in memoria tramite la targa ed eliminarlo.
	 * Per farlo salvo in una collection i veicoli presenti in memoria. Poi con un ciclo for each 
	 * controllo che la targa coincida, in caso positivo rimuovo il veicolo selezionato e apporto
	 * la modifica in memoria.
	 */
	@Override
	public Boolean delete(String k) 
	{
		Collection<Veicolo> veicoli = driver.read();
		for(Veicolo veicolo : veicoli)
		{
			if(veicolo.getTarga() == k) 
			{
				veicoli.remove(veicolo);
				driver.write(veicoli);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void setDriver(DriverInterface<Veicolo> d)
	{
		this.driver=d;
	}

}