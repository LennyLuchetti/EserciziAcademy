import java.util.List;

public class Registro {
	
	private List<Utente> utenti;
	
	public Registro(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public Registro() {

	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}
}
