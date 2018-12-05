package application;

import javafx.scene.layout.HBox;
import logic.CharacterCard;

public class CharacterPane extends HBox {
	public CharacterPane() {
		super();
		CharacterCard a = new CharacterCard("Black", 100, 5, 100, 5, "file:res/bomb.png");
		CharacterCard b = new CharacterCard("Black", 100, 5, 100, 5, "file:res/bomb.png");
		CharacterCard c = new CharacterCard("Black", 100, 5, 100, 5, "file:res/bomb.png");
		this.getChildren().addAll(a,b,c);
	}
}
