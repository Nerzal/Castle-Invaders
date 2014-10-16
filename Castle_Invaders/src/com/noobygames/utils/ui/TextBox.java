package com.noobygames.utils.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;



public class TextBox extends SimpleElement {

	private Array<String> text;
	
	public TextBox(Rectangle position) {
		super(position);
		
	}
	
	/**Adds the given string to the array
	 * @param text The String to add**/
	public void addText(String text){
		this.text.add(text);
		
	}
	
	/**Removes the given string from the list
	 * @param str The string to remove**/
	public boolean delText(String str){
		for(String obj: text)
			if(obj.equals(str)){
				text.removeValue(obj, true);
				return true;
			}else 
				return false;
		return false;
	}

	/**
	 * @return the text
	 */
	public Array<String> getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(Array<String> text) {
		this.text = text;
	}

}
