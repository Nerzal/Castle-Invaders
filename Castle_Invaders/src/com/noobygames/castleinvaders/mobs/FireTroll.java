package com.noobygames.castleinvaders.mobs;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobygames.castleinvaders.Assets;
import com.noobygames.castleinvaders.GameLiving;
import com.noobygames.castleinvaders.World.Species;

public class FireTroll extends GameLiving {

	public final int TROLL_MOVE_VELOCITY = 15*3;
	public static final float TROLL_WIDTH = 120;
	public static final float TROLL_HEIGHT = 120;

	public float lifeTime;

	public FireTroll(float x, float y, Species species, int mobLevel, int lane) {
		super(x, y, TROLL_WIDTH, TROLL_HEIGHT, species, lane);

		velocity.set(TROLL_MOVE_VELOCITY, 0);
		position.set(x, y);
		setCenterX(position.x + width / 2);
		lifeTime = 0;
		hp = 70 + mobLevel * 5;
		mana = 100;
		isCaster = true;
		isRange = false;
		attackRange = 35; // Der wird am Ende denke mal in Pixeln gezählt
							// werden
		castRange = 400;
		attackSpeed = 1.4f; // 0.4f = Soll 0.4x/sec zuhaun
		maxLivingTime = 35; // Soll : In Sekunden
		damageType = DamageType.fire;
		this.species = com.noobygames.castleinvaders.World.Species.lavaTroll;
		this.mobLevel = mobLevel;
		fireResi = 0.75f;
		iceResi = 0.05f;
		darknessResi = 0.15f;
		slashResi = 0.10f;
		thrustResi = 0.10f;
		crushResi = 0.10f;

	}

	@Override
	public TextureRegion getAnimation() {
		switch (state) {
		case attack:
			return Assets.lta.getKeyFrame(stateTime, true);
		case walk:
			return Assets.ltw.getKeyFrame(stateTime, true);
		case hit:
			return Assets.lth.getKeyFrame(stateTime, true);
		case die:
			return Assets.ltd.getKeyFrame(stateTime, false);
		case rangeAttack:
			return Assets.lta.getKeyFrame(stateTime, true);
		}
		return null;
	}
	
	@Override
	public float getStandartMoveVelocity() {
		return this.TROLL_MOVE_VELOCITY;
	}

}
