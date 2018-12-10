package Drawing;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.RenderableHolder;

public class HomeScreen extends Canvas{
	
	private Image img;
	
	public HomeScreen() {
		super(600,800);
		GraphicsContext gc = this.getGraphicsContext2D();
		img = RenderableHolder.getMain();
		draw(gc);
		System.out.println("homescreen");
	}

	private void draw(GraphicsContext gc) {
		gc.drawImage(img, 0, 0);
	}
}
