package logic;

import java.util.ArrayList;
import java.util.List;

import application.CharacterPane;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class GameLogic {
	//private static List<Entity> gameObjectContainer;
	
	private static Castle c1 = new WhiteCastle(54, 210, 110, 250);	
	private static Castle c2 = new BlackCastle(150, 160, 110, 250);
	private static Castle c3 = new WhiteCastle(250, 260, 110, 250);
	private static Castle c4 = new BlackCastle(345, 160, 110, 250);
	private static Castle c5 = new WhiteCastle(432, 210, 110, 250);
	private static Lane l1 = new Lane(80, 460, 60, 200, Color.BURLYWOOD);		
	private static Lane l2 = new Lane(180, 410, 60, 250, Color.BURLYWOOD);
	private static Lane l3 = new Lane(275, 510, 60, 150, Color.BURLYWOOD);		
	private static Lane l4 = new Lane(370, 410, 60, 250, Color.BURLYWOOD);
	private static Lane l5 = new Lane(450, 460, 60, 200, Color.BURLYWOOD);
	private static CharacterPane cp = new CharacterPane();
	//private Character bomb1,bomb2,bomb3,bomb4,bomb5,bomb6,bomb7,bomb1,bomb1,bomb1,bomb1,bomb1,bomb1,bomb1,bomb1,bomb1,;
	
	public static Castle getC1() {
		return c1;
	}

	public static void setC1(Castle c1) {
		GameLogic.c1 = c1;
	}

	public static Castle getC2() {
		return c2;
	}

	public static void setC2(Castle c2) {
		GameLogic.c2 = c2;
	}

	public static Castle getC3() {
		return c3;
	}

	public static void setC3(Castle c3) {
		GameLogic.c3 = c3;
	}

	public static Castle getC4() {
		return c4;
	}

	public static void setC4(Castle c4) {
		GameLogic.c4 = c4;
	}

	public static Castle getC5() {
		return c5;
	}

	public static void setC5(Castle c5) {
		GameLogic.c5 = c5;
	}

	public static Lane getL1() {
		return l1;
	}

	public static void setL1(Lane l1) {
		GameLogic.l1 = l1;
	}

	public static Lane getL2() {
		return l2;
	}

	public static void setL2(Lane l2) {
		GameLogic.l2 = l2;
	}

	public static Lane getL3() {
		return l3;
	}

	public static void setL3(Lane l3) {
		GameLogic.l3 = l3;
	}

	public static Lane getL4() {
		return l4;
	}

	public static void setL4(Lane l4) {
		GameLogic.l4 = l4;
	}

	public static Lane getL5() {
		return l5;
	}

	public static void setL5(Lane l5) {
		GameLogic.l5 = l5;
	}

	public GameLogic(){
		//gameObjectContainer = new ArrayList<Entity>();
	
		//Gamepane field = new Field();
		//RenderableHolder.getInstance().add(field);
		
		for(ButtonLane btn:CharacterCard.getAll()) {
			btn.setDisable(true);
		}
		
		addNewObject(c1);addNewObject(c2);addNewObject(c3);addNewObject(c4);addNewObject(c5);
		addNewObject(l1);addNewObject(l2);addNewObject(l3);addNewObject(l4);addNewObject(l5);
		//addNewObject(bomb);
	}
	
	public static void addNewObject(Entity entity){
		//gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public void logicUpdate(){
		c1.update();c2.update();c3.update();c4.update();c5.update();
		for(IRenderable en : RenderableHolder.getInstance().getEntities()) {
			if(!(en instanceof Character)) continue;
			Character bomb = (Character) en;
			if(!bomb.isDestroyed() && bomb.getTarget().collideWith(bomb)){
				bomb.crash(bomb.getTarget());
			}
		}
		
	}

	public static CharacterPane getCp() {
		return cp;
	}

	public static void setCp(CharacterPane cp) {
		GameLogic.cp = cp;
	}
}
