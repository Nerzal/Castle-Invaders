package com.noobygames.castleinvaders.mobs;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobygames.castleinvaders.Assets;
import com.noobygames.castleinvaders.GameLiving;
import com.noobygames.castleinvaders.World.Species;

/** @author Tobi **/
public class Orc extends GameLiving {
	public final int ORC_MOVE_VELOCITY = -25;
	public static final float ORC_WIDTH = 120;
	public static final float ORC_HEIGHT = 120;

	/**
	 * Constructor for Orc
	 * 
	 * @see class Troll constructor
	 **/
	public Orc(float x, float y, Species species, int mobLevel, int lane) {
		super(x, y, ORC_WIDTH, ORC_HEIGHT, species, lane);
		// TODO Auto-generated constructor stub
		hp = 180 + mobLevel;
		isCaster = false;
		isRange = false;
		attackRange = 35;
		attackSpeed = 1.1f;
		velocity.set(ORC_MOVE_VELOCITY, 0);
		position.set(x, y);
		maxLivingTime = 100000000;
		attackDamage = 40 + mobLevel / 8;
		this.mobLevel = mobLevel;
		fireResi = 0.25f /* mobLevel / 200 */;
		iceResi = 0.25f;
		darknessResi = 0.25f;
		slashResi = 0.25f;
		thrustResi = 0.25f;
		crushResi = 0.25f;
		damageType = DamageType.slash;
		deadTime = 0;
		swingTimer = 0;
		setCenterX(position.x + width / 2);
		bowEquipped = false;
	}

	public TextureRegion getAnimation() {
		switch (state) {
		case attack:
			return Assets.orca.getKeyFrame(stateTime, true);
		case walk:
			return Assets.orcw.getKeyFrame(stateTime, true);
		case run:
			return Assets.orcr.getKeyFrame(stateTime, true);
		case hit:
			return Assets.orch.getKeyFrame(stateTime, true);
		case die:
			return Assets.orcd.getKeyFrame(stateTime, false);
		case kwalk:
			return Assets.orckw.getKeyFrame(stateTime, true);
			/*
			 * case look: return Assets.murlocLook;
			 */

		}
		return null;
	}
	
	@Override
	public float getStandartMoveVelocity() {
		return this.ORC_MOVE_VELOCITY;
	}

}
