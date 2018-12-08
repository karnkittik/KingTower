package application;

import Drawing.Drawable;
import Drawing.Eraseable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ProgressBar;
import logic.Castle;

public class HPBar extends ProgressBar {

	public HPBar() {
		super(1);
		this.setPrefWidth(100);
	}
	
}
