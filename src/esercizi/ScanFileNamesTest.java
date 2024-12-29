package esercizi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ScanFileNamesTest {
	
	static ScanFileNames scanFileNames;

	@BeforeAll
	static void setUpBeforeClass() {
		scanFileNames = new ScanFileNames();
	}

	// Testo la funzione con 1 file corretto
	@Test
	void testCorrectFiles() {
		String filesList1 = "1988-08-29 956 system.zip";
		assertEquals("1", scanFileNames.solution(filesList1));
		
		String filesList2 = "1988-08-29 956 system.zip "
							+ "1995-10-12 245760 old-photos.tgz "
							+ "1989-11-05 245760 file2.rar "
							+ "1995-10-01 845 very-long-filename.rar ";
		assertEquals("4", scanFileNames.solution(filesList2));
	}
	

	// Testo la funzione con l'estensione sbagliata
	@Test
	void testWrongSuffixFiles() {
		String filesList1 = "1988-08-29 956 system.zip "
				+ "1995-10-12 245760 old-photos.tgz "
				+ "1989-11-05 245760 file2.rar "
				+ "1995-10-01 845 very-long-filename.pdf "; // no "pdf"
		assertEquals("INPUT INVALID", scanFileNames.solution(filesList1));
		
		String filesList2 = "1988-08-29 956 system.zip "
				+ "1995-10-12 245760 old-photos.tgz "
				+ "1989-11-05 245760 file2.rar "
				+ "1995-10-01 845 very-long-filename.html "; // no "html"
		assertEquals("INPUT INVALID", scanFileNames.solution(filesList2));
	}
	
	// Testo la funzione con l'estensione doppia
	@Test
	void testDoubleSuffixFiles() {
		String filesList = "1994-12-01 845 very-long-filename.rar.zip";
		assertEquals("INPUT INVALID", scanFileNames.solution(filesList));
	}
	
	// Testo la funzione con 1 file corretto
//	@Test
//	void testWrongYearFiles() {
//		String filesList = "19A8-08-29 956 system.zip";
//		assertEquals("INPUT INVALID", scanFileNames.solution(filesList));
//	}
	
	// test dove sbaglio anno 293A
	// test dove sbagio mese E3
	// test dove sbagio giorno DD
	// singolo suffix sbagliata
	// doppia suffix
	// senza estensione (.)
	// doppia esetensione (.)
	// se passo stringa vuota (deve dare NO files)
	// data che non rispetta il limite
	// size troppo grande

}
