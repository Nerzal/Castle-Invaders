package com.noobygames.castleinvaders.mobs;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobygames.castleinvaders.Assets;
import com.noobygames.castleinvaders.GameLiving;
import com.noobygames.castleinvaders.World.Species;

public class IceTroll extends GameLiving {
	public final int TROLL_MOVE_VELOCITY = 30;
	public static final float TROLL_WIDTH = 120;
	public static final float TROLL_HEIGHT = 120;

	public float lifeTime;
	
	
	public IceTroll(float x, float y, Species species, int mobLevel, int lane) {
		super(x, y, TROLL_WIDTH, TROLL_HEIGHT, species, lane);
		velocity.set(TROLL_MOVE_VELOCITY, 0);
		position.set(x, y);
		setCenterX(position.x + width/2);
		lifeTime = 0;
		
		hp = 80 + mobLevel * 5;
		mana = 100;
		isCaster = true;
		isRange = false;
		attackRange = 35; // Der wird am Ende denke mal in Pixeln gezählt
							// werden
		castRange = 300;
		attackSpeed = 1.3f; // 0.4f = Soll 0.4x/sec zuhaun
		maxLivingTime = 50; // Soll : In Sekunden
		damageType = DamageType.ice;
		this.species = com.noobygames.castleinvaders.World.Species.iceTroll;
		this.mobLevel = mobLevel;
		fireResi = 0.05f;
		iceResi = 0.75f;
		darknessResi = 0.15f;
		slashResi = 0.10f;
		thrustResi = 0.10f;
		crushResi = 0.10f;
	}

	@Override
	public TextureRegion getAnimation() {
		switch (state) {
		case attack:
				return Assets.ita.getKeyFrame(stateTime, true);
		case walk:
				return Assets.itw.getKeyFrame(stateTime, true);
		case hit:
				return Assets.ith.getKeyFrame(stateTime, true);
		case die:
				return Assets.itd.getKeyFrame(stateTime, false);
		case rangeAttack:
				return Assets.ita.getKeyFrame(stateTime, true);
		}
		return null;
	}
	
	@Override
	public float getStandartMoveVelocity() {
		return this.TROLL_MOVE_VELOCITY;
	}

}
