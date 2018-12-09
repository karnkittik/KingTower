package sharedObject;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderable {
	public boolean isDraw();
	public void draw(GraphicsContext gc);
	public boolean isDestroyed();
	public boolean isVisible();
	public void setDraw(boolean draw);
}
