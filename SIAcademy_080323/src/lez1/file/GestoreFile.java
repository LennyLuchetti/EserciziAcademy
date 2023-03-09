package lez1.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class GestoreFile {

	private String path = "C:\\Users\\SI Academy\\Desktop\\test_git_si_2023\\";

	public boolean scriviFileNormale(String nomeFile, String contenuto) {
		try {
			
			File file = new File(path.concat(nomeFile));
			FileWriter fw = new FileWriter(file);
			
			fw.write(contenuto);
			
			fw.flush();
			fw.close();
			
			return true;
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		return false;
	}
	
	public boolean scriviFileConBuffer(String nomeFile, String contenuto) {
		try {
			
			File file = new File(path.concat(nomeFile));
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(contenuto);
			
			bw.flush();
			bw.close();
			
			return true;
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		return false;
	}
	
	public String leggiFile(String nomeFile) {
		
		String risultato = "";
		try {
			
			File file = new File(path.concat(nomeFile));
			FileReader fr = new FileReader(file);
			
			char[] in = new char[1000];
			
			int lunghezza = fr.read(in);
			for(int i = 0; i < lunghezza; i++) {
				risultato += in[i];
			}
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		return risultato;
	}

}
