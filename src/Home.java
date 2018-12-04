

import javax.swing.text.Position;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
		Pane root2 = new Pane();
		root2.setPrefHeight(600);
		root2.setPrefWidth(600);
		Scene scene2 = new Scene(root2);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Test1");
		
		Button btn = new Button("START");
		Font font = new Font("Thonburi", 20);
		btn.setFont(font);
		
		Canvas canvas = new Canvas(600,800);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().addAll(canvas,btn);
		btn.setPrefSize(100, 50);
		btn.setStyle(" -fx-border-color: transparent; -fx-border-width: 0;-fx-background-radius: 0;"
				+ "-fx-background-color: transparent; -fx-font-family: Thonburi;"
				+ "-fx-font-size: 20;-fx-text-fill: #828282;");
		btn.setLayoutX(250);btn.setLayoutY(650);
		btn.setOnAction(e -> {
			primaryStage.setScene(scene2);
		});
		setBackGround(gc);
//		drawString(gc);
		String img = "file:res/KingTower Main.png";
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
