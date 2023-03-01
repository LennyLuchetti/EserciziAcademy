import java.util.Scanner;

public class EsercizioOrdiniRistorante {

	public static void main(String[] args) {

		/*
		 * Andiamo a creare un sistema di inserimento che permetta di ordinare x tipi di
		 * piatto a tua scelta (minimo 3) che contengano nome prezzo e ingredienti
		 * 
		 * Obbiettivi Sapere quante ordinazioni e quanto ho speso in totale
		 */
		Scanner primo = new Scanner(System.in);
		Scanner secondo = new Scanner(System.in);
		Scanner terzo = new Scanner(System.in);

		String[] piatti = { "Carbonara", "Amatriciana", "Tagliata" };
		double[] prezzi = { 10, 10.5d, 18.5d };
		String[] ingredienti = { "Pasta, uova, guanciale, pecorino", "Pasta, pomodoro, guanciale, parmiggiano",
				"Carne di manzo, scaglie di parmiggiano, insalata, patate" };
		boolean cond1 = true, cond2 = true;
		int i = 0;
		double totale = 0;

		System.out.println("Benvenuto nel mio ristorante");
		System.out.println("Per mangiare premi 1 \nPer uscire premi 2");
		while (cond1) {
			int scelta1 = primo.nextInt();
			if (scelta1 == 1) {
				while (cond2) {
					int scelta2, scelta3 = 0;
					System.out.println("Per ordinare premi 1 \nPer visualizzare il menu\' premi 2 \nPer uscire premi 3");
					scelta2 = secondo.nextInt();
					switch (scelta2) {
					case 1:
						System.out.println("Scegli il piatto da ordinare\n" + "1: " + piatti[0] + " " + prezzi[0]
								+ "\n2: " + piatti[1] + " " + prezzi[1] + "\n3: " + piatti[2] + " " + prezzi[2]);
						scelta3 = terzo.nextInt();
						switch (scelta3) {
						case 1:
							System.out.println("Cabonara aggiunta all\' ordine.");
							totale = totale + prezzi[0];
							i++;
							break;
						case 2:
							System.out.println("Amatriciana aggiunta all\' ordine.");
							totale = totale + prezzi[1];
							i++;
							break;
						case 3:
							System.out.println("Tagliata aggiunta all\' ordine.");
							totale = totale + prezzi[2];
							i++;
							break;
						default:
							System.out.println("La scelta che hai effettuato non e\' disponibile, riprova.");
							break;
						}
						break;
					case 2:
						System.out.println("Ecco il nostro menu\' \n" + piatti[0] + ": " + ingredienti[0] + "\n"
								+ piatti[1] + ": " + ingredienti[1] + "\n" + piatti[2] + ": " + ingredienti[2]);
						break;
					case 3:
						if (i == 0) {
							System.out.println("Non hai ordinato nulla, arrivederci");
							cond2 = false;
						} else {
							System.out.println("Ecco il totale: " + totale);
							cond2 = false;
						}
						break;
					default:
						System.out.println("La scelta che hai effettuato non e\' disponibile, riprova.");
						break;
					}
				}
			} else if (scelta1 == 2) {
				System.out.println("Hai scelto di uscire, arrivederci");
				cond1 = false;
			} else {
				System.out.println("La scelta che hai effettuato non e\' disponibile, riprova");
				scelta1 = 0;
			}
		}
	}
}
