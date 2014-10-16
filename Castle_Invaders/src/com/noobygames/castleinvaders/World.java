package com.noobygames.castleinvaders;

import java.util.Random;

import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;
import com.noobygames.castleinvaders.mobs.Croco;
import com.noobygames.castleinvaders.mobs.FireDragon;
import com.noobygames.castleinvaders.mobs.FireTroll;
import com.noobygames.castleinvaders.mobs.IceDragon;
import com.noobygames.castleinvaders.mobs.IceTroll;
import com.noobygames.castleinvaders.mobs.Murloc;
import com.noobygames.castleinvaders.mobs.Orc;
import com.noobygames.castleinvaders.mobs.EarthDragon;
import com.noobygames.castleinvaders.mobs.Skeleton;
import com.noobygames.castleinvaders.mobs.GreyTroll;
import com.noobygames.nerzal.castleinvaders.spells.Spells;

/**
 * Updates&Spawns all Objects in the World
 * 
 * @author Noobygames T.Theel
 * **/
public class World {
	public static final int elementEarth = 1;
	public static final int elementLava = 2;
	public static final int elementIce = 3;
	public static int elementState = World.elementEarth;
	public FPSLogger fps;
	public float maxMana = 2000;
	public float mana = maxMana;
	public static int hp = 100;
	Timer timer;
	Random random;

	int orccount;
	public static boolean golemSelect = false;
	private int maxEnemies;
	private int level = 1;
	private int enemyCounter;
	private float spawnTimer;

	public static boolean win;
	public static boolean levelEnd;
	private int wave;

	public static Array<GameLiving> enemyEntities;
	public static Array<GameLiving> mobs;
	public static Array<Spells> spells;
	public static Array<Projectile> projectiles;
	


	public static int earthDragonXP = 0;
	public static int iceDragonXP = 0;
	public static int fireDragonXP = 0;

	// private boolean debug;
	public enum Species {
		greyTroll, lavaTroll, iceTroll, orc, fireBolt, grumblingIce, spell, skeleton, earthDragon, iceDragon, fireDragon, croco, murloc, arrow
	};

	public enum States {
		attack, walk, kwalk, die, run, hit, rangeAttack, look, sleep, read
	};


	/**
	 * Returns the count of all enemies spawned
	 * 
	 * @return Number of enemies
	 **/
	public int getEnemyCounter() {
		return enemyCounter;
	}

	/**
	 * Adds the given amount to the earthdragons xp
	 * 
	 * @param xp
	 *            int Amount of experience points to add
	 **/
	public static void addEarthDragonXP(int xp) {
		earthDragonXP += xp;
		/**
		 * Adds the given amount to the icedragons xp
		 * 
		 * @param xp
		 *            int Amount of experience points to add
		 **/
	}

	public static void addIceDragonXP(int xp) {
		iceDragonXP += xp;
	}

	/**
	 * Adds the given amount to the firedragons xp
	 * 
	 * @param xp
	 *            int Amount of experience points to add
	 **/
	public static void addFireDragonXP(int xp) {
		fireDragonXP += xp;
	}

	/**
	 * Initialises the World -> Creates a new Array for Trolls (own Mobs) and
	 * another list for enemy mobs, creates a timer, fps counter and random()
	 * **/
	public World(int level) {
		mobs = new Array<GameLiving>();
		enemyEntities = new Array<GameLiving>();
		spells = new Array<Spells>();
		projectiles = new Array<Projectile>();

		this.timer = new Timer();
		this.fps = new FPSLogger();
		this.random = new Random();
		this.level = level;

		enemyCounter = 0;
		maxEnemies = level * 6;
		spawnTimer = 2;
		wave = 1;
		World.levelEnd = false;
		// this.debug = false;
	}

	/**
	 * Spawns waves of mobs till maxEnemies is reached
	 * 
	 * @param delta
	 *            Actual deltaTime like Gdx.graphics.getDeltaTime();
	 * **/

	private void generateLevel(float delta) {
		int lanes[] = { 0, 128, 256, 384, 512, 640 };
		if (enemyCounter < maxEnemies) {
			for (int i = 0; i < lanes.length; i++) {
				if (wave % 2 != 0 && wave % 3 != 0)
					spawnMob(1280, lanes[i], Species.orc, level, i);
				else if (wave % 2 == 0)
					spawnMob(1200, lanes[i], Species.skeleton, level, i);
				else if (wave % 3 == 0)
					spawnMob(1200, lanes[i], Species.croco, level, i);
				else
					spawnMob(1200, lanes[i], Species.murloc, level, i);

				enemyCounter++;
			}
			wave++;
			spawnTimer += 10;
		} else
			World.levelEnd = true;
	}

	private void generateTestLevel(float delta) {
		if (enemyEntities.size == 0 && enemyCounter <= 2)
			spawnMob(1200, 384, Species.skeleton, level, 3);
	}

