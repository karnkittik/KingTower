package logic;

import java.util.List;

import application.GamePane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;

public class CoolDownBar extends ProgressBar{
		private CharacterCard owner;
		private boolean ready;
		public CoolDownBar(CharacterCard owner){
			super();
			this.owner = owner;
			ready = true;
			setPrefWidth(100);
			setVisible(false);
			setProgress(0);
			
		}
		public void update(ButtonLane one,ButtonLane two,ButtonLane three,ButtonLane four,ButtonLane five,List<ButtonLane> a,List<ButtonLane> all,int cd) {
			Thread thread = new Thread(()->{
				while(true) {
					try {
						if(GamePane.isTimeOut()||GamePane.isWin()) {
							setVisible(false);
							break;
						}
						Thread.sleep(10);
						Platform.runLater(()->{
							setProgress(getProgress()+(0.002*5)/cd); // cd/250
						});
					
					}catch(InterruptedException e){
					e.printStackTrace();
					}
					if(getProgress()>=1) {
						ready = true;
						System.out.println("finish");
						if(isReady()) {
							setVisible(false);//progress disappear
							//column
							for(ButtonLane i:a) {
								i.setReady(i.isReady()-1);
							}
							//one.setDisable(false);two.setDisable(false);three.setDisable(false);four.setDisable(false);five.setDisable(false);
							one.setReady(one.isReady()-1);two.setReady(two.isReady()-1);three.setReady(three.isReady()-1);four.setReady(four.isReady()-1);five.setReady(five.isReady()-1);
							for(ButtonLane i:all) {
								if(i.isReady()==0) i.setDisable(false);
							}
							setProgress(0);
							break;
						}
					}
				}
				System.out.println("break");
			});
			thread.start();
			return;
		}
		public boolean isReady() {
			return ready;
		}
		
		public void setReady(boolean ready) {
			this.ready = ready;
		}
		public CharacterCard getOwner() {
			return owner;
		}
		public void setOwner(CharacterCard owner) {
			this.owner = owner;
		}
		
		
		

}
