package test.utilex;

import java.io.IOException;
import java.util.Properties;

public class PropertiesExam {

	public static void main(String[] args) throws IOException {
		
		/*
		 * Properties 객체 사용법
		 * 프로퍼티스 객체를 생성한 후에, load()를 이용해서 
		 * 로딩할 프로퍼티스의 파일 경로를 getResourceAsStream()으로 연결한다.
		 * 이후에는 getProperty("key")를 이용해서 설정 정보를 get한다.
		 */

		Properties properties = new Properties();
		// 같은 classPath에 있는 Properties 파일을 로드함
		properties.load(PropertiesExam.class.getResourceAsStream("db.properties"));
		
		// getProperty()를 이용해서 설정 정보를 얻어낸다
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String admin = properties.getProperty("admin");
		
		System.out.println(driver);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		System.out.println(admin);

	}
}