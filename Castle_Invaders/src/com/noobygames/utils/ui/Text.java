package com.noobygames.utils.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


/** A Text is a simple String
 * @author Nerzal
**/
public class Text {

	private Rectangle position;
	private String text;
	private BitmapFont fB;
	private SpriteBatch sB;
	
	/**A blank Text
	 * @param position
	 * 		 	The position**/
	public Text(Rectangle position){
		this.position = position;
		this.text = null;
	}
	
	/**A text
	 * @param position
	 * 			The position
	 * @param text
	 * 			The text**/
	public Text(Rectangle position, String text){
		this.position = position;
		this.text = text;
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
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**Draws the Text onto the screen - default size -**/
	public void draw(){
		this.fB.draw(sB, text, this.getPosition().x, this.getPosition().y);
	}
	
	/**Draws the Text onto the screen - give n size -**/
	public void draw(int size){
		this.fB.scale(size);
		this.fB.draw(sB, text, this.getPosition().x, this.getPosition().y);
	}
	
	//TODO fertig machen !

}
