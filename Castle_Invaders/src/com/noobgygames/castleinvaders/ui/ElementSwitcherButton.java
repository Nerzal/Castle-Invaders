package com.noobgygames.castleinvaders.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.noobygames.castleinvaders.Assets;
import com.noobygames.castleinvaders.World;
import com.noobygames.utils.ui.Button;

public class ElementSwitcherButton extends Button {


	/**
	 * Constructor
	 * @param position
	 * @param tex
	 */
	public ElementSwitcherButton(Rectangle position, Texture tex) {
		super(position, tex);
	}

	/**
	 * Constructor
	 * @param position
	 * @param eleSwitchEarth
	 */
	public ElementSwitcherButton(Rectangle position, TextureRegion eleSwitchEarth) {
		super(position, null);
		this.setTexRegion(eleSwitchEarth);
	}

	/**
	 * Called, when the button is clicked
	 */
	@Override
	public void onClick() {
		//System.out.println("Ich wurde geclicked!");
		switch(World.elementState){
		case World.elementEarth:
			World.elementState = World.elementLava;
			this.setTexRegion(Assets.eleSwitchFire);
			
		//	System.out.println("Element gewechselt zu Lava!");
			return;
		case World.elementLava:
			World.elementState = World.elementIce;
			this.setTexRegion(Assets.eleSwitchIce);
			return;
		case World.elementIce:
			World.elementState = World.elementEarth;
			this.setTexRegion(Assets.eleSwitchEarth);
			return;
		}
	}

}
