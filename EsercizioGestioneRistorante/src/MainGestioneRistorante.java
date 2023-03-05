import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/* CHIEDO PERDONO PER NON AVERLO COMMENTATO, RIMEDIO NELLA SERATA DI LUNEDI
 * 
 * LAVORI IN CORSO: HO ANCORA DELLE PARTI DA AGGIUNGERE E ALTRE DA MODIFICARE
 * 
 * INTANTO LA PARTE ADMIN E DI MODIFICA DEL MENU IN PARTE FUNZIONA IL CODICE DI ACCESSO E' 1234
 * 
 * MENTRE SCRIVEVO IL CODICE MI SONO ACCORTO DI ALTRE 23412 FUNZIONI CHE SAREBBE STATO MEGLIO RACCHIUDERE IN ALTRI METODI MA VA BENE COSI PIANO PIANO OTTIMIZZERO'
 * 
 * GRAZIE IN ANTICIPO PER LA REVISIONE
 */


public class MainGestioneRistorante {

	public static Utente registraUtente(List<Utente> listaUtenti) {

		boolean provaAdmin = true;
		boolean provaCodice = true;
		boolean nomeEsistente = false;
		Utente utente = new Utente();

		Scanner name = new Scanner(System.in);
		Scanner pass = new Scanner(System.in);
		Scanner verAdmin = new Scanner(System.in);
		Scanner verCodice = new Scanner(System.in);

		System.out.println("Inserisci un nome utente");

		while (!nomeEsistente) {
			String nome = name.nextLine();
			if (listaUtenti.size() > 0) {
				Iterator<Utente> iterLista = listaUtenti.iterator();
				while (iterLista.hasNext()) {
					Utente controllo = iterLista.next();
					if (nome.equalsIgnoreCase(controllo.getNome())) {
						System.out.println("Esiste gia un utente con lo stesso nome, provane un altro.");
					} else {
						utente.setNome(nome);
						nomeEsistente = true;
					}
				}
			} else {
				utente.setNome(nome);
				nomeEsistente = true;
			}
		}

		System.out.println("Inserisci una password");
		String password = pass.nextLine();
		utente.setPassword(password);

		System.out.println("Sei un admin? \n1: Si \n2: No");
		while (provaAdmin) {
			int admin = verAdmin.nextInt();
			switch (admin) {
			case 1:
				System.out.println("Inserisci il codice di accesso");
				int codice = verCodice.nextInt();
				while (provaCodice) {
					if (codice == 1234) {
						utente.setAdmin(true);
						provaCodice = false;
					} else {
						System.out.println("Il codice non e\' valido");
					}
				}
				provaAdmin = false;
				break;
			case 2:
				utente.setAdmin(false);
				provaAdmin = false;
				break;
			default:
				System.out.println("Scelta non valida, riprova");
				break;
			}
		}
		utente.setId(listaUtenti.size() + 1);
		return utente;

	}

	public static Utente loginUtente(List<Utente> listaUtenti) {

		Utente user = null;
		Scanner name = new Scanner(System.in);
		Scanner pass = new Scanner(System.in);

		System.out.println("Inserisci il nome utente");
		String nome = name.nextLine();
		System.out.println("Inserisci la password");
		String password = pass.nextLine();

		Iterator<Utente> iterLista = listaUtenti.iterator();
		while (iterLista.hasNext()) {
			Utente controllo = iterLista.next();
			if (nome.equalsIgnoreCase(controllo.getNome()) && password.equals(controllo.getPassword())) {
				user = controllo;
			}
		}
		return user;
	}

	public static void visualizzaMenu(List<Piatto> listaPiatti) {
		Iterator<Piatto> iterLista = listaPiatti.iterator();
		while (iterLista.hasNext()) {
			Piatto piatto = iterLista.next();
			System.out.println(piatto.toStringVisualizza());
		}
	}

