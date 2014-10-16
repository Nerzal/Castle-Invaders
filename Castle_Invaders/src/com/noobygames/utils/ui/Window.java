package com.noobygames.utils.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;


/**
 * A Window is the root for all UI elements
 * 
 * @author Nerzal
 * @extends Table
 **/
public class Window extends Table{

	private String description;
	private Rectangle stringPos;
	
	
	
	/**
	 * @param position Rectangle with the position & size
	 * @param tex The Texture**/
	public Window(Rectangle position, Texture tex) {
		super(position, tex);
		this.setDescription(null);
		this.setStringPos(null);
	}

	
	/**
	 * @param position Rectangle with the position & size
	 * @param tex The Texture
	 * @param description A String description
	 * @param stringPos Rectangle with position & size**/
	public Window(Rectangle position, Texture tex, String description, Rectangle stringPos) {
		super(position, tex);
		this.setDescription(description);
		this.setStringPos(stringPos);
	}
	


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the stringPos
	 */
	public Rectangle getStringPos() {
		return stringPos;
	}

	/**
	 * @param stringPos the stringPos to set
	 */
	public void setStringPos(Rectangle stringPos) {
		this.stringPos = stringPos;
	}

	
}