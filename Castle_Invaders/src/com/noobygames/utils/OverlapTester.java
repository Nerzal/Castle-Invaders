package com.noobygames.utils;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class OverlapTester {
	/**
	 * Returns true if Rectangles overlap
	 * 
	 * @param r1
	 *            erstes Rechteck
	 * @param r2
	 *            zweites Rechteck
	 * @return true if they do overlap
	 **/
	public static boolean overlapRectangles(Rectangle r1, Rectangle r2) {
		if (r1.x <= r2.x + r2.width && r1.x + r1.width >= r2.x
				&& r1.y <= r2.y + r2.height && r1.y + r1.height >= r2.y)
			return true;
		else
			return false;
	}

	/**
	 * @param r
	 *            the boundings
	 * @param p
	 *            the touchPoint
	 * @return true if point is within the rectangle else false
	 **/
	public static boolean pointInRectangle(Rectangle r, Vector3 p) {
		return r.x <= p.x && r.x + r.width >= p.x && r.y <= p.y
				&& r.y + r.height >= p.y;
	}

	/**
	 * @param r
	 *            the boundings
	 * @param p
	 *            the touchPoint
	 * @return true if point is within the rectangle else false
	 **/
	public static boolean pointInRectangle(Rectangle r, Vector2 p) {
		return r.x <= p.x && r.x + r.width >= p.x && r.y <= p.y
				&& r.y + r.height >= p.y;
	}

	/**
	 * @param r
	 *            the boundings
	 * @param p
	 *            the touchPoint
	 * @return true if point is within the rectangle else false
	 **/
	public static boolean pointInRectangle(Rectangle r, float x, float y) {
		return r.x <= x && r.x + r.width >= x && r.y <= y
				&& r.y + r.height >= y;
	}

	/** This method checks, if the second rectangle is not inside the boundings of the first one
	 * @return true if it is out of boundings else false
	 * @param r1 first rectangle
	 * @param r2 second rectangle 
	 * @author Nerzal**/
	public static boolean outOfBounding(Rectangle r1, Rectangle r2) {
		if (r1.x < r2.x || r1.x > r2.x || r1.y < r2.y || r1.y > r2.y
				|| r1.width > r2.width || r1.height > r2.height)
			return true;
		else
			return false;
	}
}