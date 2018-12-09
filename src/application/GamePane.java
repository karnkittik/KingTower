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
	private GameScreen gs;
	private static CharacterPane cp = new CharacterPane();
	private static GraphicsContext gc = canvas.getGraphicsContext2D();
	public GamePane() {
		super();
		this.setPrefSize(600, 800);
		gs = new GameScreen();
		this.getChildren().add(gs);
		this.getChildren().add(pane);
		
		this.getChildren().add(canvas);
		this.getChildren().add(cp);
		cp.setLayoutX(10);cp.setLayoutY(667);
		
		timeOut = false;
		//startGameloop();
	}
	
	public GameScreen getGs() {
		return gs;
	}

	public void setGs(GameScreen gs) {
		this.gs = gs;
	}

	public void startGameloop() {
		startTimer();

	}
	
	

	public static boolean isTimeOut() {
		return timeOut;
	}

	public static void setTimeOut(boolean timeOut) {
		GamePane.timeOut = timeOut;
	}

	private static void startTimer() {
		currentTime = 11;
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
					System.out.println(currentTime);
					if(currentTime==10) {
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
		System.out.println(-currentTime);
		gc.fillText("" +currentTime, 520, 60);
		
	}

	public static void paint() {
		
	}

	
	
}
