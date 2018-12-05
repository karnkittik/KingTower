package application;


import Drawing.HomeScreen;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import logic.GameLogic;

public class Home extends Application {
 
	@Override
	public void start(Stage primaryStage) {
	    Pane home = new Pane();
	    home.setPrefSize(600, 800);
		HomeScreen homescreen = new HomeScreen();
		GamePane gamescreen = new GamePane();
		Scene Game = new Scene(gamescreen);
		home.getChildren().add(homescreen);
		Scene homescene = new Scene(home);
		primaryStage.setScene(homescene);
		primaryStage.setTitle("Main Menu");
		
		
		Hyperlink start = new Hyperlink("START"); start.setAlignment(Pos.CENTER);
		Hyperlink setting = new Hyperlink("SETTINGS"); setting.setAlignment(Pos.CENTER);
		Hyperlink easy = new Hyperlink("EASY");
		Hyperlink medium = new Hyperlink("MEDIUM");
		Hyperlink hard = new Hyperlink("HARD");
		HBox menu = new HBox(0);
		menu.setPrefWidth(400);
		menu.setAlignment(Pos.CENTER);
		menu.getChildren().addAll(easy,medium,hard);
		Font small = new Font("Thonburi",25);
//		easy.setStyle("-fx-font-family: Thonburi;"
//				+ "-fx-font-size: 25; -fx-text-fill: black;");
//		medium.setStyle("-fx-font-family: Thonburi;"
//				+ "-fx-font-size: 25; -fx-text-fill: black;");
//		hard.setStyle("-fx-font-family: Thonburi;"
//				+ "-fx-font-size: 25; -fx-text-fill: black;");
		easy.setFont(small);medium.setFont(small);hard.setFont(small);
		
		menu.setLayoutX(100);menu.setLayoutY(660);
		menu.setVisible(false); menu.setDisable(true);
		
		easy.setOnAction(e ->{
			GameLogic.setGameMode(1);
			menu.setDisable(true);menu.setVisible(false);
			setting.setDisable(false);setting.setVisible(true);
		});
		medium.setOnAction(e ->{
			GameLogic.setGameMode(2);
			menu.setDisable(true);menu.setVisible(false);
			setting.setDisable(false);setting.setVisible(true);
		});
		hard.setOnAction(e ->{
			GameLogic.setGameMode(3);
			menu.setDisable(true);menu.setVisible(false);
			setting.setDisable(false);setting.setVisible(true);
		});

		
		home.getChildren().addAll(start	,setting ,menu);
		
		start.setPrefSize(400, 50);
		start.setStyle("-fx-font-family: Thonburi;"
				+ "-fx-font-size: 70; -fx-text-fill: black;");
		start.setLayoutX(100);start.setLayoutY(550);
		start.setOnAction(e -> {
			primaryStage.setScene(Game);
		});
		
		setting.setPrefSize(400, 50);
		setting.setStyle("-fx-font-family: Thonburi;"
				+ "-fx-font-size: 40; -fx-text-fill: red;");
		setting.setLayoutX(100);setting.setLayoutY(650);
		setting.setOnAction(e -> {
			setting.setDisable(true);setting.setVisible(false);	
			menu.setVisible(true); menu.setDisable(false);			
		});


		primaryStage.show();	
	}



	public static void main(String[] args) {
		launch(args);
	}

}
