package application;


import javafx.scene.layout.HBox;
import logic.CharacterCard;

public class CharacterPane extends HBox {
	
	public CharacterPane() {
		super(10);
		//this.setPadding(new Insets(5, 5, 5, 5));
		//String name, int damage, int speed, int maxhp, int cd, String imgCharacter,String imgCard
		//String name, int damage, int speed, int maxhp, int cd, String imgCharacter,String imgCard)
		CharacterCard a = new CharacterCard("Grey", 50, 5, 100, 5, "file:res/greybomb.png","file:res/grey.png");
		CharacterCard b = new CharacterCard("Red", 200+2000, 10, 100, 15, "file:res/redbomb.png","file:res/red.png");
		CharacterCard c = new CharacterCard("Blue", 150+2000, 5, 100, 10,"file:res/bluebomb.png", "file:res/blue.png");
		this.getChildren().addAll(a,b,c);
	}
}
