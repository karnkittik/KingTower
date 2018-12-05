package logic;

import java.util.ArrayList;

public class GameLogic {
	private static int GameMode;
	private ArrayList<Character> party;
	private ArrayList<Character> activeCharacters;
	private Character boss;
	public int getGameMode() {
		return GameMode;
	}
	public static void setGameMode(int gameMode) {
		GameMode = gameMode;
	}
	
	

}
