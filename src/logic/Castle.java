package logic;

public class Castle {
	private int hp;
	private int maxhp;
	private static int speed = 105;
	private int damage;
	private int activePoint;
	private int x,y;
	private int width,height;
	private final static int LIMIT = 10000; 
	
	public Castle(int x,int y,int width,int height,int maxhp, int damage) {
		setDamage(damage);
		setHp(maxhp);
		setMaxhp(maxhp);
		setWidth(width);
		setHeight(height);
		setX(x);
		setY(y);
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxhp() {
		return maxhp;
	}

	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}

	public static int getSpeed() {
		return speed;
	}

	public static void setSpeed(int sp) {
		speed = sp;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getActivePoint() {
		return activePoint;
	}

	public void setActivePoint(int activePoint) {
		this.activePoint = activePoint;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public static int getLimit() {
		return LIMIT;
	}
	
}
