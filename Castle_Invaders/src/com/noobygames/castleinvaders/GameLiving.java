package com.noobygames.castleinvaders;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.noobygames.castleinvaders.World.Species;
import com.noobygames.castleinvaders.World.States;
import com.noobygames.nerzal.castleinvaders.spells.SpellEffect;
import com.noobygames.nerzal.castleinvaders.spells.Spells;
import com.noobygames.nerzal.castleinvaders.spells.Spells.Spell;

/**
 * Superclass for all "living" entities in the game. extends DynamicGameObject
 * 
 * @author Tobi
 **/
public abstract class GameLiving extends DynamicGameObject {

	public Array<Condition> condition;
	public float conditionTimer;

	public float deadTime = 0;

	public int hp;
	public int mana;
	public int lane;
	/** melee attack range */
	public int attackRange;

	public int attackDamage;
	public int castRange;

	public int bowRange;
	public float attackSpeed;
	public DamageType damageType;

	protected float fireResi;
	protected float iceResi;
	protected float darknessResi;
	protected float slashResi;
	protected float thrustResi;
	protected float crushResi;

	protected float stateTime;
	protected float maxLivingTime;
	protected float swingTimer;
	protected boolean isCaster;
	protected boolean isRange;
	public int mobLevel;
	public boolean inCombat;
	protected ArrayList<SpellEffect> spellEffects;
	protected Vector2 standartVelocity;

	protected float iceImmunityTimer;
	public float inCombatTimer;
	public float rootResistTimer = 0;

	protected boolean bowEquipped;
	float height;
	private float hitStateTimer;

	/** enumtype including all damagetypes in the game **/
	public enum DamageType {
		slash, thrust, crush, fire, ice, bleed, darkness
	};

	public GameLiving(float x, float y, float width, float height,
			Species species, int lane) {
		super(x, y, width, height, species);
		state = States.walk;
		stateTime = 0;
		swingTimer = 0;
		target = null;
		this.height = height;
		inCombatTimer = 0;
		this.lane = lane;
		this.spellEffects = new ArrayList<SpellEffect>();
		this.condition = new Array<Condition>();
		this.standartVelocity = new Vector2();
		this.hitStateTimer = 0.3f;
	}

	/**
	 * This method harms the GameLiving. The Calculation uses the raw damage,
	 * damageType and the specific defensive stats like resistances etc. to harm
	 * the mob. Clears the attackers target, if this was killed
	 * 
	 * @param damage
	 *            The amount of raw damage you wanna deal
	 * @param damageType
	 *            enum for resistance calculation
	 * @param attacker
	 *            The GameLiving which blew the strike, did cast the spell or
	 *            shot the arrow
	 * @return true if the mob was killed else false
	 **/
	public boolean harm(double damage, DamageType damageType,
			GameLiving attacker) {
		if (hp > 0) {
			hp -= damage * this.getResistance(damageType);
			inCombat = true;
			state = States.hit;
		}

		if (hp <= 0 && state != States.die) {
			checkDragonXP(attacker);
			attacker.target = null;
			return true;
		} else
			return false;

	}

	/**
	 * This methodes returns the Resistance of a GameLiving against the given
	 * damageType
	 * 
	 * @param type
	 *            enum-DamageType like slash,thrust etc
	 * @return the resistance
	 */
	protected float getResistance(DamageType type) {
		switch (type) {
		case slash:
			return slashResi;
		case thrust:
			return thrustResi;
		case crush:
			return crushResi;
		case fire:
			return fireResi;
		case ice:
			return iceResi;
		case darkness:
			return darknessResi;
		default:
			return 0;
		}
	}

	/** Grants dragonXP **/
	private void checkDragonXP(GameLiving attacker) {
		if (attacker.species == Species.earthDragon)
			World.addEarthDragonXP(1);
		else if (attacker.species == Species.fireDragon)
			World.addFireDragonXP(1);
		else if (attacker.species == Species.iceDragon)
			World.addFireDragonXP(1);

	}

	/**
	 * Adds a Spell to the spellList on the casters position depending on the
	 * species
	 * 
	 * @return true if a spell was added to the ArrayList
	 **/
	private boolean castSpell() {
		switch (species) {
		case lavaTroll:
			World.spells.add(new Spells(position.x + 40, position.y + 40, 35,
					35, this, target, Spell.fireBolt)); // ArrayList.add Method
														// returns true if an
														// object was added
			return true;
		case iceTroll:
			World.spells.add(new Spells(position.x + 40, position.y, 60, 40,
					this, target, Spell.grumblingIce));
			return false;
		default:
			return false;
		}
	}

	/**
	 * Calls harm method if the swingTimer is == 0, also sets state to attack
	 * for melee & cast and rangeAttack for normal range attacks When melee the
	 * target is set to 0 if it was killed. Also sets inCombat to true
	 * 
	 * @see castSpell() for casts
	 * @see shotArrow() for other ranged attacks
	 * @see inRange() for rangeCheck
	 * @see harm() for the actual damaging
	 * **/
	public void attackTarget() {
		if (target != null && target.hp > 0 && inRange(target)) {
			if (swingTimer == 0) {
				if (isCaster && state != States.hit) { // Mob is caster and not
														// attacked
					castSpell();
					state = States.attack;
					inCombat = true;
					swingTimer = attackSpeed;
				} else if (isRange && bowEquipped && !inCombat) { // Mob is
																	// ranged
																	// and not
																	// in combat
					shotArrow();
					state = States.rangeAttack;
					swingTimer = attackSpeed;

				} else if (target.harm(attackDamage, damageType, this)
						|| target.hp < 0) { // Mob is melee, if enemy dies the
											// target is null
					target = null;
					swingTimer = attackSpeed;
				}
			}
		}
	}

