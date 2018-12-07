package logic;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class CharacterCard extends HBox{
	private String name;
	private int damage;
	private int speed;
	private int hp,maxhp;
	private int cd;
	private String imgCharacter;
	private String imgCard;
	private ButtonLane one,two,three,four,five;
	private CoolDownBar cb;
	public CharacterCard(String name, int damage, int speed, int maxhp, int cd, String imgCharacter,String imgCard) {
		super(10);
		this.name = name;
		this.damage = damage;
		this.speed = speed;
		this.maxhp = maxhp;
		this.cd = cd;
		this.imgCard = imgCard;
		this.imgCharacter = imgCharacter;
		this.setAlignment(Pos.CENTER);
		StackPane sp = new StackPane();
		cb = new CoolDownBar(this);
		cb.setPrefWidth(50);
		Canvas canvas = new Canvas(80,120);
		sp.getChildren().addAll(canvas,cb);
		this.getChildren().add(sp);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image pic =  new Image(imgCard);
		gc.drawImage(pic, 0, 0);
		VBox allbutton = new VBox();
		
		
		one = new ButtonLane("Lane 1",1,name);
		one.setOnAction(e->{
			Character character = new Character(name,damage,speed,maxhp,cd,imgCharacter,imgCard);
			Lane.addAllcharacter(character);
			cb.setReady(false);
			cb.setVisible(true);
			one.setDisable(true);
			cb.update();
		});
		two = new ButtonLane("Lane 2",2,name);
		three = new ButtonLane("Lane 3",3,name);
		four = new ButtonLane("Lane 4",4,name);
		five = new ButtonLane("Lane 5",5,name);
		
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
	public ButtonLane getOne() {
		return one;
	}
	public void setOne(ButtonLane one) {
		this.one = one;
	}
	public ButtonLane getTwo() {
		return two;
	}
	public void setTwo(ButtonLane two) {
		this.two = two;
	}
	public ButtonLane getThree() {
		return three;
	}
	public void setThree(ButtonLane three) {
		this.three = three;
	}
	public ButtonLane getFour() {
		return four;
	}
	public void setFour(ButtonLane four) {
		this.four = four;
	}
	public ButtonLane getFive() {
		return five;
	}
	public void setFive(ButtonLane five) {
		this.five = five;
	}
	
	
	
}