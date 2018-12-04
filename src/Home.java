

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Home extends Application {
 
	@Override
	public void start(Stage primaryStage) {
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Test1");
		
		Canvas canvas = new Canvas(600,800);
		root.getChildren().add(canvas);
		
		
		
		
		
		
		
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
