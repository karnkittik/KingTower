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
		
		public void update(ButtonLane one,ButtonLane two,ButtonLane three,ButtonLane four,
				ButtonLane five,List<ButtonLane> a,List<ButtonLane> all,int cd,String name) {
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
					}
					catch(InterruptedException e) {
						e.printStackTrace();
					}
					//row
					if(name.equals("one") && one.isDead()) {
						System.out.println("dead");
						for(ButtonLane i:a) {
							i.setReady(i.isReady()-1);
						}
						one.setDead(false);
					}
					if(name.equals("two") && two.isDead()) {
						for(ButtonLane i:a) {
							i.setReady(i.isReady()-1);
						}
						two.setDead(false);
					}
					if(name.equals("three" )&& three.isDead()) {
						for(ButtonLane i:a) {
							i.setReady(i.isReady()-1);
						}
						three.setDead(false);
					}
					if(name.equals("four")&& four.isDead()) {
						for(ButtonLane i:a) {
							i.setReady(i.isReady()-1);
						}
						four.setDead(false);
					}
					if(name.equals("five")&& five.isDead()){
						for(ButtonLane i:a) {
							i.setReady(i.isReady()-1);
						}
						five.setDead(false);
					}
					//column
					if(getProgress()>=1) {
						ready = true;
						System.out.println("finish");
						if(isReady()) {
							setVisible(false);//progress disappear
							one.setReady(one.isReady()-1);two.setReady(two.isReady()-1);three.setReady(three.isReady()-1);
							four.setReady(four.isReady()-1);five.setReady(five.isReady()-1);
							setProgress(0);
						}
					}
					for(ButtonLane i:all) {
						if(i.isReady()==0) i.setDisable(false);
					}
					if(isReady()) {break;}
				}
				for(ButtonLane k :all) {
					System.out.print(k.isReady());
				}
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
