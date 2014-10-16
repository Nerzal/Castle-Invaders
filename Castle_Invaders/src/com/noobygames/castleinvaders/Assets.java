package com.noobygames.castleinvaders;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


/** @author Tobi **/
public class Assets {
	public static Texture splashscreen;
	public static Texture background;
	public static TextureRegion backgroundRegion;
	public static Texture menuBackground;
	public static Pixmap pixmap;
	public static Sound fireBallHit;


	public static Texture greytroll;
	public static Texture lavatroll;
	public static Texture icetroll;
	public static Texture orc;
	public static Texture orcsnew;
	public static Texture fireBall;
	public static Texture sparks;
	public static Texture iceAttack;
	public static Texture firedragon;
	public static Texture icedragon;
	public static Texture earthdragon;
	public static Texture skeleton;
	public static Texture swampthing;
	public static Texture croco;
	public static Texture arrows;
	public static TextureRegion arrow;
	public static Texture tableTexture;

	public static Texture play;
	public static TextureRegion playRegion;
	public static Texture exit;
	public static TextureRegion exitRegion;

	public static Texture elementSwitcher;
	public static TextureRegion eleSwitchFire;
	public static TextureRegion eleSwitchIce;
	public static TextureRegion eleSwitchEarth;

	public static Texture golemselection;
	public static Texture window;

	public static Animation gta; // greytrollattack
	public static Animation gtw; // greytrollwalk
	public static Animation gtd; // greytrolldie
	public static Animation gth; // greytrollhit

	public static Animation lta; // lavatrollattack
	public static Animation ltw; // lavatrollwalk
	public static Animation ltd; // lavatrolldie
	public static Animation lth; // lavatrollhit

	public static Animation ita; // icetrollattack
	public static Animation itw; // icetrollwalk
	public static Animation itd; // icetrolldie;
	public static Animation ith; // icetrollhit;

	public static Animation orca; // orc attack
	public static Animation orcw; // orc walk
	public static Animation orcd; // orc die
	public static Animation orch; // orc hit
	public static Animation orcr; // orc run
	public static Animation orckw; // orc kwalk

	public static Animation grumblingIce; // iceattack
	public static Animation fireBolt; // fireball
	public static Animation sparklets;

	public static TextureRegion golemSelectionRegion;
	public static TextureRegion iceSpike;
	public static Texture dragonSwitchButton;
	public static TextureRegion fireDragonSwitch;
	public static TextureRegion fireDragonSwitchClicked;
	public static TextureRegion iceDragonSwitch;
	public static TextureRegion iceDragonSwitchClicked;
	public static TextureRegion earthDragonSwitch;
	public static TextureRegion earthDragonSwitchClicked;

	public static Animation earthDragonAttack;
	public static Animation iceDragonAttack;
	public static Animation fireDragonAttack;
	public static Animation fireDragonDie;
	public static Animation iceDragonDie;
	public static Animation earthDragonDie;
	public static Animation fireDragonWalk;
	public static Animation earthDragonWalk;
	public static Animation iceDragonWalk;
	public static Animation earthDragonHit;
	public static Animation earthDragonRead;
	public static Animation fireDragonSleep;
	public static Animation fireDragonHit;
	public static Animation iceDragonSleep;
	public static Animation iceDragonHit;
	public static Animation earthDragonReading;
	public static Animation bowSkeletonHit;
	public static Animation bowSkeletonDie;
	public static Animation bowSkeletonRun;
	public static Animation bowSkeletonShoot;
	public static Animation swordSkeletonAttack;
	public static Animation swordSkeletonWalk;
	public static Animation swordSkeletonRun;
	public static Animation swordSkeletonHit;
	public static Animation bowSkeletonWalk;
	public static Animation swordSkeletonDie;
	public static Animation murlocAttack;
	public static Animation murlocHit;
	public static Animation murlocRunning;
	public static Animation murlocDie;
	public static Animation murlocWalk;
	public static Animation crocoAttack;
	public static Animation crocoHit;
	public static Animation crocoLook;
	public static Animation crocoRun;
	public static Animation crocoDie;
	public static Animation crocoWalk;
	private static Texture settings;
	public static TextureRegion settingsRegion;
	private static Texture store;
	public static TextureRegion storeRegion;
	private static Texture storeLayout;
	public static TextureRegion storLayoutRegion;
	public static Texture greyTrollSelect;
	public static Texture iceTrollSelect;
	public static Texture lavaTrollSelect;

