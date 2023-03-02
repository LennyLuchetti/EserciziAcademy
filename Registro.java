import java.util.ArrayList;

public class Registro {
	
	private ArrayList<Utente> utenti;
	
	public Registro(ArrayList<Utente> utenti) {
		this.utenti = utenti;
	}

	public Registro() {

	}

	public ArrayList<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(ArrayList<Utente> utenti) {
		this.utenti = utenti;
	}
}
