package esercizi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String userString = "";
		
		
		// Finchè l'utente non digita "termina programma" continuo a richiedere una stringa e stamparla
		while (!userString.equalsIgnoreCase("stop")) {
			
			
			
			// System.out.println("valore di userString: " + userString);
			
			// Chiedo stringa
			System.out.println("-- DIGITA UNA STRINGA --");
			userString = scanner.nextLine();
			
			// Stampo stringa
			System.out.println("stringa stampata: " + userString);
			
			
		}
		
		scanner.close();
		System.out.println("Programma terminato!");

	}

}
