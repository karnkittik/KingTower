package application;


import Drawing.GameScreen;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class GamePane extends Pane{
	private Button one,two,three,four,five,castle;
	public GamePane() {
		super();
		this.setPrefSize(600, 800);
		GameScreen game = new GameScreen();
		this.getChildren().add(game);	
		
	}
	public Button getOne() {
		return one;
	}
	public Button getTwo() {
		return two;
	}
	public Button getThree() {
		return three;
	}
	public Button getFour() {
		return four;
	}
	public Button getFive() {
		return five;
	}
	public Button getCastle() {
		return castle;
	}
	
}
