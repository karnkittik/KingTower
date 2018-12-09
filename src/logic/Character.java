package logic;

import Drawing.Drawable;
import Drawing.Eraseable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.RenderableHolder;

public class Character extends Entity implements Drawable,Eraseable{
	//private Castle target;

	private String name;
	private int damage;
	private int speed;
	private int hp,maxhp;
	private int cd;
	private double x,y,length;
	private Image imgCharacter;
	private Image imgCard;
	private boolean terminate;
	private Castle target;
	public Character(double x,double y,double length,String name, int damage, int speed,int maxhp, 
		int cd, Image imgCharacter,Image imgCard) {
		this.x = x;
		this.y = y;
		this.length = length;
		this.name = name;
		this.damage = damage;
		this.speed = speed;
		this.hp = maxhp;
		this.maxhp = maxhp;
		this.cd = cd;
		this.imgCharacter = imgCharacter;
		this.imgCard = imgCard;
		this.terminate = false;
		setDestroyed(false);
	}
	public boolean collideWith(Castle target) {

		return this.y - target.getY() <= 165;

	}
	public boolean isTerminate() {
		return terminate;
	}

	public void setTerminate(boolean terminate) {
		this.terminate = terminate;
	}

	@Override
	public void erase(GraphicsContext gc) {
		gc.clearRect(x, y, 80, 120);
		
	}
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(imgCharacter, x, y);
		setY(getY()-1);	
	}
	
	public void crash(Castle target) {
		target.setHp(Math.max(target.getHp()-damage, 0));

		if(target instanceof WhiteCastle) {
			target.setImg(RenderableHolder.getWhiteCastlefire());
		}
		if(target instanceof BlackCastle) {
			target.setImg(RenderableHolder.getBlackCastlefire());
		}
		RenderableHolder.getExplosionSound().play();
		setDestroyed(true);
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;

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

	public Castle getTarget() {
		return target;
	}

	public void setTarget(Castle target) {
		this.target = target;
	}

	@Override
	public void setDestroyed(boolean destroy) {
		this.destroyed = destroy;
		
	}
	
	
}
