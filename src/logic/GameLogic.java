package logic;

import java.util.ArrayList;
import java.util.List;

import sharedObject.RenderableHolder;

public class GameLogic {
	private static List<Entity> gameObjectContainer;
	
	private Castle c1,c2,c3,c4,c5;
	//private Character bomb1,bomb2,bomb3,bomb4,bomb5,bomb6,bomb7,bomb1,bomb1,bomb1,bomb1,bomb1,bomb1,bomb1,bomb1,bomb1,;
	
	public GameLogic(){
		gameObjectContainer = new ArrayList<Entity>();
	
		//Gamepane field = new Field();
		//RenderableHolder.getInstance().add(field);
		c1 = new WhiteCastle(54, 210, 110, 250);	
		c2 = new BlackCastle(150, 160, 110, 250);
		c3 = new WhiteCastle(250, 260, 110, 250);
		c4 = new BlackCastle(345, 160, 110, 250);
		c5 = new WhiteCastle(432, 210, 110, 250);
		
		addNewObject(c1);addNewObject(c1);addNewObject(c1);addNewObject(c1);addNewObject(c1);
		//addNewObject(bomb);
	}
	
	public static void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public static void logicUpdate(){
		c1.update();c2.update();c3.update();c4.update();c5.update();
		if(!bomb.isDestroyed() && c1.collideWith(bomb)){
			bomb.onCollision(c1);
		}
		
	}
}
