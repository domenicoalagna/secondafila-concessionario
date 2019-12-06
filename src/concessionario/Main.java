package concessionario;

//yo madafaca

import java.util.InputMismatchException;
import java.util.Scanner;
import concessionario.core.Dipendente;
import concessionario.core.Veicolo;
import concessionario.database.DriverInterface;
import concessionario.database.DriverMemoryImplementation;
import concessionario.database.TableDipendenteImplementation;
import concessionario.database.TableInterface;
import concessionario.database.TableVeicoliImplementation;

public class Main {

	static Scanner input = new Scanner(System.in);
	static TableInterface<Integer, Dipendente> tabellaDipendente;

	public static void main(String[] args) {

		DriverInterface<Dipendente> driverDipendente = new DriverMemoryImplementation();
		tabellaDipendente = new TableDipendenteImplementation(driverDipendente);
		DriverInterface<Veicolo> driverVeicolo = new DriverMemoryImplementation();
		TableInterface<String, Veicolo> tabellaVeicolo = new TableVeicoliImplementation(driverVeicolo);

		/*
		 * { Dipendente dip = new Dipendente(100, "Fabio", "Fabioli");
		 * tabellaDipendente.insert(dip);
		 * 
		 * System.out.println(tabellaDipendente.get());
		 * 
		 * Dipendente dipDaCambiare = tabellaDipendente.get(100);
		 * dipDaCambiare.setAmministratore(true); dipDaCambiare.setNome("Gianni");
		 * tabellaDipendente.update(dipDaCambiare);
		 * 
		 * System.out.println(tabellaDipendente.get());
		 * 
		 * Dipendente dipDaCambiare2 = tabellaDipendente.get(100);
		 * dipDaCambiare2.setNome("Fabio"); tabellaDipendente.update(dipDaCambiare2);
		 * 
		 * System.out.println(tabellaDipendente.get()); }
		 */

		int scelta = 0;

		do {

			stampaMenù();

			boolean ok;

			do {
				ok = true;

				try {
					scelta = input.nextInt();
				} catch (InputMismatchException e) {
					input.nextLine();
					System.out.println("La scelta effettuata non è valida, riprova");
					stampaMenù();
					ok = false;
				}

			} while (!ok);

			switch (scelta) {

			case 0:
				System.out.println("Stammi bene ;)");
				break;
			case 1:
				gestioneDipendenti();
				break;
			case 2:
				gestioneVeicoli();
				break;
			default:
				System.out.println("La scelta effettuata non è valida");
			}

		}

		while (scelta != 0);

	}

	public static void stampaMenù() {

		System.out.println("Hola amigo! Cosa vuoi fare?:");
		System.out.println("1 - Gestione dipendenti");
		System.out.println("2 - Gestione veicoli");
		System.out.println("0 - Esci");
	}

	public static void gestioneDipendenti() {

		int scelta = 0;

		do {

			stampaMenùDipendenti();

			boolean ok;

			do {
				ok = true;

				try {
					scelta = input.nextInt();
				} catch (InputMismatchException e) {
					input.nextLine();
					System.out.println("La scelta effettuata non è valida, riprova");
					stampaMenùDipendenti();
					ok = false;
				}

			} while (!ok);

			switch (scelta) {

			case 0:
				System.out.println("Stammi bene ;)");
				break;
			case 1:
				String nome;
				String cognome;
				Integer cid;
				Boolean amministratore = false;

				System.out.println("Inserisci nome");
				nome = input.next();

				System.out.println("Inserisci cognome");
				cognome = input.next();

				System.out.println("Inserisci Codice dipendente");
				cid = input.nextInt();
                
			
				Boolean bella = true;
				System.out.println("Il nuovo dipendente è un amministratore? Y/N");
				do {        
                
				switch (input.next()) {
				
				case "Y":
					amministratore = true;
					break;
				case "N":
					amministratore = false;
					break;
				default:
					System.out.println("Scelta non valida, riprova!");
					bella = false;
					System.out.println("Il nuovo dipendente è un amministratore? Y/N");
					break;
				}
                } while (bella == false);

				Dipendente dip = new Dipendente(cid, nome, cognome, amministratore);
				tabellaDipendente.insert(dip);
				System.out.println("Operazione eseguita con successo");
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			default:
				System.out.println("La scelta effettuata non è valida");
			}

		}

		while (scelta != 0);

	}

	public static void gestioneVeicoli() {

	}

	public static void stampaMenùDipendenti() {

		System.out.println("Quale operazione vuoi svolgere?");
		System.out.println("1 - Inserire nuovo dipendente");
		System.out.println("2 - Visualizzare elenco dipendenti");
		System.out.println("3 - Visualizzare stato di un dipendente");
		System.out.println("4 - Modificare stato di un dipendente");
		System.out.println("5 - Eliminare un dipendente");
		System.out.println("0 - Esci");
	}
}
