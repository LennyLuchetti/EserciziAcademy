package lez1.file;

public class Main {

	public static void main(String[] args) {
		
		GestoreFile gestore = new GestoreFile();
		if(gestore.scriviFileNormale("provNormale.txt", "Zio pera"))
			System.out.println("Scrittura effettuata");
		else
			System.out.println("Scrittura non effettuata");
		
		
	}

}
