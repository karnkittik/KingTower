package Drawing;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class GameScreen extends Canvas{
	public GameScreen() {
		super(600,800);
		GraphicsContext gc = getGraphicsContext2D();
		String img = "file:res/1.png";
		draw(gc,img);
	}

	private void draw(GraphicsContext gc, String img) {
		Image pic = new Image(img);
		System.out.println(img);
		gc.drawImage(pic, 0, 0);
		
	}
	
}
