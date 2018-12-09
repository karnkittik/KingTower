package logic;


public abstract class CollidableEntity extends Entity{
protected int radius;
	
	protected boolean collideWith(CollidableEntity other){
		//return Math.hypot(this.x-other.x, this.y-other.y) <= this.radius+other.radius;
		if(this.width == 110) //this is Castle
		{
			return other.y + other.height <= this.y+this.height;
			
		}
		else //this is Bomb
		{
			return other.y + other.height >= this.y+this.height;
		}
	}

}

