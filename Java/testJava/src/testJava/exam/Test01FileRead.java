package testJava.exam;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

public class Test01FileRead implements Closeable{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("src/testJava/exam/Test01FileRead.java"));
		
		while (true) {
			String readLine = br.readLine();
			if(readLine == null) { 
				break;
			}
			
			System.out.println(readLine);
		}
		
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
