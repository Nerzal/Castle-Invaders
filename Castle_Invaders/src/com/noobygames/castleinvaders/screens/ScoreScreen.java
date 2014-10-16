package com.noobygames.castleinvaders.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.noobygames.castleinvaders.Assets;
import com.noobygames.castleinvaders.CastleInvaders;
import com.noobygames.castleinvaders.Player;

public class ScoreScreen implements Screen, InputProcessor {

	private CastleInvaders game;
	private Player player;
	private OrthographicCamera camera;
	static final float FRUSTUM_WIDTH = 1280;
	static final float FRUSTUM_HEIGTH = 768;
	private boolean wonLastRound;
	private int earthDragonXP;
	private int fireDragonXP;
	private int iceDragonXP;
	private int touched = 0;
	private Vector2 touchpoint;
	private float timer;

	public ScoreScreen(CastleInvaders game, Player player, Boolean win,
			int earthDragonXP, int fireDragonXP, int iceDragonXP){
		this.game = game;
		this.player = player;
		wonLastRound = win;
		this.earthDragonXP = earthDragonXP;
		this.fireDragonXP = fireDragonXP;
		this.iceDragonXP = iceDragonXP;
		touchpoint = new Vector2();

		game.font.scale(3);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, FRUSTUM_WIDTH, FRUSTUM_HEIGTH);
	}

	@Override
	public void render(float delta) {
		game.batch.begin();
		Gdx.gl.glEnable(GL20.GL_TEXTURE_2D);

		if (touchpoint.x >= -200)
			touched++;

		if (touched >= 2 && timer > 3) {
			game.setScreen(new MainMenuScreen(game, player));
			this.dispose();
		}

		else if (wonLastRound && timer < 6 && timer >= 3)
			drawDragonXP();

		else if (wonLastRound) {
			game.batch.draw(Assets.menuBackground, 0, 0, 1280, 768);
			game.batch.draw(Assets.window, 60, 60, 1160, 648);
			game.font.draw(game.batch, "You won!", 370, 600);
			game.font.draw(game.batch,
					"Coins earned: " + game.prefs.getInteger("level") * 100,
					370, 560);
			if (player.getLevel() % 3 == 0)
				game.font.draw(game.batch, "Gems earned: 1", 370, 520);
			game.font.draw(game.batch,
					"Total Coins: " + game.prefs.getInteger("coins"), 370, 480);
			game.font.draw(game.batch,
					"Total Gems: " + game.prefs.getInteger("gems"), 370, 440);
			game.font.draw(game.batch, "Tap to continue", 370, 250);
		}

		else {
			game.batch.draw(Assets.menuBackground, 0, 0);
			game.batch.draw(Assets.window, 60, 60, 1160, 648);
			game.font.draw(game.batch, "You have been defeated!", 370, 600);
			game.font.draw(game.batch, "Total Coins: " + player.getCoins(),
					370, 490);
			game.font.draw(game.batch, "Total Gems: " + player.getGems(), 370,
					450);
			game.font.draw(game.batch, "Tap to continue", 370, 250);
		}

		timer += Gdx.graphics.getDeltaTime();
		game.batch.end();
	}

	private void drawDragonXP() {
		game.batch.draw(Assets.menuBackground, 0, 0, 1280, 768);
		game.batch.draw(Assets.window, 60, 60, 1160, 648);
		game.font.draw(game.batch, "Firedragon XP earned: " + fireDragonXP,
				100, 500);
		game.font.draw(game.batch,
				"Total Firedragon XP: " + player.getFireDragonXP(), 100, 460);
		game.font.draw(game.batch, "Icedragon XP earned: " + iceDragonXP, 100,
				400);
		game.font.draw(game.batch,
				"Total Icedragon XP: " + player.getIceDragonXP(), 100, 360);
		game.font.draw(game.batch, "Earthdragon XP earned: " + earthDragonXP,
				100, 300);
		game.font.draw(game.batch,
				"Total Earthdragon XP: " + player.getEarthDragonXP(), 100, 260);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(this);
		Gdx.input.setCatchBackKey(true);
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);

	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		touchpoint.x = screenX;
		touchpoint.y = screenY;
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
