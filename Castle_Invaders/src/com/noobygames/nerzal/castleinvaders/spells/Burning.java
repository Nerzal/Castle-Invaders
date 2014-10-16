package com.noobygames.nerzal.castleinvaders.spells;

import com.noobygames.castleinvaders.GameLiving;
/** Burning effects have an initial dmg aswell as ticking damage(harming enemies over time)
 *	@author Nerzal
 */
public class Burning extends SpellEffect {

	/**Construcor. Creates a new SpellEffect object
	 * 
	 * @param x bottom left corner
	 * @param y botton left corner
	 * @param width width of the effect
	 * @param height height of the effect
	 * @param caster caster of the spell that inflicted this effect
	 * @param target target of the SpellEffect
	 * @param spell enum type for Spells like fireBolt
	 */
	public Burning(float x, float y, float width, float height,
			GameLiving caster, GameLiving target, Spell spell) {
		super(x, y, width, height, caster, target, spell); 
		this.setEffectDmg((float) (caster.mobLevel+1 * 10));
		this.setEffectDuration((float)(caster.mobLevel+1 * 2.5));
		this.setTickDamage((float) (caster.mobLevel+1 * 2.5));
		this.setTickDuration((float) (0.65)); //TODO+1 think of better fitting values
		this.setConditionDuration((float) 2.5);
		this.setCondition(Condition.dot);
		this.harmTarget(getEffectDmg());
	}
	

	
	

}
