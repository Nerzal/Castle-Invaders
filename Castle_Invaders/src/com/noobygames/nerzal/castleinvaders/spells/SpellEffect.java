package com.noobygames.nerzal.castleinvaders.spells;


import com.badlogic.gdx.Gdx;
import com.noobygames.castleinvaders.GameLiving;
import com.noobygames.castleinvaders.World.States;
/**
 *
 * @author Nerzal
 *
 */
public class SpellEffect extends Spells {

	protected float effectDuration;
	protected float effectDmg;
	protected float tickDamage;
	protected float tickDuration;
	protected float tickTimer;
	protected Condition condition;
	protected float conditionTimer;
	protected float conditionDuration;
	private boolean init = false;
	
	
	public SpellEffect(float x, float y, float width, float height,
			GameLiving caster, GameLiving target, Spell spell) {
		super(x, y, width, height, caster, target, spell);
		//target.addSpellEffect(this);
	}

	public void init(){ // Is called, when the object is created/the spelleffect applies
		init = true;
		if(condition != Condition.root)
			target.condition.add(condition); 
		else if(target.rootResistTimer <= 0){ // To avoid perma root
			target.condition.add(condition); 
		}
		conditionTimer = conditionDuration;
		tickTimer = tickDuration;
		
	}
	
	public void updateAll(){
		if(!init) 
			init();
		updateTickTimer();
		updateConditionTimer();
	}
	
	/**
	 * Updates ands resets the tickTimer
	 */
	protected void updateTickTimer(){
		tickTimer -= Gdx.graphics.getDeltaTime();
		effectDuration -= Gdx.graphics.getDeltaTime();
		//Gdx.app.log("TickTimer", ""+tickTimer);
		if(tickTimer <= 0){
			tickTimer = tickDuration;
			this.harmTarget(tickDamage);	
			if(effectDuration <= 0 || target.state == States.die && target != null ){
				if(target.condition.contains(Condition.root, true))
					target.rootResistTimer = 2.5f;
				target.removeSpellEffect(this);
				target.condition.removeValue(this.condition, true);	
			}
		}
			
	}
	
	/**
	 * Updates ands resets the tickTimer
	 */
	protected void updateConditionTimer(){
		conditionTimer -= Gdx.graphics.getDeltaTime();
		if(conditionTimer <= 0)
			target.condition.removeValue(this.condition, true);
				//Gdx.app.log("Condition", "Removed!");
		/*else
			if(this.condition == Condition.root)
				target.velocity.x = 0;*/
	}
	
	/**Calls the targets harm method to deal damage
	 * @param dmg dmg to deal
	 * @see GameLiving**/
	protected void harmTarget(float dmg){
	//	Gdx.app.log("BURNING", "Harmed target - SpellEffect.Burning! "+dmg+" damage done!"+" Effect/Burndmg: "+effectDmg+"/"+tickDamage);
		if(dmg>0)
			this.target.harm(dmg, this.damageType, this.caster);
	//	Gdx.app.log("BURNING", "Target has now: "+target.hp+" hp!");
	}
	

	/**
	 * @return the effectDuration
	 */
	public float getEffectDuration() {
		return effectDuration;
	}

	/**
	 * @param effectDuration the effectDuration to set
	 */
	public void setEffectDuration(float effectDuration) {
		this.effectDuration = effectDuration;
	}

	/**
	 * @return the effectDmg
	 */
	public float getEffectDmg() {
		return effectDmg;
	}

	/**
	 * @param effectDmg the effectDmg to set
	 */
	public void setEffectDmg(float effectDmg) {
		this.effectDmg = effectDmg;
	}

	/**
	 * @return the tickDamage
	 */
	public float getTickDamage() {
		return tickDamage;
	}

	/**
	 * @param tickDamage the tickDamage to set
	 */
	public void setTickDamage(float tickDamage) {
		this.tickDamage = tickDamage;
	}

	/**
	 * @return the tickDuration
	 */
	public float getTickDuration() {
		return tickDuration;
	}

	/**
	 * @param tickDuration the tickDuration to set
	 */
	public void setTickDuration(float tickDuration) {
		this.tickDuration = tickDuration;
	}

	/**
	 * @return the condition
	 */
	public Condition getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	
	/**
	 * 
	 * @param conditionDuration the duration to set
	 */
	public void setConditionDuration(float conditionDuration){
		this.conditionDuration = conditionDuration;
	}

}
