package logic;

import Drawing.Drawable;
import Drawing.Eraseable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ProgressBar;

public class HPBar extends ProgressBar {

	public HPBar() {
		super(1);
		this.setPrefWidth(100);
	}
	
}
