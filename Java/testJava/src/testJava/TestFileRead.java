package testJava;

import java.io.BufferedReader;
import java.io.FileReader;

public class TestFileRead {
	
	// 지금 내가 편집하고 있는 파일을 읽어서 콘솔에 나타내기
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader("src/testJava/TestFileRead.java"));
		
		while (true) {
			String readLine = br.readLine();
			if(readLine == null) {
				break;
			}
			System.out.println(readLine);
		}
		br.close();
	}
}