	public static void modificaMenu(List<Piatto> listaPiatti) {
		Scanner in = new Scanner(System.in);
		Scanner inPiatto = new Scanner(System.in);
		boolean modifica = true;
		while (modifica) {
			System.out.println("Inserisci 1 per aggiungere un piatto nuovo, 2 per rimuovere un piatto esistente oppure 3 per uscire");
			int scelta = in.nextInt();
			switch (scelta) {
			case 1:
				boolean aggiungi = true;
				while (aggiungi) {
					Piatto nuovoPiatto = new Piatto();
					System.out.println("Inserisci il nome del piatto");
					nuovoPiatto.setNome(inPiatto.nextLine());
					System.out.println("Inserisci gli ingredienti");
					nuovoPiatto.setIngredienti(inPiatto.nextLine());
					System.out.println("Inserisci il prezzo");
					nuovoPiatto.setPrezzo(inPiatto.nextDouble());
					System.out.println("Il piatto e\' stato aggiunto al menu");
					listaPiatti.add(nuovoPiatto);
					System.out.println("Inserisci 1 per aggiungere un altro piatto nuovo oppure 2 per tornare indietro");
					boolean vaiAvanti = true;
					while (vaiAvanti) {
						int altroPiatto = in.nextInt();
						switch (altroPiatto) {
						case 1:
							vaiAvanti = false;
							break;
						case 2:
							vaiAvanti = false;
							aggiungi = false;
							break;
						default:
							System.out.println("Scelta non valida, riprova");
							break;
						}
					}
				}
				break;
			case 2:
				Iterator<Piatto> iterLista = listaPiatti.iterator();
				int i = 1;
				boolean rimuovi = true;
				while (iterLista.hasNext()) {
					Piatto piatto = iterLista.next();
					System.out.println(i + ") " + piatto.toStringVisualizza());
					i++;
				}
				System.out.println("Inserisci il numero relativo al piatto da rimuovere");
				while (rimuovi) {
					int piattoDaRimuovere = in.nextInt();
					listaPiatti.remove(piattoDaRimuovere - 1);
					System.out.println("Inserisci 1 per rimuovere un altro piatto oppure 2 per tornare indietro");
					boolean vaiAvanti = true;
					while (vaiAvanti) {
						int altroPiatto = in.nextInt();
						switch (altroPiatto) {
						case 1:
							vaiAvanti = false;
							break;
						case 2:
							vaiAvanti = false;
							rimuovi = false;
							break;
						default:
							System.out.println("Scelta non valida, riprova");
							break;
						}
					}
				}
				break;
			case 3:
				modifica = false;
				break;
			default:
				modifica = false;
				break;
			}
		}
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Utente utenteCorrente = new Utente();
		List<Utente> listaUtenti = new ArrayList<Utente>();
		List<Piatto> listaPiatti = new ArrayList<Piatto>();

		Piatto carbonara = new Piatto();
		Piatto amatriciana = new Piatto();
		Piatto gricia = new Piatto();

		carbonara.setNome("Carbonara");
		carbonara.setIngredienti("Pasta, Uova, Guanciale, Formaggio");
		carbonara.setPrezzo(10.5);

		amatriciana.setNome("Amatriciana");
		amatriciana.setIngredienti("Pasta, Pomodoro, Guanciale, Formaggio");
		amatriciana.setPrezzo(11);

		gricia.setNome("Gricia");
		gricia.setIngredienti("Pasta, Guanciale, Formaggio");
		gricia.setPrezzo(9.5);

		listaPiatti.add(carbonara);
		listaPiatti.add(amatriciana);
		listaPiatti.add(gricia);

		boolean sceltaRegistrazione = true;

		System.out.println("Inserisci 1 per registrarti, 2 per il login o 3 per uscire.");
		int sceltaLogin = in.nextInt();
		while (sceltaRegistrazione) {
			switch (sceltaLogin) {
			case 1:
				Utente user = registraUtente(listaUtenti);
				listaUtenti.add(user);
				System.out.println("Inserisci 1 per registrare un altro utente o 2 per andare al login");
				sceltaLogin = in.nextInt();
				break;
			case 2:
				utenteCorrente = loginUtente(listaUtenti);
				if (utenteCorrente == null) {
					System.out.println("Username o password errati");
				} else {
					System.out.println("Benvenuto " + listaUtenti.get(utenteCorrente.getId() - 1).getNome());
					sceltaRegistrazione = false;
				}
				break;
			case 3:
				System.out.println("Hai scelto di uscire, arrivederci.");
				sceltaRegistrazione = false;
				break;
			default:
				System.out.println("Scelta non valida, riprova");
				break;
			}
		}
		if (utenteCorrente.isAdmin()) {
			boolean sceltaAdmin = true;
			while (sceltaAdmin) {
				System.out.println("Inserisci 1 per modificare il menu, 2 per visualizzarlo oppure 3 per uscire");
				boolean modifica = true;
				while (modifica) {
					int sceltaModificaMenu = in.nextInt();
					switch (sceltaModificaMenu) {
					case 1:
						modificaMenu(listaPiatti);
						modifica = false;
						break;
					case 2:
						visualizzaMenu(listaPiatti);
						modifica = false;
						break;
					case 3:
						modifica = false;
						sceltaAdmin = false;
						break;
					default:
						System.out.println("Scelta non valida, riprova");
						break;
					}
				}
			}
		}
		visualizzaMenu(listaPiatti);
	}
}
