package com.noobygames.castleinvaders;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Castle_Invaders";
		//cfg.useGL20 = true;
		cfg.width = 840;
		cfg.height = 640;
		cfg.addIcon("data/icon.png", FileType.Internal);
		new LwjglApplication(new CastleInvaders(), cfg);
	}
}
