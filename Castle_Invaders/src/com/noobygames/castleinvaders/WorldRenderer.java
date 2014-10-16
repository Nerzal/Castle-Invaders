package com.noobygames.castleinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.noobgygames.castleinvaders.ui.TextureElement;
import com.noobygames.castleinvaders.World.Species;
import com.noobygames.castleinvaders.World.States;
import com.noobygames.nerzal.castleinvaders.spells.Spells;
import com.noobygames.utils.ui.Table;

/** @author Tobi **/
public class WorldRenderer {

	static final float FRUSTUM_WIDTH = 1280;
	static final float FRUSTUM_HEIGTH = 768;
	final CastleInvaders game;
	public WorldRenderer renderer;
	World world;
	private TextureRegion keyFrame;
	States state;
	Species species;
	BitmapFont font;
	public OrthographicCamera camera;
	private Player player;
	private Table table;

	public WorldRenderer(World world, final CastleInvaders gam, Player player,
			Table table) {
		this.world = world;
		game = gam;
		Assets.load(game);
		font = new BitmapFont();
		font.setScale(3);
		this.player = player;
		this.table = table;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, FRUSTUM_WIDTH, FRUSTUM_HEIGTH);
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

	}

	public void render() {
		Gdx.gl.glEnable(GL20.GL_TEXTURE_2D);
		renderBackground();
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_ONE, GL20.GL_ONE_MINUS_SRC_ALPHA);
		game.batch.begin();

		renderMobs(World.mobs);
		renderMobs(World.enemyEntities);
		renderSpells(World.spells);
		renderProjectiles(World.projectiles);
		// renderGui();
		renderTable();
		if (World.win && World.levelEnd)
			drawWin();
		else if (!World.win && World.levelEnd)
			drawWin();
		// drawGolemSelection(x,y);
		font.draw(game.batch, "Level:" + player.getLevel(), 70, 695);
		font.draw(game.batch, "Mana: " + Math.round(world.mana) + "/"
				+ (int) world.maxMana, 70, 730);
		font.draw(game.batch, "HP: " + World.hp + "/100", 70, 765);
		game.batch.end();

	}

	private void renderTable() {
		table.draw(game.batch);
	}

	private void renderProjectiles(Array<Projectile> projectiles) {
		for (Projectile obj : projectiles) {
			if (!obj.isHitTarget()) {
				switch (obj.species) {
				default:
					if (!obj.isHitTarget())
						game.batch.draw(Assets.arrow, obj.getCenterX(),
								obj.position.y, 30, 60);
					break;
				}
			}
		}

	}

	private void renderSpells(Array<Spells> spells) {
		for (Spells i : spells) {
			try {
				switch (i.getSpell()) {
				case fireBolt:
					if (!i.isHitTarget()) {
						keyFrame = Assets.fireBolt.getKeyFrame(
								i.getStateTime(), true);
						game.batch.draw(keyFrame, i.position.x, i.position.y,
								25, 25);

						keyFrame = Assets.sparklets.getKeyFrame(
								i.getStateTime(), true);
						game.batch.draw(keyFrame, i.getCenterX(), i.position.y,
								30, 30);
						break;
					} else {
						keyFrame = Assets.fireBolt.getKeyFrame(
								i.getStateTime(), true);
						if (i.getTarget() != null)
							game.batch.draw(keyFrame, i.getTarget()
									.getCenterX(), i.position.y, 35, 35);
						break;
					}
				case grumblingIce:
					if (!i.isHitTarget()) {
						keyFrame = Assets.grumblingIce.getKeyFrame(
								i.getStateTime(), true);
						game.batch.draw(keyFrame, i.position.x,
								i.position.y + 10, 100, 90);
						break;
					} else {
						keyFrame = Assets.iceSpike;
						if (i.getTarget() != null)
							game.batch.draw(keyFrame, i.getTarget().position.x,
									i.getTarget().position.y, 60, 130);
					}
					break;
				}

			} catch (IndexOutOfBoundsException e) {
				System.out
						.println("Indezes for Spells ran out of exceptions!! Oh noes!");
			}
		}
	}

	/**
	 * This function draws every element depending on the species of the 2 lists
	 * onto the framebuffer
	 * 
	 * @param mobs
	 *            List of DynamicGameObjects (mobs) to render
	 * **/
	private void renderMobs(Array<GameLiving> mobs) {
		for (GameLiving mob : mobs) {
			if (mob.getAnimation() == null)
				Gdx.app.log("Null", mob.toString());
			game.batch.draw(mob.getAnimation(), mob.position.x, mob.position.y,	mob.width, mob.height);
		}
	}

	private void renderBackground() {
		game.batch.begin();
		game.batch.draw(Assets.background, 0, 0);
		game.batch.end();

	}

	public void setSize(int width, int height) {
		// TODO Auto-generated method stub

	}

	public void drawGolemSelection(int x, int y) {
		Gdx.gl.glEnable(GL20.GL_TEXTURE_2D);
		game.batch.begin();
		game.batch.draw(Assets.golemSelectionRegion, x, y);
		game.batch.end();

	}

	public void drawWin() {
		Gdx.gl.glEnable(GL20.GL_TEXTURE_2D);
		game.batch.draw(Assets.window, 60, 60, 1160, 648);
		font.draw(game.batch, "Tap to continue", 370, 250);
	}

	public void drawTex(TextureElement stickToMouse, Vector3 touchPoint) {
		game.batch.begin();
		game.batch.draw(stickToMouse.getTex(), touchPoint.x, touchPoint.y, 65,
				65);
		game.batch.end();

	}

}
