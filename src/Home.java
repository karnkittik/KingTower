

import javax.swing.text.Position;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Home extends Application {
 
	@Override
	public void start(Stage primaryStage) {
	    Pane root = new Pane();
		root.setPrefHeight(800);
		root.setPrefWidth(600);
		
		Pane game = new Pane();
		game.setPrefHeight(800);
		game.setPrefWidth(600);
		
		Pane setting = new SettingPane();
		
		Scene Setting = new Scene(setting); 
		Scene Game = new Scene(game);
		Scene Main = new Scene(root);
		primaryStage.setScene(Main);
		primaryStage.setTitle("Main Menu");
		
		
		Button btn = new Button("START");
		Button btn2 = new Button("SETTINGS");
		
		Font font = new Font("Thonburi", 20);
		btn.setFont(font); btn2.setFont(font);
		
		Canvas canvas = new Canvas(600,800);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		root.getChildren().addAll(canvas,btn,btn2);
		btn.setPrefSize(400, 50);
		btn.setStyle(" -fx-border-color: transparent; -fx-border-width: 0;-fx-background-radius: 0;"
				+ "-fx-background-color: transparent; -fx-font-family: Thonburi;"
				+ "-fx-font-size: 70; -fx-text-fill: black;");
		btn.setLayoutX(100);btn.setLayoutY(550);
		btn.setOnAction(e -> {
			primaryStage.setScene(Game);
		});
		
		btn2.setPrefSize(400, 50);
		btn2.setStyle(" -fx-border-color: transparent; -fx-border-width: 0;-fx-background-radius: 0;"
				+ "-fx-background-color: transparent; -fx-font-family: Thonburi;"
				+ "-fx-font-size: 40; -fx-text-fill: red;");
		btn2.setLayoutX(100);btn2.setLayoutY(650);
		btn2.setOnAction(e -> {
			primaryStage.setScene(Setting);
		});

		setBackGround(gc);
		
//		drawString(gc);
		String img = "file:res/mainmenu.jpeg";
		drawImage(gc, img);

		primaryStage.show();	
	}
	private void drawImage(GraphicsContext gc,String img) {
		System.out.println(img);
		Image pic = new Image(img);
		gc.drawImage(pic, 0, 0);
		
	}

	private void setBackGround(GraphicsContext gc) {
		gc.setFill(Color.BLUE);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(),gc.getCanvas().getHeight());
	}

	private void drawString(GraphicsContext gc) {
		Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 32);
		gc.setFont(theFont);
		
		gc.setFill(Color.RED);
		gc.fillText("Valor", 60, 50);
		
		gc.setFill(Color.BLUE);
		gc.fillText("Mystic", 60, 100);
		
		gc.setFill(Color.YELLOW);
		gc.fillText("Instinct", 60, 150);
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
