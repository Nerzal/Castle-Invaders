package com.noobygames.nerzal.castleinvaders.spells;

import com.noobygames.castleinvaders.GameLiving;
/** This Spelleffect should root the target and apply a snare effect afterwards.
 *  
 * @author Nerzal
 *
 */
public class Freeze extends SpellEffect {

	public Freeze(float x, float y, float width, float height,
			GameLiving caster, GameLiving target, Spell spell) {
		super(x, y, width, height, caster, target, spell);
		this.setEffectDmg((float) (0)); //TODO add StoreObject to add initial damage !
		this.setEffectDuration((float)(2.0));
		this.setTickDamage((float) (0)); // No tick dmg 
		this.setTickDuration((float) (0)); 
		this.setConditionDuration((float) 2.0); //Guess condition duration is not really needed TODO 
		this.setCondition(Condition.root);
	}

}
