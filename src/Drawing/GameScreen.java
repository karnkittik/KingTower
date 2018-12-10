package Drawing;

import application.GamePane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class GameScreen extends Canvas{
	public GameScreen() {
		super(600,800);
		GraphicsContext gc = getGraphicsContext2D();
		Image img = RenderableHolder.getGame();
		draw(gc,img);
	}

	private void draw(GraphicsContext gc, Image img) {
		gc.drawImage(img, 0, 0);
		
	}
	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			if (entity.isVisible() && !entity.isDestroyed()) {
				entity.draw(gc);
			}
		}
		if(GameLogic.getC1().isDead()&&GameLogic.getC2().isDead()&&GameLogic.getC3().isDead()&&
				GameLogic.getC4().isDead()&&GameLogic.getC5().isDead()) {
			GamePane.setWin(true);
		}

	}
}