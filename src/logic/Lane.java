package logic;

import java.util.ArrayList;
import java.util.List;

public class Lane {
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
