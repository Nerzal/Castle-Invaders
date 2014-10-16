package com.noobygames.castleinvaders.mobs;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobygames.castleinvaders.Assets;
import com.noobygames.castleinvaders.GameLiving;
import com.noobygames.castleinvaders.World.Species;

/** @author Tobi **/
public class GreyTroll extends GameLiving{

	public final int TROLL_MOVE_VELOCITY = 15;
	public static final float TROLL_WIDTH = 120;
	public static final float TROLL_HEIGHT = 120;

	public float lifeTime;

	/**
	 * Constructor needs posX, posY and Species standart state is "walk"
	 * 
	 * @param x
	 *            posX of the Troll
	 * @param y
	 *            posY of the Troll
	 * @param species
	 *            Enum indicates, what kinda mob it is
	 **/
	public GreyTroll(float x, float y, Species species, int mobLevel, int lane) {
		super(x, y, TROLL_WIDTH, TROLL_HEIGHT, species, lane);
		// state = States.walk;
		velocity.set(TROLL_MOVE_VELOCITY, 0);
		position.set(x, y);
		setCenterX(position.x + width/2);
		lifeTime = 0;

			hp = 150 + mobLevel * 15;
			isCaster = false;
			isRange = false;
			attackRange = 35; // Der wird am Ende denke mal in Pixeln gezählt
								// werden
			attackSpeed = 1.2f; // 0.4f = Soll 0.4x/sec zuhaun
			maxLivingTime = 75; // Soll : In Sekunden
			this.species = com.noobygames.castleinvaders.World.Species.greyTroll;
			attackDamage = 30 + mobLevel;
			this.mobLevel = mobLevel;
			damageType = DamageType.crush;
			fireResi = 0.15f;
			iceResi = 0.15f;
			darknessResi = 0.15f;
			slashResi = 0.35f;
			thrustResi = 0.35f;
			crushResi = 0.35f;
	
			bowEquipped = false;
		
	}

	@Override
	public TextureRegion getAnimation() {
		switch (state) {
		case attack:
				return Assets.gta.getKeyFrame(stateTime, true);
				
		case walk:
				return Assets.gtw.getKeyFrame(stateTime, true);
			
		case hit:
				return Assets.gth.getKeyFrame(stateTime, true);
			
		case die:
				return Assets.gtd.getKeyFrame(stateTime, false);
		}
		return null;
	}
	
	@Override
	public float getStandartMoveVelocity() {
		return this.TROLL_MOVE_VELOCITY;
	}
}