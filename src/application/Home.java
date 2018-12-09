package application;


import Drawing.GameScreen;
import Drawing.HomeScreen;
import javafx.animation.AnimationTimer;
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
import sharedObject.RenderableHolder;


public class Home extends Application {
 
	@Override
	public void start(Stage primaryStage) {
	    Pane home = new Pane();
	    home.setPrefSize(600, 800);
		HomeScreen homescreen = new HomeScreen();
		home.getChildren().add(homescreen);
		
		GamePane gamepane = new GamePane();
		Scene Game = new Scene(gamepane);
		//GameScreen gs = new GameScreen();
		//gamepane.getChildren().add(gs);
		Scene homescene = new Scene(home);
		primaryStage.setScene(homescene);
		primaryStage.setTitle("KingTower");
	    primaryStage.setResizable(false);
	    
	    GameLogic gamelogic = new GameLogic();
	    
		
		
		Hyperlink start = new Hyperlink("START"); start.setAlignment(Pos.CENTER);
		Hyperlink setting = new Hyperlink("SETTINGS"); setting.setAlignment(Pos.CENTER);
		Hyperlink easy = new Hyperlink("EASY");
		Hyperlink medium = new Hyperlink("MEDIUM");
		Hyperlink hard = new Hyperlink("HARD");
		Hyperlink back = new Hyperlink("BACK");
		HBox menu = new HBox(0);
		menu.setPrefWidth(400);
		menu.setAlignment(Pos.CENTER);
		menu.getChildren().addAll(easy,medium,hard);
		Font small = new Font("Thonburi",25);

		easy.setFont(small);medium.setFont(small);hard.setFont(small);
		easy.setDisable(true);medium.setDisable(false);hard.setDisable(false);
		easy.setVisible(false);medium.setVisible(false);hard.setVisible(false);
		menu.setLayoutX(100);menu.setLayoutY(660);
		back.setLayoutX(0);back.setLayoutY(740);
		back.setPrefWidth(600);back.setAlignment(Pos.CENTER);
		back.setStyle(" -fx-border-width: 0; -fx-font-family: Thonburi;" + 
				"    -fx-font-size: 25;" + 
				"    -fx-text-fill: white;" );
		back.setVisible(false);back.setDisable(true);
		back.setOnAction(e -> {
			easy.setVisible(false);medium.setVisible(false);hard.setVisible(false);
			setting.setDisable(false);setting.setVisible(true);
			back.setVisible(false);back.setDisable(true);
		});
		easy.setOnAction(e ->{
			//GameLogic.setGameMode(1);
			easy.setDisable(true);medium.setDisable(false);hard.setDisable(false);
			setting.setDisable(false);setting.setVisible(false);
		});
		medium.setOnAction(e ->{
			//GameLogic.setGameMode(2);
			easy.setDisable(false);medium.setDisable(true);hard.setDisable(false);
			setting.setDisable(false);setting.setVisible(false);
		});
		hard.setOnAction(e ->{
			//GameLogic.setGameMode(3);
			easy.setDisable(false);medium.setDisable(false);hard.setDisable(true);
			//menu.setDisable(true);menu.setVisible(false);
			setting.setDisable(false);setting.setVisible(false);
		});

		easy.setStyle("-fx-border-width: 0;");
		medium.setStyle("-fx-border-width: 0;");
		hard.setStyle("-fx-border-width: 0;");
		
		home.getChildren().addAll(menu,  back, start,setting );
		
		start.setPrefSize(400, 50);
		start.setStyle("-fx-border-width: 0; -fx-font-family: Thonburi;"
				+ "-fx-font-size: 70; -fx-text-fill: black;");
		start.setLayoutX(100);start.setLayoutY(550);
		start.setOnAction(e -> {
			primaryStage.setScene(Game);
			
			gamepane.startGameloop();
			
			
			AnimationTimer animation = new AnimationTimer() {
				public void handle(long now) {
					//System.out.println("k");;
					if(GamePane.isTimeOut()) {
						this.stop();
						//alert
					}
					gamepane.getGs().paintComponent();
//gamepane.getHPpane().HPUpdate();
					gamelogic.logicUpdate();
					RenderableHolder.getInstance().update();
				}
			};
			animation.start();
			
		});
		
		setting.setPrefSize(400, 50);
		setting.setStyle(" -fx-border-width: 0; -fx-font-family: Thonburi;"
				+ "-fx-font-size: 40; -fx-text-fill: red;");
		setting.setLayoutX(100);setting.setLayoutY(650);
		setting.setOnAction(e -> {
			setting.setDisable(true);setting.setVisible(false);	
			easy.setVisible(true);medium.setVisible(true);hard.setVisible(true);
			back.setVisible(true);back.setDisable(false);
		});


		primaryStage.show();	
	}


	public static void main(String[] args) {
		launch(args);
	}

}
