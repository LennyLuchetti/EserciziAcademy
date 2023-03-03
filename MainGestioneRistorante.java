import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MainGestioneRistorante {

	public static void registraUtente() {

		boolean provaAdmin = true;
		boolean provaCodice = true;
		Utente utente = new Utente();
		
		Registro registro = new Registro();
		List<Utente> listaUtenti = new ArrayList<Utente>();
		
		Scanner name = new Scanner(System.in);
		Scanner pass = new Scanner(System.in);
		Scanner verAdmin = new Scanner(System.in);
		Scanner verCodice = new Scanner(System.in);
		System.out.println("Inserisci un nome utente");
		String nome = name.nextLine();
		utente.setNome(nome);

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
		
		utente.setId(registro.getUtenti().size() + 1);
		listaUtenti.add(utente);

	}

	public static void main(String[] args) {

		registraUtente();
		

	}

}
