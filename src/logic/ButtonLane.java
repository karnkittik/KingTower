package logic;

import javafx.scene.control.Button;

public class ButtonLane extends Button {
	
	private String name;
	private String character;
	private int ready;
	private int lane;
	private boolean dead;
	
	public ButtonLane(String name,int lane,String character) {
		super(name);
		this.setPrefSize(80	, 20);
		setName(name);
		setLane(lane);
		setReady(0);
		setDisable(true);
		setDead(false);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int isReady() {
		return ready;
	}
	
	public void setReady(int ready) {
		this.ready = ready;
	}
	
	public int getLane() {
		return lane;
	}
	
	public void setLane(int lane) {
		this.lane = lane;
	}
	
	public String getCharacter() {
		return character;
	}
	
	public void setCharacter(String character) {
		this.character = character;
	}
	
	public boolean isDead() {
		return dead;
	}
	
	public void setDead(boolean dead) {
		this.dead = dead;
	}

}
