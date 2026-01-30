package test.utilex;

public class Player implements Comparable<Player> {

	private String id;
	private String pw;
	private String name;
	private int win;
	private int lose;
	private int draw;
	private double rate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public double getRate() {
		int total = win + lose + draw;
		return (double) win / total;
		// return win / win + lose + draw;
	}

	@Override
	public int compareTo (Player o) {
		if(o.getRate() < getRate()) return 1;
		else if(o.getRate() > getRate()) return -1;
		else return 0;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.getRate());
	}
}