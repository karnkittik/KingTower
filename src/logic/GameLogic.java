package logic;

import java.util.ArrayList;
import java.util.List;

import application.CharacterPane;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class GameLogic {
	//private static List<Entity> gameObjectContainer;
	private static int gameMode = 1;
	private static Castle c1 = new WhiteCastle(60, 210, 110, 250);	
	private static Castle c2 = new BlackCastle(160, 160, 110, 250);
	private static Castle c3 = new WhiteCastle(255, 260, 110, 250);
	private static Castle c4 = new BlackCastle(350, 160, 110, 250);
	private static Castle c5 = new WhiteCastle(439, 210, 110, 250);
	private static Lane l1 = new Lane(80-10, 460, 60+20, 200, Color.BURLYWOOD);		
	private static Lane l2 = new Lane(180-10, 410, 60+20, 250, Color.BURLYWOOD);
	private static Lane l3 = new Lane(275-10, 510, 60+20, 150, Color.BURLYWOOD);		
	private static Lane l4 = new Lane(370-10, 410, 60+20, 250, Color.BURLYWOOD);
	private static Lane l5 = new Lane(460-10, 460, 60+20, 200, Color.BURLYWOOD);
	private static CharacterPane cp = new CharacterPane();
	//private Character bomb1,bomb2,bomb3,bomb4,bomb5,bomb6,bomb7,bomb1,bomb1,bomb1,bomb1,bomb1,bomb1,bomb1,bomb1,bomb1,;
	
	public static Castle getC1() {
		return c1;
	}

	public static int getGameMode() {
		return gameMode;
	}

	public static void setGameMode(int gameMode) {
		GameLogic.gameMode = gameMode;
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
		//int i;
		//c1.update();c2.update();c3.update();c4.update();c5.update();
		for(IRenderable en : RenderableHolder.getInstance().getEntities()) {
//			i =1;
//			if(en instanceof Character) System.out.println(i++);
			if(en instanceof Character) {
				//!((Character)en).isDestroyed() && 
				if(!((Character)en).isDestroyed() && ((Character)en).collideWith(((Character)en).getTarget())){
					((Character)en).crash(((Character)en).getTarget());
				}
			}
			if(en instanceof WhiteCastle) {
				if(((Castle)en).getHp()==0) {
					//System.out.println("collapse");
					//System.out.println(numberCastle);
					((Castle)en).setDead(true);
					((Castle)en).setImg("file:res/whitedestroy.png");
				}
			}
			if(en instanceof BlackCastle) {
				if(((Castle)en).getHp()==0) {
					//System.out.println("collapse");
					//System.out.println(numberCastle);
					((Castle)en).setDead(true);
					((Castle)en).setImg("file:res/blackdestroy.png");
				}
			}
		}	
		if(GameLogic.getC1().isDead()) {
			for(ButtonLane one : CharacterCard.getAllbtn1()) 
			{
				one.setDisable(true);one.setVisible(false);
			}
		}
		if(GameLogic.getC2().isDead()) {
			for(ButtonLane two : CharacterCard.getAllbtn2()) 
			{
				two.setDisable(true);two.setVisible(false);
			}
		}
		if(GameLogic.getC3().isDead()) {
			for(ButtonLane three : CharacterCard.getAllbtn3()) 
			{
				three.setDisable(true);three.setVisible(false);
			}
		}
		if(GameLogic.getC4().isDead()) {
			for(ButtonLane four : CharacterCard.getAllbtn4()) 
			{
				four.setDisable(true);four.setVisible(false);
			}
		}
		if(GameLogic.getC5().isDead()) {
			for(ButtonLane five : CharacterCard.getAllbtn5()) 
			{
				five.setDisable(true);five.setVisible(false);
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
