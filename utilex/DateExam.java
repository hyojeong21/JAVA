package test.utilex;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExam {

	public static void main(String[] args) {

		/*
		 * Date 클래스: 날짜와 시간을 관리하는 클래스
		 * 대부분의 API가 Deprecated 되어 있어서, Calendar 클래스를 사용하도록 권장되나
		 * 기본 API들은 많이 사용된다.
		 */
		
		Date now = new Date();
		System.out.println(now);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
		String formatDate = sdf.format(now);
		System.out.println(formatDate);
		
		Calendar cNow = Calendar.getInstance();		// 현재 시간을 나타내는 객체 get
		System.out.println(cNow);
		
		int year = cNow.get(Calendar.YEAR);
		System.out.println(year);
		
		// 이번주가 몇 번째 주인지 확인해보기
		System.out.println(cNow.get(Calendar.WEEK_OF_MONTH));
		System.out.println(cNow.get(Calendar.WEEK_OF_YEAR));
		System.out.println(cNow.get(Calendar.DAY_OF_YEAR));
		
		// 크리스마스까지 며칠 남았는지 확인해보기. set메서드 이용
		Calendar xmas = Calendar.getInstance();
		xmas.set(2026, 11, 25);
		System.out.println(xmas);
		System.out.println(xmas.get(Calendar.DAY_OF_YEAR));
		int diff = xmas.get(Calendar.DAY_OF_YEAR) - cNow.get(Calendar.DAY_OF_YEAR);
		
		// cNow는 현재 시간을 가지고 있다. 이 시간값을 이용해서 다음처럼 출력시키자
		// SimpleDateFormat을 이용한다.
		// 현재 시간은 오후 ?시 ?분 ?초 입니다.
		Date d = cNow.getTime();
		sdf = new SimpleDateFormat("현재 시간은 a h시 MM분 ss초입니다");
		System.out.println(sdf.format(d));
		
		// 0~10 사이의 랜덤한 값을 갖는 5개 배열을 생성해서 이를 오름차순으로 정렬 후 결과를 출력하세요
		int[] arr = new int[5];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10) + 1;
        }
        
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
        
        Pattern pa = Pattern.compile("s[a-z]*"); // s로 시작하는 알파벳 소문자가 0개 이상 리턴
        Matcher ma = null;
        
        ma = pa.matcher("super");
        System.out.println(ma.matches());
         
	}
}