	/**
	 * Adds a projectile from type arrow to the projectile list
	 * 
	 * @return True if a projectile was successfully added to the list
	 **/
	private boolean shotArrow() {
		World.projectiles.add(new Projectile(position.x + width / 2, position.y
				+ height / 2, 30, 30, this, target, Species.arrow));
		return true;
	}

	/**
	 * Sets targets to the GameLiving if it is in attackRange
	 * 
	 * @see inRange() for the range check
	 * @param enemy
	 *            The target, must be a GameLiving
	 * **/
	public boolean setTarget(GameLiving enemy) {
		if (lane != enemy.lane || enemy.state == States.die)
			return false;
		else {
			target = enemy;
			return true;
		}

	}

	/**
	 * Checks if the second gameliving is in the attack range of the first one
	 * 
	 * @param target
	 * 
	 * @return true if a target was set
	 **/
	protected boolean inRange(GameLiving orc) {
		if (isCaster)
			return castRange >= Math.abs(getCenterX() - orc.getCenterX());
		else if (isRange)
			return bowRange >= Math.abs(getCenterX() - orc.getCenterX());
		else
			return attackRange >= Math.abs(getCenterX() - orc.getCenterX());

	}

	/**
	 * Checks if an enemy mob is about to invade the players realm! An enemy mob
	 * invades the players realm, when its x-position (left border) is <= 20
	 * 
	 * @return true if an enemy mob did invade the players realm else false
	 */
	private boolean checkInvade() {
		if (velocity.x < 0 && position.x <= 20)
			if (state == States.walk || state == States.run
					|| state == States.kwalk && state != States.die) {
				World.hp -= 10;
				state = States.die;
				return true;

			}
		return false;
	}

	/**
	 * Equips the bow, if the mob is NOT in melee range
	 */
	private void checkArcheryWeapon() {
		if (target != null)
			bowEquipped = attackRange <= Math.abs(getCenterX() - target.getCenterX());
	}

	/**
	 * Sets the state to States.die if the mob reaches its maxLivingTime
	 */
	private void checkMaxLivingTime() {
		if (stateTime >= maxLivingTime) {
			state = States.die;
		}
	}

	/**
	 * Checks for spellEffects, if the mob is affected by any they will get
	 * updated
	 */
	private void checkSpellEffects() {
		if (state != States.die && !this.spellEffects.isEmpty())
			for (int i = 0; i < this.spellEffects.size(); i++) {
				SpellEffect obj = spellEffects.get(i);
				obj.updateAll();
			}
	}

	/**
	 * Checks if there are conditions updates the mobs stats depending on the
	 * condition
	 */
	private void checkConditions() {
		// TODO add all possible conditions
		if (condition.contains(Condition.root, true))
			this.velocity.x = 0;
		else
			this.velocity.x = this.getStandartMoveVelocity();
	}

	/** Updates the mobs position, state, condition and timers **/
	public void update(float delta) {
		checkInvade();
		checkMaxLivingTime();
		if (isRange)
			checkArcheryWeapon();
		checkSpellEffects();

		if (hp > 0) {
			switch (state) {
			case walk:
				position.add(velocity.x * delta, 0);
				break;
			case hit:
				if (this.hitStateTimer <= 0) {
					state = States.walk;
					this.hitStateTimer = 0.35f;
				} else {
					this.hitStateTimer -= delta;
					position.add(velocity.x * delta, 0);
				}
				break;
			case attack:
				if (target == null || target.state == States.die)
					state = States.walk;
				break;
			case run:
				position.add((velocity.x + 5) * delta, 0);
				break;
			case kwalk:
				position.add((velocity.x - 2) * delta, 0);
				break;
			}

			checkConditions();

		} else {
			velocity.set(0, 0);
			state = States.die;
			deadTime += delta;
		}

		setCenterX(position.x + width / 2);
		stateTime += delta;

	}

	/**
	 * Grabs the specific animation depending on the GameLivings state. It
	 * actually returns the keyFrame
	 * 
	 * @return Returns the Animation
	 **/
	public abstract TextureRegion getAnimation();

	/**
	 * Updates all Timers
	 * 
	 * @param delta
	 *            Time since last frame
	 * @return returns true if mob was removed
	 **/
	protected boolean updateTimers(float delta) {
		if (deadTime > 1.5) { // Having a dead corpse for 1,5 secs is enough
			if (World.mobs.removeValue(this, true)
					|| World.enemyEntities.removeValue(this, true))
				return true;
			else
				return false;
		}
		this.rootResistTimer -= Gdx.graphics.getDeltaTime();
		if (swingTimer <= 0)
			swingTimer = 0;
		else
			swingTimer -= delta;

		if (inCombatTimer <= 0) {
			inCombatTimer = 0;
			inCombat = false;
		} else
			inCombatTimer -= delta;

		return false;
	}

	public void addSpellEffect(SpellEffect spellEffect) {
		if (!spellEffects.contains(spellEffect))
			spellEffects.add(spellEffect);
	}

	public boolean removeSpellEffect(SpellEffect spellEffect) {
		return this.spellEffects.remove(spellEffect);
	}

	/**
	 * Grabs the standard movement velocity (more or less from the
	 * child-classes)
	 * 
	 * @return the velocity
	 */
	public abstract float getStandartMoveVelocity();

	@Override
	public String toString() {
		return "Species: " + this.species + " State: " + this.state
				+ " isRange?: " + this.isRange + " isCaster?: " + this.isCaster;
	}

}
