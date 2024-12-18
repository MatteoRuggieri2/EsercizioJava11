package esercizi;

import java.time.LocalDate;
import java.util.Scanner;

public class ScanFileNames {
	
	/* Restituire "NO FILES" o il counter files validi
	Contare solo i files con data < 13 Ottobre 1995
	Usare LocalDate.of(yyy,mm,gg) per creare una data e LocalDate.iBefore()
	per confrontare le date */
	
	/* Restituire INPUT INVALID e t se input malformato
	- Se size > (240K) scartare il nome file e continue
	- Se non c'è estensione (.)
	- Se non c'è suffix dopo .
	- Se suffix diverso da rar zip tgz */
	
	/* Scartare il file corretto individuato se size > (240K) */
	
	
	// Stringa di esempio: "1988-08-29 956 system.zip"
	
	
	// COSTRUTTORE
//	public ScanFileNames(String s) {
//		System.out.println("Counter di file corretti: " + solution(s));
//	}

	public String solution(String s) {
		
		// COSTANT
		LocalDate LIMIT_DATE = LocalDate.of(1995, 10, 13);
		int MAX_KILO_BYTE_FILE_SIZE = 240;
		int MAX_BYTE_FILE_SIZE = MAX_KILO_BYTE_FILE_SIZE * 1024;   // 1KB = 1024 B
		String[] ALLOWED_SUFFIX_ARRAY = {"rar", "zip", "tgz"};
		
		// DATA
		String fileCompleteName = "";  // name + suffix
		String fileDate = "";
		int fileSize = 0;
		String fileName = "";  // name
		String fileSuffix = "";
		boolean fileDateCheck = false;
		boolean fileSizeCheck = false;
		boolean fileExtensionCheck = false;
		boolean fileSuffixCheck = false;
		int validFilesCounter = 0;
		
		
		// Apro scanner e gli passo la stringa
		Scanner sc = new Scanner(s);
		
		// Finchè è presente un token
		while (sc.hasNext()) {
			fileDate = sc.next();
			
			// Se non rispetta la struttura della stringa ritorno "INPUT INVALID"
			if (!sc.hasNextInt()) {
				return "INPUT INVALID";
			}
				
			fileSize = sc.nextInt();
			
			// Se non rispetta la struttura della stringa ritorno "INPUT INVALID"
			if (!sc.hasNext()) {
				return "INPUT INVALID";
			}
			
			fileCompleteName = sc.next();
			
			validFilesCounter++;
		}
		
		// Separo la data
		String[] dataElementsArray = fileDate.split("-");
		
		int fileYear = Integer.parseInt(dataElementsArray[0]);
		int fileMonth = Integer.parseInt(dataElementsArray[1]);
		int fileDay = Integer.parseInt(dataElementsArray[2]);
		
		// Creo la data con i dati scomposti che mi sono ricavato
		LocalDate curDate = LocalDate.of(fileYear, fileMonth, fileDay);

		// Se la data è inferiore di 13 ottobre 1995 metto fileDateCheck = TRUE
		if (curDate.isBefore(LIMIT_DATE)) {
			fileDateCheck = true;
		}
		
		// Se la dimensione del file è inferiore a 240KB metto fileSizeCheck = TRUE
		if (fileSize < MAX_BYTE_FILE_SIZE) {
			fileSizeCheck = true;
		}
		
		// Se il nome del file contiene l'estensione fileExtensionCheck = TRUE
		if (fileCompleteName.contains(".")) {
			fileExtensionCheck = true;
		}
		
		// Prendo il nome del file e l'estensione
		String[] fileNameAndSuffix = fileCompleteName.split("\\.");
		fileName = fileNameAndSuffix[0];
		fileSuffix = fileNameAndSuffix[1];
		
		fileSuffixCheck = false;
		
		// Se l'estensione del file non è ammessa return INPUT INVALID
		for (int i = 0; i < ALLOWED_SUFFIX_ARRAY.length; i++) {
			
			String allowedSuffix = ALLOWED_SUFFIX_ARRAY[i];
			
			// Se l'estensione è diversa e sono nell'ultimo giro vuol dire che non c'è l'estensione corretta
			if (fileSuffix.equals(allowedSuffix)) {
				fileSuffixCheck = true;
			}
		}
		
		
		// Se maggiore di 240kb, non c'è . , suffisso diverso, INPUT INVALID
		if (fileSize > MAX_BYTE_FILE_SIZE || fileExtensionCheck == false || fileSuffixCheck == false) {
			return "INPUT INVALID";
		}
		
		// Se ci sono 0 file ritorno "NO FILES"
		if (validFilesCounter == 0) {
			return "NO FILES";
		}
		
		// Ritorno il numero di file corretti
		return String.valueOf(validFilesCounter);
	}
}