	public static void load(Game game) {
		Texture.setEnforcePotImages(false);
		background = new Texture(Gdx.files.internal("data/background.png"));
		backgroundRegion = new TextureRegion(background, 0, 0, 1280, 768);
		menuBackground = new Texture(Gdx.files.internal("data/menubackground.png"));
		tableTexture = new Texture(Gdx.files.internal("data/tableTest.png"));
		
		lavaTrollSelect = new Texture(Gdx.files.internal("data/lavatrollselect.png"));
		iceTrollSelect = new Texture(Gdx.files.internal("data/icetrollselect.png"));
		greyTrollSelect = new Texture(Gdx.files.internal("data/greytrollselect.png"));
		
		fireBallHit = Gdx.audio.newSound(Gdx.files.internal("data/fireBallHit.wav"));

		golemselection = new Texture(
				Gdx.files.internal("data/golemselection.png"));

		dragonSwitchButton = new Texture(Gdx.files.internal("data/dragonswitchbutton.png"));
		golemSelectionRegion = new TextureRegion(golemselection, 0, 0, 256, 128);
		earthDragonSwitch = new TextureRegion(dragonSwitchButton, 0, 0, 128, 128);
		earthDragonSwitchClicked = new TextureRegion(dragonSwitchButton, 128, 0, 128, 128);
		iceDragonSwitch = new TextureRegion(dragonSwitchButton, 256, 0, 128, 128);
		iceDragonSwitchClicked = new TextureRegion(dragonSwitchButton, 384, 0, 128, 128);
		fireDragonSwitch = new TextureRegion(dragonSwitchButton, 512, 0, 128, 128);
		fireDragonSwitchClicked = new TextureRegion(dragonSwitchButton, 640, 0, 128, 128);


		greytroll = new Texture(Gdx.files.internal("data/greytroll.png"));
		lavatroll = new Texture(Gdx.files.internal("data/lavatroll.png"));
		icetroll = new Texture(Gdx.files.internal("data/icetroll.png"));
		
		firedragon = new Texture(Gdx.files.internal("data/firedragon.png"));
		icedragon = new Texture(Gdx.files.internal("data/icedragon.png"));
		earthdragon = new Texture(Gdx.files.internal("data/earthdragon.png"));
		
		skeleton = new Texture(Gdx.files.internal("data/skeleton.png"));
		swampthing = new Texture(Gdx.files.internal("data/swampthing.png"));
		croco = new Texture(Gdx.files.internal("data/croco.png"));

		arrows = new Texture(Gdx.files.internal("data/arrow.png"));
		arrow = new TextureRegion(arrows,0,0,32,50);

		orc = new Texture(Gdx.files.internal("data/orc.png"));
		orcsnew = new Texture(Gdx.files.internal("data/orcsnew.png"));

		fireBall = new Texture(Gdx.files.internal("data/fireballs.png"));
		sparks = new Texture(Gdx.files.internal("data/sparks.png"));
		iceAttack = new Texture(Gdx.files.internal("data/iceattack.png"));

		play = new Texture(Gdx.files.internal("data/playButton.png")); // 192x96
		playRegion = new TextureRegion(play, 0, 0, 256, 256);
		exit = new Texture(Gdx.files.internal("data/exitButton.png")); // dito
		exitRegion = new TextureRegion(exit, 0, 0, 256, 256);
		settings = new Texture(Gdx.files.internal("data/settingsButton.png"));
		settingsRegion = new TextureRegion(settings, 0, 0, 256, 256);
		store = new Texture(Gdx.files.internal("data/storeButton.png"));
		storeRegion = new TextureRegion(store, 0, 0, 256, 256);
		
		storeLayout = new Texture(Gdx.files.internal("data/store.png"));
		storLayoutRegion = new TextureRegion(storeLayout, 0, 0, 1280, 768);

		elementSwitcher = new Texture(Gdx.files.internal("data/eleswitch.png"));
		eleSwitchFire = new TextureRegion(elementSwitcher, 256, 0, 128, 128);
		eleSwitchIce = new TextureRegion(elementSwitcher, 128, 0, 128, 128);
		eleSwitchEarth = new TextureRegion(elementSwitcher, 0, 0, 128, 128);

		window = new Texture(Gdx.files.internal("data/window.png"));
		splashscreen = new Texture(Gdx.files.internal("data/splashscreen.png"));

		gta = new Animation(13 / 60f,
				new TextureRegion(greytroll, 0, 0, 96, 96), // xstart,ystart,xend,yend
				new TextureRegion(greytroll, 96, 0, 96, 96), new TextureRegion(
						greytroll, 192, 0, 96, 96), new TextureRegion(
						greytroll, 288, 0, 96, 96), new TextureRegion(
						greytroll, 384, 0, 96, 96), new TextureRegion(
						greytroll, 480, 0, 96, 96), new TextureRegion(
						greytroll, 576, 0, 96, 96), new TextureRegion(
						greytroll, 672, 0, 96, 96), // 8
				new TextureRegion(greytroll, 0, 96, 96, 96), new TextureRegion(
						greytroll, 96, 96, 96, 96), new TextureRegion(
						greytroll, 192, 96, 96, 96), new TextureRegion(
						greytroll, 288, 96, 96, 96), new TextureRegion(
						greytroll, 384, 96, 96, 96)); // 13

		lta = new Animation(13 / 60f,
				new TextureRegion(lavatroll, 0, 0, 96, 96), // xstart,ystart,xend,yend
				new TextureRegion(lavatroll, 96, 0, 96, 96), new TextureRegion(
						lavatroll, 192, 0, 96, 96), new TextureRegion(
						lavatroll, 288, 0, 96, 96), new TextureRegion(
						lavatroll, 384, 0, 96, 96), new TextureRegion(
						lavatroll, 480, 0, 96, 96), new TextureRegion(
						lavatroll, 576, 0, 96, 96), new TextureRegion(
						lavatroll, 672, 0, 96, 96), // 8
				new TextureRegion(lavatroll, 0, 96, 96, 96), new TextureRegion(
						lavatroll, 96, 96, 96, 96), new TextureRegion(
						lavatroll, 192, 96, 96, 96), new TextureRegion(
						lavatroll, 288, 96, 96, 96), new TextureRegion(
						lavatroll, 384, 96, 96, 96)); // 13

		ita = new Animation(13 / 60f,
				new TextureRegion(icetroll, 0, 0, 96, 96), // xstart,ystart,xend,yend
				new TextureRegion(icetroll, 96, 0, 96, 96), new TextureRegion(
						icetroll, 192, 0, 96, 96), new TextureRegion(icetroll,
						288, 0, 96, 96), new TextureRegion(icetroll, 384, 0,
						96, 96), new TextureRegion(icetroll, 480, 0, 96, 96),
				new TextureRegion(icetroll, 576, 0, 96, 96), new TextureRegion(
						icetroll, 672, 0, 96, 96), // 8
				new TextureRegion(icetroll, 0, 96, 96, 96), new TextureRegion(
						icetroll, 96, 96, 96, 96), new TextureRegion(icetroll,
						192, 96, 96, 96), new TextureRegion(icetroll, 288, 96,
						96, 96), new TextureRegion(icetroll, 384, 96, 96, 96)); // 13

		gth = new Animation(11 / 60f,
				new TextureRegion(greytroll, 480, 96, 96, 96),
				new TextureRegion(greytroll, 576, 96, 96, 96),
				new TextureRegion(greytroll, 672, 96, 96, 96),
				new TextureRegion(greytroll, 0, 192, 96, 96),
				new TextureRegion(greytroll, 96, 192, 96, 96),
				new TextureRegion(greytroll, 192, 192, 96, 96),
				new TextureRegion(greytroll, 288, 192, 96, 96),
				new TextureRegion(greytroll, 384, 192, 96, 96), // 8
				new TextureRegion(greytroll, 480, 192, 96, 96),
				new TextureRegion(greytroll, 576, 192, 96, 96),
				new TextureRegion(greytroll, 672, 192, 96, 96)); // 11

		lth = new Animation(11 / 60f,
				new TextureRegion(lavatroll, 480, 96, 96, 96),
				new TextureRegion(lavatroll, 576, 96, 96, 96),
				new TextureRegion(lavatroll, 672, 96, 96, 96),
				new TextureRegion(lavatroll, 0, 192, 96, 96),
				new TextureRegion(lavatroll, 96, 192, 96, 96),
				new TextureRegion(lavatroll, 192, 192, 96, 96),
				new TextureRegion(lavatroll, 288, 192, 96, 96),
				new TextureRegion(lavatroll, 384, 192, 96, 96), // 8
				new TextureRegion(lavatroll, 480, 192, 96, 96),
				new TextureRegion(lavatroll, 576, 192, 96, 96),
				new TextureRegion(lavatroll, 672, 192, 96, 96)); // 11

		ith = new Animation(11 / 60f, new TextureRegion(icetroll, 480, 96, 96,
				96), new TextureRegion(icetroll, 576, 96, 96, 96),
				new TextureRegion(icetroll, 672, 96, 96, 96),
				new TextureRegion(icetroll, 0, 192, 96, 96), new TextureRegion(
						icetroll, 96, 192, 96, 96), new TextureRegion(icetroll,
						192, 192, 96, 96),
				new TextureRegion(icetroll, 288, 192, 96, 96),
				new TextureRegion(icetroll, 384, 192, 96, 96), // 8
				new TextureRegion(icetroll, 480, 192, 96, 96),
				new TextureRegion(icetroll, 576, 192, 96, 96),
				new TextureRegion(icetroll, 672, 192, 96, 96)); // 11

		gtd = new Animation(
				15 / 60f,
				new TextureRegion(greytroll, 0, 288, 96, 96),
				new TextureRegion(greytroll, 96, 288, 96, 96),
				new TextureRegion(greytroll, 192, 288, 96, 96),
				new TextureRegion(greytroll, 288, 288, 96, 96),
				new TextureRegion(greytroll, 384, 288, 96, 96),
				new TextureRegion(greytroll, 480, 288, 96, 96),
				new TextureRegion(greytroll, 576, 288, 96, 96),
				new TextureRegion(greytroll, 672, 288, 96, 96), // 8
				new TextureRegion(greytroll, 0, 384, 96, 96),
				new TextureRegion(greytroll, 96, 384, 96, 96),
				new TextureRegion(greytroll, 192, 384, 96, 96),
				new TextureRegion(greytroll, 288, 384, 96, 96), // 12
				new TextureRegion(greytroll, 384, 384, 96, 96),
				new TextureRegion(greytroll, 480, 384, 96, 96),
				new TextureRegion(greytroll, 576, 384, 96, 96)); // 15

		ltd = new Animation(
				15 / 60f,
				new TextureRegion(lavatroll, 0, 288, 96, 96),
				new TextureRegion(lavatroll, 96, 288, 96, 96),
				new TextureRegion(lavatroll, 192, 288, 96, 96),
				new TextureRegion(lavatroll, 288, 288, 96, 96),
				new TextureRegion(lavatroll, 384, 288, 96, 96),
				new TextureRegion(lavatroll, 480, 288, 96, 96),
				new TextureRegion(lavatroll, 576, 288, 96, 96),
				new TextureRegion(lavatroll, 672, 288, 96, 96), // 8
				new TextureRegion(lavatroll, 0, 384, 96, 96),
				new TextureRegion(lavatroll, 96, 384, 96, 96),
				new TextureRegion(lavatroll, 192, 384, 96, 96),
				new TextureRegion(lavatroll, 288, 384, 96, 96), // 12
				new TextureRegion(lavatroll, 384, 384, 96, 96),
				new TextureRegion(lavatroll, 480, 384, 96, 96),
				new TextureRegion(lavatroll, 576, 384, 96, 96)); // 15

		itd = new Animation(15 / 60f,
				new TextureRegion(icetroll, 0, 288, 96, 96),
				new TextureRegion(icetroll, 96, 288, 96, 96),
				new TextureRegion(icetroll, 192, 288, 96, 96),
				new TextureRegion(icetroll, 288, 288, 96, 96),
				new TextureRegion(icetroll, 384, 288, 96, 96),
				new TextureRegion(icetroll, 480, 288, 96, 96),
				new TextureRegion(icetroll, 576, 288, 96, 96),
				new TextureRegion(icetroll, 672, 288, 96, 96), // 8
				new TextureRegion(icetroll, 0, 384, 96, 96), 
				new TextureRegion(icetroll, 96, 384, 96, 96),
				new TextureRegion(icetroll, 192, 384, 96, 96),
				new TextureRegion(icetroll, 288, 384, 96, 96), // 12
				new TextureRegion(icetroll, 384, 384, 96, 96),
				new TextureRegion(icetroll, 480, 384, 96, 96),
				new TextureRegion(icetroll, 576, 384, 96, 96)); // 15

		gtw = new Animation(8 / 60f, new TextureRegion(greytroll, 672, 384, 96,
				96), new TextureRegion(greytroll, 0, 480, 96, 96),
				new TextureRegion(greytroll, 96, 480, 96, 96),
				new TextureRegion(greytroll, 192, 480, 96, 96),
				new TextureRegion(greytroll, 288, 480, 96, 96),
				new TextureRegion(greytroll, 384, 480, 96, 96),
				new TextureRegion(greytroll, 480, 480, 96, 96),
				new TextureRegion(greytroll, 576, 480, 96, 96));

		ltw = new Animation(8 / 60f, new TextureRegion(lavatroll, 672, 384, 96,
				96), new TextureRegion(lavatroll, 0, 480, 96, 96),
				new TextureRegion(lavatroll, 96, 480, 96, 96),
				new TextureRegion(lavatroll, 192, 480, 96, 96),
				new TextureRegion(lavatroll, 288, 480, 96, 96),
				new TextureRegion(lavatroll, 384, 480, 96, 96),
				new TextureRegion(lavatroll, 480, 480, 96, 96),
				new TextureRegion(lavatroll, 576, 480, 96, 96));

		itw = new Animation(9 / 60f, new TextureRegion(icetroll, 672, 384, 96,
				96), new TextureRegion(icetroll, 0, 480, 96, 96),
				new TextureRegion(icetroll, 96, 480, 96, 96),
				new TextureRegion(icetroll, 192, 480, 96, 96),
				new TextureRegion(icetroll, 288, 480, 96, 96),
				new TextureRegion(icetroll, 384, 480, 96, 96),
				new TextureRegion(icetroll, 480, 480, 96, 96),
				new TextureRegion(icetroll, 576, 480, 96, 96));

		orch = new Animation(9 / 60f, new TextureRegion(orcsnew, 0, 0, 96, 96),
				new TextureRegion(orcsnew, 96, 0, 96, 96), new TextureRegion(
						orcsnew, 192, 0, 96, 96), new TextureRegion(orcsnew,
						288, 0, 96, 96), new TextureRegion(orcsnew, 384, 0, 96,
						96), new TextureRegion(orcsnew, 480, 0, 96, 96),
				new TextureRegion(orcsnew, 576, 0, 96, 96), new TextureRegion(
						orcsnew, 672, 0, 96, 96), // 8
				new TextureRegion(orcsnew, 768, 0, 96, 96));

		orca = new Animation(11 / 60f, new TextureRegion(orcsnew, 864, 0, 96,
				96), new TextureRegion(orcsnew, 0, 96, 96, 96),
				new TextureRegion(orcsnew, 96, 96, 96, 96), new TextureRegion(
						orcsnew, 192, 96, 96, 96), new TextureRegion(orcsnew,
						288, 96, 96, 96), new TextureRegion(orcsnew, 384, 96,
						96, 96), new TextureRegion(orcsnew, 480, 96, 96, 96),
				new TextureRegion(orcsnew, 576, 96, 96, 96), new TextureRegion(
						orcsnew, 672, 96, 96, 96), new TextureRegion(orcsnew,
						768, 96, 96, 96), new TextureRegion(orcsnew, 864, 192,
						96, 96)); // 11

		orcd = new Animation(11 / 60f, new TextureRegion(orcsnew, 0, 192, 96,
				96), new TextureRegion(orcsnew, 96, 192, 96, 96),
				new TextureRegion(orcsnew, 192, 192, 96, 96),
				new TextureRegion(orcsnew, 288, 192, 96, 96),
				new TextureRegion(orcsnew, 384, 192, 96, 96),
				new TextureRegion(orcsnew, 480, 192, 96, 96),
				new TextureRegion(orcsnew, 576, 192, 96, 96),
				new TextureRegion(orcsnew, 672, 192, 96, 96),
				new TextureRegion(orcsnew, 768, 192, 96, 96),
				new TextureRegion(orcsnew, 864, 192, 96, 96),
				new TextureRegion(orcsnew, 0, 288, 96, 96)); // 11

		orcw = new Animation(8 / 60f, new TextureRegion(orcsnew, 96, 288, 96,
				96), new TextureRegion(orcsnew, 192, 288, 96, 96),
				new TextureRegion(orcsnew, 288, 288, 96, 96),
				new TextureRegion(orcsnew, 288, 288, 96, 96),
				new TextureRegion(orcsnew, 384, 288, 96, 96),
				new TextureRegion(orcsnew, 480, 288, 96, 96),
				new TextureRegion(orcsnew, 576, 288, 96, 96),
				new TextureRegion(orcsnew, 672, 288, 96, 96)); // 8

		orcr = new Animation(11 / 60f, new TextureRegion(orcsnew, 768, 288, 96,
				96), new TextureRegion(orcsnew, 864, 288, 96, 96),
				new TextureRegion(orcsnew, 0, 384, 96, 96), new TextureRegion(
						orcsnew, 96, 384, 96, 96), new TextureRegion(orcsnew,
						192, 384, 96, 96), new TextureRegion(orcsnew, 288, 384,
						96, 96), new TextureRegion(orcsnew, 384, 384, 96, 96),
				new TextureRegion(orcsnew, 480, 384, 96, 96),
				new TextureRegion(orcsnew, 576, 384, 96, 96)); // 11

		orckw = new Animation(8 / 60f, new TextureRegion(orcsnew, 672, 384, 96,
				96), new TextureRegion(orcsnew, 768, 384, 96, 96),
				new TextureRegion(orcsnew, 864, 384, 96, 96),
				new TextureRegion(orcsnew, 0, 480, 96, 96), new TextureRegion(
						orcsnew, 96, 480, 96, 96), new TextureRegion(orcsnew,
						192, 480, 96, 96), new TextureRegion(orcsnew, 288, 480,
						96, 96), new TextureRegion(orcsnew, 384, 480, 96, 96));

		// Feuerdrachen Animationen
		fireDragonAttack = new Animation(9 / 60f, 
				new TextureRegion(firedragon, 0, 0, 128, 128),
				new TextureRegion(firedragon, 128, 0, 115, 90),
				new TextureRegion(firedragon, 256, 0, 115, 90),
				new TextureRegion(firedragon, 384, 0, 115, 90),
				new TextureRegion(firedragon, 512, 0, 115, 90),
				new TextureRegion(firedragon, 640, 0, 115, 90),
				new TextureRegion(firedragon, 768, 0, 115, 90),
				new TextureRegion(firedragon, 896, 0, 115, 90),
				new TextureRegion(firedragon, 0, 128, 115, 90));

		fireDragonDie = new Animation(11 / 60f,
				new TextureRegion(firedragon, 128, 128, 115, 90),
				new TextureRegion(firedragon, 256, 128, 115, 90),
				new TextureRegion(firedragon, 384, 128, 115, 90),
				new TextureRegion(firedragon, 640, 128, 115, 90),
				new TextureRegion(firedragon, 768, 128, 115, 90), // 5
				new TextureRegion(firedragon, 896, 128, 115, 90),
				new TextureRegion(firedragon, 0, 256, 115, 90),
				new TextureRegion(firedragon, 128, 256, 115, 90),
				new TextureRegion(firedragon, 256, 256, 115, 90),
				new TextureRegion(firedragon, 384, 256, 115, 90));
		
		fireDragonWalk = new Animation(9 / 60f,
				new TextureRegion(firedragon, 512, 256, 115, 90),
				new TextureRegion(firedragon, 640, 256, 115, 90),
				new TextureRegion(firedragon, 768, 256, 115, 90),
				new TextureRegion(firedragon, 896, 256, 115, 90),
				new TextureRegion(firedragon, 0, 384, 115, 90),
				new TextureRegion(firedragon, 128, 384, 115, 90), // 5
				new TextureRegion(firedragon, 256, 384, 115, 90),
				new TextureRegion(firedragon, 384, 384, 115, 90),
				new TextureRegion(firedragon, 512, 384, 115, 90));
		
		fireDragonSleep = new Animation(9 / 60f, 
				new TextureRegion(firedragon, 640, 384, 115, 90),
				new TextureRegion(firedragon, 768, 384, 115, 90), 
				new TextureRegion(firedragon, 896, 384, 115, 90), 
				new TextureRegion(firedragon, 0, 512, 115, 90),
				new TextureRegion(firedragon, 128, 512, 115, 90),
				new TextureRegion(firedragon, 256, 512, 115, 90),
				new TextureRegion(firedragon, 384, 512, 115, 90),
				new TextureRegion(firedragon, 512, 512, 115, 90),
				new TextureRegion(firedragon, 640, 512, 115, 90));
			
		fireDragonHit = new Animation(7 / 60f, 
				new TextureRegion(firedragon, 768, 512, 115, 90),
				new TextureRegion(firedragon, 896, 512, 115, 90), 
				new TextureRegion(firedragon, 0, 640, 115, 90), 
				new TextureRegion(firedragon, 128, 640, 115, 90),
				new TextureRegion(firedragon, 256, 640, 115, 90),
				new TextureRegion(firedragon, 384, 640, 115, 90),
				new TextureRegion(firedragon, 512, 640, 115, 90));

		// Eisdrachen Animationen
		
		iceDragonAttack = new Animation(9 / 60f, 
				new TextureRegion(icedragon, 0, 0, 115, 90),
				new TextureRegion(icedragon, 128, 0, 115, 90),
				new TextureRegion(icedragon, 256, 0, 115, 90),
				new TextureRegion(icedragon, 384, 0, 115, 90),
				new TextureRegion(icedragon, 512, 0, 115, 90),
				new TextureRegion(icedragon, 640, 0, 115, 90),
				new TextureRegion(icedragon, 768, 0, 115, 90),
				new TextureRegion(icedragon, 896, 0, 115, 90),
				new TextureRegion(icedragon, 0, 128, 115, 90));

		iceDragonDie = new Animation(10 / 60f,
				new TextureRegion(icedragon, 128, 128, 115, 90),
				new TextureRegion(icedragon, 256, 128, 115, 128),
				new TextureRegion(icedragon, 384, 128, 115, 128),
				new TextureRegion(icedragon, 640, 128, 115, 90),
				new TextureRegion(icedragon, 768, 128, 115, 90), // 5
				new TextureRegion(icedragon, 896, 128, 115, 90),
				new TextureRegion(icedragon, 0, 256, 115, 128),
				new TextureRegion(icedragon, 128, 256, 115, 90),
				new TextureRegion(icedragon, 256, 256, 115, 90));
			
		iceDragonWalk = new Animation(8 / 60f,
				new TextureRegion(icedragon, 384, 256, 115, 90),
				new TextureRegion(icedragon, 512, 256, 115, 90),
				new TextureRegion(icedragon, 640, 256, 115, 90),
				new TextureRegion(icedragon, 768, 256, 115, 90),
				new TextureRegion(icedragon, 896, 256, 115, 90),
				new TextureRegion(icedragon, 0, 384, 115, 90),
				new TextureRegion(icedragon, 128, 384, 115, 90), // 5
				new TextureRegion(icedragon, 256, 384, 115, 90));
				
		iceDragonSleep = new Animation(9 / 60f, 
				new TextureRegion(icedragon, 384, 384, 115, 90),
				new TextureRegion(icedragon, 512, 384, 115, 90),
				new TextureRegion(icedragon, 640, 384, 115, 90),
				new TextureRegion(icedragon,768, 384, 115, 90), 
				new TextureRegion(icedragon, 896, 384, 115, 90), 
				new TextureRegion(icedragon, 0, 512, 115, 90),
				new TextureRegion(icedragon, 128, 512, 115, 90),
				new TextureRegion(icedragon, 256, 512, 115, 90),
				new TextureRegion(icedragon, 384, 512, 115, 90));
		
		iceDragonHit = new Animation(7 / 60f, 
				new TextureRegion(icedragon, 512, 512, 115, 90),
				new TextureRegion(icedragon, 896, 512, 115, 90), 
				new TextureRegion(icedragon, 0, 640, 115, 90),
				new TextureRegion(icedragon, 128, 640, 115, 90),
				new TextureRegion(icedragon, 256, 640, 115, 90),
				new TextureRegion(icedragon, 384, 640, 115, 90),
				new TextureRegion(icedragon, 512, 640, 115, 90));

		// Erd Drachen Animationen
		earthDragonAttack = new Animation(9 / 60f, 
				new TextureRegion(earthdragon, 0, 0, 115, 90), 
				new TextureRegion(earthdragon, 128, 0, 115, 90), 
				new TextureRegion(earthdragon, 256, 0, 115, 90), 
				new TextureRegion(earthdragon, 384, 0, 115, 90),
				new TextureRegion(earthdragon, 512, 0, 115, 90),
				new TextureRegion(earthdragon, 640, 0, 115, 90),
				new TextureRegion(earthdragon, 768, 0, 115, 90),
				new TextureRegion(earthdragon, 896, 0, 115, 90),
				new TextureRegion(earthdragon, 0, 128, 115, 90));

		earthDragonHit = new Animation(7 / 60f, 
				new TextureRegion(earthdragon, 128, 128, 115, 90), 
				new TextureRegion(earthdragon, 256, 128,115, 90), 
				new TextureRegion(earthdragon, 384, 128, 115, 90),
				new TextureRegion(earthdragon, 512, 128, 115, 90),
				new TextureRegion(earthdragon, 640, 128, 115, 90),
				new TextureRegion(earthdragon, 768, 128, 115, 90),
				new TextureRegion(earthdragon, 896, 128, 115, 90));

		earthDragonReading = new Animation(9 / 60f, 
				new TextureRegion(earthdragon, 0, 256, 115, 90), 
				new TextureRegion(earthdragon, 128, 256, 115, 90), 
				new TextureRegion(earthdragon, 256, 256, 115, 90), 
				new TextureRegion(earthdragon, 384, 256, 115, 90),
				new TextureRegion(earthdragon, 512, 256, 115, 90),
				new TextureRegion(earthdragon, 640, 256, 115, 90),
				new TextureRegion(earthdragon, 768, 256, 115, 90),
				new TextureRegion(earthdragon, 896, 256, 115, 90),
				new TextureRegion(earthdragon, 0, 384, 115, 90));

		earthDragonDie = new Animation(11 / 60f, 
				new TextureRegion(earthdragon, 128, 384, 115, 90), 
				new TextureRegion(earthdragon, 256, 384, 115, 90), 
				new TextureRegion(earthdragon, 384, 384, 115, 90),
				new TextureRegion(earthdragon, 512, 384, 115, 90),
				new TextureRegion(earthdragon, 640, 384, 115, 90),
				new TextureRegion(earthdragon, 768, 384, 115, 90),
				new TextureRegion(earthdragon, 896, 384, 115, 90), 
				new TextureRegion(earthdragon, 0, 512, 115, 90), 
				new TextureRegion(earthdragon, 128, 512, 115, 90),
				new TextureRegion(earthdragon, 256, 512, 115, 90),
				new TextureRegion(earthdragon, 384, 512, 115, 90));
				
		
		earthDragonWalk = new Animation(8 / 60f, 
				new TextureRegion(earthdragon, 512, 512, 115, 90),
				new TextureRegion(earthdragon, 640, 512, 115, 90),
				new TextureRegion(earthdragon, 768, 512, 115, 90),
				new TextureRegion(earthdragon, 896, 512, 115, 90),
				new TextureRegion(earthdragon, 0, 640, 115, 90), 
				new TextureRegion(earthdragon, 128, 640, 115, 90),
				new TextureRegion(earthdragon, 256, 640, 115, 90),
				new TextureRegion(earthdragon, 384, 640, 115, 90));

		bowSkeletonHit = new Animation(7 / 60f, 
				new TextureRegion(skeleton, 0, 0, 96, 96), 
				new TextureRegion(skeleton, 96, 0, 96, 96),
				new TextureRegion(skeleton, 192, 0, 96, 96), 
				new TextureRegion(skeleton, 288, 0, 96, 96), 
				new TextureRegion(skeleton,384, 0, 96, 96), 
				new TextureRegion(skeleton, 480, 0,96, 96), 
				new TextureRegion(skeleton, 576, 0, 96, 96));

		bowSkeletonDie = new Animation(9 / 60f, 
				new TextureRegion(skeleton, 672, 0, 96, 96), 
				new TextureRegion(skeleton, 768, 0, 96, 96),
				new TextureRegion(skeleton, 864, 0, 96, 96), 
				new TextureRegion(skeleton, 0, 96, 96, 96), 
				new TextureRegion(skeleton, 96, 96, 96, 96), 
				new TextureRegion(skeleton, 192, 96,96, 96), 
				new TextureRegion(skeleton, 288, 96, 96, 96),
				new TextureRegion(skeleton, 384, 96, 96, 96),
				new TextureRegion(skeleton, 480, 96, 96, 96));

		bowSkeletonRun = new Animation(8 / 60f, 
				new TextureRegion(skeleton,576, 96, 96, 96), 
				new TextureRegion(skeleton, 672, 96, 96, 96),
				new TextureRegion(skeleton, 768, 96, 96, 96),
				new TextureRegion(skeleton, 864, 96, 96, 96),
				new TextureRegion(skeleton, 0, 192, 96, 96), 
				new TextureRegion(skeleton, 96, 192, 96, 96), 
				new TextureRegion(skeleton, 192, 192, 96, 96), 
				new TextureRegion(skeleton, 288, 192, 96, 96));

		bowSkeletonShoot = new Animation(13 / 60f, 
				new TextureRegion(skeleton,384, 192, 96, 96),
				new TextureRegion(skeleton, 480, 192, 96, 96),
				new TextureRegion(skeleton, 576, 192, 96, 96),
				new TextureRegion(skeleton, 672, 192, 96, 96),
				new TextureRegion(skeleton, 768, 192, 96, 96),
				new TextureRegion(skeleton, 864, 192, 96, 96),
				new TextureRegion(skeleton, 0, 288, 96, 96), 
				new TextureRegion(skeleton, 96, 288, 96, 96), 
				new TextureRegion(skeleton, 192, 288, 96, 96), 
				new TextureRegion(skeleton, 288, 288, 96, 96), 
				new TextureRegion(skeleton, 384, 288, 96,96), 
				new TextureRegion(skeleton, 480, 288, 96, 96),
				new TextureRegion(skeleton, 576, 288, 96, 96));

		swordSkeletonAttack = new Animation(9 / 60f, 
				new TextureRegion(skeleton, 672, 288, 96, 96), 
				new TextureRegion(skeleton, 768, 288, 96, 96), 
				new TextureRegion(skeleton, 864, 288, 96, 96),
				new TextureRegion(skeleton, 0, 384, 96, 96), 
				new TextureRegion(skeleton, 96, 384, 96, 96), 
				new TextureRegion(skeleton, 192, 384, 96, 96), 
				new TextureRegion(skeleton, 288, 384, 96, 96), 
				new TextureRegion(skeleton, 384, 384, 96,96), 
				new TextureRegion(skeleton, 480, 384, 96, 96));

		swordSkeletonWalk = new Animation(9 / 60f, 
				new TextureRegion(skeleton,576, 384, 96, 96),
				new TextureRegion(skeleton, 672, 384, 96, 96),
				new TextureRegion(skeleton, 768, 384, 96, 96),
				new TextureRegion(skeleton, 864, 384, 96, 96),
				new TextureRegion(skeleton, 0, 480, 96, 96), 
				new TextureRegion(skeleton, 96, 480, 96, 96), 
				new TextureRegion(skeleton, 192, 480, 96, 96), 
				new TextureRegion(skeleton, 288, 480, 96, 96), 
				new TextureRegion(skeleton, 384, 480, 96, 96));

		swordSkeletonRun = new Animation(9 / 60f, 
				new TextureRegion(skeleton, 480, 480, 96, 96),
				new TextureRegion(skeleton, 576, 480, 96, 96),
				new TextureRegion(skeleton, 672, 480, 96, 96),
				new TextureRegion(skeleton, 768, 480, 96, 96),
				new TextureRegion(skeleton, 864, 480, 96, 96),
				new TextureRegion(skeleton, 0, 576, 96, 96), 
				new TextureRegion(skeleton, 96, 576, 96, 96), 
				new TextureRegion(skeleton, 192, 576, 96, 96), 
				new TextureRegion(skeleton, 288, 576, 96, 96));

		swordSkeletonHit = new Animation(7 / 60f, 
				new TextureRegion(skeleton, 384, 576, 96, 96),
				new TextureRegion(skeleton, 480, 576, 96, 96),
				new TextureRegion(skeleton, 576, 576, 96, 96),
				new TextureRegion(skeleton, 672, 576, 96, 96),
				new TextureRegion(skeleton, 768, 576, 96, 96),
				new TextureRegion(skeleton, 864, 576, 96, 96),
				new TextureRegion(skeleton, 0, 672, 96, 96), 
				new TextureRegion(skeleton, 96, 672, 96, 96));

		bowSkeletonWalk = new Animation(8 / 60f, 
				new TextureRegion(skeleton, 192, 672, 96, 96),
				new TextureRegion(skeleton, 288, 672, 96, 96),
				new TextureRegion(skeleton, 384, 672, 96, 96),
				new TextureRegion(skeleton, 480, 672, 96, 96),
				new TextureRegion(skeleton, 576, 672, 96, 96),
				new TextureRegion(skeleton, 672, 672, 96, 96),
				new TextureRegion(skeleton, 768, 672, 96, 96),
				new TextureRegion(skeleton, 864, 672, 96, 96));

		swordSkeletonDie = new Animation(9 / 60f, 
				new TextureRegion(skeleton, 192, 672, 96, 96),
				new TextureRegion(skeleton, 288, 672, 96, 96),
				new TextureRegion(skeleton, 384, 672, 96, 96),
				new TextureRegion(skeleton, 480, 672, 96, 96),
				new TextureRegion(skeleton, 576, 672, 96, 96),
				new TextureRegion(skeleton, 672, 672, 96, 96),
				new TextureRegion(skeleton, 768, 672, 96, 96),
				new TextureRegion(skeleton, 864, 672, 96, 96),
				new TextureRegion(skeleton, 0, 768, 96, 96));

		murlocAttack = new Animation(13 / 60f, 
				new TextureRegion(swampthing, 0, 0, 96, 96), 
				new TextureRegion(swampthing, 96, 0, 96, 96),
				new TextureRegion(swampthing, 192, 0, 96, 96),
				new TextureRegion(swampthing, 288, 0, 96, 96),
				new TextureRegion(swampthing, 384, 0, 96, 96),
				new TextureRegion(swampthing, 480, 0, 96, 96),
				new TextureRegion(swampthing, 576, 0, 96, 96),
				new TextureRegion(swampthing, 672, 0, 96, 96),
				new TextureRegion(swampthing, 768, 0, 96, 96),
				new TextureRegion(swampthing, 864, 0, 96, 96),
				new TextureRegion(swampthing, 0, 96, 96, 96),
				new TextureRegion(swampthing, 96, 96, 96, 96),
				new TextureRegion(swampthing, 192, 96, 96, 96));

		murlocHit = new Animation(9 / 60f, 
				new TextureRegion(swampthing, 288, 96, 96, 96), 
				new TextureRegion(swampthing, 384, 96, 96, 96),
				new TextureRegion(swampthing, 480, 96, 96, 96),
				new TextureRegion(swampthing, 576, 96, 96, 96),
				new TextureRegion(swampthing, 672, 96, 96, 96),
				new TextureRegion(swampthing, 768, 96, 96, 96),
				new TextureRegion(swampthing, 864, 96, 96, 96),
				new TextureRegion(swampthing, 0, 192, 96, 96),
				new TextureRegion(swampthing, 96, 192, 96, 96));

		murlocRunning = new Animation(8 / 60f, 
				new TextureRegion(swampthing,192, 192, 96, 96), 
				new TextureRegion(swampthing, 288, 192, 96,96), 
				new TextureRegion(swampthing, 384, 192, 96, 96),
				new TextureRegion(swampthing, 480, 192, 96, 96),
				new TextureRegion(swampthing, 576, 192, 96, 96),
				new TextureRegion(swampthing, 672, 192, 96, 96),
				new TextureRegion(swampthing, 768, 192, 96, 96),
				new TextureRegion(swampthing, 864, 192, 96, 96));

		murlocDie = new Animation(13 / 60f, 
				new TextureRegion(swampthing, 0,288, 96, 96), 
				new TextureRegion(swampthing, 96, 288, 96, 96),
				new TextureRegion(swampthing, 192, 288, 96, 96),
				new TextureRegion(swampthing, 288, 288, 96, 96),
				new TextureRegion(swampthing, 384, 288, 96, 96),
				new TextureRegion(swampthing, 480, 288, 96, 96),
				new TextureRegion(swampthing, 576, 288, 96, 96),
				new TextureRegion(swampthing, 672, 288, 96, 96),
				new TextureRegion(swampthing, 768, 288, 96, 96),
				new TextureRegion(swampthing, 864, 288, 96, 96),
				new TextureRegion(swampthing, 0, 384, 96, 96),
				new TextureRegion(swampthing, 96, 384, 96, 96),
				new TextureRegion(swampthing, 192, 384, 96, 96));

		murlocWalk = new Animation(8 / 60f, 
				new TextureRegion(swampthing, 288,384, 96, 96), 
				new TextureRegion(swampthing, 384, 384, 96, 96),
				new TextureRegion(swampthing, 480, 384, 96, 96),
				new TextureRegion(swampthing, 576, 384, 96, 96),
				new TextureRegion(swampthing, 672, 384, 96, 96),
				new TextureRegion(swampthing, 768, 384, 96, 96),
				new TextureRegion(swampthing, 864, 384, 96, 96),
				new TextureRegion(swampthing, 0, 480, 96, 96));

		crocoAttack = new Animation(11 / 60f, 
				new TextureRegion(croco, 0, 0, 128, 128), 
				new TextureRegion(croco, 128, 0, 128, 128),
				new TextureRegion(croco, 256, 0, 128, 128), 
				new TextureRegion(croco, 384, 0, 128, 128), 
				new TextureRegion(croco, 512, 0, 128, 128),
				new TextureRegion(croco, 640, 0, 128, 128), 
				new TextureRegion(croco, 768, 0, 128, 128), 
				new TextureRegion(croco, 896, 0, 128, 128),
				new TextureRegion(croco, 0, 128, 128, 128), 
				new TextureRegion(croco, 128, 128, 128, 128), 
				new TextureRegion(croco, 256, 128, 128, 128));

		crocoHit = new Animation(9 / 60f, 
				new TextureRegion(croco, 384, 128,128, 128), 
				new TextureRegion(croco, 512, 128, 128, 128),
				new TextureRegion(croco, 640, 128, 128, 128),
				new TextureRegion(croco, 768, 128, 128, 128),
				new TextureRegion(croco, 896, 128, 128, 128),
				new TextureRegion(croco, 0, 256, 128, 128),
				new TextureRegion(croco, 128, 256, 128, 128), 
				new TextureRegion(croco,256, 256, 128, 128), 
				new TextureRegion(croco, 384, 256,128, 128));

		crocoLook = new Animation(13 / 60f, 
				new TextureRegion(croco, 512, 256, 128, 128), 
				new TextureRegion(croco, 640, 256, 128, 128),
				new TextureRegion(croco, 768, 256, 128, 128),
				new TextureRegion(croco, 896, 256, 128, 128),
				new TextureRegion(croco, 0, 384, 128, 128), 
				new TextureRegion(croco, 128, 384, 128, 128), 
				new TextureRegion(croco, 256, 384, 128, 128), 
				new TextureRegion(croco, 384, 384,128, 128),
				new TextureRegion(croco, 512, 384, 128, 128),
				new TextureRegion(croco, 640, 384, 128, 128),
				new TextureRegion(croco, 768, 384, 128, 128),
				new TextureRegion(croco, 896, 384, 128, 128),
				new TextureRegion(croco, 0, 512, 128, 128));

		crocoRun = new Animation(8 / 60f, 
				new TextureRegion(croco, 128, 512, 128, 128), 
				new TextureRegion(croco, 256, 512, 128, 128),
				new TextureRegion(croco, 384, 512, 128, 128),
				new TextureRegion(croco, 512, 512, 128, 128),
				new TextureRegion(croco, 640, 512, 128, 128),
				new TextureRegion(croco, 768, 512, 128, 128),
				new TextureRegion(croco, 896, 512, 128, 128),
				new TextureRegion(croco, 0, 640, 128, 128));

		crocoDie = new Animation(11 / 60f, 
				new TextureRegion(croco, 128, 640,128, 128),
				new TextureRegion(croco, 256, 640, 128, 128),
				new TextureRegion(croco, 384, 640, 128, 128),
				new TextureRegion(croco, 512, 640, 128, 128),
				new TextureRegion(croco, 640, 640, 128, 128),
				new TextureRegion(croco, 768, 640, 128, 128),
				new TextureRegion(croco, 896, 640, 128, 128),
				new TextureRegion(croco, 0, 768, 128, 128), 
				new TextureRegion(croco, 128, 768, 128, 128), 
				new TextureRegion(croco, 256, 768, 128, 128), 
				new TextureRegion(croco, 384, 768, 128, 128));

		crocoWalk = new Animation(8 / 60f, 
				new TextureRegion(croco, 512, 768, 128, 128), 
				new TextureRegion(croco, 640, 768, 128, 128),
				new TextureRegion(croco, 768, 768, 128, 128),
				new TextureRegion(croco, 896, 768, 128, 128),
				new TextureRegion(croco, 0, 896, 128, 128), 
				new TextureRegion(croco, 128, 896, 128, 128), 
				new TextureRegion(croco, 256, 896, 128, 128), 
				new TextureRegion(croco, 384, 896, 128, 128));

		grumblingIce = new Animation(5 / 60f, 
				new TextureRegion(iceAttack, 0, 0, 128, 128), 
				new TextureRegion(iceAttack, 128, 0, 128, 128),
				new TextureRegion(iceAttack, 256, 0, 128, 128),
				new TextureRegion(iceAttack, 384, 0, 128, 128),
				new TextureRegion(iceAttack, 512, 0, 128, 128));

		iceSpike = new TextureRegion(iceAttack, 640, 0, 128, 128);

		fireBolt = new Animation(4 / 60f, new TextureRegion(fireBall, 0, 0,
				128, 128), new TextureRegion(fireBall, 128, 0, 128, 128),
				new TextureRegion(fireBall, 256, 0, 128, 128),
				new TextureRegion(fireBall, 384, 0, 128, 128));

		sparklets = new Animation(4 / 60, new TextureRegion(sparks, 0, 0, 128,
				128), new TextureRegion(sparks, 128, 0, 128, 128),
				new TextureRegion(sparks, 256, 0, 128, 128), new TextureRegion(
						sparks, 384, 0, 128, 128));

	}
	public static void loadMenu(Game game){
		menuBackground = new Texture(Gdx.files.internal("menubackground.png"));
	}
}
