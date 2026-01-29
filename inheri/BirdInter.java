package test.inheri;

public interface BirdInter extends Fly, BirdVelocity{ // 인터페이스라 다중 상속 ㄱㄴ
	
	default void birdFly() {	// default 선언시 메서드 정의부를 가질 수 있음
		System.out.println("독수리가 " + EAGLE_VELOCITY + " 속도로 날고 있음");
	}
	
	static int getSpeed() {
		return EAGLE_VELOCITY;
	}
}
