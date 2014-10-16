package com.noobygames.castleinvaders.mobs;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobygames.castleinvaders.Assets;
import com.noobygames.castleinvaders.GameLiving;
import com.noobygames.castleinvaders.World.Species;

public class EarthDragon extends GameLiving{

	private final float DRAGON_MOVE_VELOCITY = 20;
	public static float DRAGON_WIDTH = 180;
	public static float DRAGON_HEIGHT = 180;
	public float lifeTime;


	public EarthDragon(float x, float y,
			Species species, int mobLevel, int lane) {
		super(x, y, DRAGON_WIDTH, DRAGON_HEIGHT, species, lane);
		velocity.set(DRAGON_MOVE_VELOCITY, 0);
		position.set(x, y);
		setCenterX(position.x + width / 2);
		lifeTime = 0;
		this.mobLevel = mobLevel;
		
		if(mobLevel <= 4){
			DRAGON_WIDTH = mobLevel * 50;
			DRAGON_HEIGHT = mobLevel * 50;
		}
		
			hp = 300 + mobLevel * 15;
			isCaster = false;
			isRange = false;
			attackRange = 35;
			attackSpeed = 1.2f; 
			maxLivingTime = 75; 
			this.species = com.noobygames.castleinvaders.World.Species.earthDragon;
			attackDamage = 30 + mobLevel;

			damageType = DamageType.crush;
			fireResi = 0.25f;
			iceResi = 0.25f;
			darknessResi = 0.25f;
			slashResi = 0.45f;
			thrustResi = 0.45f;
			crushResi = 0.45f;
			
			maxLivingTime = 90;
	
		bowEquipped = false;

	}


	@Override
	public TextureRegion getAnimation() {
		switch (state) {
		case attack:
				return Assets.earthDragonAttack.getKeyFrame(stateTime, true);
		case walk:
				return Assets.earthDragonWalk.getKeyFrame(stateTime, true);
		case hit:
				return Assets.earthDragonHit.getKeyFrame(stateTime, true);
		case die:
				return Assets.earthDragonDie.getKeyFrame(stateTime, false);
		case read: 
				return Assets.earthDragonRead.getKeyFrame(stateTime, true);
			}
		return null;
	}


	@Override
	public float getStandartMoveVelocity() {
		return this.DRAGON_MOVE_VELOCITY;
	}

}
