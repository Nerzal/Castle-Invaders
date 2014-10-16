package com.noobygames.castleinvaders;

import com.noobygames.castleinvaders.GameLiving.DamageType;
import com.noobygames.castleinvaders.World.Species;
import com.noobygames.castleinvaders.World.States;

/** @author Tobi **/
public class Projectile extends DynamicGameObject {

	private static final float PROJECTILE_WIDTH = 240;
	private static final float PROJECTILE_HEIGHT = 120;
	private static final float PROJECTILE_MOVE_VELOCITY = -20;
	private boolean hitTarget;
	private double attackDamage;
	private DamageType damageType;
	private float stateTime;
	private float hitTimer;
	private GameLiving owner;

	/**
	 * @param x
	 *            PosX
	 * @param y
	 *            PosY
	 * @param width
	 *            width
	 * @param height
	 *            height
	 * @param caster
	 *            The one to "cast" the projectile
	 * @param target
	 *            The Target - Must be a GameLiving/DynamicGameObject
	 * @param arrow
	 *            Species (Enum type)
	 **/
	public Projectile(float x, float y, float width, float height,
			GameLiving caster, GameLiving target, Species arrow) {
		super(x, y, PROJECTILE_WIDTH, PROJECTILE_HEIGHT, arrow);
		velocity.set(PROJECTILE_MOVE_VELOCITY, 0);
		position.set(x, y-height/2);
		setCenterX(position.x + width / 2);
		attackDamage = caster.mobLevel * 5;
		damageType = caster.damageType;
		this.owner = caster;
		hitTarget = false;
		this.target = target;
		setHitTimer(0);
		setStateTime(0);
	}

	
	/**Checks whether the projectile did collide with its target
	 * @return true on collision else false**/
	private boolean checkCollision() {
		if (velocity.x > 0){
			if (getCenterX() >= target.getCenterX())
				return true;
			else
				return false;
		} else if (getCenterX() <= target.getCenterX())
			return true;
		else
			return false;
	}

	
	/** Updates the projectiles position
	 * @param deltaTime Time since last frame**/
	public void update(float deltaTime) {
		if (!isHitTarget()) {
			position.x += velocity.x;
			if (checkCollision()) {
				if (target.harm(attackDamage, damageType, owner)
					 || target.state == States.die) {
					target = null;
				}
				setHitTarget(true);
			}
		} else
			hitTimer += deltaTime;

		setCenterX(position.x + width / 2);

		stateTime += deltaTime;
	}

	/**@return the stateTime**/
	public float getStateTime() {
		return stateTime;
	}

	/**sets the stateTime
	 * the stateTime is the time (in ms) since the last state change
	 * @param stateTime stateTime**/
	public void setStateTime(float stateTime) {
		this.stateTime = stateTime;
	}

	/**returns the time since the target is hit
	 * @return hitTimer**/
	public float getHitTimer() {
		return hitTimer;
	}

	public void setHitTimer(float hitTimer) {
		this.hitTimer = hitTimer;
	}

	public boolean isHitTarget() {
		return hitTarget;
	}

	public void setHitTarget(boolean hitTarget) {
		this.hitTarget = hitTarget;
	}

}
