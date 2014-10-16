package com.noobygames.castleinvaders;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import com.noobygames.castleinvaders.World.Species;
import com.noobygames.castleinvaders.World.States;


public abstract class DynamicGameObject extends GameObject {

	protected GameLiving target;

	public States state;
	public Species species;
	public final Vector2 velocity;
	public final Vector2 accel;
	public final float width;
	private float centerX;

	protected double hitRange;

	public enum Condition {
		snare, root, dot, stun
	}

	public DynamicGameObject(float x, float y, float width, float height,
			Species species) {
		super(x, y, width, height);
		target = null;
		this.species = species;
		velocity = new Vector2();
		accel = new Vector2();
		this.width = width;
		setCenterX(x+width/2);

	}

	public DynamicGameObject(Rectangle bounds) {
		super(bounds);
		velocity = null;
		accel = null;
		width = bounds.getWidth();
	}

	/**
	 * Prüft den Abstand zwischen Objekt & Target
	 * 
	 * @param obj1
	 *            object
	 * @param obj2
	 *            target
	 * @return returns true on target hit
	 **/
	protected boolean rangeCheck(GameLiving obj1, GameLiving obj2) {

		if (obj1.species == Species.greyTroll
				|| obj1.species == Species.iceTroll
				|| obj1.species == Species.lavaTroll) {
			if (Math.pow(obj1.hitRange, 2) >= Math.pow((obj1.position.x + 20)
					- obj2.position.x, 2))
				return true;
			
		} else if (obj1.species == Species.orc) {
			if (Math.pow(obj1.hitRange, 2) >= Math.pow((obj1.position.x)
					- obj2.position.x, 2))
				return true;
		}
		
		return false;
	}

	public float getCenterX() {
		return centerX;
	}

	public void setCenterX(float centerX) {
		this.centerX = centerX;
	}
}
