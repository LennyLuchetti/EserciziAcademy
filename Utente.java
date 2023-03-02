
public class Utente {
	
	private String nome;
	private String password;
	private int id;
	private int codiceAccesso;
	private boolean admin;
	
	public Utente(String nome, String password, int id, int codiceAccesso, boolean admin) {
		
		this.nome = nome;
		this.password = password;
		this.id = id;
		this.codiceAccesso = codiceAccesso;
		this.admin = admin;
	}
	
	public Utente() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodiceAccesso() {
		return codiceAccesso;
	}

	public void setCodiceAccesso(int codiceAccesso) {
		this.codiceAccesso = codiceAccesso;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
