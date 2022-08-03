package IOFileCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileCopy {
	public static void main(String[] args) {
		
		FileInputStream fin = null;
		FileOutputStream fos = null;

		File file1 = new File("e:/D_Other/Tulips.jpg");
		File file2 = new File("e:/D_Other/복사본_Tulips.jpg");
		try {
			
			
			fin = new FileInputStream(file1);
			fos = new FileOutputStream(file2); 
			
			int data;
			
			
			while((data = fin.read()) != -1) {
				
				fos.write(data);
			}
			
			fin.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
			

		
		
	}
}
