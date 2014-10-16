package com.noobgygames.castleinvaders.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.noobygames.utils.ui.Button;

public class DragonUltiButton extends Button {

	public DragonUltiButton(Rectangle position, Texture tex) {
		super(position, tex);
	}



	public DragonUltiButton(Rectangle position, TextureRegion earthDragonSwitch) {
		super(position, null);
		this.setTexRegion(earthDragonSwitch);
		this.setClicked(false);
	}



	/**This method switches the TextureRegion of the button
	 * **/
	@Override
	public void onClick() {
	}

}
