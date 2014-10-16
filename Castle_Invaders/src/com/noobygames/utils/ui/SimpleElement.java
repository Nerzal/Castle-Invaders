package com.noobygames.utils.ui;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class SimpleElement extends Element {
				
	/**marks the position and the size of the element**/
	private Rectangle position;
	/**the texture for the element**/
	private Texture tex;
	private TextureRegion texRegion;
	
	
	/**
	 * @param position marks the position and the size
	 * @param tex the texture **/
	public SimpleElement(Rectangle position, Texture tex){
		this.position = position;
		this.tex = tex;
		this.texRegion = null;
	}
	
	/**
	 * @param position marks the position and the size
	 * @param tex the texture **/
	public SimpleElement(Rectangle position){
		this.position = position;
		this.tex = null;
		this.texRegion = null;
	}
	
	/**
	 * @param position marks the position and size
	 * @param texRegion the texture region**/
	public SimpleElement(Rectangle position, TextureRegion texRegion){
		this.position = position;
		this.texRegion = texRegion;
		this.tex = null;
	}
	
	/**
	 * @return the position
	 */
	public Rectangle getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Rectangle position) {
		this.position = position;
	}
	
	/**
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param width the width
	 * @param height the height
	 * **/
	public void setPosition(float x, float y, float width, float height){
		this.position.set(x, y, width, height);
	}

	/**
	 * @return the tex
	 */
	public Texture getTex() {
		return tex;
	}

	/**
	 * @param tex the tex to set
	 */
	public void setTex(Texture tex) {
		this.tex = tex;
	}
	
	/**
	 * @return the textureRegion
	 */
	public TextureRegion getTexRegion() {
		return texRegion;
	}

	/**
	 * @param texReg the textureRegion to set
	 */
	public void setTexRegion(TextureRegion texReg) {
		this.texRegion = texReg;
	}
	
	/**Calls the batchers draw method
	 * @param batch The SpriteBatcher**/
	public void drawIt(SpriteBatch batch){
		if(this.tex != null)
			this.draw(batch);
		else if(this.texRegion != null)
			this.drawTexRegion(batch);
	}
	
	/**Draws the element if it has a Texture**/
	private void draw(SpriteBatch batch){
		batch.draw(this.tex, this.position.x, this.position.y, this.position.width, this.position.height);
	}
	
	/**Draws the element if it has a TextureRegion**/
	private void drawTexRegion(SpriteBatch batch){
		batch.draw(this.texRegion, this.position.x, this.position.y, this.position.width, this.position.height);
	}

}
