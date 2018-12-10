package logic;

import Drawing.Drawable;
import Drawing.Eraseable;
import sharedObject.RenderableHolder;

public class WhiteCastle extends Castle implements Drawable,Eraseable{

	public WhiteCastle(int x, int y, int width, int height,String name) {
		super(x, y, width, height, 1000, RenderableHolder.getWhiteCastle());
		setName(name);
	}

}
