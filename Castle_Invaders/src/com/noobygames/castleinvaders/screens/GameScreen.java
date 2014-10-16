package com.noobygames.castleinvaders.screens;




import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.noobgygames.castleinvaders.ui.DragonUltiButton;
import com.noobgygames.castleinvaders.ui.ElementSwitcherButton;
import com.noobgygames.castleinvaders.ui.TextureElement;
import com.noobygames.castleinvaders.Assets;
import com.noobygames.castleinvaders.CastleInvaders;
import com.noobygames.castleinvaders.Player;
import com.noobygames.castleinvaders.World;
import com.noobygames.castleinvaders.World.Species;
import com.noobygames.castleinvaders.WorldRenderer;
import com.noobygames.utils.exceptions.OutOfBoundingException;
import com.noobygames.utils.ui.Button;
import com.noobygames.utils.ui.ClickableElement;
import com.noobygames.utils.ui.Table;


/**
 * @author Tobi
 * **/

public class GameScreen implements Screen, InputProcessor {
	final CastleInvaders game;

	static final int GAME_READY = 0;
	static final int GAME_RUNNING = 1;
	static final int GAME_PAUSED = 2;
	static final int GAME_LEVEL_END = 3;
	static final int GAME_OVER = 4;

	
	int state;
	Vector3 touchPoint;
	World world;
	Player player;
	WorldRenderer renderer;
	Rectangle pauseBounds;
	Rectangle resumeBounds;
	String scoreString;
	TextureElement stickToMouse;
	private int id;
	//private final Window window = new Window();
	private final Table table;

	private boolean isHonoured;

	private float switchTimer = 0;

	private boolean start;
	int lanes[] = { 0, 128, 256, 384, 512, 640, 768 };


	public static final Button elementSwitcher = new ElementSwitcherButton(new Rectangle(1000, 5, 80, 80), Assets.eleSwitchEarth);
	public static final Button dragonUlti = new DragonUltiButton(new Rectangle(880, 5, 80, 80), Assets.earthDragonSwitch);
	//ClickableElement greyTrollSelect = new TextureElement(new Rectangle(), Assets.greyTrollSelect);
	Array<TextureElement> selectButtons = new Array<TextureElement>();

	private boolean sticked;

	private int lane;
	
	

	public GameScreen(final CastleInvaders gam) throws OutOfBoundingException {
		this.game = gam;
		sticked = false;
		id = 0; // One unique id for each element
		dragonUlti.setId(id+2);
		elementSwitcher.setId(id+1);
		state = GAME_READY; 
		player = new Player();
		touchPoint = new Vector3();
		world = new World(player.getLevel());
		stickToMouse = new TextureElement(null,null,null);
		touchPoint.z = 0;
		player.updatePrefs(game);
		isHonoured = false;
		this.stickToMouse = null;
		

		table = new Table(new Rectangle(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()), null);
		table.setId(id);
		table.addElement(dragonUlti);
		table.addElement(elementSwitcher);
		table.addElement(new TextureElement(new Rectangle(400, 5, 65, 65), Assets.greyTrollSelect, Species.greyTroll));
		table.addElement(new TextureElement(new Rectangle(460, 5, 65, 65), Assets.lavaTrollSelect, Species.lavaTroll));
		table.addElement(new TextureElement(new Rectangle(520, 5, 65, 65), Assets.iceTrollSelect, Species.iceTroll));
		
		
		renderer = new WorldRenderer(world, game, player, table);
		id+=4;
	}

	@Override
	public void resize(int width, int height) {
		renderer.setSize(width, height);
	}

