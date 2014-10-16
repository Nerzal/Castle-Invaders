package com.noobygames.castleinvaders;

import com.noobygames.castleinvaders.World.Species;

/**@author Tobi**/
public class Player {
	private int coins;
	private int gems;
	private int level;
	static private String playerName;
	private int greyTrollLevel;
	private int lavaTrollLevel;
	private int iceTrollLevel;
	int dexterity;
	int intelligence;
	int concentration;
	int totalEnemiesKilled;
	private int earthDragonLevel;
	private int earthDragonXP;
	private int iceDragonLevel;
	private int iceDragonXP;
	private int fireDragonLevel;
	private int fireDragonXP;
	
	
	public Player() {
		coins = 0;
		gems = 0;
		level = 1;
		
		setGreyTrollLevel(1);
		setLavaTrollLevel(1);
		setIceTrollLevel(1);
		
		earthDragonLevel = 1;
		earthDragonXP = 0;
		iceDragonLevel = 1;
		iceDragonXP = 0;
		fireDragonLevel = 1;
		fireDragonXP = 0;
		
		playerName = "Player";
	}
	
	/** Adds/Substracts the given ammount of coins
	 * @param addCoins Ammount of coins to add.
	 * **/
	public void addCoins(int addCoins) {
		coins  += addCoins;
	}
	
	/** Returns the actual ammount of coins the Player owns.
	 * @return returns coins
	 * **/
	public int getCoins() {
		return coins;
	}
	
	/** Adds a level * **/
	public void addLevel() {
		level += 1;
	}
	
	public void addlevel(int x){
		level += x;
	}
	
	/** Returns the actual level
	 * @return returns level**/
	public int getLevel() {
		return level;
	}
	
	/**Adds/Substracs the given ammount 
	 * @param addGems amount to add/substract
	 * **/
	public void addGems(int addGems) {
		gems += addGems;
	}
	
	/**Returns the ammount of Gems
	 * @return returns gems**/
	public int getGems() {
		return gems;
	}
	
	/**Sets the Players name
	 * @param pName Name to set
	 * **/
	public void setPlayerName(String pName) {
		playerName = pName;
	}
	
	/** Returns the PlayerName
	 * @return returns playername
	 * **/
	public String getPlayerName() {
		return playerName;
	}
	
	public int getTotalEnemiesKilled(){
		return totalEnemiesKilled;
	}
	
	public void setTotalEnemiesKilled(int kills){
		totalEnemiesKilled += kills;
	}
	
	public void updatePrefs(final CastleInvaders game){
		
		coins = game.prefs.getInteger("coins");
		gems = game.prefs.getInteger("gems");
		level = game.prefs.getInteger("level");
		
		totalEnemiesKilled = game.prefs.getInteger("totalEnemiesKilled");
		
		setGreyTrollLevel(game.prefs.getInteger("greyTrollLevel"));
		setLavaTrollLevel(game.prefs.getInteger("lavaTrollLevel"));
		setIceTrollLevel(game.prefs.getInteger("iceTrollLevel"));
		
		earthDragonLevel = game.prefs.getInteger("earthDragonLevel");
		earthDragonXP = game.prefs.getInteger("earthDragonXP");
		
		iceDragonLevel = game.prefs.getInteger("iceDragonLevel");
		iceDragonXP = game.prefs.getInteger("iceDragonXP");
		
		fireDragonLevel = game.prefs.getInteger("fireDragonLevel");
		fireDragonXP = game.prefs.getInteger("fireDragonXP");
	}

	public int getEarthDragonLevel() {
		return earthDragonLevel;
	}

	public void setEarthDragonLevel(int earthDragonLevel) {
		this.earthDragonLevel = earthDragonLevel;
	}

	public int getIceDragonLevel() {
		return iceDragonLevel;
	}

	public void setIceDragonLevel(int iceDragonLevel) {
		this.iceDragonLevel = iceDragonLevel;
	}

	public int getFireDragonLevel() {
		return fireDragonLevel;
	}

	public void setFireDragonLevel(int fireDragonLevel) {
		this.fireDragonLevel = fireDragonLevel;
	}

	public int getEarthDragonXP() {
		return earthDragonXP;
	}

	public void setEarthDragonXP(int earthDragonXP) {
		this.earthDragonXP = earthDragonXP;
	}

	public int getIceDragonXP() {
		return iceDragonXP;
	}

	public void setIceDragonXP(int iceDragonXP) {
		this.iceDragonXP = iceDragonXP;
	}

	public int getFireDragonXP() {
		return fireDragonXP;
	}

	public void setFireDragonXP(int fireDragonXP) {
		this.fireDragonXP = fireDragonXP;
	}

	public int getIceTrollLevel() {
		return iceTrollLevel;
	}

	public void setIceTrollLevel(int iceTrollLevel) {
		this.iceTrollLevel = iceTrollLevel;
	}

	public int getGreyTrollLevel() {
		return greyTrollLevel;
	}

	public void setGreyTrollLevel(int greyTrollLevel) {
		this.greyTrollLevel = greyTrollLevel;
	}

	public int getLavaTrollLevel() {
		return lavaTrollLevel;
	}

	public void setLavaTrollLevel(int lavaTrollLevel) {
		this.lavaTrollLevel = lavaTrollLevel;
	}

	public int getMobLevelForSpecies(Species species) {	
		switch(species){
		case greyTroll:
			return getGreyTrollLevel();
		case lavaTroll:
			return getLavaTrollLevel();
		case iceTroll:
			return getIceTrollLevel();
		case fireDragon:
			return getFireDragonLevel();
		case iceDragon:
			return getIceDragonLevel();
		case earthDragon:
			return getEarthDragonLevel();
		default:
			return 0;
		}
	}

}
