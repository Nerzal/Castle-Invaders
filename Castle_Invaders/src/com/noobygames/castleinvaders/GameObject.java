package com.noobygames.castleinvaders;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameObject {
	public final Vector2 position;
	public final Rectangle bounds;

	public GameObject(float x, float y, float width, float height) {
		this.position = new Vector2(x, y);
		this.bounds = new Rectangle(x - width / 2, y - height / 2, width,
				height);
	}
	
	public GameObject(Rectangle bounds){
		this.bounds = bounds;
		this.position = new Vector2(bounds.getX(), bounds.getY());
	}

	public void resetBoundsWithPosition() {
		this.bounds.x = this.position.x - this.bounds.width / 2;
		this.bounds.y = this.position.y - this.bounds.height / 2;
	}
}
