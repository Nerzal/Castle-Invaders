package com.noobygames.castleinvaders;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.noobygames.castleinvaders.screens.SplashScreen;

/**@author Tobi**/
public class CastleInvaders extends Game {

	public SpriteBatch batch;
	public BitmapFont font;
	
	public Preferences prefs;

	/**Initialises a font and spritebatcher aswell as the preferences.
	 * finally sets the screen to a new object of Splashscreen**/
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		prefs = Gdx.app.getPreferences("CastleInvaders");
		this.setScreen(new SplashScreen(this));
	}

	public void render() {
		super.render(); // important!
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}

}