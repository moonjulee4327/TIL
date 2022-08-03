

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileCopy {
	public static void main(String[] args) {

		File file1 = new File("C:/Users/이문주/Desktop/ddit/Tulips.jpg");
		File file2 = new File("C:/Users/이문주/Desktop/ddit/복사본_Tulips.jpg");
		
		FileInputStream fin = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			
			long start = System.currentTimeMillis();
			
			fin = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			bis = new BufferedInputStream(fin);
			bos = new BufferedOutputStream(fos);
			
			int data;
			
			
			while((data = bis.read()) != -1) {
				
				bos.write(data);
			}
			
			bos.flush();
			
			long end = System.currentTimeMillis();
			
			System.out.println("소요시간 : " + (end-start));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
			

		
		
	}
}
