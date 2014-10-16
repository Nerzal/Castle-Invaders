package com.noobygames.castleinvaders.mobs;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobygames.castleinvaders.Assets;
import com.noobygames.castleinvaders.GameLiving;
import com.noobygames.castleinvaders.World.Species;

public class Skeleton extends GameLiving {

	public final float SKELETON_MOVE_VELOCITY = -25;
	public static final float SKELETON_WIDTH = 120;
	public static final float SKELETON_HEIGHT = 120;
	public float lifeTime;

	public Skeleton(float x, float y, Species species, int mobLevel, int lane) {
		super(x, y, SKELETON_WIDTH, SKELETON_HEIGHT, species, lane);
		
		velocity.set(SKELETON_MOVE_VELOCITY, 0);
		position.set(x, y);
		setCenterX(position.x + width / 2);
		
		lifeTime = 0;
		hp = 100 + mobLevel;
		
		this.species = com.noobygames.castleinvaders.World.Species.skeleton;
		this.mobLevel = mobLevel;
		attackDamage = 30 + mobLevel;
		damageType = DamageType.thrust;
		
		bowEquipped = true;
		isCaster = false;
		isRange = true;
		
		attackRange = 35; 
		bowRange = 450;
		attackSpeed = 2.0f; 
		maxLivingTime = 100000;
	
		fireResi = 0.05f;
		iceResi = 0.25f;
		darknessResi = 0.55f;
		slashResi = 0.15f;
		thrustResi = 0.15f;
		crushResi = 0.15f;
	}

	@Override
	public TextureRegion getAnimation() {
		switch (state) {
		case attack:
			return Assets.swordSkeletonAttack.getKeyFrame(stateTime, true);
		case rangeAttack:
			return Assets.bowSkeletonShoot.getKeyFrame(stateTime, true);
		case walk:
			if (!bowEquipped)
				return Assets.swordSkeletonWalk.getKeyFrame(stateTime, true);
			else
				return Assets.bowSkeletonWalk.getKeyFrame(stateTime, true);
		case run:
			if (!bowEquipped)
				return Assets.swordSkeletonRun.getKeyFrame(stateTime, true);
			else
				return Assets.bowSkeletonRun.getKeyFrame(stateTime, true);
		case hit:
			if (!bowEquipped)
				return Assets.swordSkeletonHit.getKeyFrame(stateTime, true);
			else
				return Assets.bowSkeletonHit.getKeyFrame(stateTime, true);
		case die:
			if (!bowEquipped)
				return Assets.swordSkeletonDie.getKeyFrame(stateTime, false);
			else
				return Assets.bowSkeletonDie.getKeyFrame(stateTime, false);

		}
		return null;
	}
	
	@Override
	public float getStandartMoveVelocity() {
		return this.SKELETON_MOVE_VELOCITY;
	}

}
