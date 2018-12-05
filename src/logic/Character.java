package logic;

public class Character {

	private String name;
	private int speed;
	private int power;
	private String imagePath;
	private int hp;
	private int maxHp;
	private int activePoint;
	

	private final static int LIMIT = 10000; 

	public Character(String name, int maxHp, int speed, int power, String imagePath) {
		super();
		this.name = name;
		this.speed = speed;
		this.power = power;
		this.imagePath = imagePath;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.activePoint = 0;
	}
	
	public boolean attack(Character target) {
		if(target.getHp() > 0) {
			target.setHp(target.getHp() - this.getPower() < 0 ? 0 : target.getHp() - this.getPower());
			return true;
		}
		else
			return false;
	}
	
	public String getName() {
		return name;
	}

	public int getSpeed() {
		return speed;
	}

	public int getPower() {
		return power;
	}

	public String getImagePath() {
		return imagePath;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public int getActivePoint() {
		return activePoint;
	}
	
	public void setActivePoint(int activePoint) {
		this.activePoint = activePoint;
	}

	public static int getLimit() {
		return LIMIT;
	}

	public boolean isDead() {
		return this.hp <= 0;
	}
	
	public String printHp() {
		return String.format("%d/%d", this.hp, this.maxHp);
	}

	public boolean isReady() {
		return this.activePoint >= Character.getLimit();
	}
}
