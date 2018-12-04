import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SettingPane extends StackPane{
	private boolean clicked;
	public SettingPane() {
		super.setPrefSize(600, 800);
		setClicked(false);
		Canvas canvas = new Canvas(600,800);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		String img = "file:res/Slide1.png";
		Image pic = new Image(img);
		gc.drawImage(pic, 0, 0);
		
		VBox box = new VBox(80);
		box.setAlignment(Pos.CENTER);
		super.getChildren().addAll(canvas,box);
		Button easy = new Button("EASY");
		Button medium = new Button("MEDIUM");
		Button hard = new Button("HARD");
		box.getChildren().addAll(easy,medium,hard);
		
		setButton(easy);setButton(medium);setButton(hard);
		easy.setOnAction(e -> {
			System.out.println("easy");
			setClicked(true);
		});
		medium.setOnAction(e -> {
			System.out.println("medium");
			setClicked(true);
		});
		hard.setOnAction(e -> {
			System.out.println("hard");
			setClicked(true);
		});
		
		
	}
	private void setButton(Button btn) {
		btn.setPrefSize(400, 50);
		btn.setStyle(" -fx-border-color: transparent; -fx-border-width: 0;-fx-background-radius: 0;"
				+ "-fx-background-color: transparent; -fx-font-family: Thonburi;"
				+ "-fx-font-size: 70; -fx-text-fill: black;");
		
	}
	public boolean isClicked() {
		return clicked;
	}
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	
}
