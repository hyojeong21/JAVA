package test.inheri;

public class Duck extends Animal implements Fly{
	
	public String name;
	public String breed;
	
	public Duck(String name, String breed) {	// 생성자 정의하기
		super("오리");
		this.name = name;
		this.breed = breed;
	}
	
	public String toString() {
		return super.toString() + " 이름은 " + name + " 품종은 " + breed;
	}
	
	// sound() 오버라이드
	@Override
	public void sound() {
		System.out.println("꽥꽥");
	}
	
	// 오리가 알을 낳는 기능을 추가합니다
	public void layEggs() {
		System.out.println("오리가 알을 낳는다");
	}
	
	@Override
	public void fly() {
		System.out.println("오리가 " + BirdVelocity.DUCK_VELOCITY + " 속도로 날다");
	}
	
}
