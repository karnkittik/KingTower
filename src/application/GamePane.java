package application;

import Drawing.GameScreen;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.ButtonLane;
import logic.CharacterCard;
import sharedObject.RenderableHolder;

public class GamePane extends Pane {
	
	private static int currentTime;
	private static long lastTimeTriggered;
	private static boolean win = false;
	private static boolean timeOut = false;
	private static AnimationTimer animationTimer;
	private static Canvas canvas = new Canvas(600, 800);
	private static GraphicsContext gc = canvas.getGraphicsContext2D();
	private static CharacterPane cp;
	private HPPane hp = new HPPane();
	private GameScreen gs;
	
	public GamePane() {
		super();
		this.setPrefSize(600, 800);
		gs = new GameScreen();
		cp = new CharacterPane();
		this.getChildren().add(gs);
		this.getChildren().add(canvas);
		this.getChildren().add(hp);
		this.getChildren().add(cp);
		cp.setLayoutX(10);
		cp.setLayoutY(667);
	}
	
	public HPPane getHPpane() {
		return hp;
	}

	public void setHPpane(HPPane hPpane) {
		hp = hPpane;
	}

	public GameScreen getGs() {
		return gs;
	}

	public void setGs(GameScreen gs) {
		this.gs = gs;
	}

	public static boolean isTimeOut() {
		return timeOut;
	}

	public static void setTimeOut(boolean timeOut) {
		GamePane.timeOut = timeOut;
	}

	public void startTimer() {
		currentTime = 60;
		lastTimeTriggered = -1;
		GraphicsContext gc = canvas.getGraphicsContext2D();
		animationTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) { 
				// TODO Auto-generated method stub
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				
				if (now - lastTimeTriggered >= 1000000000) //1 second
				{
					if (win) {
						drawCurrentTimeString(gc,Color.ORANGE);
						this.stop();
						animationTimer.stop();
					} else if (currentTime == 60) {
						drawCurrentTimeString(gc,Color.WHITE);
						for (ButtonLane btn:CharacterCard.getAll()) {
							btn.setDisable(false);
						}
					} else if (currentTime == 58) {
						drawCurrentTimeString(gc,Color.WHITE);
						RenderableHolder.getGamesound().play();	
					}
					else if(currentTime == 0) {
						drawCurrentTimeString(gc,Color.RED);
						for(ButtonLane btn:CharacterCard.getAll()) {
							btn.setDisable(true);
							btn.setReady(0);
						}
//						RenderableHolder.getGamesound().stop();
						setTimeOut(true);
						System.out.println("! Time Up !");
						stop();
						timeOut = true;
					} else if (currentTime <= 3 && currentTime >= 1) {
						drawCurrentTimeString(gc,Color.YELLOW);
					} else {
						drawCurrentTimeString(gc,Color.WHITE);
					}
					lastTimeTriggered = now;
					currentTime--;
				}
			}
		};
		animationTimer.start();	
	}

	private static void drawCurrentTimeString(GraphicsContext gc2,Color color) {
		gc.setFill(color);
		gc.setFont(new Font(40));
		gc.clearRect(512, 0, 90, 90);
		gc.fillText("" + currentTime, 520, 60);
	}

	public static boolean isWin() {
		return win;
	}

	public static void setWin(boolean win) {
		GamePane.win = win;
	}	
}
