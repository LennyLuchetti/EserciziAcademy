package EsercizioMetodi;

public class EsercizioVerificaMetodi {
	
	/*Un metodo è una funzione, ovvero un blocco di codice esterno al main, che permette di riutilizzare il codice ogni volta che
	 * viene richiamato. Nel caso "somma" al metodo vanno passati due parametri di tipo numerico che verranno
	 * aritmeticamente sommati all'interno del metodo; questo poi restituirà al main un parametro singolo che è la somma
	 * dei parametri che gli sono stati passati.
     */
	
	static int somma(int x, int y) {   //Nome metodo e attributi 
		int somma = x + y;             //Somma aritmetica
		return somma;                  //Restituzione totale
	}
	
	/* Il metodo "media" prende un array di valori interi in ingresso, cicla l'array sommando ogni volta il 
	 * numero successivo al totale, poi divide il totale per il numero di elementi dell'array, infine
	 * ritorna la media come valore double
	 */
	
	static double media(int[] numeri) {
		int somma = 0;
		for(int i = 0; i < numeri.length; i++) {        //Ciclo l'array 
			somma += numeri[i];                         //A ogni ciclo aggiungo il nuovo numero alla somma
		}
		double media = (double)somma/numeri.length;     //Divido la somma per il numero di elementi dell'array
		return media;
	}
	
	/* Il metodo "inverti" prende una stringa in ingresso, cicla la stringa partendo dalla fine, aggiunge i valori
	 * in una nuova stringa e restituisce la nuova stringa invertita
	 */
	
	static String inverti(String stringa) {
		String stringaInvertita = "";                   //Inizializzo una nuova stringa vuota
		for(int i = stringa.length()-1; i >= 0; i--) {  //Ciclo la stringa partendo dalla fine
		stringaInvertita += stringa.charAt(i);          //Aggiungo ogni volta il valore alla nuova stringa 
		}
		return stringaInvertita;
	}

	public static void main(String[] args) {

		
		int totale = somma(5, 7);        //Richiamo il metodo e inizializzo una variabile con il valore che ritorna dal metodo
		System.out.println("La somma e\': " + totale);      //Stampo il risultato
		
		int[] numMedia = {2, 4, 6, 8, 10};
		double media = media(numMedia);
		System.out.println("La media e\': " + media);
		
		String parola = "ciao";
		String parolaInvertita = inverti(parola);
		System.out.println("La parola invertita e\': " + parolaInvertita);

	}

}
