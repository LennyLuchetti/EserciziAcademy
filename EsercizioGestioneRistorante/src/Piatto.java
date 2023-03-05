public class Piatto {
	
	private String nome;
	private String ingredienti;
	private double prezzo;
	
	public Piatto(String nome, String ingredienti, double prezzo) {
		this.nome = nome;
		this.ingredienti = ingredienti;
		this.prezzo = prezzo;
	}
	
	public Piatto() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(String ingredienti) {
		this.ingredienti = ingredienti;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String toStringOrdine() {
		return  nome + " " + prezzo;
	}

	public String toStringVisualizza() {
		return nome + "\nIngredienti: " + ingredienti;
	}
	
	

}
