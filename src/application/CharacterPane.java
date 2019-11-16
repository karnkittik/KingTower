package application;

import javafx.scene.layout.HBox;
import logic.CharacterCard;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class CharacterPane extends HBox {
	
	public CharacterPane() {
		super(10);
		
		//String name, int damage, double speed, int maxhp, int cd, String imgCharacter,String imgCard)
		if (GameLogic.getGameMode() == 1) {
			CharacterCard a = new CharacterCard("Grey", 250, 6, 100, 2, RenderableHolder.getGreyBomb(), RenderableHolder.getGrey());
			CharacterCard b = new CharacterCard("Red", 300, 5.5,100, 4, RenderableHolder.getRedBomb(), RenderableHolder.getRed());
			CharacterCard c = new CharacterCard("Blue", 350, 5, 100, 9,RenderableHolder.getBlueBomb(), RenderableHolder.getBlue());
			a.getCb().setStyle("-fx-accent : dimgrey");
			b.getCb().setStyle("-fx-accent : firebrick");
			c.getCb().setStyle("-fx-accent : royalblue");
			this.getChildren().addAll(a, b, c);
			System.out.println("GameMode : Easy");
		} else if (GameLogic.getGameMode() == 2) {
			CharacterCard a = new CharacterCard("Grey", 200, 4, 100, 3, RenderableHolder.getGreyBomb(), RenderableHolder.getGrey());
			CharacterCard b = new CharacterCard("Red", 250, 3.5, 100, 5, RenderableHolder.getRedBomb(), RenderableHolder.getRed());
			CharacterCard c = new CharacterCard("Blue", 300, 3, 100, 10,RenderableHolder.getBlueBomb(), RenderableHolder.getBlue());
			a.getCb().setStyle("-fx-accent : dimgrey");
			b.getCb().setStyle("-fx-accent : firebrick");
			c.getCb().setStyle("-fx-accent : royalblue");
			this.getChildren().addAll(a, b,c);
			System.out.println("GameMode : Medium");
		} else if (GameLogic.getGameMode() == 3) {
			CharacterCard a = new CharacterCard("Grey", 150, 4, 100, 4, RenderableHolder.getGreyBomb(), RenderableHolder.getGrey());
			CharacterCard b = new CharacterCard("Red", 200, 3.5, 100, 6, RenderableHolder.getRedBomb(), RenderableHolder.getRed());
			CharacterCard c = new CharacterCard("Blue", 250, 3, 100, 11, RenderableHolder.getBlueBomb(), RenderableHolder.getBlue());
			a.getCb().setStyle("-fx-accent : dimgrey");
			b.getCb().setStyle("-fx-accent :firebrick");
			c.getCb().setStyle("-fx-accent : royalblue");
			this.getChildren().addAll(a, b, c);
			System.out.println("GameMode : Hard");
		}
	}
}
