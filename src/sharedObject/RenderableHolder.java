package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import logic.Castle;
import logic.Character;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image blueBomb;
	public static Image redBomb;
	public static Image greyBomb;
	public static Image blue;
	public static Image red;
	public static Image grey;
	public static Image whiteCastle;
	public static Image blackCastle;
	public static AudioClip  explosionSound;
	
	static {
		loadResource();
	}
	
	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
//		comparator = (IRenderable o1, IRenderable o2) -> {
//			if (o1.getZ() > o2.getZ())
//				return 1;
//			return -1;
//		};
	}
	public static RenderableHolder getInstance() {
		return instance;
	}
	
	public static void loadResource() {
		blueBomb = new Image(ClassLoader.getSystemResource("bluebomb.png").toString());
		redBomb = new Image(ClassLoader.getSystemResource("redbomb.png").toString());
		greyBomb = new Image(ClassLoader.getSystemResource("greybomb.png").toString());
		blue = new Image(ClassLoader.getSystemResource("blue.png").toString());
		red = new Image(ClassLoader.getSystemResource("red.png").toString());
		grey = new Image(ClassLoader.getSystemResource("grey.png").toString());
		whiteCastle = new Image(ClassLoader.getSystemResource("White.png").toString());
		blackCastle = new Image(ClassLoader.getSystemResource("Black.png").toString());
		explosionSound = new AudioClip(ClassLoader.getSystemResource("Explosion.wav").toString());
	}
	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		//Collections.sort(entities, comparator);
//		for(IRenderable x: entities){
//			if(x instanceof Castle) System.out.println("castle");
//			if(x instanceof Character) System.out.println("bomb");
			
//		}
	}
	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed())
				entities.remove(i);
				//System.out.println("d");
		}
	}
	public List<IRenderable> getEntities() {
		return entities;
	}
}
