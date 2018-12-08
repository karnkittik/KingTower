package application;


import Drawing.GameScreen;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import logic.BlackCastle;
import logic.Castle;
import logic.WhiteCastle;

public class GamePane extends Pane{
	private static Canvas canvas = new Canvas(600,800);
	private static GraphicsContext gc = canvas.getGraphicsContext2D();
	public GamePane() {
		super();
		this.setPrefSize(600, 800);
		GameScreen game = new GameScreen();
		this.getChildren().add(game);	
		this.getChildren().add(canvas);
		CharacterPane cp = new CharacterPane();
		this.getChildren().add(cp);
		cp.setLayoutX(10);cp.setLayoutY(667);
		
		startGameloop();
	}

	public static void startGameloop() {
		Castle c1 = new WhiteCastle(54, 210, 110, 250);
		Castle c2 = new WhiteCastle(250, 260, 110, 250);
		Castle c3 = new WhiteCastle(432, 210, 110, 250);
		Castle c4 = new BlackCastle(150, 160, 110, 250);
		Castle c5 = new BlackCastle(345, 160, 110, 250);
		
		
	}

	public static void updateUI() {
		
	}

	
	
}
