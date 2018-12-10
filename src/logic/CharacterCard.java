package logic;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.LogicalHandler;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class CharacterCard extends HBox{
	private static List<ButtonLane> allbtn1 = new ArrayList<ButtonLane>();
	private static List<ButtonLane> allbtn2 = new ArrayList<ButtonLane>();
	private static List<ButtonLane> allbtn3 = new ArrayList<ButtonLane>();
	private static List<ButtonLane> allbtn4 = new ArrayList<ButtonLane>();
	private static List<ButtonLane> allbtn5 = new ArrayList<ButtonLane>();
	private static List<ButtonLane> all = new ArrayList<ButtonLane>();
	private String name;
	private int damage;
	private double speed;
	private int hp,maxhp;
	private int cd;
	private Image imgCharacter;
	private Image imgCard;
	private ButtonLane one,two,three,four,five;
	private CoolDownBar cb;
	private static List<Character> allCaharacter = new ArrayList<Character>();
	public CharacterCard(String name, int damage, double speed, int maxhp, int cd, Image imgCharacter,Image imgCard) {
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

		gc.drawImage(imgCard, 0, 0);
		VBox allbutton = new VBox();
		
		one = new ButtonLane("Lauriel",1,name);allbtn1.add(one);System.out.println("one");
		all.add(one);System.out.println("all");
		one.setOnAction(e->{
			Character character = new Character(70,660,200,name,damage,speed,maxhp,cd,imgCharacter,imgCard);
			character.setTarget(GameLogic.getC1());character.setOwner(one);
			RenderableHolder.getInstance().getEntities().add(character);
			cb.setReady(false);
			cb.setVisible(true);
			for(ButtonLane a:allbtn1) {a.setDisable(true); a.setReady(a.isReady()+1);}
			one.setDisable(true);two.setDisable(true);three.setDisable(true);four.setDisable(true);five.setDisable(true);
			one.setReady(one.isReady()+1);two.setReady(two.isReady()+1);three.setReady(three.isReady()+1);four.setReady(four.isReady()+1);five.setReady(five.isReady()+1);
			cb.update(one,two,three,four,five,allbtn1,all,cd,"one");

		});
		two = new ButtonLane("Moren",2,name);allbtn2.add(two);all.add(two);
		two.setOnAction(e->{
			Character character = new Character(170,660,250,name,damage,speed,maxhp,cd,imgCharacter,imgCard);
			character.setTarget(GameLogic.getC2());character.setOwner(two);
			RenderableHolder.getInstance().getEntities().add(character);
			cb.setReady(false);
			cb.setVisible(true);
			for(ButtonLane a:allbtn2) {a.setDisable(true); a.setReady(a.isReady()+1);}
			one.setDisable(true);two.setDisable(true);three.setDisable(true);four.setDisable(true);five.setDisable(true);
			one.setReady(one.isReady()+1);two.setReady(two.isReady()+1);three.setReady(three.isReady()+1);four.setReady(four.isReady()+1);five.setReady(five.isReady()+1);
			cb.update(one,two,three,four,five,allbtn2,all,cd,"two");
		});
		three = new ButtonLane("Yorn",3,name);allbtn3.add(three);all.add(three);
		three.setOnAction(e->{
			Character character = new Character(265,660,150,name,damage,speed,maxhp,cd,imgCharacter,imgCard);
			character.setTarget(GameLogic.getC3());character.setOwner(three);
			RenderableHolder.getInstance().getEntities().add(character);
			cb.setReady(false);
			cb.setVisible(true);
			for(ButtonLane a:allbtn3) {a.setDisable(true); a.setReady(a.isReady()+1);}
			one.setDisable(true);two.setDisable(true);three.setDisable(true);four.setDisable(true);five.setDisable(true);
			one.setReady(one.isReady()+1);two.setReady(two.isReady()+1);three.setReady(three.isReady()+1);four.setReady(four.isReady()+1);five.setReady(five.isReady()+1);
			cb.update(one,two,three,four,five,allbtn3,all,cd,"three");
		});
		four = new ButtonLane("Illumia",4,name);allbtn4.add(four);all.add(four);
		four.setOnAction(e->{
			Character character = new Character(360,660,250,name,damage,speed,maxhp,cd,imgCharacter,imgCard);
			character.setTarget(GameLogic.getC4());character.setOwner(four);
			RenderableHolder.getInstance().getEntities().add(character);
			cb.setReady(false);
			cb.setVisible(true);
			for(ButtonLane a:allbtn4) {a.setDisable(true); a.setReady(a.isReady()+1);}
			one.setDisable(true);two.setDisable(true);three.setDisable(true);four.setDisable(true);five.setDisable(true);
			one.setReady(one.isReady()+1);two.setReady(two.isReady()+1);three.setReady(three.isReady()+1);four.setReady(four.isReady()+1);five.setReady(five.isReady()+1);
			cb.update(one,two,three,four,five,allbtn4,all,cd,"four");
		});
		five = new ButtonLane("Sephera",5,name);allbtn5.add(five);all.add(five);
		five.setOnAction(e->{
			Character character = new Character(450,660,200,name,damage,speed,maxhp,cd,imgCharacter,imgCard);
			character.setTarget(GameLogic.getC5());character.setOwner(five);
			RenderableHolder.getInstance().getEntities().add(character);
			cb.setReady(false);
			cb.setVisible(true);
			for(ButtonLane a:allbtn5) {a.setDisable(true); a.setReady(a.isReady()+1);}
			one.setDisable(true);two.setDisable(true);three.setDisable(true);four.setDisable(true);five.setDisable(true);
			one.setReady(one.isReady()+1);two.setReady(two.isReady()+1);three.setReady(three.isReady()+1);four.setReady(four.isReady()+1);five.setReady(five.isReady()+1);
			cb.update(one,two,three,four,five,allbtn5,all,cd,"five");
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
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
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
	public Image getImgCharacter() {
		return imgCharacter;
	}
	public void setImgCharacter(Image imgCharacter) {
		this.imgCharacter = imgCharacter;
	}
	public Image getImgCard() {
		return imgCard;
	}
	public void setImgCard(Image imgCard) {
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
	public static List<ButtonLane> getAll() {
		return all;
	}
	public static void setAll(List<ButtonLane> all) {
		CharacterCard.all = all;
	}
	public static List<Character> getAllCaharacter() {
		return allCaharacter;
	}
	public static void setAllCaharacter(List<Character> allCaharacter) {
		CharacterCard.allCaharacter = allCaharacter;
	}
	public static List<ButtonLane> getAllbtn1() {
		return allbtn1;
	}
	public static void setAllbtn1(List<ButtonLane> allbtn1) {
		CharacterCard.allbtn1 = allbtn1;
	}
	public static List<ButtonLane> getAllbtn2() {
		return allbtn2;
	}
	public static void setAllbtn2(List<ButtonLane> allbtn2) {
		CharacterCard.allbtn2 = allbtn2;
	}
	public static List<ButtonLane> getAllbtn3() {
		return allbtn3;
	}
	public static void setAllbtn3(List<ButtonLane> allbtn3) {
		CharacterCard.allbtn3 = allbtn3;
	}
	public static List<ButtonLane> getAllbtn4() {
		return allbtn4;
	}
	public static void setAllbtn4(List<ButtonLane> allbtn4) {
		CharacterCard.allbtn4 = allbtn4;
	}
	public static List<ButtonLane> getAllbtn5() {
		return allbtn5;
	}
	public static void setAllbtn5(List<ButtonLane> allbtn5) {
		CharacterCard.allbtn5 = allbtn5;
	}
	public CoolDownBar getCb() {
		return cb;
	}
	public void setCb(CoolDownBar cb) {
		this.cb = cb;
	}
	
	
	
}