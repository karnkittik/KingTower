package Drawing;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

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
	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			// System.out.println(entity.getZ());
			if (entity.isVisible() && !entity.isDestroyed()) {
				entity.draw(gc);
			}
		}

	}
	
}
