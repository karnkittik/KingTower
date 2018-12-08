package logic;

import java.util.ArrayList;
import java.util.List;

import Drawing.Eraseable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Lane implements Drawable, Eraseable {
	private static List<Character> allcharacter = new ArrayList<Character>();
	private int x,y,width,height;
	private String color;
	public Lane(int x, int y, int width, int height, String color) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	@Override
	public void draw(GraphicsContext gc, String img, int x, int y) {
		Image pic = new Image(img);
		gc.drawImage(pic, x, y);	
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
