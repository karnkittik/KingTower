package logic;

import Drawing.Drawable;
import Drawing.Eraseable;

public class BlackCastle extends Castle implements Drawable,Eraseable{

	public BlackCastle(int x, int y, int width, int height) {
		super(x, y, width, height, 1500, 12, "file:res/Black.png");

	}
	
}
