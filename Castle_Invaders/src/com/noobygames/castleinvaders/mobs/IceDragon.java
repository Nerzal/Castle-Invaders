package com.noobygames.castleinvaders.mobs;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobygames.castleinvaders.Assets;
import com.noobygames.castleinvaders.GameLiving;
import com.noobygames.castleinvaders.World.Species;
import com.noobygames.castleinvaders.World.States;

public class IceDragon extends GameLiving {

	private final float DRAGON_MOVE_VELOCITY = 15;
	public static float DRAGON_WIDTH = 180;
	public static float DRAGON_HEIGHT = 180;
	public float lifeTime;

	public IceDragon(float x, float y,
			Species species, int mobLevel, int lane) {
		super(x, y, DRAGON_WIDTH, DRAGON_HEIGHT, species, lane);
		velocity.set(DRAGON_MOVE_VELOCITY, 0);
		position.set(x, y);
		setCenterX(position.x + width / 2);
		lifeTime = 0;
		this.mobLevel = mobLevel;

		if (mobLevel <= 4) {
			DRAGON_WIDTH = mobLevel * 50;
			DRAGON_HEIGHT = mobLevel * 50;
			hp = 200 + mobLevel * 10;
			isCaster = false;
			isRange = false;
			attackRange = 35; // Der wird am Ende denke mal in Pixeln gezählt
								// werden
			attackSpeed = 1.2f; // 0.4f = Soll 0.4x/sec zuhaun
			maxLivingTime = 75; // Soll : In Sekunden
			this.species = com.noobygames.castleinvaders.World.Species.iceDragon;
			attackDamage = 30 + mobLevel;
			damageType = DamageType.crush;
			fireResi = 0.15f;
			iceResi = 0.85f;
			darknessResi = 0.25f;
			slashResi = 0.35f;
			thrustResi = 0.35f;
			crushResi = 0.35f;
			bowEquipped = false;
			maxLivingTime = 90;

		}
	}

	@Override
	public void update(float delta) {
		if (target == null && hp > 0)
			state = States.walk;

		if (stateTime >= maxLivingTime || hp <= 0 || position.x >= 1275) {
			state = States.die;
		}

		if (hp > 0)
			switch (state) {
			case walk:
				velocity.set(DRAGON_MOVE_VELOCITY * delta, 0);
				position.add(velocity.x, 0);
				break;
			case hit:
				if (hp <= 0)
					state = States.die;
				else
					state = States.walk;
				break;
			case attack:
				if (target == null || target.state == States.die)
					state = States.walk;
				position.add(0, 0);
				break;
			case run:
				velocity.set((DRAGON_MOVE_VELOCITY + 5), 0);
				position.add(velocity.x, 0);
				break;
			case kwalk:
				velocity.set((DRAGON_MOVE_VELOCITY - 2), 0);
				position.add(velocity.x, 0);
				break;
			}

		else {
			velocity.set(0, 0);
			deadTime += delta;
		}

		setCenterX(position.x + width / 2);
		stateTime += delta;
		lifeTime += stateTime;

	}

	@Override
	public TextureRegion getAnimation() {
		switch (state) {
		case attack:
			return Assets.iceDragonAttack.getKeyFrame(stateTime, true);

		case walk:
			return Assets.iceDragonWalk.getKeyFrame(stateTime, true);

		case hit:
			return Assets.iceDragonHit.getKeyFrame(stateTime, true);

		case die:
			return Assets.iceDragonDie.getKeyFrame(stateTime, false);
		
		case read:
			return Assets.iceDragonSleep.getKeyFrame(stateTime, true);
		}
		return null;
	}
	
	@Override
	public float getStandartMoveVelocity() {
		return this.DRAGON_MOVE_VELOCITY;
	}
}
