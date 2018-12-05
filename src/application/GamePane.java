package application;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class GamePane extends Pane{
	private final static String img = "file:res/wallpaper3.png";
	public GamePane() {
		super();
		super.setPrefSize(600, 800);
		Canvas canvas = new Canvas(600,800);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawImage(gc, img);
		super.getChildren().add(canvas);	
		}
	private void drawImage(GraphicsContext gc,String img) {
		System.out.println(img);
		Image pic = new Image(img);
		gc.drawImage(pic, 0, 0);
		
	}
	
	
}
