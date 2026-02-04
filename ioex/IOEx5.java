package test.ioex;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Member implements Serializable{

	private static final long serialVersionUID = -3682820767514922541L;
	
	private String id;
	private String name;
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return id + " : " + name;
	}
	
}

public class IOEx5 {

	public static void main(String[] args) throws Exception {
		
//		BufferedReader br = 
//				new BufferedReader(
//						new FileReader("C:\\JavaWorkspace\\javaFund2\\src\\test\\ioex\\IOEx4.java"));
//		
//		int lineNo = 1;
//		while(true) {
//			String str = br.readLine();
//			if(str == null) break;
//			System.out.println(lineNo + "\t" + str);
//			lineNo++;
//		}
//		br.close();
		
		
		
		
		/*
		 * 객체를 통째로 쓰거나 읽기(ObjectIn-OutputStream)
		 * 이 대상이 되는 객체는 반드시 Serializable을 구현한 객체여야 함
		 * 이 인터페이스는 메서드가 없는 애이기 때문에 구현선언만 해주면 됨.
		 */
		ObjectOutputStream oos = 
				new ObjectOutputStream(
						new FileOutputStream("C:\\Temp\\object.dat"));
		
		// Member 객체 생성
		Member m1 = new Member("aa", "자바객체");
		
		oos.writeObject(m1);
		
		oos.flush();
		oos.close();
		
		
		
		
		// 파일에 쓰여진 객체를 읽어들인다.
		// 이때 주의해야할 것은 쓴 순서 그대로 읽어야 한다.
		// ex) 객체를 쓰고, byte[]를 썼다면, 읽을 때도 readObject(), readByte() 형태로 읽어야 한다.
		// 그렇지 않으면 예외 발생함
		// 또한 읽어들인 후에는 적절한 타입으로 캐스팅을 통해 원형으로 만든다
		ObjectInputStream ios =
				new ObjectInputStream(
						new FileInputStream("C:\\Temp\\object.dat"));
		
		// 파일을 읽고 역직렬화 후 객체로 복원한다.
		Member m2 = (Member)ios.readObject();
		
		ios.close();
		
		System.out.println(m2);
		
	}
}