package logic;

import javafx.scene.control.Button;

public class ButtonLane extends Button {
	private String name;
	private boolean ready;
	private int lane;
	private String character;
	public ButtonLane(String name,int lane,String character) {
		super(name);
		this.setPrefSize(60	, 20);
		setName(name);
		setLane(lane);
		setReady(true);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isReady() {
		return ready;
	}
	public void setReady(boolean ready) {
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

}
