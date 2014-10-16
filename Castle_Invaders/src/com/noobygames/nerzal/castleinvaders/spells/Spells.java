package com.noobygames.nerzal.castleinvaders.spells;

import com.badlogic.gdx.math.Rectangle;
import com.noobygames.castleinvaders.DynamicGameObject;
import com.noobygames.castleinvaders.GameLiving;
import com.noobygames.castleinvaders.GameLiving.DamageType;
import com.noobygames.castleinvaders.World.Species;
import com.noobygames.castleinvaders.World.States;

/** @author Tobi **/
public class Spells extends DynamicGameObject {

	protected float lifeTime;
	protected float spellDuration;
	protected boolean isDot;
	protected GameLiving caster;
	protected GameLiving target;
	private Spell spell;
	protected int attackDamage;
	protected float stateTime;
	protected int spellLevel;
	protected DamageType damageType;
	private boolean hitTarget;
	private float hitTimer;

	public enum Spell {
		fireBolt, grumblingIce//, burning
	};

	/**
	 * Default constructor of Spells
	 * 
	 * @param x
	 *            lower left corner
	 * @param y
	 *            lower left corner
	 * @param width
	 *            width
	 * @param height
	 *            height
	 * @param caster
	 *            Casting mob
	 * @param target
	 *            the spells target
	 * @param spell
	 *            e-num Inhabits the specific spell name, like fireBolt or
	 *            grumblingIce
	 **/
	public Spells(float x, float y, float width, float height,
			GameLiving caster, GameLiving target, Spell spell) {
		super(x, y, width, height, Species.spell);
		position.set(x, y);
		lifeTime = 0;
		this.caster = caster;
		this.setTarget(target);
		this.setSpell(spell);
		stateTime = 0;
		setHitTarget(false);
		setHitTimer(0.0f);

		switch (spell) {
		case fireBolt:
			hitRange = 0;
			attackDamage = 30;
			damageType = DamageType.fire;
			isDot = true;
			velocity.set(15, 0);
			break;
		case grumblingIce:
			hitRange = 0;
			attackDamage = 20;
			damageType = DamageType.ice;
			isDot = false;
			velocity.set(15, 0);
		default:
			break;
		}
		setCenterX(position.x + width / 2);

	}

	public Spells(Rectangle bounds) {
		super(bounds);
	}

	/**Checks if the Spell has hit its target
	 * @return true if hit**/
	private boolean checkCollision() {
		if(getCenterX() >= getTarget().getCenterX())
			return true;
		else
			return false;
	}

	/**
	 * updates position calls target.harm(), when in hitRange
	 * 
	 * @param deltaTime
	 *            Time since last frame
	 */
	public void update(float deltaTime) {
		if (!isHitTarget()) {
			position.x += velocity.x;
			if (checkCollision()) {
				checkForSpellEffects();
				if (getTarget().harm(attackDamage, damageType, caster) || getTarget().state == States.die) {
					setTarget(null);
				}
				setHitTarget(true);
				//Assets.fireBallHit.play((float) 0.3);
				//Assets.fireBallHit.play();
			}
		} else 
		setHitTimer(getHitTimer() + deltaTime);
		
		setCenterX(position.x + width/2);
	
		stateTime += deltaTime;
	}

	private void checkForSpellEffects() { //TODO write a prettier method!
		switch(this.spell){
		case fireBolt: 
			if(!target.condition.contains(Condition.dot, true))
				target.addSpellEffect(new Burning(this.bounds.getX(), this.bounds.getY(), this.bounds.getWidth(), this.bounds.getHeight(), caster, target, Spell.fireBolt));
			break;
		case grumblingIce:
			if(!target.condition.contains(Condition.root, true))
				target.addSpellEffect(new Freeze(this.bounds.getX(), this.bounds.getY(), this.bounds.getWidth(), this.bounds.getHeight(), caster, target, Spell.grumblingIce));
			break;
		default:
			break;
		}
	}

	public float getStateTime() {
		return stateTime;
	}

	/**
	 * @return the target
	 */
	public GameLiving getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(GameLiving target) {
		this.target = target;
	}

	/**
	 * @return the hitTimer
	 */
	public float getHitTimer() {
		return hitTimer;
	}

	/**
	 * @param hitTimer the hitTimer to set
	 */
	public void setHitTimer(float hitTimer) {
		this.hitTimer = hitTimer;
	}

	/**
	 * @return the hitTarget
	 */
	public boolean isHitTarget() {
		return hitTarget;
	}

	/**
	 * @param hitTarget the hitTarget to set
	 */
	public void setHitTarget(boolean hitTarget) {
		this.hitTarget = hitTarget;
	}

	/**
	 * @return the spell
	 */
	public Spell getSpell() {
		return spell;
	}

	/**
	 * @param spell the spell to set
	 */
	public void setSpell(Spell spell) {
		this.spell = spell;
	}

}
