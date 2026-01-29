package test.langex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassExam {
	public static void main(String[] args) throws ClassNotFoundException {
		
		// Class class 는 클래스에 필요한 정보를 관리하는 클래스임
		
		Class cls = Class.forName("test.langex.ClassExam");
		
		System.out.println(cls.getName());
		
		Constructor[] cons = cls.getConstructors();
		for(Constructor con: cons) {
			System.out.println(con);
		}
		
		// 메서드 이름을 출력시켜보자. API 참조하자.. 이건 나중에 추가 설명해주신다고 함
		Method[] methods = cls.getMethods();
		for(Method name : methods) {
			System.out.println(name.getName());
			System.out.println(name.getParameterCount());
		}
	}
	
	void a() {
		
	}
	
	void b() {
		
	}
}