	/**
	 * Calls : generateLevel, updateMobs and regenMana
	 * @param delta
	 *            Actual delta time (The time between last and actual frame)
	 * **/
	public void updateWorld(float delta) {
		if (spawnTimer <= 0 && enemyCounter < maxEnemies)
			generateLevel(delta);
		// generateTestLevel(delta);
		else
			spawnTimer -= delta;

	
		updateMobs(delta);
		updateSpells(delta);
		updateProjectiles(delta);
		regenMana(delta);
	}

	/**
	 * This function spawns specific mobs depending on the Species
	 * 
	 * @param f
	 *            x-coord to spawn
	 * @param g
	 *            y-coord to spawn
	 * @param species
	 *            species of the object to spawn
	 * @param mobLevel
	 *            specific level of the mob to spawn
	 * 
	 * **/
	public void spawnMob(float f, float g, Species species, int mobLevel,
			int lane) {
		switch (species) {
		case greyTroll:
			if (mana >= 20) {
				mobs.add(new GreyTroll(0, g, species, mobLevel, lane));
				mana -= 20;
			}
			break;
		case lavaTroll:
			if (mana >= 30) {
				mobs.add(new FireTroll(0, g, species, mobLevel, lane));
				mana -= 30;
			}
			break;
		case iceTroll:
			if (mana >= 30) {
				mobs.add(new IceTroll(0, g, species, mobLevel, lane));
				mana -= 30;
			}
			break;

		case earthDragon:
			if (mana >= 100) {
				mobs.add(new EarthDragon(0, g, species, mobLevel, lane));
				mana -= 100;
			}
			break;

		case iceDragon:
			if (mana >= 100) {
				mobs.add(new IceDragon(0, g, species, mobLevel, lane));
				mana -= 100;
			}
			break;

		case fireDragon:
			if (mana >= 100) {
				mobs.add(new FireDragon(0, g, species, mobLevel, lane));
				mana -= 100;
			}
			break;

		case orc:
			enemyEntities.add(new Orc(f, g, species, mobLevel, lane));
			break;

		case skeleton:
			enemyEntities.add(new Skeleton(f, g, species, mobLevel, lane));
			break;

		case croco:
			enemyEntities.add(new Croco(f, g, species, mobLevel, lane));
			break;

		case murloc:
			enemyEntities.add(new Murloc(f, g, species, mobLevel, lane));
			break;
		}
	}

	/**
	 * Calls mob.update() for every element in the Array. Sets swingTimer = 0 if
	 * its <= 0 and substracts delta from swingTimer, if its >= 0
	 * 
	 * @param delta
	 *            Actual delta time
	 * **/
	private void updateMobs(float delta) {
		for (GameLiving mob : mobs) {
			mob.update(delta);
			mob.updateTimers(delta);
			
			mob.target = getFirstMobOnLane(enemyEntities, mob.lane);
			
			if (mob.target != null)
				mob.attackTarget();		
		}

		for (GameLiving mob : enemyEntities) {
			mob.updateTimers(delta);
			mob.update(delta);

			mob.target = getFirstMobOnLane(mobs, mob.lane);
			if (mob.target != null)
				mob.attackTarget();		
		}
	}

	/**
	 * Adds 2x delta to the players mana
	 * 
	 * @param delta
	 *            time since last frame
	 * **/
	private void regenMana(float delta) {
		if (mana < maxMana)
			mana += delta * 2.5f;
	}

	/**
	 * calls the update method for each spell
	 * 
	 * @param delta
	 *            Actual delta Time
	 **/
	private void updateSpells(float delta) {
		for (Spells spell : spells) {
			if (spell.getTarget() == null || spell.isHitTarget()
					&& spell.getHitTimer() >= 0.2f)
				spells.removeValue(spell, true);
			else
				spell.update(delta);
		}
	}

	/**
	 * calls the update method for each projectile
	 * 
	 * @param delta
	 *            Actual delta Time
	 **/
	private void updateProjectiles(float delta) {
		for (Projectile projectile : projectiles) {
			if (projectile.target == null || projectile.isHitTarget())
				projectiles.removeValue(projectile, true);
			else
				projectile.update(delta);
		}
	}

	/**
	 * checks if the player won the stage
	 * 
	 * @return true if player won
	 **/
	public boolean checkWin() {
		if (enemyCounter >= maxEnemies && enemyEntities.size == 0)
			return true;
		else
			return false;
	}

	/**
	 * Returns the mob standing on the first position on its line @ return First
	 * mob, else null
	 **/
	public GameLiving getFirstMobOnLane(Array<GameLiving> list, int lane) {
		GameLiving tmp = null;
		for (GameLiving mob : list) {
			if (mob.lane != lane)
				continue;
			else if (tmp == null)
				tmp = mob;
			else if (mob.velocity.x < 0) {
				if (mob.position.x < tmp.position.x)
					tmp = mob;
			} else if (mob.position.x > tmp.position.x)
				tmp = mob;
		}
		return tmp;
	}

	/** Cleansup **/
	public void cleanUp() {
		enemyEntities.clear();
		mobs.clear();
		spells.clear();
		projectiles.clear();
		enemyCounter = 0;
		wave = 1;
		hp = 100;
		fireDragonXP = 0;
		earthDragonXP = 0;
		iceDragonXP = 0;
		mana = maxMana;
	}

}