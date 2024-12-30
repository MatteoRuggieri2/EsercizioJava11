package esercizi;

public class Main {

	public static void main(String[] args) {
		
		String filesList = "1988-08-29 956 system.zip "
				+ "1995-10-12 245760 old-photos.tgz "
				+ "1989-11-05 245760 file2.rar "
				+ "1996-12-01 845 very-long-filename.rar ";

		ScanFileNames scanFileNames = new ScanFileNames();

		System.out.println("Output: " + scanFileNames.solution(filesList));

	}

}
