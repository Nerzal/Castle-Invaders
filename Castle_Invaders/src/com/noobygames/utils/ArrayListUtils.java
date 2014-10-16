package com.noobygames.utils;

import java.util.ArrayList;

import com.noobygames.castleinvaders.GameObject;

public class ArrayListUtils {
	
	public ArrayList<GameObject> moveObjectsX(ArrayList<GameObject> list, int deltaX){
		if(list.isEmpty())
			return null;
		if(deltaX == 0)
			return list;
		
		for(GameObject obj: list){
			obj.position.x+=deltaX;
			return list;
		}
		return null;
	}
}
