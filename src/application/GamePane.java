package application;

import Drawing.GameScreen;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.BlackCastle;
import logic.ButtonLane;
import logic.Castle;
import logic.CharacterCard;
import logic.Lane;
import logic.WhiteCastle;
import logic.Character;

public class GamePane extends Pane {
	private static int currentTime;
	private static AnimationTimer animationTimer;
	private static long lastTimeTriggered;
	private static Canvas canvas = new Canvas(600,800);
	private static Pane pane = new Pane();
	private static boolean timeOut;
	private static GraphicsContext gc = canvas.getGraphicsContext2D();
	public GamePane() {
		super();
		this.setPrefSize(600, 800);
		GameScreen game = new GameScreen();
		this.getChildren().add(game);
		this.getChildren().add(canvas);
		this.getChildren().add(pane);
		CharacterPane cp = new CharacterPane();
		this.getChildren().add(cp);
		cp.setLayoutX(10);cp.setLayoutY(667);
		
		timeOut = false;
		startGameloop();
	}

	public static void startGameloop() {
		Castle c1 = new WhiteCastle(54, 210, 110, 250);	
		Castle c2 = new BlackCastle(150, 160, 110, 250);
		Castle c3 = new WhiteCastle(250, 260, 110, 250);
		Castle c4 = new BlackCastle(345, 160, 110, 250);
		Castle c5 = new WhiteCastle(432, 210, 110, 250);
		
		Lane l1 = new Lane(80, 460, 60, 200, Color.BURLYWOOD);		
		Lane l2 = new Lane(180, 410, 60, 250, Color.BURLYWOOD);
		Lane l3 = new Lane(275, 510, 60, 150, Color.BURLYWOOD);		
		Lane l4 = new Lane(370, 410, 60, 250, Color.BURLYWOOD);
		Lane l5 = new Lane(450, 460, 60, 200, Color.BURLYWOOD);
			
		for(Lane l : Lane.getAllLane()) {
			l.draw(gc);
		}
		pane.getChildren().add(c1.getHpbar());
		pane.getChildren().add(c2.getHpbar());
		pane.getChildren().add(c3.getHpbar());
		pane.getChildren().add(c4.getHpbar());
		pane.getChildren().add(c5.getHpbar());

		for(Castle c : Castle.getAllCastle()) {
			c.draw(gc);
			
		}
		
		for(ButtonLane btn:CharacterCard.getAll()) {
			btn.setDisable(true);
		}
		
		startTimer();

	}
	
	public static boolean isTimeOut() {
		return timeOut;
	}

	public static void setTimeOut(boolean timeOut) {
		GamePane.timeOut = timeOut;
	}

	private static void startTimer() {
		currentTime = 121;
		lastTimeTriggered = -1;
		GraphicsContext gc = canvas.getGraphicsContext2D();
		animationTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) { 
				// TODO Auto-generated method stub
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				
				if (now - lastTimeTriggered >= 1000000000) //1 second
				{
					currentTime--;
					if(currentTime==120) {
						for(ButtonLane btn:CharacterCard.getAll()) {
							btn.setDisable(false);
						}
					}
					if(currentTime==0) {
						drawCurrentTimeString(gc,Color.RED);
						for(ButtonLane btn:CharacterCard.getAll()) {
							btn.setDisable(true);
							btn.setReady(0);
						}
						setTimeOut(true);
						System.out.println("timeout");
						this.stop();
						animationTimer.stop();
					}else if(currentTime<=3&&currentTime>=1) {
						drawCurrentTimeString(gc,Color.YELLOW);
					}else {drawCurrentTimeString(gc,Color.WHITE);}
					lastTimeTriggered = now;
				}
			}
		};
		animationTimer.start();
		
	}

	protected static void drawCurrentTimeString(GraphicsContext gc2,Color color) {
		gc.setFill(color);
		gc.setFont(new Font(40));
		gc.clearRect(512, 0, 90, 90);
		gc.fillText("" +currentTime, 520, 60);
		
	}

	public static void updateUI() {
		
	}

	
	
}
