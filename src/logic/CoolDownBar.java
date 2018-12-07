package logic;

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
		public void update() {
			Thread thread = new Thread(()->{
				while(true) {
					try {
						Thread.sleep(100);
						Platform.runLater(()->{
							setProgress(getProgress()+0.02);
						});
					
					}catch(InterruptedException e){
					e.printStackTrace();
					}
					if(getProgress()>=1) {
						ready = true;
						System.out.println("finish");
						if(isReady()) {
							owner.getOne().setDisable(false);
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
