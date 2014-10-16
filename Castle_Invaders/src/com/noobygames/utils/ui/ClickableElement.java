package com.noobygames.utils.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract  class ClickableElement extends SimpleElement {

	private boolean isClicked;
	private final boolean isClickable = true;

	public ClickableElement(Rectangle position, Texture tex) {
		super(position, tex);
		this.isClicked = false;
	}


	public ClickableElement(Rectangle position) {
		super(position);
		this.isClicked = false;
	}


	/** onClick() is called, when an element is clicked 
	 * @return **/
	public abstract void onClick();
	
	

	/**
	 * @return the isClicked
	 */
	public boolean isClicked() {
		return isClicked;
	}

	/**
	 * @param isClicked
	 *            the isClicked to set
	 */
	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}

	/**
	 * @return the isClickable
	 */
	public boolean isClickable() {
		return isClickable;
	}

	@Override
	public String toString() {
		return "PosX: " + this.getPosition().x + " PosY: "+ this.getPosition().y + " Width: " + this.getPosition().width
				+ " Height: " + this.getPosition().height;
	}

}
