package esercizi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ScanFileNamesTest {
	
	static ScanFileNames scanFileNames;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		scanFileNames = new ScanFileNames();
	}

	// Testo la funzione con 1 file corretto
	@Test
	void test1CorrectFiles() {
		String filesList = "1988-08-29 956 system.zip";
		assertEquals("1", scanFileNames.solution(filesList));
	}
	
	// Testo la funzione con 4 file corretti
	@Test
	void test4CorrectFiles() {
		String filesList = "1988-08-29 956 system.zip 1995-10-12 245760 old-photos.tgz 1989-11-05 245761 file2.rar 1994-12-01 845 very-long-filename.rar";
		assertEquals("4", scanFileNames.solution(filesList));
	}
	
	// Testo la funzione con l'estensione sbagliata
	@Test
	void testWrongSuffixFiles() {
		String filesList = "1994-12-01 845 very-long-filename.pdf";
		assertEquals("INPUT INVALID", scanFileNames.solution(filesList));
	}
	
	// Testo la funzione con l'estensione doppia  DOVREBBE DARMI INPUT INVALID, ci sarà un errore con split e l'array creato dallo split
//	@Test
//	void testDoubleSuffixFiles() {
//		String filesList = "1994-12-01 845 very-long-filename.rar.zip";
//		assertEquals("INPUT INVALID", scanFileNames.solution(filesList));
//	}
	
	// Testo la funzione con 1 file corretto
//	@Test
//	void testWrongYearFiles() {
//		String filesList = "19A8-08-29 956 system.zip";
//		assertEquals("INPUT INVALID", scanFileNames.solution(filesList));
//	}
	
	// test dove sbaglio anno 293A
	// test dove sbagio mese E3
	// test dove sbagio giorno DD
	// singola estensione sbagliata
	// doppia estensione
	// se passo stringa vuota (deve dare NO files)
	// data che non rispetta il limite
	// size troppo grande

}
