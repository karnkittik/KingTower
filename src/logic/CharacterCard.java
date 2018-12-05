package logic;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CharacterCard extends HBox{
	private String name;
	private int damage;
	private int speed;
	private int hp,maxhp;
	private int cd;
	private String img;
	private static ButtonLane one,two,three,four,five;
	public CharacterCard(String name, int damage, int speed, int maxhp, int cd, String img) {
		super(10);
		this.name = name;
		this.damage = damage;
		this.speed = speed;
		this.maxhp = maxhp;
		this.cd = cd;
		this.img = img;
		this.setAlignment(Pos.CENTER);
		Canvas canvas = new Canvas(80,120);
		this.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image pic =  new Image(img);
		gc.drawImage(pic, 0, 0);
		VBox allbutton = new VBox();
		one = new ButtonLane("Lane 1");
		two = new ButtonLane("Lane 2");
		three = new ButtonLane("Lane 3");
		four = new ButtonLane("Lane 4");
		five = new ButtonLane("Lane 5");
		allbutton.getChildren().addAll(one,two,three,four,five);
		this.getChildren().add(allbutton);
		
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
