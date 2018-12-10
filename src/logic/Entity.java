package logic;

import sharedObject.IRenderable;

public abstract class Entity implements IRenderable{

	protected double x,y;
	protected double width,height;
	protected boolean visible,destroyed;
	protected boolean draw;
	protected Entity() {
		visible = true;
		destroyed = false;
	}
	
	@Override
	public boolean isDestroyed(){
		return destroyed;
	}
	
	@Override
	public boolean isVisible(){
		return visible;
	}
	
	@Override
	public boolean isDraw() {
		return draw;
	}
	@Override
	public void setDraw(boolean draw) {
		this.draw = draw;
	}
	
}