package logic;

import javafx.scene.control.Button;

public class ButtonLane extends Button {
	private String name;
	private boolean ready;
	public ButtonLane(String name) {
		super(name);
		this.setPrefSize(50	, 20);
		setName(name);
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
	
}
