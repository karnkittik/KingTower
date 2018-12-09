package logic;

import Drawing.Drawable;
import Drawing.Eraseable;
import sharedObject.RenderableHolder;

public class BlackCastle extends Castle implements Drawable,Eraseable{

	public BlackCastle(int x, int y, int width, int height) {
		super(x, y, width, height, 1500, 12, RenderableHolder.getBlackCastle());

	}
	
}
