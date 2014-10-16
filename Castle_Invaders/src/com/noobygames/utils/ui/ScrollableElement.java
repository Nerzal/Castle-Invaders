package com.noobygames.utils.ui;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * A ScrollableElement inhabits an array of elements, which is scrollable (wow)
 * It inhabits also a slider, which is able to move within the borders of this
 * element
 * 
 * @author Nerzal
 * @extends Table
 * @implements InputProcessor
 **/
public class ScrollableElement extends Table implements InputProcessor {

	boolean isVertical;
	Slider slider;

	/**
	 * @param position 
	 * 			The position of the element
	 * @param tex
	 * 		   	The texture
	 * @param isVertical
	 * 			Does it scroll verticaly?
	 * @param sliderTex
	 * 			The slider's texture**/
	public ScrollableElement(Rectangle position, Texture tex,
			boolean isVertical, Texture sliderTex) {
		super(position, tex);
		this.isVertical = isVertical;
		if (isVertical)
			this.slider = new Slider(new Rectangle(this.getPosition().x + this.getPosition().width - this.getPosition().width / 20,
										this.getPosition().y + this.getPosition().height - this.getPosition().height / this.elements.size,
										this.getPosition().width / 20,
										this.getPosition().height / this.elements.size), 
							position, tex, isVertical);
		else
			this.slider = new Slider(new Rectangle(this.getPosition().x + this.getPosition().width - this.getPosition().width / this.elements.size,
										this.getPosition().y + this.getPosition().height - this.getPosition().height / 20,
										this.getPosition().width / this.elements.size,
										this.getPosition().height / 20), 
							position, tex, isVertical);

	}

	public void drawIt() {
		//this.draw();

	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if (isVertical) {
			this.slider.scroll(screenY);
			return true;
		} else {
			this.slider.scroll(screenX);
			return true;
		}
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
