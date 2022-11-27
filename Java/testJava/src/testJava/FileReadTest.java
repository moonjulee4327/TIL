package testJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadTest {
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new FileReader("src/testJava/TestFileRead.java"));
		
		String readLine = "";
		
		while (true) {
			
			readLine = br.readLine();
			
			if (readLine == null) {
				break;
			}
			System.out.println(readLine);
		}
		br.close();
	}
}
