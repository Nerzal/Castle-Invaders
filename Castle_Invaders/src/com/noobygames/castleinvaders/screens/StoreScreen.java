package com.noobygames.castleinvaders.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.noobgygames.castleinvaders.ui.StoreElement;
import com.noobygames.castleinvaders.Assets;
import com.noobygames.castleinvaders.CastleInvaders;
import com.noobygames.castleinvaders.Player;
import com.noobygames.castleinvaders.store.Store;
import com.noobygames.castleinvaders.store.StoreObject;
import com.noobygames.utils.exceptions.OutOfBoundingException;
import com.noobygames.utils.ui.ClickableElement;
import com.noobygames.utils.ui.Table;
import com.noobygames.utils.ui.Text;

public class StoreScreen extends Store implements Screen, InputProcessor {

	private OrthographicCamera camera;
	private final CastleInvaders game;
	private Store store;
	private Table table;

	public StoreScreen(CastleInvaders game, OrthographicCamera camera,
			Player player) {
		super(player);
		this.store = new Store(player);
		this.camera = camera;
		this.game = game;
		table = new Table(new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), Assets.window);
		if (store.getItems() != null)
			for (StoreObject obj : store.getItems()) {
				try {
					table.addElement(new StoreElement(new Rectangle(200 * table
							.getElements().size, 100 * table.getElements().size,
							80, 80), Assets.window, obj));
				} catch (OutOfBoundingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		//game.font.scale(3);

	}

	@Override
	public void render(float delta) {
		game.batch.begin();
		game.batch.draw(Assets.menuBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		game.font.draw(game.batch, "Store", 500, 750);
		table.draw(game.batch);
		game.batch.end();

		if (Gdx.input.justTouched()) {
			game.setScreen(new MainMenuScreen(game, player));
			this.dispose();
		}

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return false;
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
