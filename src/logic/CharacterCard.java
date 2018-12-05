package logic;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

public class CharacterCard extends HBox{
	private String name;
	private int damage;
	private int speed;
	private int hp,maxhp;
	private int cd;
	private String img;
	public CharacterCard(String name, int damage, int speed, int maxhp, int cd, String img) {
		super();
		this.name = name;
		this.damage = damage;
		this.speed = speed;
		this.maxhp = maxhp;
		this.cd = cd;
		this.img = img;
		Canvas canvas = new Canvas(80,120);
		this.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image pic =  new Image(img);
		gc.drawImage(pic, 0, 0);
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	

	
	

}
