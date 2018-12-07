package application;


import Drawing.GameScreen;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class GamePane extends Pane{
	public GamePane() {
		super();
		this.setPrefSize(600, 800);
		GameScreen game = new GameScreen();
		this.getChildren().add(game);	
		
		CharacterPane cp = new CharacterPane();
		this.getChildren().add(cp);
		cp.setLayoutX(10);cp.setLayoutY(667);
	}

	public static void updateUI() {
		
	}

	
	
}