	@Override
	public void show() {
		player.updatePrefs(game);
		world = new World(player.getLevel());
		renderer = new WorldRenderer(world, game, player, table);
		Gdx.input.setInputProcessor(this);
		Gdx.input.setCatchBackKey(true);
		renderer.camera.update();
		game.batch.setProjectionMatrix(renderer.camera.combined);
		state = GAME_RUNNING;
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null); // Ressourcen freigeben
	}

	@Override
	public void pause() {
		if (state == GAME_RUNNING)
			state = GAME_PAUSED;
	}

	@Override
	public void resume() {
		if (state == GAME_PAUSED)
			this.state = GAME_RUNNING;
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null); // Ressourcen freigeben
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		switch(World.elementState){
		case World.elementEarth:
			if(dragonUlti.isClicked())
				dragonUlti.setTexRegion(Assets.earthDragonSwitchClicked);
			else
				dragonUlti.setTexRegion(Assets.earthDragonSwitch);
			break;
		case World.elementLava:
			if(dragonUlti.isClicked())
				dragonUlti.setTexRegion(Assets.fireDragonSwitchClicked);
			else
				dragonUlti.setTexRegion(Assets.fireDragonSwitch);
			break;
		case World.elementIce:
			if(dragonUlti.isClicked())
				dragonUlti.setTexRegion(Assets.iceDragonSwitchClicked);
			else
				dragonUlti.setTexRegion(Assets.iceDragonSwitch);
			break;
		}
		world.updateWorld(delta);
		renderer.render();
		if(sticked)
			renderer.drawTex(stickToMouse,touchPoint);
		start = true;

		switch (state) {
		case GAME_READY:
			presentReady();
			break;
		case GAME_RUNNING:
			presentRunning();
			break;
		case GAME_PAUSED:
			presentPaused(Gdx.input.getX(), Gdx.input.getY());
			break;
		case GAME_LEVEL_END:
			presentLevelEnd();
			break;
		case GAME_OVER:
			presentGameOver();
			break;
		}
	}

	private void presentGameOver() {
		world.cleanUp();

		if (Gdx.input.isTouched()) {
			game.setScreen(new ScoreScreen(game, player, false,
					World.earthDragonXP, World.fireDragonXP, World.iceDragonXP));
			this.dispose();
		}
		this.dispose();
	}

	private void presentLevelEnd() {
		if (!isHonoured) {
			player.setTotalEnemiesKilled(world.getEnemyCounter());
			player.addCoins(player.getLevel() * 100);

			if (player.getLevel() % 3 == 0)
				player.addGems(1);

			player.addLevel();

			player.setEarthDragonXP(player.getEarthDragonXP()
					+ World.earthDragonXP);
			player.setFireDragonXP(player.getFireDragonXP()
					+ World.fireDragonXP);
			player.setIceDragonXP(player.getIceDragonXP() + World.iceDragonXP);

			game.prefs.putInteger("totalEnemiesKilled",
					player.getTotalEnemiesKilled());
			game.prefs.putInteger("coins", player.getCoins());
			game.prefs.putInteger("gems", player.getGems());
			game.prefs.putInteger("level", player.getLevel());

			game.prefs.putInteger("earthDragonXP", player.getEarthDragonXP());
			game.prefs.putInteger("iceDragonXP", player.getIceDragonXP());
			game.prefs.putInteger("fireDragonXP", player.getFireDragonXP());
			game.prefs.flush();

			isHonoured = true;
		}

		World.win = true;
		world.cleanUp();

		switchTimer+=Gdx.graphics.getDeltaTime();
		if (switchTimer >= 1.5) {
			game.setScreen(new ScoreScreen(game, player, true,
					World.earthDragonXP, World.fireDragonXP, World.iceDragonXP));
			this.dispose();
		}
	}

	private void presentPaused(float x, float y) {
	}

	private void presentRunning() {
		if (World.hp <= 0) {
			this.state = GAME_OVER;
			World.win = false;
			World.levelEnd = true;
		}
		if (world.checkWin()) {
			this.state = GAME_LEVEL_END;
			World.win = true;
			World.levelEnd = true;
		}

		if (World.hp <= 0) {
			World.levelEnd = true;
			this.state = GAME_OVER;
		}

	}

	private void presentReady() {
	}

	@Override
	public boolean keyDown(int keycode) {

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.BACK) {
			this.pause();
			return true;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {

		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		touchPoint.x = screenX;
		touchPoint.y = screenY;

		
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		touchPoint.x = screenX;
		touchPoint.y = screenY;

		renderer.camera.unproject(touchPoint);
		//Gdx.app.log("Info", ""+touchPoint.y+" screenY:"+screenY);
		for(int i=0; i<=lanes.length-2;i++){
			if(touchPoint.y >= lanes[i] && touchPoint.y <= lanes[i+1])
				lane = i;
		}
		if(sticked)
			world.spawnMob(screenX, lanes[lane], stickToMouse.getSpecies(), player.getMobLevelForSpecies(stickToMouse.getSpecies()), lane);
		sticked = false;
		if(table.removeElement(stickToMouse))
			id--;
		return true;
	}

	

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		touchPoint.x = screenX;
		touchPoint.y = screenY;
	//	Gdx.app.log("INFO", "screenX: "+screenX+" screenY: "+screenY);
		renderer.camera.unproject(touchPoint);
		if(table.checkElementTouched(touchPoint) && !sticked)
			for(ClickableElement obj: table.getElements()){
			if(obj.isClicked()){
				this.stickToMouse = new TextureElement(new Rectangle(touchPoint.x, touchPoint.y, 65, 65),obj.getTex(), ((TextureElement) obj).getSpecies());
				this.stickToMouse.setId(id);
				id++;
				if(table.getElementforID(stickToMouse.getId()) == null)
			//		table.addElement(stickToMouse);
				sticked = true;
				obj.setClicked(false);
			}
		}
	//	Gdx.app.log("INFO", "screenX: "+screenX+" screenY: "+screenY+" sticked?: "+sticked);
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {

		return false;
	}

	@Override
	public boolean scrolled(int amount) {

		return false;
	}

}
