package logic;

public class Character {
	private String name;
	private int damage;
	private int speed;
	private int hp,maxhp;
	private int cd;
	private String imgCharacter;
	private String imgCard;
	public Character(String name, int damage, int speed,int maxhp, int cd, String imgCharacter,String imgCard) {
		super();
		this.name = name;
		this.damage = damage;
		this.speed = speed;
		this.hp = maxhp;
		this.maxhp = maxhp;
		this.cd = cd;
		this.imgCharacter = imgCharacter;
		this.imgCard = imgCard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
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
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	public String getImgCharacter() {
		return imgCharacter;
	}
	public void setImgCharacter(String imgCharacter) {
		this.imgCharacter = imgCharacter;
	}
	public String getImgCard() {
		return imgCard;
	}
	public void setImgCard(String imgCard) {
		this.imgCard = imgCard;
	}
	
	
}
