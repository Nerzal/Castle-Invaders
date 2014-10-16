package com.noobygames.castleinvaders.mobs;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobygames.castleinvaders.Assets;
import com.noobygames.castleinvaders.GameLiving;
import com.noobygames.castleinvaders.World.Species;

public class FireDragon extends GameLiving {

	private final float DRAGON_MOVE_VELOCITY = 15;
	public static float DRAGON_WIDTH = 180;
	public static float DRAGON_HEIGHT = 180;
	public float lifeTime;

	public FireDragon(float x, float y, Species species, int mobLevel, int lane) {
		super(x, y, DRAGON_WIDTH, DRAGON_HEIGHT, species, lane);
		velocity.set(DRAGON_MOVE_VELOCITY, 0);
		position.set(x, y);
		setCenterX(position.x + width / 2);
		lifeTime = 0;
		this.mobLevel = mobLevel;

			hp = 200 + mobLevel * 10;
			isCaster = false;
			isRange = false;
			attackRange = 35; // Der wird am Ende denke mal in Pixeln gezählt
								// werden
			attackSpeed = 1.2f; // 0.4f = Soll 0.4x/sec zuhaun
			maxLivingTime = 75; // Soll : In Sekunden
			this.species = com.noobygames.castleinvaders.World.Species.fireDragon;
			attackDamage = 30 + mobLevel;
			damageType = DamageType.crush;
			fireResi = 0.85f;
			iceResi = 0.15f;
			darknessResi = 0.25f;
			slashResi = 0.35f;
			thrustResi = 0.35f;
			crushResi = 0.35f;
			maxLivingTime = 90;

			bowEquipped = false;
		

	}

	@Override
	public TextureRegion getAnimation() {
		switch (state) {
		case attack:
				return Assets.fireDragonAttack.getKeyFrame(stateTime, true);
				
		case walk:
				return Assets.fireDragonWalk.getKeyFrame(stateTime, true);
			
		case hit:
				return Assets.fireDragonHit.getKeyFrame(stateTime, true);
			
		case die:
				return Assets.fireDragonDie.getKeyFrame(stateTime, false);
				
		case sleep: 
				return Assets.fireDragonSleep.getKeyFrame(stateTime, true);
			}
		return null;
	}
	
	@Override
	public float getStandartMoveVelocity() {
		return this.DRAGON_MOVE_VELOCITY;
	}

}
