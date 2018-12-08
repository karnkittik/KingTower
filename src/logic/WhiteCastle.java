package logic;

import Drawing.Drawable;
import Drawing.Eraseable;

public class WhiteCastle extends Castle implements Drawable,Eraseable{

	public WhiteCastle(int x, int y, int width, int height) {
		super(x, y, width, height, 1000, 10, "file:res/White.png");
	}

}
