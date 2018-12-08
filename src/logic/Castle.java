package logic;

import java.util.ArrayList;
import java.util.List;

import Drawing.Drawable;
import Drawing.Eraseable;
import application.HPBar;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Castle implements Drawable,Eraseable{
	private int hp;
	private int maxhp;
	private static int speed = 105;
	private int damage;
	private int activePoint;
	private int x,y;
	private int width,height;
	private HPBar hpbar;
	private final static int LIMIT = 5000; 
	private String img;
	private static List<Castle> allCastle = new ArrayList<Castle>();
	public Castle(int x,int y,int width,int height,int maxhp, int damage,String img) {
		setDamage(damage);
		setHp(maxhp);
		setMaxhp(maxhp);
		setWidth(width);
		setHeight(height);
		setImg(img);
		setX(x);
		setY(y);
		hpbar = new HPBar();
		hpbar.setLayoutX(x+5);
		hpbar.setLayoutY(y+140);
		allCastle.add(this);
	}

	public HPBar getHpbar() {
		return hpbar;
	}

	public void setHpbar(HPBar hpbar) {
		this.hpbar = hpbar;
	}
	
//	public void drawHPBar(Pane pane) {
//		hpbar.setLayoutX(x+5);
//		hpbar.setLayoutY(y+140);
//	}

	@Override
	public void draw(GraphicsContext gc) {
		Image pic = new Image(img);
		gc.drawImage(pic, x, y);	
	}

	@Override
	public void erase(GraphicsContext gc) {
		gc.clearRect(x, y, width, height);
		
	}
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public static List<Castle> getAllCastle() {
		return allCastle;
	}

	public static void setAllCastle(List<Castle> allCastle) {
		Castle.allCastle = allCastle;
	}


}
