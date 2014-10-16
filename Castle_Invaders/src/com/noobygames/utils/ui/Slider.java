package com.noobygames.utils.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.noobygames.utils.exceptions.SliderOutOfBoundingsException;

/**
 * @author Nerzal
 * @extends SimpleElement
 **/
public class Slider extends SimpleElement {

	private boolean isVertical;
	private Rectangle ownerPos;
	private boolean border;

	/**
	 * @param position
	 *            Relative position
	 * @param ownerPos
	 *            Position of the Table or Window the element lays on
	 * @param tex
	 *            the texture
	 * @param isVertical
	 *            does it slide vertical
	 **/
	public Slider(Rectangle position, Rectangle ownerPosition, Texture tex,
			boolean isVertical) {
		super(position, tex);
		this.isVertical = isVertical;
		this.ownerPos = ownerPosition;
	}

	/**
	 * @return the isVertical
	 */
	public boolean isVertical() {
		return isVertical;
	}

	/**
	 * @param isVertical
	 *            the isVertical to set
	 */
	public void setVertical(boolean isVertical) {
		this.isVertical = isVertical;
	}

	/**
	 * This method moves the slider within the borders of the owner
	 * 
	 * @param delta
	 *            The pixels to scroll
	 **/
	public void scroll(float delta) {
		try{
		if (this.isVertical) {
			if (delta > 0)
				if (this.getPosition().y + this.getPosition().height + delta < this.ownerPos.y)
					this.setPosition(this.getPosition().x + delta,
							this.getPosition().y, this.getPosition().width,
							this.getPosition().height);
				else {
					this.setBorder(true);
					throw new SliderOutOfBoundingsException();
				}

			else if (delta < 0)
				if (this.getPosition().y + delta > this.ownerPos.y)
					this.setPosition(this.getPosition().x + delta,
							this.getPosition().y, this.getPosition().width,
							this.getPosition().height);
				else {
					this.setBorder(true);
					throw new SliderOutOfBoundingsException();
				}
		} else {
			if (delta > 0)
				if (this.getPosition().x + this.getPosition().width + delta < this.ownerPos.x
						+ this.ownerPos.width)
					this.setPosition(this.getPosition().x, this.getPosition().y
							+ delta, this.getPosition().width,
							this.getPosition().height);
				else {
					this.setBorder(true);
					throw new SliderOutOfBoundingsException();
				}

			else if (delta < 0)
				if (this.getPosition().x + delta > this.ownerPos.x
						+ this.ownerPos.width)
					this.setPosition(this.getPosition().x, this.getPosition().y
							+ delta, this.getPosition().width,
							this.getPosition().height);
				else {
					this.setBorder(true);
					throw new SliderOutOfBoundingsException();
				}
		}
		} catch (SliderOutOfBoundingsException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the border
	 */
	public boolean isBorder() {
		return border;
	}

	/**
	 * @param border
	 *            the border to set
	 */
	public void setBorder(boolean border) {
		this.border = border;
	}

}
