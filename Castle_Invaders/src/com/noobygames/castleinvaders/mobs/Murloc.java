package com.noobygames.castleinvaders.mobs;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobygames.castleinvaders.Assets;
import com.noobygames.castleinvaders.GameLiving;
import com.noobygames.castleinvaders.World.Species;

public class Murloc extends GameLiving {

	private static final float MURLOC_WIDTH = 120;
	private static final float MURLOC_HEIGHT = 120;
	private final float MURLOC_MOVE_VELOCITY = -25;
	public float lifeTime;
	
	public Murloc(float x, float y,
			Species species, int mobLevel, int lane) {
		super(x, y, MURLOC_WIDTH, MURLOC_HEIGHT, species, lane);
		velocity.set(MURLOC_MOVE_VELOCITY, 0);
		position.set(x, y);
		setCenterX(position.x + width/2);
		lifeTime = 0;
		
		hp = 100 + mobLevel * 10;
		isCaster = false;
		isRange = true;
		attackRange = 35; // Der wird am Ende denke mal in Pixeln gezählt
							// werden
		attackSpeed = 1.2f; // 0.4f = Soll 0.4x/sec zuhaun
		maxLivingTime = 75; // Soll : In Sekunden
		this.species = com.noobygames.castleinvaders.World.Species.murloc;
		attackDamage = 30 + mobLevel;
		this.mobLevel = mobLevel;
		damageType = DamageType.crush;
		fireResi = 0.25f;
		iceResi = 0.25f;
		darknessResi = 0.25f;
		slashResi = 0.35f;
		thrustResi = 0.35f;
		crushResi = 0.35f;
		bowEquipped = false;
	}

	@Override
	public TextureRegion getAnimation() {
		switch (state) {
		case attack:
			return Assets.murlocAttack.getKeyFrame(stateTime, true);
		case walk:
			return Assets.murlocWalk.getKeyFrame(stateTime, true);
		case run:
			return Assets.murlocRunning.getKeyFrame(stateTime, true);
		case hit:
			return Assets.murlocHit.getKeyFrame(stateTime, true);
		case die:
			return Assets.murlocDie.getKeyFrame(stateTime, false);
	/*	case look:
			return Assets.murlocLook;*/

		}
		return null;
	}
	
	@Override
	public float getStandartMoveVelocity() {
		return this.MURLOC_MOVE_VELOCITY;
	}

}
