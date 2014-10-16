package com.noobygames.utils.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.noobygames.utils.OverlapTester;
import com.noobygames.utils.exceptions.OutOfBoundingException;

/**
 * Group of RadioButtons, which are linked together (only one can be active)
 * 
 * @author Nerzal
 **/
public class RadioGroupButton extends ClickableElement {

	private Array<RadioButton> rB;

	
	/**
	 * Constructor
	 * 
	 * @param position
	 *            A rectangle with the relative position on the window and its size
	 * @param tex 
	 * 			The texture
	 **/
	public RadioGroupButton(Rectangle position, Texture tex) {
		super(position, tex);
	}

	/**
	 * Constructor
	 * 
	 * @param position
	 *            A rectangle with the relative position on the window and its size
	 * @param tex 
	 * 			The texture
	 * 
	 * @param rB An array of radiobuttons
	 *           
	 * @throws OutOfBoundingException
	 **/
	public RadioGroupButton(Rectangle position, Texture tex,
			Array<RadioButton> rB) {
		super(position, tex);
		try {
			for (RadioButton rb : rB) {
				if (OverlapTester.outOfBounding(this.getPosition(),
						rb.getPosition()))
					throw new OutOfBoundingException();
			}
			this.rB = rB;
		} catch (OutOfBoundingException e) {
			System.out
					.println("One of the Radiobuttons you wanted to add is out of the RadioGroupButtons boundings! Pls try again!");
		}
	}

	/**
	 * If a click occured within the boundings of the radiobuttongroup this
	 * method checks if a radiobutton was clicked. If a radiobutton was clicked
	 * its onClick() method is called and all other buttons are set to "false"
	 * 
	 * @see RadioButton
	 * @param touchPoint
	 *            the touchPoint
	 **/
	public void onClick(Vector2 touchPoint) {
		RadioButton tmp = null;

		for (RadioButton rb : rB)
			if (OverlapTester.pointInRectangle(rb.getPosition(), touchPoint))
				if (!rb.isClicked()) {
					rb.onClick();
					tmp = rb;
				}

		for (RadioButton rb : rB)
			if (tmp != null)
				if (rb != tmp)
					rb.setClicked(false);
	}

	/**
	 * Checks if a radioButton at the given index is clicked
	 * 
	 * @return true if the rb is clicked else false
	 **/
	public boolean isRbClicked(int index) {
		if (!(index > rB.size))
			return this.rB.get(index).isClicked();
		else
			return false;
	}

	@Override
	public void onClick() {

	}

	/**
	 * @return the rb
	 */
	public Array<RadioButton> getRb() {
		return rB;
	}

	/**
	 * @param rb
	 *            the rb to set
	 */
	public void setRb(Array<RadioButton> rb) {
		this.rB = rb;
	}

	/**
	 * Adds a RadioButton to the Group
	 * 
	 * @param rB
	 *            Radiobutton to add
	 **/
	public void addRb(RadioButton rB) {
		try {
			if (OverlapTester.outOfBounding(this.getPosition(),
					rB.getPosition()))
				throw new OutOfBoundingException();
			else
				this.rB.add(rB);
		} catch (OutOfBoundingException e) {
			System.out
					.println("One of the Radiobuttons you wanted to add is out of the RadioGroupButtons boundings! Pls try again!");
		}
	}

	/**
	 * Removes a specific radiobutton from the group
	 * 
	 * @param rB
	 *            The RadioButton to remove
	 * @return true if found&removed else false
	 **/
	public boolean removeRb(RadioButton rB) {
		return this.rB.removeValue(rB, true);
	}

	/**
	 * @param index
	 *            index of the Radiobutton to remove
	 * @return returns the button if found&removed else null
	 **/
	public RadioButton removeRb(int index) {
		return this.rB.removeIndex(index);
	}

	/** Draws the radiobuttons **/
	public void drawGroup(SpriteBatch batch) {
		for (RadioButton rb : rB)
			rb.drawIt(batch);
	}

}
