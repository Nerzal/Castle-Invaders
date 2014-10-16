package com.noobygames.utils.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.noobygames.utils.OverlapTester;
import com.noobygames.utils.exceptions.OutOfBoundingException;

/**
 * @author Nerzal
 * @extends SimpleElement
 **/
public class Table extends SimpleElement {

	protected Array<ClickableElement> elements;
	protected Array<SimpleElement> simpleElements;

	public Table(Rectangle position, Texture tex) {
		super(position, tex);
		this.elements = new Array<ClickableElement>();
		this.simpleElements = new Array<SimpleElement>();

	}

	public Element getElementforID(int id) {
		for (Element e : elements)
			if (e.getId() == id)
				return e;
		for (Element e : simpleElements)
			if (e.getId() == id)
				return e;

		return null;
	}

	/**
	 * Draws the table and all elements it inhabits
	 **/
	public void draw(SpriteBatch batch) {

		if (this.getTex() != null)
			batch.draw(this.getTex(), this.getPosition().x,
					this.getPosition().y, this.getPosition().width,
					this.getPosition().height);

		for (SimpleElement obj : elements)
			obj.drawIt(batch);

		for (SimpleElement obj : simpleElements) {
			obj.drawIt(batch);
		}
	}

	/**
	 * @return the elements
	 */
	public Array<ClickableElement> getElements() {
		return elements;
	}

	/**
	 * @param elements
	 *            the elements to set
	 */
	public void setElements(Array<ClickableElement> elements) {
		this.elements = elements;
	}

	/**
	 * Adds a simple Element onto the elements list if the position of the
	 * element is inside the table, else an OutOfBoundingException will be
	 * thrown
	 * 
	 * @param e
	 *            the element to add
	 * @throws OutOfBoundingException
	 **/
	public void addElement(ClickableElement e) throws OutOfBoundingException {
		if (OverlapTester.outOfBounding(this.getPosition(), e.getPosition()))
			elements.add(e);
		else
			throw new OutOfBoundingException();
	}

	public void addElementWithNewPosition(ClickableElement e) {
		if (this.elements.first() == null)
			e.setPosition(this.getPosition().x + 10, this.getPosition().y + 10,
					this.getPosition().width / 10,
					this.getPosition().height / 10);
		else
			e.setPosition(this.align());
		
		this.elements.add(e);
	}

	private Rectangle align() {
		
		return null;
	}

	/**
	 * Removes the given element from the list
	 * 
	 * @param e
	 *            the element to delete
	 **/
	public boolean removeElement(ClickableElement e) {
		return elements.removeValue(e, true);
	}

	/**
	 * Removes the element at the given index
	 * 
	 * @param index
	 *            The index
	 **/
	public SimpleElement removeElement(int index) {
		return elements.removeIndex(index);

	}

	/**
	 * Calls the setClicked() and onClickMethod
	 * 
	 * @see ClickableElement
	 * @param touchPoint
	 *            Vector3 which inhabits a touchPoint (x,y,(z)) values
	 * **/
	public boolean checkElementTouched(Vector3 touchPoint) {
		for (ClickableElement obj : elements) {
			if (OverlapTester.pointInRectangle(obj.getPosition(), touchPoint)) {
				// System.out.println("The following clickableElement was clicked: "+obj.toString());
				if (!obj.isClicked()) {
					obj.setClicked(true);
					return true;
				} else
					obj.setClicked(false);
				obj.onClick();
				// System.out.println(""+obj.isClicked());
			}
		}
		return false;
	}

	/**
	 * @return the SimpleElements
	 */
	public Array<SimpleElement> getSimpleElements() {
		return simpleElements;
	}

	/**
	 * @param SimpleElements
	 *            the SimpleElements to set
	 */
	public void setSimpleElements(Array<SimpleElement> simpleElements) {
		this.simpleElements = simpleElements;
	}

	/**
	 * Adds a simple SimpleElement onto the SimpleElements list
	 * 
	 * @param e
	 *            the SimpleElement to add
	 **/
	public void addSimpleElement(SimpleElement e) {
		simpleElements.add(e);
	}

	/**
	 * Removes the given SimpleElement from the list
	 * 
	 * @param e
	 *            the SimpleElement to delete
	 **/
	public boolean removeSimpleElement(SimpleElement e) {
		return simpleElements.removeValue(e, true);
	}

}
