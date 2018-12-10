package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import application.GamePane;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import logic.Castle;
import logic.Character;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	
	private List<IRenderable> entities;
	private static Image blueBomb;
	private static Image redBomb;
	private static Image greyBomb;
	private static Image blue;
	private static Image red;
	private static Image grey;
	private static Image whiteCastle;
	private static Image whiteCastlefire;
	private static Image whiteCastlemorefire;
	private static Image blackCastle;
	private static Image blackCastlefire;
	private static Image blackCastlemorefire;
	private static Image bar;
	private static Image game;
	private static Image main;
	private static AudioClip  homesound;
	private static AudioClip  greysound;
	private static AudioClip  redsound;
	private static AudioClip  bluesound;
	private static AudioClip  gamesound;
	
	static {
		loadResource();
	}
	
	public static Image getBlueBomb() {
		return blueBomb;
	}
	public static void setBlueBomb(Image blueBomb) {
		RenderableHolder.blueBomb = blueBomb;
	}
	public static Image getRedBomb() {
		return redBomb;
	}
	public static void setRedBomb(Image redBomb) {
		RenderableHolder.redBomb = redBomb;
	}
	public static Image getGreyBomb() {
		return greyBomb;
	}
	public static void setGreyBomb(Image greyBomb) {
		RenderableHolder.greyBomb = greyBomb;
	}
	public static Image getBlue() {
		return blue;
	}
	public static void setBlue(Image blue) {
		RenderableHolder.blue = blue;
	}
	public static Image getRed() {
		return red;
	}
	public static void setRed(Image red) {
		RenderableHolder.red = red;
	}
	public static Image getGrey() {
		return grey;
	}
	public static void setGrey(Image grey) {
		RenderableHolder.grey = grey;
	}
	public static Image getWhiteCastle() {
		return whiteCastle;
	}
	public static void setWhiteCastle(Image whiteCastle) {
		RenderableHolder.whiteCastle = whiteCastle;
	}
	public static Image getWhiteCastlefire() {
		return whiteCastlefire;
	}
	public static void setWhiteCastlefire(Image whiteCastlefire) {
		RenderableHolder.whiteCastlefire = whiteCastlefire;
	}
	public static Image getWhiteCastlemorefire() {
		return whiteCastlemorefire;
	}
	public static void setWhiteCastlemorefire(Image whiteCastlemorefire) {
		RenderableHolder.whiteCastlemorefire = whiteCastlemorefire;
	}
	public static Image getBlackCastle() {
		return blackCastle;
	}
	public static void setBlackCastle(Image blackCastle) {
		RenderableHolder.blackCastle = blackCastle;
	}
	public static Image getBlackCastlefire() {
		return blackCastlefire;
	}
	public static void setBlackCastlefire(Image blackCastlefire) {
		RenderableHolder.blackCastlefire = blackCastlefire;
	}
	public static Image getBlackCastlemorefire() {
		return blackCastlemorefire;
	}
	public static void setBlackCastlemorefire(Image blackCastlemorefire) {
		RenderableHolder.blackCastlemorefire = blackCastlemorefire;
	}
	public static Image getBar() {
		return bar;
	}
	public static void setBar(Image bar) {
		RenderableHolder.bar = bar;
	}
	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
	}
	public static RenderableHolder getInstance() {
		return instance;
	}
	
	public static void loadResource() {
		setGame(new Image(ClassLoader.getSystemResource("1.png").toString()));
		blueBomb = new Image(ClassLoader.getSystemResource("bluebomb.png").toString());
		redBomb = new Image(ClassLoader.getSystemResource("redbomb.png").toString());
		greyBomb = new Image(ClassLoader.getSystemResource("greybomb.png").toString());
		blue = new Image(ClassLoader.getSystemResource("blue.png").toString());
		red = new Image(ClassLoader.getSystemResource("red.png").toString());
		grey = new Image(ClassLoader.getSystemResource("grey.png").toString());
		whiteCastle = new Image(ClassLoader.getSystemResource("White.png").toString());
		whiteCastlefire = new Image(ClassLoader.getSystemResource("whitefire.png").toString());
		whiteCastlemorefire = new Image(ClassLoader.getSystemResource("whitedestroy.png").toString());
		blackCastle = new Image(ClassLoader.getSystemResource("Black.png").toString());
		blackCastlefire = new Image(ClassLoader.getSystemResource("blackfire.png").toString());
		blackCastlemorefire = new Image(ClassLoader.getSystemResource("blackdestroy.png").toString());
		bar = new Image(ClassLoader.getSystemResource("Bar.png").toString());
		greysound = new AudioClip(ClassLoader.getSystemResource("greysound.wav").toString());
		redsound = new AudioClip(ClassLoader.getSystemResource("redsound.wav").toString());
		bluesound = new AudioClip(ClassLoader.getSystemResource("bluesound.wav").toString());
		main = new Image(ClassLoader.getSystemResource("mainmenu.jpeg").toString());
		homesound = new AudioClip(ClassLoader.getSystemResource("homesong.mp3").toString());
		gamesound = new AudioClip(ClassLoader.getSystemResource("gamesong.mp3").toString());
	}
	public void add(IRenderable entity) {
		entities.add(entity);
	}
	
	public void update() {
		if(!GamePane.isTimeOut()&& !GamePane.isWin()) {
			for (int i = entities.size() - 1; i >= 0; i--) {
				if (entities.get(i).isDestroyed())
					entities.remove(i);
			}
		}
	}
	
	public List<IRenderable> getEntities() {
		return entities;
	}
	
	public static Image getMain() {
		return main;
	}
	
	public static void setMain(Image main) {
		RenderableHolder.main = main;
	}
	
	public static AudioClip getRedsound() {
		return redsound;
	}
	
	public static void setRedsound(AudioClip redsound) {
		RenderableHolder.redsound = redsound;
	}
	
	public static AudioClip getBluesound() {
		return bluesound;
	}
	
	public static void setBluesound(AudioClip bluesound) {
		RenderableHolder.bluesound = bluesound;
	}
	
	public static AudioClip getGreysound() {
		return greysound;
	}
	
	public static void setGreysound(AudioClip greysound) {
		RenderableHolder.greysound = greysound;
	}
	
	public static Image getGame() {
		return game;
	}
	
	public static void setGame(Image game) {
		RenderableHolder.game = game;
	}
	
	public static AudioClip getHomesound() {
		return homesound;
	}
	
	public static void setHomesound(AudioClip homesound) {
		RenderableHolder.homesound = homesound;
	}
	
	public static AudioClip getGamesound() {
		return gamesound;
	}
	
	public static void setGamesound(AudioClip gamesound) {
		RenderableHolder.gamesound = gamesound;
	}
	
}
