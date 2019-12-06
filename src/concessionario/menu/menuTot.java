package concessionario.menu;

import java.util.Scanner;
import concessionario.core.Dipendente;
import concessionario.core.Veicolo;
import concessionario.core.Auto;
import concessionario.core.Moto;
import concessionario.database.DriverInterface;
import concessionario.database.DriverMemoryImplementation;
import concessionario.database.TableDipendenteImplementation;
import concessionario.database.TableVeicoloImplementation;
import concessionario.database.TableInterface;


public class menuTot implements MenuInterface
{
	DriverInterface<Dipendente> driverDipendenti = new DriverMemoryImplementation();
	TableInterface<Integer, Dipendente> tabellaDipendente = new TableDipendenteImplementation(driverDipendenti);
	
	DriverInterface<Veicolo> driverVeicoli = new DriverMemoryImplementation();
	TableInterface<String, Veicolo> tabellaVeicolo = new TableVeicoloImplementation(driverVeicoli);
	
	Scanner input= new Scanner(System.in);
	
	
	
	
	
	@Override
	public void menuIniziale()
	{
		int scelta;
		do 
		{
			System.out.println("	");	
			System.out.println("Ciao! Che tipo di operatore sei?");
			System.out.println("1. Cliente");
			System.out.println("2. Amministratore sistema");
			System.out.println("0. Esci");
			scelta=input.nextInt();
			switch (scelta)
			{
			case 0:
				System.out.println("Arrivederci");
				break;
			case 1:
				menuCliente();
				break;
			case 2:
				menuAmministratore();
				break;
			default:
				System.out.println("Scelta errata");
				break;
			}
		}
		while(scelta!=0);
		
	}
	
	
	
	@Override
	public void menuCliente()
	{
Integer sceltaCliente;
		
		do
		{
			System.out.println("Scegli la tipologia di veicolo che vuoi comprare:");
			System.out.println("1. AUTO");
			System.out.println("2. MOTO");
			System.out.println("0. Indietro");
			sceltaCliente=input.nextInt();
			
			switch (sceltaCliente)
			{
			case 0:
				System.out.println("");
				break;
			case 1:
				for(Veicolo v : tabellaVeicolo.get())
				{
					if(v instanceof Auto) 
					{
						System.out.println(v);		
					}
				}
				break;
			case 2:
				for(Veicolo v : tabellaVeicolo.get())
				{
					if(v instanceof Moto) 
					{
						System.out.println(v);
					}
				}
				break;
			default:
				System.out.println("Scelta errata");
				break;
			}

		}
		while(sceltaCliente!=0);
		
	}

	@Override
	public void menuAmministratore()
	{
		Dipendente d=null;
		Veicolo v=null;
		Integer val;
		String val2;
		Integer sceltaAmministratore;
		
		do
		{
			System.out.println("	");	
			System.out.println("Che cosa vuoi fare?");
			System.out.println("	");
			System.out.println("---SEZIONE DIPENDENTI---");
			System.out.println("1. Inserire dipendente");
			System.out.println("2. Modificare dipendente");
			System.out.println("3. Eliminare dipendente");
			System.out.println("4. Vedere dipendenti");
			System.out.println("	");
			System.out.println("---SEZIONE AUTO---");
			System.out.println("5. Inserire auto");
			System.out.println("6. Modificare auto");
			System.out.println("7. Eliminare auto");
			System.out.println("	");
			System.out.println("---SEZIONE MOTO---");
			System.out.println("8. Inserire moto");
			System.out.println("9. Modificare moto");
			System.out.println("10. Eliminare moto");
			System.out.println("	");
			System.out.println("0. Indietro");
			sceltaAmministratore=input.nextInt();
			
			switch (sceltaAmministratore)
			{
			case 0:
				System.out.println("");
				break;
			case 1:
				d=new Dipendente(input);
				tabellaDipendente.insert(d);
				break;
			case 2:
				d=new Dipendente(input);
				tabellaDipendente.update(d);
				break;
			case 3:
				System.out.println("Inserire il CID del dipendente: ");
				val=input.nextInt();
				tabellaDipendente.delete(val);
				break;
			case 4:
				for(Dipendente x : tabellaDipendente.get())
				{
					System.out.println(x);
				}
				break;
			case 5:
				v=new Auto(input);
				tabellaVeicolo.insert(v);
				break;
			case 6:
				v=new Auto(input);
				tabellaVeicolo.update(v);
				break;
			case 7:
				System.out.println("Inserire la targa dell'auto: ");
				val2=input.next();
				tabellaVeicolo.delete(val2);
				break;
			case 8:
				v=new Moto(input);
				tabellaVeicolo.insert(v);
				break;
			case 9:
				v=new Moto(input);
				tabellaVeicolo.update(v);
				break;
			case 10:
				System.out.println("Inserire la targa della moto: ");
				val2=input.next();
				tabellaVeicolo.delete(val2);
				break;
			default:
				System.out.println("Scelta errata");
				break;
			}
		}
		while(sceltaAmministratore!=0);
		
	}

	
	

}
