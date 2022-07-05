package chapter11;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTime {
	public static void main(String[] args) {
		Date date = new Date();
		// 2022-07-05 우리나라는 이런 형식을 좋아함
		
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(format.format(date));
//		
		//localDateTime 은 시간까지 표현
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일 hh:mm:ss")));
		
		
		
	}
}
