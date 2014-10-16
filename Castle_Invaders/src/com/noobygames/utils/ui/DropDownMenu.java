package com.noobygames.utils.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.noobygames.utils.OverlapTester;
import com.noobygames.utils.exceptions.OutOfBoundingException;

/** @author Nerzal
 * @extends clickableElement **/
public class DropDownMenu extends Button {

	private boolean isExtended = false;
	private Table table;

	/**
	 * Standard construcor
	 * 
	 * @param position
	 *            A rectangle with the relative position on the window and its
	 *            size
	 * @param tex
	 *            The Texture
	 * @param table
	 *            The Table, which inhabits all elements
	 * @see Table
	 * @see Rectangle
	 * @throws OutOfBoundingException
	 **/
	public DropDownMenu(Rectangle position, Texture tex, Table table) {
		super(position, tex);
		try {
			this.table = table;
			this.table.setPosition(this.getPosition().x, this.getPosition().y,
					this.table.getPosition().width,
					this.table.getPosition().height);
			if (OverlapTester.outOfBounding(this.getPosition(),
					table.getPosition()))
				;
			throw new OutOfBoundingException();
		} catch (OutOfBoundingException e) {
			System.out
					.println("The table u wanted to add onto the Dropdownmenu is out of Boundings! Pls try again!");
		}
	}

	/**
	 * Draws the dropdown menu. If its expanded all objects on the table get
	 * drawn else only the SimpleElement gets drawn
	 * 
	 * @see SimpleElement
	 **/
	public void draw() {
	/*	if (isExtended)
			this.table.draw();
		else
			this.drawIt();
*/
	}

	/**
	 * Expands the dropdownmenu
	 * 
	 * @return true if the dropdownmenu gets expanded else false
	 **/
	public boolean expand() {
		if (!isExtended) {
			this.isExtended = true;
			return true;
		} else
			return false;

	}

	@Override
	public void onClick() {
		this.setExtended(!this.isExtended);
	}



	/**
	 * @return the isExtended
	 */
	public boolean isExtended() {
		return isExtended;
	}

	/**
	 * @param isExtended
	 *            the isExtended to set
	 */
	public void setExtended(boolean isExtended) {
		this.isExtended = isExtended;
	}

	/**
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * @param table
	 *            the table to set
	 */
	public void setTable(Table table) {
		this.table = table;
	}

}
