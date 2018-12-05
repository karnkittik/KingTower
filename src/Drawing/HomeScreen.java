package Drawing;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class HomeScreen extends Canvas{
	
	public HomeScreen() {
		super(600,800);
		GraphicsContext gc = this.getGraphicsContext2D();
		String img = "file:res/mainmenu.jpeg";
		draw(gc,img);
		
	}

	private void draw(GraphicsContext gc,String img) {
		System.out.println(img);
		Image pic = new Image(img);
		gc.drawImage(pic, 0, 0);
		
	}
}
