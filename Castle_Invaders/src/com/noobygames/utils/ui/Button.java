package com.noobygames.utils.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**Typical button has a position, a texture and an onClick method
 * @extends clickableElement
 * @author Nerzal**/
public abstract class Button extends ClickableElement {

	/** Constructor
	 * @param position The position
	 * @param The texture**/
	
	public Button(Rectangle position, Texture tex) {
		super(position, tex);
		
	}

	public abstract void onClick();

}
