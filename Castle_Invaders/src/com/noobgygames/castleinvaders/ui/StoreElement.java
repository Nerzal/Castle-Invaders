package com.noobgygames.castleinvaders.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.noobygames.castleinvaders.store.StoreObject;
import com.noobygames.utils.ui.ClickableElement;

public class StoreElement extends ClickableElement {
	StoreObject obj;
	
	public StoreElement(Rectangle position, Texture tex, StoreObject obj) {
		super(position, tex);
		this.obj = obj;
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
	}

}
