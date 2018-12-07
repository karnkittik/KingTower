package logic;

import java.util.ArrayList;
import java.util.List;

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
	private static List<ButtonLane> allbtn1 = new ArrayList<ButtonLane>();
	private static List<ButtonLane> allbtn2 = new ArrayList<ButtonLane>();
	private static List<ButtonLane> allbtn3 = new ArrayList<ButtonLane>();
	private static List<ButtonLane> allbtn4 = new ArrayList<ButtonLane>();
	private static List<ButtonLane> allbtn5 = new ArrayList<ButtonLane>();
	private static List<ButtonLane> all = new ArrayList<ButtonLane>();
	private String name;
	private int damage;
	private int speed;
	private int hp,maxhp;
	private int cd;
	private String imgCharacter;
	private String imgCard;
	private static boolean bone,btwo,bthree,bfour,bfive;
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
		
		one = new ButtonLane("Lane 1",1,name);allbtn1.add(one);all.add(one);
		one.setOnAction(e->{
			Character character = new Character(name,damage,speed,maxhp,cd,imgCharacter,imgCard);
			Lane.addAllcharacter(character);
			cb.setReady(false);
			cb.setVisible(true);
			for(ButtonLane a:allbtn1) {a.setDisable(true); a.setReady(a.isReady()+1);}
			one.setDisable(true);two.setDisable(true);three.setDisable(true);four.setDisable(true);five.setDisable(true);
			one.setReady(one.isReady()+1);two.setReady(two.isReady()+1);three.setReady(three.isReady()+1);four.setReady(four.isReady()+1);five.setReady(five.isReady()+1);
			cb.update(one,two,three,four,five,allbtn1,all,cd);
		});
		two = new ButtonLane("Lane 2",2,name);allbtn2.add(two);all.add(two);
		two.setOnAction(e->{
			Character character = new Character(name,damage,speed,maxhp,cd,imgCharacter,imgCard);
			Lane.addAllcharacter(character);
			cb.setReady(false);
			cb.setVisible(true);
			for(ButtonLane a:allbtn2) {a.setDisable(true); a.setReady(a.isReady()+1);}
			one.setDisable(true);two.setDisable(true);three.setDisable(true);four.setDisable(true);five.setDisable(true);
			one.setReady(one.isReady()+1);two.setReady(two.isReady()+1);three.setReady(three.isReady()+1);four.setReady(four.isReady()+1);five.setReady(five.isReady()+1);
			cb.update(one,two,three,four,five,allbtn2,all,cd);
		});
		three = new ButtonLane("Lane 3",3,name);allbtn3.add(three);all.add(three);
		three.setOnAction(e->{
			Character character = new Character(name,damage,speed,maxhp,cd,imgCharacter,imgCard);
			Lane.addAllcharacter(character);
			cb.setReady(false);
			cb.setVisible(true);
			for(ButtonLane a:allbtn3) {a.setDisable(true); a.setReady(a.isReady()+1);}
			one.setDisable(true);two.setDisable(true);three.setDisable(true);four.setDisable(true);five.setDisable(true);
			one.setReady(one.isReady()+1);two.setReady(two.isReady()+1);three.setReady(three.isReady()+1);four.setReady(four.isReady()+1);five.setReady(five.isReady()+1);
			cb.update(one,two,three,four,five,allbtn3,all,cd);
		});
		four = new ButtonLane("Lane 4",4,name);allbtn4.add(four);all.add(four);
		four.setOnAction(e->{
			Character character = new Character(name,damage,speed,maxhp,cd,imgCharacter,imgCard);
			Lane.addAllcharacter(character);
			cb.setReady(false);
			cb.setVisible(true);
			for(ButtonLane a:allbtn4) {a.setDisable(true); a.setReady(a.isReady()+1);}
			one.setDisable(true);two.setDisable(true);three.setDisable(true);four.setDisable(true);five.setDisable(true);
			one.setReady(one.isReady()+1);two.setReady(two.isReady()+1);three.setReady(three.isReady()+1);four.setReady(four.isReady()+1);five.setReady(five.isReady()+1);
			cb.update(one,two,three,four,five,allbtn4,all,cd);
		});
		five = new ButtonLane("Lane 5",5,name);allbtn5.add(five);all.add(five);
		five.setOnAction(e->{
			Character character = new Character(name,damage,speed,maxhp,cd,imgCharacter,imgCard);
			Lane.addAllcharacter(character);
			cb.setReady(false);
			cb.setVisible(true);
			for(ButtonLane a:allbtn5) {a.setDisable(true); a.setReady(a.isReady()+1);}
			one.setDisable(true);two.setDisable(true);three.setDisable(true);four.setDisable(true);five.setDisable(true);
			one.setReady(one.isReady()+1);two.setReady(two.isReady()+1);three.setReady(three.isReady()+1);four.setReady(four.isReady()+1);five.setReady(five.isReady()+1);
			cb.update(one,two,three,four,five,allbtn5,all,cd);
		});
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