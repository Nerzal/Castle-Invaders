package com.noobygames.utils.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**typical radiobutton 
 * @author Nerzal**/
public class RadioButton extends ClickableElement {

	private Texture texClicked;
	private TextureRegion texRegionNotClicked;
	private TextureRegion texRegionClicked;
	
	/**Constructor
	 * **/
	public RadioButton(Rectangle position, Texture texClicked, Texture texNotClicked) {
		super(position, texNotClicked);
		this.texClicked = texClicked;
	}
	
	public RadioButton(Rectangle position, TextureRegion texClicked, TextureRegion texNotClicked) {
		super(position);
		this.texRegionClicked = texClicked;
		this.texRegionNotClicked = texNotClicked;
	}
	
	@Override
	public void onClick() {
		this.setClicked(!isClicked());
	}

	/**
	 * @return the texClicked
	 */
	public Texture getTexClicked() {
		return texClicked;
	}

	/**
	 * @param texClicked the texClicked to set
	 */
	public void setTexClicked(Texture texClicked) {
		this.texClicked = texClicked;
	}
	

}
