package logic;

import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class GameLogic {
	
	private static int gameMode = 1;
	private static Castle c1 = new WhiteCastle(60, 210, 110, 250, "Lauriel");
	private static Castle c2 = new BlackCastle(160, 160, 110, 250,"Moren");
	private static Castle c3 = new WhiteCastle(255, 260, 110, 250, "Yorn");
	private static Castle c4 = new BlackCastle(350, 160, 110, 250, "Illumia");
	private static Castle c5 = new WhiteCastle(439, 210, 110, 250,"Sephera");
	private static Lane l1 = new Lane(70, 460, 80, 200, Color.DARKGREY);		
	private static Lane l2 = new Lane(170, 410, 80, 250, Color.SLATEGRAY);
	private static Lane l3 = new Lane(265, 510, 80, 150, Color.DARKGREY);		
	private static Lane l4 = new Lane(360, 410, 80, 250, Color.SLATEGRAY);
	private static Lane l5 = new Lane(450, 460, 80, 200, Color.DARKGREY);
	
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

	public GameLogic() {
		for (ButtonLane btn : CharacterCard.getAll()) {
			btn.setDisable(true);
		}
		addNewObject(c1);
		addNewObject(c2);
		addNewObject(c3);
		addNewObject(c4);
		addNewObject(c5);
		addNewObject(l1);
		addNewObject(l2);
		addNewObject(l3);
		addNewObject(l4);
		addNewObject(l5);
	}
	
	public static void addNewObject(Entity entity) {
		RenderableHolder.getInstance().add(entity);
	}
	
	public void logicUpdate() {
		for (IRenderable en : RenderableHolder.getInstance().getEntities()) {
			if (en instanceof Character) {
				if (!((Character)en).isDestroyed() && ((Character)en).collideWith(((Character)en).getTarget())){
					((Character)en).crash(((Character)en).getTarget());
				}
			}
			if (en instanceof WhiteCastle) {
				if (((Castle)en).getHp() == 0) {
					((Castle)en).setDead(true);
					((Castle)en).setImg(RenderableHolder.getWhiteCastlemorefire());
				}
			}
			if (en instanceof BlackCastle) {
				if (((Castle)en).getHp() == 0) {
					((Castle)en).setDead(true);
					((Castle)en).setImg(RenderableHolder.getBlackCastlemorefire());
				}
			}
		}	
		if (GameLogic.getC1().isDead()) {
			for (ButtonLane one : CharacterCard.getAllbtn1()) {
				one.setDisable(true);
				one.setVisible(false);
			}
		}
		if (GameLogic.getC2().isDead()) {
			for (ButtonLane two : CharacterCard.getAllbtn2()) {
				two.setDisable(true);
				two.setVisible(false);
			}
		}
		if (GameLogic.getC3().isDead()) {
			for (ButtonLane three : CharacterCard.getAllbtn3()) {
				three.setDisable(true);
				three.setVisible(false);
			}
		}
		if (GameLogic.getC4().isDead()) {
			for (ButtonLane four : CharacterCard.getAllbtn4()) 
			{
				four.setDisable(true);
				four.setVisible(false);
			}
		}
		if (GameLogic.getC5().isDead()) {
			for (ButtonLane five : CharacterCard.getAllbtn5()) 
			{
				five.setDisable(true);
				five.setVisible(false);
			}
		}
	}
	
}
