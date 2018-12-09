package application;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class HPPane extends Pane{
	public HPPane() {
		super.setPrefSize(600, 800);
		Pane bar = new Pane();
		bar.setPrefSize(600, 140);
		///////////////
		Canvas canvas = new Canvas(600, 800);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		bar.getChildren().add(canvas);
		String img = "file:res/blue.png";
		Image pic = new Image(img);
		gc.drawImage(pic, 0, 660);
		///////////////////
		
		bar.setLayoutX(0);bar.setLayoutY(200);
		getChildren().add(bar);
	}

	public void HPUpdate() {
		System.out.println("hp");
		
	}
}
