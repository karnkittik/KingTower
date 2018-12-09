package logic;

import java.util.ArrayList;
import java.util.List;

import Drawing.Drawable;
import Drawing.Eraseable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Lane extends Entity implements Drawable, Eraseable {
	private static List<Character> allcharacter = new ArrayList<Character>();
	private static List<Lane> allLane = new ArrayList<Lane>();
	private int x,y,width,height;
	private Color color;
	public Lane(int x, int y, int width, int height, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		allLane.add(this);
	}
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(color);;
		gc.fillRect(x, y, width, height);
	}

	@Override
	public void erase(GraphicsContext gc) {
		gc.clearRect(x, y, width, height);
		
	}
	public static List<Character> getAllcharacter() {
		return allcharacter;
	}
	public static void addAllcharacter(Character character) {
		Lane.allcharacter.add(character);
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public static List<Lane> getAllLane() {
		return allLane;
	}
	public static void setAllLane(List<Lane> allLane) {
		Lane.allLane = allLane;
	}
	@Override
	public void setDestroyed(boolean destroy) {
		this.destroyed = destroy;
		
	}
	
	
	
}
