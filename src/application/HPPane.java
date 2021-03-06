package application;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import logic.GameLogic;
import logic.HPBar;
import sharedObject.RenderableHolder;

public class HPPane extends Pane {

	private HPBar one;
	private HPBar two;
	private HPBar three;
	private HPBar four;
	private HPBar five;
	private Label hpOne;
	private Label hpTwo;
	private Label hpThree;
	private Label hpFour;
	private Label hpFive;
	
	public HPPane() {
		super.setPrefSize(600, 800);
		Canvas canvas = new Canvas(600, 140);
		canvas.setLayoutX(0);
		canvas.setLayoutY(660);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		getChildren().add(canvas);
		gc.drawImage(RenderableHolder.getBar(), 0, 0);
		one = GameLogic.getC1().getHpbar();
		one.setStyle("-fx-accent : turquoise");
		two = GameLogic.getC2().getHpbar();
		two.setStyle("-fx-accent : tomato");
		three = GameLogic.getC3().getHpbar();
		three.setStyle("-fx-accent : turquoise");
		four = GameLogic.getC4().getHpbar();
		four.setStyle("-fx-accent : tomato");
		five = GameLogic.getC5().getHpbar();
		five.setStyle("-fx-accent : turquoise");
		getChildren().addAll(one, two, three, four, five);
		one.setLayoutX(GameLogic.getC1().getX() + 15);
		one.setLayoutY(GameLogic.getC1().getY() - 30);
		two.setLayoutX(GameLogic.getC2().getX() + 15);
		two.setLayoutY(GameLogic.getC2().getY() - 30);
		three.setLayoutX(GameLogic.getC3().getX() + 15);
		three.setLayoutY(GameLogic.getC3().getY() - 30);
		four.setLayoutX(GameLogic.getC4().getX() + 15);
		four.setLayoutY(GameLogic.getC4().getY() - 30);
		five.setLayoutX(GameLogic.getC5().getX() + 15);
		five.setLayoutY(GameLogic.getC5().getY() - 30);
		hpOne = new Label(GameLogic.getC1().getHp() + "/" + GameLogic.getC1().getMaxhp());
		hpOne.setLayoutX(GameLogic.getC1().getX() + 23);
		hpOne.setLayoutY(GameLogic.getC1().getY() - 29);
		hpTwo = new Label(GameLogic.getC2().getHp() + "/" + GameLogic.getC2().getMaxhp());
		hpTwo.setLayoutX(GameLogic.getC2().getX() + 23);
		hpTwo.setLayoutY(GameLogic.getC2().getY() - 29);
		hpThree = new Label(GameLogic.getC3().getHp() + "/" + GameLogic.getC3().getMaxhp());
		hpThree.setLayoutX(GameLogic.getC3().getX() + 23);
		hpThree.setLayoutY(GameLogic.getC3().getY() - 29);
		hpFour = new Label(GameLogic.getC4().getHp() + "/" + GameLogic.getC4().getMaxhp());
		hpFour.setLayoutX(GameLogic.getC4().getX() + 23);
		hpFour.setLayoutY(GameLogic.getC4().getY() - 29);
		hpFive = new Label(GameLogic.getC5().getHp() + "/" + GameLogic.getC5().getMaxhp());
		hpFive.setLayoutX(GameLogic.getC5().getX() + 23);
		hpFive.setLayoutY(GameLogic.getC5().getY() - 29);
		Label cone = new Label(GameLogic.getC1().getName());
		cone.setLayoutX(GameLogic.getC1().getX() + 52);
		cone.setLayoutY(GameLogic.getC1().getY() + 10);
		Label ctwo = new Label(GameLogic.getC2().getName());
		ctwo.setLayoutX(GameLogic.getC2().getX() + 52);
		ctwo.setLayoutY(GameLogic.getC2().getY() + 10);
		Label cthree = new Label(GameLogic.getC3().getName());
		cthree.setLayoutX(GameLogic.getC3().getX() + 55);
		cthree.setLayoutY(GameLogic.getC3().getY() + 10);
		Label cfour = new Label(GameLogic.getC4().getName());
		cfour.setLayoutX(GameLogic.getC4().getX() + 52);
		cfour.setLayoutY(GameLogic.getC4().getY() + 10);
		Label cfive = new Label(GameLogic.getC5().getName());
		cfive.setLayoutX(GameLogic.getC5().getX() + 50);
		cfive.setLayoutY(GameLogic.getC5().getY() + 10);
		ctwo.setStyle("-fx-text-fill : white;");
		cfour.setStyle("-fx-text-fill : white;");
		cone.setStyle("-fx-text-fill : blue;");
		cthree.setStyle("-fx-text-fill : blue;");
		cfive.setStyle("-fx-text-fill : blue;");
		getChildren().addAll(cone, ctwo, cthree, cfour, cfive, hpOne, hpTwo, hpThree, hpFour, hpFive);
		HPUpdate();hpOne.setText(GameLogic.getC1().getHp() + "/" + GameLogic.getC1().getMaxhp());
	}

	public void HPUpdate() {
		Thread thread = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(100);
					Platform.runLater(() -> {
						one.setProgress((double) GameLogic.getC1().getHp() / GameLogic.getC1().getMaxhp());
						two.setProgress((double) GameLogic.getC2().getHp() / GameLogic.getC2().getMaxhp());
						three.setProgress((double) GameLogic.getC3().getHp() / GameLogic.getC3().getMaxhp());
						four.setProgress((double) GameLogic.getC4().getHp() / GameLogic.getC4().getMaxhp());
						five.setProgress((double) GameLogic.getC5().getHp() / GameLogic.getC5().getMaxhp());
						hpOne.setText(GameLogic.getC1().getHp() + "/" + GameLogic.getC1().getMaxhp());
						hpTwo.setText(GameLogic.getC2().getHp() + "/" + GameLogic.getC2().getMaxhp());
						hpThree.setText(GameLogic.getC3().getHp() + "/" + GameLogic.getC3().getMaxhp());
						hpFour.setText(GameLogic.getC4().getHp() + "/" + GameLogic.getC4().getMaxhp());
						hpFive.setText(GameLogic.getC5().getHp() + "/" + GameLogic.getC5().getMaxhp());
						if (one.getProgress() == 0) {
							one.setVisible(false);
							hpOne.setVisible(false);
						}
						if (two.getProgress() == 0) {
							two.setVisible(false);
							hpTwo.setVisible(false);
						}
						if (three.getProgress() == 0) {
							three.setVisible(false);
							hpThree.setVisible(false);
						}
						if (four.getProgress() == 0) {
							four.setVisible(false);
							hpFour.setVisible(false);
						}
						if (five.getProgress() == 0) {
							five.setVisible(false);
							hpFive.setVisible(false);
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (GamePane.isTimeOut() || GamePane.isWin()) {
					break;
				}
			}
		});
		thread.start();
		return;
	}
}