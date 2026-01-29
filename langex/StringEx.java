package test.langex;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class StringEx {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		/*
		 * 스트링 객체는 "" 를 이용해서 생성시엔 공유 영역에 저장하고,
		 * 같은 값을 가진 문자열을 "" 로 생성하게 되면
		 * 같은 객체의 ref를 되돌려준다. 즉 같은 객체라는 뜻이다.
		 * 
		 * 자바에서는 객체간의 비교시 == 의 의미는 같은 객체인지를 물어보는 거다
		 * 즉 ref가 같은지를 물어보는 것이다.
		 */

		String a = "hello";
		String b = "hello";
		
		System.out.println(a == b);
		
		// 생성자를 이용한 문자열 객체 생성하기
		String c = new String("hello");
		System.out.println(a == c);
		
		String st = new String();
		
		byte [] bs = {49, 50, 51};
		// 위 배열의 값을 문자열로 생성함
		st = new String(bs);
		System.out.println(st);
		
		st = new String(bs, 0, 2, "EUC-KR");
		
		System.out.println(st);
		
		// 기본 문자셋 정보 얻어내보기
		Charset cset = Charset.defaultCharset();
		System.out.println(cset.toString());
		
		char[] chArr = {'자','바','는','재','미'};
		String chStr = new String(chArr, 3, 2);
		System.out.println(chStr);
		
		System.out.println(chStr.contains("미"));
		
		// equals(String): 두 개의 문자열 값이 같으면 true, 아니면 false를 리턴함
		System.out.println(c.equals(a));
		
		System.out.println(Arrays.toString("안녕 오늘은 뭐하니".getBytes()));
		
		bs = new byte[]{
		-20, -107, -120, -21, -123, -107, 32, -20, -104, -92, -21, -118, -104, -20,
		-99, -128, 32, -21, -83, -112, -19, -107, -104, -21, -117, -120
		};
		
		String str = new String(bs, "ISO-8859-1");
		System.out.println(str);
		
		// 내 이메일을 변수에 담아서, @ 를 기준으로 id 분리해서 그걸 char 배열로 변환해서
		// 그것의 길이와 값을 출력해보자
		
		String email = "seohyojeong123@gmail.com";
		
		String id = email.split("@")[0];
		// String id = email.substring(0, email.indexOf("@"));
		
		char[] myid = id.toCharArray();
		
		System.out.println(myid.length);
		System.out.println(myid);
		// System.out.println(Arrays.toString(myid));
		
		// charset 인터페이스에서 보면, 문자열을 리턴하도록 하는 메서드가 있다.
		// 자바에서 지원하는 문자셋이 무엇인지를 출력해보자.
		for (Charset cs : Charset.availableCharsets().values()) {
            System.out.println(cs.name());
		}
		
		StringBuilder sb = new StringBuilder("hello");
		System.out.println("내부 버퍼의 크기: " + sb.capacity());
		
		// 문자열 끝에 추가하는 메서드 append();
		// 오버로딩 되어 있어서 파라미터 타입에 맞게 사용함
		sb.append("world");
		System.out.println(sb);
		
		// 문자열 중간에 문자 넣기
		sb.insert(1, "h");
		System.out.println(sb);
		
		// 문자열 지우기
		sb.delete(0,3);
		System.out.println(sb);
		
		// o 다음에 공백을 추가해서 llo world가 되도록 해보기
		sb.insert(sb.indexOf("w"), " ");
		System.out.println(sb);
		
		// sb 객체의 값을 String 객체로 생성해보자
		String str2 = new String(sb);
		// String str2 = sb.toString();
		System.out.println(str2);
		
		byte[] b1 = "abcde".getBytes();
		byte[] b2 = "jklmn".getBytes();
		
		System.arraycopy(b1, 0, b2, 0, b1.length);
		System.out.println(Arrays.toString(b2));
		
		System.out.println(new String(b2));
		
		System.out.println(System.currentTimeMillis());
		
		// 자바프로그램을 강제 종료시키는 메서드. 과제할 때 유용하게 쓰일듯
		// System.exit(0);
		
		// 자바의 Wrapper 클래스
		// 자바에서 사용되는 모든 Ptype을 클래스로 정의한 클래스
		// 이 클래스를 이용하면 ptype에 관련된 많은 정보를 손쉽게 사용할 수 있다.
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Integer.compare(0, 1));
		
		int i = 10;
		Integer.valueOf(i).floatValue();
		
		System.out.println(Integer.parseInt("10"));
		
		String pass = "AasAdF1dx";	// 숫자 하나와 대문자가 포함되어야 한다고 가정한다.
		
		int digitCnt = 0, alphaCnt = 0;
		
		for(int ii = 0; ii < pass.length(); ii++) {
			// 문자를 하나씩 분리한다
			char ch = pass.charAt(ii);
			
			// 분리된 문자가 대문자인지, 소문자인지 검증한다
			if(Character.isUpperCase(ch)) {
				alphaCnt++;
			}
			if(Character.isDigit(ch)) {
				digitCnt++;
			}
			
		}
	}
}