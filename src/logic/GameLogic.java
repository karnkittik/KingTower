package logic;

import java.util.ArrayList;

import application.GamePane;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GameLogic {
	private static int GameMode;
	public static GameLogic instance = new GameLogic();
	
	private ArrayList<Castle> party;
	private ArrayList<Castle> activeCharacters;
	
	private Castle mainCastle;

	public GameLogic() {
		party = new ArrayList<Castle>();
		
		//7 castle
		
//		Character a = new Character("Grey", 100, 5, 100, 5,"", "file:res/grey.png");
//		Character b = new Character("Red", 100, 5, 100, 5,"", "file:res/red.png");
//		Character c = new Character("Blue", 100, 5, 100, 5,"", "file:res/blue.png");
//		party.add(a);
//		party.add(b);
//		party.add(b);
		
		//castle
		//boss = new Character("Sephiroth", 1500, 40, 105, "sephiroth.png");
		
		startGameLoop();
	}

	public void startGameLoop() {
		activeCharacters = new ArrayList<Castle>(party);
		Thread t = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(16);
					runLogicLoop(); //boss attack
					Platform.runLater(() -> {
						GamePane.updateUI();
					});
					//if timeout|| mainCastledead break
					if (activeCharacters.isEmpty() || boss.isDead()) {
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//if timeout
			if (activeCharacters.isEmpty())
			{
				Platform.runLater(() -> {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setContentText("So sad that you can't take KingTower down");
					alert.setHeaderText("You are DEFEATED!");
					alert.setTitle("Battle Result");
					alert.show();
				});
			} else {
				Platform.runLater(() -> {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setContentText("Congratulation! KingTower is collapsed!");
					alert.setHeaderText("You are VICTORIOUS!");
					alert.setTitle("Battle Result");
					alert.show();
				});
			}
		});
		t.start();
	}

	public static GameLogic getInstance() {
		return instance;
	}

	public ArrayList<Castle> getParty() {
		return this.party;
	}

//	public Character getBoss() {
//		return this.boss;
//	}
	public Castle getMainCastle() {
		return mainCastle;
	}
	
	public void runLogicLoop () {
		mainCastle.setActivePoint(mainCastle.getActivePoint() + Castle.getSpeed());
		if (mainCastle.getActivePoint() >= Castle.getLimit()) {
			Character target = activeCharacters.get;
			//attack all on that lane
			//<=0 remove from active
			boss.attack(target);
			if (target.isDead()) {
				target.setActivePoint(0);
				activeCharacters.remove(target);
			}
			boss.setActivePoint(0);
		}
		
		for (Character character : activeCharacters) {
			//if bomb arrive that terminal pixel
			if (!character.isReady()) {
				character.setActivePoint(character.getActivePoint() + character.getSpeed());
				if (character.getActivePoint() > Character.getLimit()) {
					character.setActivePoint(Character.getLimit());
				}
			}
		}	
		
	}

	public static int getGameMode() {
		return GameMode;
	}

	public static void setGameMode(int gameMode) {
		GameMode = gameMode;
	}
	
	

}

