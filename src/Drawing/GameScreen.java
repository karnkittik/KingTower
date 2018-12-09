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
	private static final GameScreen instance = new GameScreen();
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
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			// System.out.println(entity.getZ());
			if (entity.isVisible() && !entity.isDestroyed()) {
				entity.draw(gc);
			}
		}
		if(GameLogic.getC1().isDead()&&GameLogic.getC2().isDead()&&GameLogic.getC3().isDead()&&
				GameLogic.getC4().isDead()&&GameLogic.getC5().isDead()) {
//			drawFire(gc);  //bugs
			GamePane.setWin(true);
		}

	}

//	private void drawFire(GraphicsContext gc) {
//		String img = "file:res/Superfire.png";
//		Image pic = new Image(img);
//		gc.drawImage(pic, 187, 0);
//		
//	}

	public static GameScreen getInstance() {
		return instance;
	}
	
}
