package test.inheri;

public class Eagle extends Animal implements BirdInter{
	
	int speed = EAGLE_VELOCITY;
	
	public Eagle(String type) {
		super("독수리");
	}

	@Override
	public void fly() {
		
	}

	@Override
	public void sound() {
		
	}
	
	public int currentSpeed() {
		return BirdInter.getSpeed();
	}
}