package test.inheri;

public class Cat extends Animal {
	
	public String name;
	public String breed;
	
	public Cat(String name, String breed) {	// 생성자 정의하기
		super("고양이");
		this.name = name;
		this.breed = breed;
	}
	
	public String toString() {
		return super.toString() + " 이름은 " + name + " 품종은 " + breed;
	}
	
	// sound() 오버라이드
	@Override
	public void sound() {
		System.out.println("야옹");
	}
}
