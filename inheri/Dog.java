package test.inheri;

public class Dog extends Animal {
	
	public String name;
	public String breed;
	
	public Dog(String name, String breed) {	// 생성자 정의하기
		super("개");
		this.name = name;
		this.breed = breed;
	}
	
	/*
	 * 메서드 오버라이딩: 상속받은 부모의 메서드와 모든 것(이름, 리턴타입, 파라미터)을
	 * 똑같이 정의해서 자식 입장에서 내용부를 재정의하는 것. 이렇게 오버라이드를 하게 되면
	 * 자식 객체를 발생한 경우엔, 부모객체의 메서드는 은닉되어진다.
	*/
	
	public String toString() {
		return super.toString() + " 이름은 " + name + " 품종은 " + breed;
	}
	
	// sound() 오버라이드
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
